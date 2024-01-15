package io.renren.modules.app.utils;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * @author xiehanying
 */
public class SqlTest {
    public static void main(String[] args) {
        String sql = "select * from test;";
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        System.out.println(sqlStatements.get(0).getChildren());
    }
}
