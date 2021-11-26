package com.github.playernguyen.qlbuilder.fields;

/**
 * Represent fields or columns. Column demands name, type, and more enhanced
 * features ({@link QLBuilderFieldFunction}) such as auto increment, primary key, etc.
 */
public interface QLBuilderField {

    /**
     * Retrieves a field type. The same as column type.
     *
     * @return a field type.
     */
    QLBuilderFieldType getType();

    /**
     * Retrieves a field name. The same as column name.
     *
     * @return a field name
     */
    String getName();

    /**
     * Retrieves field function, to build a utility
     *
     * @return a {@link QLBuilderFieldFunction} instance
     */
    QLBuilderFieldFunction getFieldFunction();

    /**
     * Whether the field (column) is nullable or not. Default is true.
     *
     * @return true whether field (column) is nullable, false otherwise (not null).
     */
    boolean isNullable();

    /**
     * Set whether null or not.
     *
     * @param nullable a value of not null or nullable.
     */
    void setNullable(boolean nullable);

    /**
     * Whether the field is primary key or not. If field set contains more than one primary key,
     * an exception will be thrown.
     *
     * @return true whether field is primary key, false otherwise.
     */
    boolean isPrimaryKey();

    /**
     * Set a primary key for this value. Default is false.
     *
     * @param primaryKey a value of primary key. Default is false
     */
    void setPrimaryKey(boolean primaryKey);

    /**
     * Whether the field contains auto increment key, this for integer type only.
     *
     * @return true whether this field is auto increment, false otherwise.
     * @throws UnsupportedOperationException whether the datatype is not number type.
     */
    boolean isAutoIncrement();

    /**
     * Set auto increment for this field.
     *
     * @param autoIncrement an auto increment value for this field
     */
    void setAutoIncrement(boolean autoIncrement);

    /**
     * Whether to unsigned value for this field.
     *
     * @return true whether this field is unsigned, false otherwise.
     */
    boolean isUnsigned();

    /**
     * Set unsigned for this field. Default is false.
     *
     * @param unsigned an unsigned value for this field
     */
    void setUnsigned(boolean unsigned);

    /**
     * Whether to unique value for this field.
     *
     * @return true whether this field is unique, false otherwise.
     */
    boolean isUnique();

    /**
     * Set unique for this field. Default is false.
     *
     * @param unique a unique value for this field.
     */
    void setUnique(boolean unique);

    /**
     * Set a default value for this field as init value.
     *
     * @param string a default value to be set.
     */
    void setDefaultValue(String string);

    /**
     * Retrieves a default value of this field.
     *
     * @return a default value of this field.
     */
    String getDefaultValue();

    /**
     * Retrieves a string contains SQL query. The SQL table query template: <br>
     * <b>`col_name` DATA_TYPE CONSTRAINTS</b>
     * <br>
     *
     * @return a string contains query.
     */
    String toSQLQuery();
}
