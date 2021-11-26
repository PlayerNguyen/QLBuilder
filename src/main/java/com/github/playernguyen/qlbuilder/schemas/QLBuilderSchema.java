package com.github.playernguyen.qlbuilder.schemas;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldSet;

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
    boolean hasTable(String tableName);


    void createTable(String tableName, Consumer<QLBuilderFieldSet> fieldSetConsumer);

}
