package com.microservice.product.microserviceproduct.config.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConfigDataSource /**implements MultiTenantConnectionProvider **/{


    private DataSource dataSource;


    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }


    public void releaseAnyConnection(Connection connection) throws SQLException {

    }


    public Connection getConnection(String s) throws SQLException {
        Connection con = dataSource.getConnection();
        con.setSchema(s);
        return con;
    }


    public void releaseConnection(String s, Connection connection) throws SQLException {
        connection.close();
    }


    public boolean supportsAggressiveRelease() {
        return true;
    }


    public boolean isUnwrappableAs(Class<?> aClass) {
        return false;
    }


    public <T> T unwrap(Class<T> aClass) {
        return null;
    }
}
