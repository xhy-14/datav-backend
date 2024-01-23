package io.renren.modules.app.service.impl.sql;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.ResponseCode.MysqlCode;
import io.renren.modules.app.dao.MysqlDao;
import io.renren.modules.app.dto.MysqlConnectDto;
import io.renren.modules.app.dto.MysqlSqlDto;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.sql.MysqlService;
import io.renren.modules.app.vo.DatabaseVo;
import io.renren.modules.table.entity.MysqlConnectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
@Service
public class MySqlServiceImpl extends ServiceImpl<MysqlDao, MysqlConnectionEntity> implements MysqlService {
    @Autowired
    private UserService userService;

    @Override
    public R connectTest(MysqlConnectDto mysqlConnectDto) {
        if(testConnection(mysqlConnectDto)) {
            return R.success("连接成功");
        } else {
            return R.fail(MysqlCode.TEST_FAIL.getCode(), MysqlCode.TEST_FAIL.getMsg());
        }
    }

    @Override
    public R saveConnection(MysqlConnectDto mysqlConnectDto, HttpServletRequest httpServletRequest) {
        // 先测试连接是否可以
        if( !testConnection(mysqlConnectDto) ) {
            return R.fail(MysqlCode.TEST_FAIL.getCode(), MysqlCode.TEST_FAIL.getMsg());
        }

        // 获取当前用户
        UserEntity userEntity = userService.currentUser(httpServletRequest);

        // 保存连接
        MysqlConnectionEntity connectionEntity = new MysqlConnectionEntity();
        connectionEntity.setHost(mysqlConnectDto.getIp());
        connectionEntity.setPassword(mysqlConnectDto.getPassword());
        connectionEntity.setDatabaseName(mysqlConnectDto.getDatabase());
        connectionEntity.setUserId(userEntity.getUserId());
        connectionEntity.setPort(mysqlConnectDto.getPort());
        connectionEntity.setUserName(mysqlConnectDto.getUsername());
        connectionEntity.setIsDelete(0);
        Date time = new Date(System.currentTimeMillis());
        connectionEntity.setUpdateTime(time);
        connectionEntity.setCreateTime(time);
        connectionEntity.setName(mysqlConnectDto.getName());
        baseMapper.insert(connectionEntity);

        return R.success(getDatabaseColumns(mysqlConnectDto));

    }

    @Override
    public R getDataBaseByID(Long id) {
        LambdaQueryWrapper<MysqlConnectionEntity> queryWrapper = new LambdaQueryWrapper<>();
        MysqlConnectionEntity connectionEntity = baseMapper.selectOne(queryWrapper.eq(MysqlConnectionEntity::getId, id));

        MysqlConnectDto mysqlConnectDto = new MysqlConnectDto(connectionEntity);

        DatabaseVo databaseColumns = getDatabaseColumns(mysqlConnectDto);
        databaseColumns.setId(id);
        return R.success(databaseColumns);
    }

