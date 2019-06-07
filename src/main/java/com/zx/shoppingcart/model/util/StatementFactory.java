package com.zx.shoppingcart.model.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component()
public class StatementFactory implements FactoryBean<Statement> {

    //TODO:把数据库地址放到配置文件中
    private static String DB_PATH = "jdbc:sqlite:src/main/resources/sample.db";

    @Override
    public Statement getObject() throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_PATH);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        return statement;
    }

    @Override
    public Class<?> getObjectType() {
        return Statement.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
