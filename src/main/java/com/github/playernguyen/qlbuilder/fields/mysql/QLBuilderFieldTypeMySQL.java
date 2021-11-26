package com.github.playernguyen.qlbuilder.fields.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldType;

public enum QLBuilderFieldTypeMySQL implements QLBuilderFieldType {

    INTEGER("INT", Integer.class, 255, true, new long[]{0L, 4294967295L}),
    VARCHAR("VARCHAR", String.class, 255),
    CHAR("CHAR", String.class, 255);

    private final String sqlType;
    private final Class<?> clazz;
    private final long defaultSize;
    private final boolean isUnsignable;
    private final long[] unsignedRange;

    QLBuilderFieldTypeMySQL(String sqlType, Class<?> clazz, long defaultSize, boolean isUnsignable, long[] unsignedRange) {
        this.sqlType = sqlType;
        this.clazz = clazz;
        this.defaultSize = defaultSize;
        this.isUnsignable = isUnsignable;
        this.unsignedRange = unsignedRange;
    }

    QLBuilderFieldTypeMySQL(String sqlType, Class<?> clazz, long defaultSize) {
        this.sqlType = sqlType;
        this.clazz = clazz;
        this.isUnsignable = true;
        this.defaultSize = defaultSize;
        this.unsignedRange = null;
    }

    public long getSizeRange() {
        return defaultSize;
    }

    public long[] getUnsignedRange() {
        return unsignedRange;
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
