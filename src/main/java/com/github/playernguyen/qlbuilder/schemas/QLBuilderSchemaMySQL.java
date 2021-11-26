package com.github.playernguyen.qlbuilder.schemas;


import com.github.playernguyen.qlbuilder.connectors.QLConnector;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldSet;
import com.github.playernguyen.qlbuilder.fields.mysql.QLBuilderFieldSetMySQL;
import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public class QLBuilderSchemaMySQL implements QLBuilderSchema {

    private final QLConnector connector;

    public QLBuilderSchemaMySQL(QLConnector connector) {
        this.connector = connector;
    }

    /**
     * {@inheritDoc} <br>
     * QLBuilder using query
     * <b>SELECT count(*) FROM information_schema.TABLES WHERE (TABLE_SCHEMA = '...')
     * AND (TABLE_NAME = '...');</b>
     * to check the MySQL table is existed or not.
     *
     * @return true whether the table is existed, false otherwise
     */
    @Override
    public boolean hasTable(@NotNull String tableName) throws SQLException {
        // Pre-check argument
        Preconditions.checkNotNull(tableName, "tableName must not be null or empty");
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT count(*) FROM information_schema.TABLES WHERE (TABLE_SCHEMA = ?) " +
                             "AND (TABLE_NAME = ?);")) {
            preparedStatement.setString(1, connector.getDatabaseName());
            preparedStatement.setString(2, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1) == 1;
        }
    }

    @Override
    public void createTable(String tableName,
                            Consumer<QLBuilderFieldSet> fieldSetFunction)
            throws SQLException {

        QLBuilderFieldSet fieldSet = new QLBuilderFieldSetMySQL();
        fieldSetFunction.accept(fieldSet);

        String createTableQuery = String.format("CREATE TABLE `%s` (%s)",
                tableName,
                fieldSet.parseBuilderString()
        ).trim();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(createTableQuery)) {
            // Generate a string and execute
            statement.executeUpdate();
        }
    }

}
