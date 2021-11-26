package com.github.playernguyen.qlbuilder.fields;

public class QLBuilderFieldFunctionMySQL implements QLBuilderFieldFunction{

    private final QLBuilderFieldMySQL field;

    public QLBuilderFieldFunctionMySQL(QLBuilderFieldMySQL field) {
        this.field = field;
    }

    @Override
    public QLBuilderFieldFunction primaryKey() {
        this.field.setPrimaryKey(true);
        return this;
    }

    @Override
    public QLBuilderFieldFunction notNull() {
        this.field.setNullable(false);
        return this;
    }

    @Override
    public QLBuilderFieldFunction nullable() {
        this.field.setNullable(false);
        return this;
    }

    public QLBuilderFieldMySQL getField() {
        return field;
    }
}
