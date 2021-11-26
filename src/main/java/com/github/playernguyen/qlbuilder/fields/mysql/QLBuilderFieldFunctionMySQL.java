package com.github.playernguyen.qlbuilder.fields.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunction;

public class QLBuilderFieldFunctionMySQL implements QLBuilderFieldFunction {

    private final QLBuilderFieldMySQL field;

    public QLBuilderFieldFunctionMySQL(QLBuilderFieldMySQL field) {
        this.field = field;
    }

    @Override
    public QLBuilderFieldFunctionMySQL primaryKey() {
        this.field.setPrimaryKey(true);
        return this;
    }

    @Override
    public QLBuilderFieldFunctionMySQL notNull() {
        this.field.setNullable(false);
        return this;
    }

    @Override
    public QLBuilderFieldFunctionMySQL nullable() {
        this.field.setNullable(false);
        return this;
    }

    public QLBuilderFieldFunctionMySQL size(long size) {
        this.field.setSize(size);
        return this;
    }

    public QLBuilderFieldMySQL getField() {
        return field;
    }
}