    /**
     * 获取数据库内容
     * @param mysqlConnectDto
     * @return
     */
    public DatabaseVo getDatabaseColumns(MysqlConnectDto mysqlConnectDto) {
        Connection connect = getConnect(mysqlConnectDto);
        List<String> columns = new ArrayList<>();
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SHOW TABLES");
            while (rs.next()) {
                columns.add(rs.getString(1));
            }
            DatabaseVo databaseVo = new DatabaseVo();
            databaseVo.setName(mysqlConnectDto.getName());
            databaseVo.setTables(columns);
            return databaseVo;
        } catch (SQLException throwables) {
            throw new RRException("数据库连接异常");
        }
    }


    /**
     * 测试链接
     * @param mysqlConnectDto
     * @return
     */
    public boolean testConnection(MysqlConnectDto mysqlConnectDto) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(mysqlConnectDto.getUsername());
        dataSource.setPassword(mysqlConnectDto.getPassword());
        String url = "jdbc:mysql://" + mysqlConnectDto.getIp() + ":" + mysqlConnectDto.getPort() + "/" + mysqlConnectDto.getDatabase();
        dataSource.setUrl(url);
        dataSource.setBreakAfterAcquireFailure(true);
        dataSource.setConnectionErrorRetryAttempts(0);
        dataSource.setMaxWait(3000);
        try {
            if(mysqlConnectDto.isMysql8()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                dataSource.setDriver(new com.mysql.jdbc.Driver());
            }
        } catch (Exception e) {
            return false;
        }

        try {
            dataSource.init();
        } catch (SQLException e) {
            dataSource.close();
            return false;
        }
        try {
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
            return true;
        } catch (SQLException e) {
            dataSource.close();
            return false;
        }
    }

    /**
     * 获取连接
     * @param mysqlConnectDto
     * @return
     */
    public Connection getConnect(MysqlConnectDto mysqlConnectDto) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(mysqlConnectDto.getUsername());
        dataSource.setPassword(mysqlConnectDto.getPassword());
        String url = "jdbc:mysql://" + mysqlConnectDto.getIp() + ":" + mysqlConnectDto.getPort() + "/" + mysqlConnectDto.getDatabase();
        dataSource.setUrl(url);
        dataSource.setBreakAfterAcquireFailure(true);
        dataSource.setConnectionErrorRetryAttempts(0);
        dataSource.setMaxWait(3000);
        try {
            if(mysqlConnectDto.isMysql8()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                dataSource.setDriver(new com.mysql.jdbc.Driver());
            }
        } catch (Exception e) {
            throw new RRException("数据库连接失败");
        }

        try {
            dataSource.init();
        } catch (SQLException e) {
            dataSource.close();
            throw new RRException("数据库连接失败");
        }
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            dataSource.close();
            throw new RRException("数据库连接失败");
        }
    }

    @Override
    public R getMySqlConnections(HttpServletRequest httpServletRequest) {
        UserEntity userEntity = userService.currentUser(httpServletRequest);
        LambdaQueryWrapper<MysqlConnectionEntity> queryWrapper = new LambdaQueryWrapper<>();
        List<MysqlConnectionEntity> mysqlConnectionEntities = baseMapper.selectList(
                queryWrapper.eq(MysqlConnectionEntity::getUserId, userEntity.getUserId())
        );

        List<MysqlConnectDto> mysqlConnectDtoList = new ArrayList<>();
        for(MysqlConnectionEntity entity: mysqlConnectionEntities) {
            MysqlConnectDto mysqlConnectDto = new MysqlConnectDto(entity);
            mysqlConnectDto.setPassword("*****");
            mysqlConnectDtoList.add(mysqlConnectDto);
        }
        return R.success(mysqlConnectDtoList);
    }

    @Override
    public R executeSelect(MysqlSqlDto mysqlSqlDto) {
        System.out.println(mysqlSqlDto);
        LambdaQueryWrapper<MysqlConnectionEntity> queryWrapper = new LambdaQueryWrapper<>();
        MysqlConnectionEntity connectionEntity = baseMapper.selectOne(
                queryWrapper.eq(MysqlConnectionEntity::getId, mysqlSqlDto.getId())
        );
        MysqlConnectDto mysqlConnectDto = new MysqlConnectDto(connectionEntity);
        Connection connect = getConnect(mysqlConnectDto);
        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(mysqlSqlDto.getCode());
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 列名
            List<Object> header = new ArrayList<>();
            for(int i=1; i<=metaData.getColumnCount(); i++) {
                header.add(metaData.getColumnName(i));
            }
            List<Map<Object, Object>> rows = new ArrayList<>();
            while(resultSet.next()) {
                Map<Object, Object> map = new HashMap<>();
                for(int i=0; i<header.size(); i++) {
                    map.put(header.get(i), resultSet.getObject(i+1));
                }
                rows.add(map);
            }
            CSVEntity csvEntity = new CSVEntity();
            csvEntity.setHeaders(header);
            csvEntity.setRows(rows);
            return R.success(csvEntity);
        } catch (SQLException throwables) {
            return R.fail(MysqlCode.EXECUTE_FAIL.getCode(), throwables.getMessage());
        }
    }
}
