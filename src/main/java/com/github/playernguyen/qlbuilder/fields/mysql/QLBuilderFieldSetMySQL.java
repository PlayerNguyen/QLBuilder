package com.github.playernguyen.qlbuilder.fields.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderField;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionInteger;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionVarchar;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldSet;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a MySQL FieldSet.
 */
public class QLBuilderFieldSetMySQL implements QLBuilderFieldSet {

    private final ArrayList<QLBuilderField> fieldSet = new ArrayList<>();

    public QLBuilderFieldSetMySQL() {
    }

    @Override
    public ArrayList<QLBuilderField> getFieldSet() {
        return this.fieldSet;
    }

    @Override
    public QLBuilderFieldFunctionInteger addInteger(String name) {
        QLBuilderFieldMySQL fieldResponse = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, name);
        fieldSet.add(fieldResponse);
        return (QLBuilderFieldFunctionInteger) fieldResponse.getFieldFunction();
    }

    @Override
    public QLBuilderFieldFunctionVarchar addVarchar(String name) {
        QLBuilderFieldMySQL fieldResponse = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.VARCHAR, name);
        fieldSet.add(fieldResponse);
        return (QLBuilderFieldFunctionVarchar) fieldResponse.getFieldFunction();
    }

    @Override
    public String parseBuilderString() {
        StringBuilder constructor = new StringBuilder();

        // Iterate all field set and append a new string, whether
        //  it has next item, append separator
        Iterator<QLBuilderField> iterator = fieldSet.iterator();
        while (iterator.hasNext()) {
            constructor.append(iterator.next().toSQLQuery());
            if (iterator.hasNext()) {
                constructor.append(", ");
            }
        }

        return constructor.toString();
    }
}
