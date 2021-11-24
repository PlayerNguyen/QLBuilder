package com.github.playernguyen.qlbuilder.schemas;


import com.github.playernguyen.qlbuilder.connectors.QLConnector;
import com.github.playernguyen.qlbuilder.schemas.fields.QLBuilderFieldSet;
import com.google.common.base.Preconditions;

import java.util.function.Consumer;

public class QLBuilderSchemaMySQL implements QLBuilderSchema {

    private final QLConnector connector;

    public QLBuilderSchemaMySQL(QLConnector connector) {
        this.connector = connector;
    }

    @Override
    public boolean hasTable(String tableName) {
        // Pre-check argument
        Preconditions.checkNotNull(tableName, "tableName must not be null or empty");
        return false;
    }

    @Override
    public void createTable(String tableName, Consumer<QLBuilderFieldSet> fieldSetConsumer) {

    }

}
