package com.github.playernguyen.qlbuilder.fields;

/**
 * A field function represents utilities class before
 * execute something (create, update,... table)
 */
public interface QLBuilderFieldFunction {

    /**
     * Set a primary key for this field
     *
     * @return a current pipeline
     */
    QLBuilderFieldFunction primaryKey();

    /**
     * Set the field to not be null
     *
     * @return a current pipeline.
     */
    QLBuilderFieldFunction notNull();

    /**
     * Set the field to be null.
     *
     * @return a current pipeline.
     */
    QLBuilderFieldFunction nullable();
}
