package com.github.playernguyen.qlbuilder.schemas;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldSet;

import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * A schema group to modify schema level (tables, schemas)
 */
public interface QLBuilderSchema {

    /**
     * Check whether the table with name is existed or not.
     *
     * @param tableName a table name to check for existence.
     * @return true whether the table is existed, false otherwise.
     */
    boolean hasTable(String tableName) throws SQLException;

    /**
     * Create a new table in current database.
     *
     * @param tableName a table name.
     * @param fieldFunction a field set function to modify table settings.
     * @see QLBuilderFieldSet
     */
    void createTable(String tableName, Consumer<QLBuilderFieldSet> fieldFunction)
            throws SQLException;
}
