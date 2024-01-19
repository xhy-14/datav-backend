package io.renren.modules.app.service.sql;

import io.renren.common.utils.R;
import io.renren.modules.app.dto.MysqlConnectDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiehanying
 */
public interface MysqlService {
    /**
     * mysql连接测试
     * @param mysqlConnectDto
     * @return
     */
    R connectTest(MysqlConnectDto mysqlConnectDto);

    /**
     * 保存mysql连接
     * @param mysqlConnectDto
     * @return
     */
    R saveConnection(MysqlConnectDto mysqlConnectDto, HttpServletRequest httpServletRequest);

    /**
     * 根据id获取数据库
     * @param id
     * @return
     */
    R getDataBaseByID(Long id);
}
