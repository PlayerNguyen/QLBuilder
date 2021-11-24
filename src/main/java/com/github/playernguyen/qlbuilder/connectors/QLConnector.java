package com.github.playernguyen.qlbuilder.connectors;

import com.github.playernguyen.qlbuilder.types.QLSQLDatabaseType;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connector provides connection instance to the client.
 */
public interface QLConnector {

    /**
     * Retrieves a connection which will be established by connector.
     *
     * @return a SQL driver connection
     * @throws SQLException an connection error
     */
    Connection getConnection() throws SQLException;

    /**
     * Retrieves database type. This method will branch a function differently
     *
     * @return a type of database system.
     */
    QLSQLDatabaseType getType();

}
