package com.github.playernguyen.qlbuilder.fields;

import java.util.HashSet;
import java.util.Set;

/**
 * A FieldSet represents table.
 * A FieldSet stores data inside a {@link HashSet} before create table or execute any query
 * affected on it.<br>
 */
public interface QLBuilderFieldSet {

    Set<QLBuilderField> getFieldSet();

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

}
