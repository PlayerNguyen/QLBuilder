package com.github.playernguyen.qlbuilder.connectors;

import com.github.playernguyen.qlbuilder.types.QLSQLDatabaseType;
import com.google.common.base.Preconditions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * {@inheritDoc}
 */
public class QLConnectorMySQL implements QLConnector {

    private static final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "3306";

    private final Properties configuredProperties;
    private final String driverClass = (
            System.getenv("DATABASE_DRIVER_CLASS") != null
                    ? System.getenv("DATABASE_DRIVER_CLASS")
                    : DEFAULT_DRIVER
    );

    public QLConnectorMySQL(Properties configuredProperties) throws ClassNotFoundException {
        // Load properties object. Comfortable to the environment file or environment variables
        this.configuredProperties = configuredProperties;
        // Load MySQL driver
        Class.forName(driverClass);
    }

    public QLConnectorMySQL(String host,
                            String port,
                            String username,
                            String password,
                            String database,
                            String options) throws ClassNotFoundException {
        this.configuredProperties = new Properties();
        this.configuredProperties.setProperty("DATABASE_HOST", host);
        this.configuredProperties.setProperty("DATABASE_PORT", port);
        this.configuredProperties.setProperty("DATABASE_USERNAME", username);
        this.configuredProperties.setProperty("DATABASE_PASSWORD", password);
        this.configuredProperties.setProperty("DATABASE_NAME", database);
        this.configuredProperties.setProperty("DATABASE_OPTIONS", options);
        // Load MySQL driver
        Class.forName(driverClass);
    }

    /**
     * Generate a connection url with follows pattern
     * jdbc:mysql://{{host}}:{{port}}/{{database}}?{{options}}
     * <br>
     * Example of url:<br>
     * <ul>
     *     <li>jdbc:mysql://localhost:3306/test</li>
     *     <li>jdbc:mysql://localhost:3306/test?useSSL=false</li>
     *     <li>jdbc:mysql://125.43.2.45:9213/test</li>
     *     <li>...</li>
     * </ul>
     *
     * @return an url string
     */
    private String generateConnectionString() {

        Preconditions.checkNotNull(this.configuredProperties.getProperty("DATABASE_NAME"),
                "Database name cannot be null"
        );

        String host = this.configuredProperties.getProperty("DATABASE_HOST") != null
                ? this.configuredProperties.getProperty("DATABASE_HOST")
                : DEFAULT_HOST;

        String port = this.configuredProperties.getProperty("DATABASE_PORT") != null
                ? this.configuredProperties.getProperty("DATABASE_PORT")
                : DEFAULT_PORT;

        return String.format("jdbc:mysql://%s:%s/%s?%s",
                host,
                port,
                this.configuredProperties.getProperty("DATABASE_NAME"),
                this.configuredProperties.getProperty("DATABASE_OPTIONS")
        );
    }

    /**
     * {@inheritDoc}
     *
     * @return a database name
     */
    public String getDatabaseName() {
        return this.configuredProperties.getProperty("DATABASE_NAME");
    }

    /**
     * {@inheritDoc}
     *
     * @return a connection
     */
    @Override
    public Connection getConnection() throws SQLException {
        Preconditions.checkNotNull(this.configuredProperties.getProperty("DATABASE_USERNAME"));
        Preconditions.checkNotNull(this.configuredProperties.getProperty("DATABASE_PASSWORD"));
        return DriverManager.getConnection(generateConnectionString(),
                this.configuredProperties.getProperty("DATABASE_USERNAME"),
                this.configuredProperties.getProperty("DATABASE_PASSWORD")
        );
    }

    /**
     * {@inheritDoc}
     *
     * @return a connection type
     */
    @Override
    public QLSQLDatabaseType getType() {
        return QLSQLDatabaseType.MYSQL;
    }
}
