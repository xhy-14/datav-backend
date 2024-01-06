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
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.app.ResponseCode.UserResponseCode;
import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}

	/**
	 * 用户注册
	 * @param form
	 * @return
	 */
	@Override
	public R register(RegisterForm form) {

		UserEntity user = new UserEntity();
		user.setMobile(form.getMobile());
		user.setUsername(form.getMobile());
		user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		QueryWrapper userQuery = new QueryWrapper<UserEntity>();
		// 查询手机号是否已经被使用
		UserEntity registerUser = baseMapper.selectOne(
				(Wrapper<UserEntity>) userQuery.eq("mobile", user.getMobile()));
		if (registerUser != null) {
			return R.ok(UserResponseCode.USER_EXISTS.getMsg(),
					UserResponseCode.USER_EXISTS.getCode());
		}
		// 校验合格
		baseMapper.insert(user);

		return R.ok();
	}
}
