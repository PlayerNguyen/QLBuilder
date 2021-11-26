package com.github.playernguyen.qlbuilder.fields;


public interface QLBuilderFieldType {

    /**
     * Retrieves a string of sql datatype.
     *
     * @return a string of sql datatype.
     */
    String toSQLType();

    /**
     * Retrieves an object class represents field datatype.
     *
     * @return a class for this object.
     */
    Class<?> toObjectClass();


}
