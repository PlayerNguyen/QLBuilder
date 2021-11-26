package com.github.playernguyen.qlbuilder.fields.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionVarchar;

public class QLBuilderFieldFunctionVarcharMySQL
        extends QLBuilderFieldFunctionMySQL implements QLBuilderFieldFunctionVarchar {
    public QLBuilderFieldFunctionVarcharMySQL(QLBuilderFieldMySQL field) {
        super(field);
    }
}
