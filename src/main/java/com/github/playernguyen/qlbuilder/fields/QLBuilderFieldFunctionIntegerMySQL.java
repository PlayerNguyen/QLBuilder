package com.github.playernguyen.qlbuilder.fields;

public class QLBuilderFieldFunctionIntegerMySQL extends QLBuilderFieldFunctionMySQL
        implements QLBuilderFieldFunctionInteger {


    public QLBuilderFieldFunctionIntegerMySQL(QLBuilderFieldMySQL field) {
        super(field);
    }

    @Override
    public QLBuilderFieldFunction autoIncrement() {
        this.getField().setAutoIncrement(true);
        return null;
    }
}
