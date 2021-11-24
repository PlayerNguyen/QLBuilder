package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.QLBuilder;
import com.github.playernguyen.qlbuilder.connectors.QLConnector;
import com.github.playernguyen.qlbuilder.connectors.QLConnectorMySQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Properties;

public class QLMySQLMocker{

    private QLConnector connector;
    private QLBuilder builder;

    @BeforeEach
    public void setup() throws ClassNotFoundException {
        // Setup connector first
        Properties properties = new Properties();
        properties.putAll(System.getenv());
        connector = new QLConnectorMySQL(properties);
        // Then setup builder
        builder = new QLBuilder(connector);
    }

    @Test
    public void shouldBeConnectableToDatabaseServer() throws SQLException {
        Assertions.assertNotNull(connector.getConnection());
    }

    public QLBuilder getBuilder() {
        return builder;
    }

    public QLConnector getConnector() {
        return connector;
    }
}
