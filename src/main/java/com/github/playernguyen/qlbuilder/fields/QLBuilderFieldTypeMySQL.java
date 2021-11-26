package com.github.playernguyen.qlbuilder.fields;

public enum QLBuilderFieldTypeMySQL implements QLBuilderFieldType {

    INTEGER("INT", Integer.class);

    private final String sqlType;
    private final Class<?> clazz;

    QLBuilderFieldTypeMySQL(String sqlType, Class<?> clazz) {
        this.sqlType = sqlType;
        this.clazz = clazz;
    }

    @Override
    public String toSQLType() {
        return this.sqlType;
    }

    @Override
    public Class<?> toObjectClass() {
        return this.clazz;
    }
}
