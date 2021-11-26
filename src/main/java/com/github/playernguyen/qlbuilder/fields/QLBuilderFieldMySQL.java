package com.github.playernguyen.qlbuilder.fields;

import static com.github.playernguyen.qlbuilder.fields.QLBuilderFieldTypeMySQL.INTEGER;

public class QLBuilderFieldMySQL implements QLBuilderField {

    private final QLBuilderFieldType type;
    private final String name;
    private final QLBuilderFieldFunction function;

    private boolean nullable = true;
    private boolean primaryKey = false;
    private boolean unique = false;
    private boolean autoIncrement = false;
    private boolean unsigned = false;

    public QLBuilderFieldMySQL(QLBuilderFieldType type, String name) {
        this.type = type;
        this.name = name;
        if (this.type == INTEGER) {
            this.function = new QLBuilderFieldFunctionIntegerMySQL(this);
        } else this.function = new QLBuilderFieldFunctionMySQL(this);
    }

    @Override
    public QLBuilderFieldType getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public QLBuilderFieldFunction getFieldFunction() {
        return this.function;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    @Override
    public boolean isPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean isAutoIncrement() {
        if (this.type != INTEGER) {
            throw new UnsupportedOperationException("Auto increment must be assigned to integer variable type.");
        }
        return this.autoIncrement;
    }

    @Override
    public boolean isUnsigned() {
        return this.unsigned;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    @Override
    public void setAutoIncrement(boolean autoIncrement) {
        // Unexpected types
        if (this.type != INTEGER)
            throw new UnsupportedOperationException("Auto increment must be assigned to integer variable");

        this.autoIncrement = autoIncrement;
    }

    @Override
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public void setUnsigned(boolean unsigned) {
        this.unsigned = unsigned;
    }

    /**
     * Generate a mysql constraint query. MySQL Constraints is a table field configurations.
     * Constraints can be revealed as follows: <br>
     * `col_name` `col_type` {constraint} <br>
     * E.g: <br>
     * <ul>
     *     <li>NOT NULL AUTO_INCREMENT PRIMARY KEY</li>
     *     <li>CREATE INDEX</li>
     *     <li>UNIQUE</li>
     *     <li>...</li>
     * </ul>
     *
     * @return a mysql constraint query.
     */
    private String parseConstraint() {
        StringBuilder constructor = new StringBuilder();
        // Unique
        if (unique)
            constructor.append(" unique");
        // Not null field variable
        if (!nullable)
            constructor.append(" not null");
        // Auto increment
        if(autoIncrement)
            constructor.append(" auto increment");
        // Primary key field variable
        if (primaryKey)
            constructor.append(" primary key");
        // Retrieves a built string
        return constructor.toString().trim().toUpperCase();
    }

    @Override
    public String toSQLQuery() {
        return String.format("`%s` %s %s",
                this.getName(),
                this.getType().toSQLType(),
                this.parseConstraint()
        ).trim();
    }
}
