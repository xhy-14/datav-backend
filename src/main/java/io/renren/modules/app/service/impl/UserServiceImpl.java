/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Claims;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.ResponseCode.UserResponseCode;
import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public UserEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return R
	 */
	@Override
	public R login(LoginForm form) {
		//表单校验
		ValidatorUtils.validateEntity(form);

		//用户登录
		UserEntity user = this.queryByMobile(form.getMobile());
		if (user == null) {
			// 没有手机号
			return R.fail(UserResponseCode.USER_NOT_EXISTS.getCode(), UserResponseCode.USER_NOT_EXISTS.getMsg());
		}

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			return R.fail(UserResponseCode.USER_RESPONSE_ERROR.getCode(), UserResponseCode.USER_RESPONSE_ERROR.getMsg());
		}

		//生成token
		String token = jwtUtils.generateToken(user.getUserId());

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", jwtUtils.getExpire());

		return R.success(map);
	}

	/**
	 * 用户注册
	 * @param form
	 * @return R
	 */
	@Override
	public R register(RegisterForm form) {

		UserEntity user = new UserEntity();
		user.setMobile(form.getMobile());
		user.setUsername(form.getMobile());
		user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		// 校验手机号是否合格
		// 定义手机号的正则表达式
		String regex = "^1[3-9]\\d{9}$";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regex);
		// 创建匹配器
		Matcher matcher = pattern.matcher(user.getMobile());
		if ( !matcher.find() ) {
			return R.fail(UserResponseCode.MOBILE_ERROR.getCode(), UserResponseCode.MOBILE_ERROR.getMsg());
		}

		// 校验密码是否在8~16位
		// 定义密码的正则表达式
		if(form.getPassword().length() < 8 || form.getPassword().length() > 16) {
			return R.fail(UserResponseCode.PASSWORD_ERROR.getCode(), UserResponseCode.PASSWORD_ERROR.getMsg());
		}

		// 查询手机号是否已经被使用
		UserEntity registerUser = this.queryByMobile(user.getMobile());

		if (registerUser != null) {
			return R.fail(UserResponseCode.USER_EXISTS.getCode(),
					UserResponseCode.USER_EXISTS.getMsg());
		}

		// 校验合格
		baseMapper.insert(user);

		return R.success();
	}

	/**
	 * 获取当前登录用户
	 * @param token
	 * @return UserEntity
	 */
	@Override
	public UserEntity currentUser(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader("token");
		if (token == null){
			throw new RRException("用户未登录");
		}
		UserEntity user = (UserEntity) jwtUtils.getClaimByToken(token);
		return user;
	}
}
