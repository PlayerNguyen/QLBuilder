package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.QLBuilder;
import com.github.playernguyen.qlbuilder.connectors.QLConnector;
import com.github.playernguyen.qlbuilder.connectors.QLConnectorMySQL;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class QLMySQLMocker {

    private static QLConnector connector;
    private static QLBuilder builder;
    Properties properties = new Properties();

    @BeforeEach
    public void setup() throws ClassNotFoundException {
        // Setup connector first

        properties.putAll(System.getenv());
        connector = new QLConnectorMySQL(properties);
        // Then setup builder
        builder = new QLBuilder(connector);
    }


    /**
     * Drop a table with name, whether the table have a relationship (ref) with others, make sure that you
     * drop the other one first. Otherwise, the function will throw SQLException
     *
     * @param table a table name
     * @throws SQLException a connection or relationship errors.
     */
    public void dropTable(String table) throws SQLException {
        System.out.printf("Deleting table %s...%n", table);
        try (Connection connection = connector.getConnection();
             PreparedStatement statement1 = connection.prepareStatement("DROP TABLE " + table)) {
            statement1.executeUpdate();
        }
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
