package com.github.playernguyen.qlbuilder.fields.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunction;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionInteger;

public class QLBuilderFieldFunctionIntegerMySQL
        extends QLBuilderFieldFunctionMySQL implements QLBuilderFieldFunctionInteger {

    public QLBuilderFieldFunctionIntegerMySQL(QLBuilderFieldMySQL field) {
        super(field);
    }

    @Override
    public QLBuilderFieldFunction autoIncrement() {
        this.getField().setAutoIncrement(true);
        return this;
    }
}
