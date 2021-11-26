package com.github.playernguyen.qlbuilder.fields;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a MySQL FieldSet.
 */
public class QLBuilderFieldSetMySQL implements QLBuilderFieldSet{

    private final Set<QLBuilderField> fieldSet = new HashSet<>();

    public QLBuilderFieldSetMySQL() {
    }

    @Override
    public Set<QLBuilderField> getFieldSet() {
        return this.fieldSet;
    }

    @Override
    public QLBuilderFieldFunctionInteger addInteger(String name) {
        QLBuilderFieldMySQL fieldResponse = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, name);
        return (QLBuilderFieldFunctionInteger) fieldResponse.getFieldFunction();
    }

    @Override
    public QLBuilderFieldFunctionVarchar addVarchar(String name) {
        return null;
    }
}
