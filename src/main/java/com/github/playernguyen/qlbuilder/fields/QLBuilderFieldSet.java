package com.github.playernguyen.qlbuilder.fields;

import com.github.playernguyen.qlbuilder.fields.QLBuilderField;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionInteger;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldFunctionVarchar;

import java.util.HashSet;
import java.util.List;

/**
 * A FieldSet represents table.
 * A FieldSet stores data inside a {@link HashSet} before create table or execute any query
 * affected on it.<br>
 */
public interface QLBuilderFieldSet {

    /**
     * A list represents storage of a table
     *
     * @return a storage that store columns of table
     */
    List<QLBuilderField> getFieldSet();

    /**
     * Add new column as integer datatype.
     *
     * @param name a column name
     * @return a {@link QLBuilderFieldFunctionInteger} to interact with.
     */
    QLBuilderFieldFunctionInteger addInteger(String name);

    /**
     * Add new column as varchar datatype.
     *
     * @param name a column name
     * @return a {@link QLBuilderFieldFunctionVarchar} instance to interact with.
     */
    QLBuilderFieldFunctionVarchar addVarchar(String name);

    /**
     * Compile a field set and retry a table generated sql query
     *
     * @return a generated string
     */
    String parseBuilderString();
}
