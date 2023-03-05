package com.microservice.product.microserviceproduct.config.connection;


import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConfigDataSource implements MultiTenantConnectionProvider {


    private DataSource dataSource;

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {

    }

    @Override
    public Connection getConnection(String s) throws SQLException {
        Connection con = dataSource.getConnection();
        con.setSchema(s);
        return con;
    }

    @Override
    public void releaseConnection(String s, Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

    @Override
    public boolean isUnwrappableAs(Class<?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }
}
