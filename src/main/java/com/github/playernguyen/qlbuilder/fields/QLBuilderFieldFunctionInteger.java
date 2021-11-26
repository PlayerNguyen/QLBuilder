package com.github.playernguyen.qlbuilder.fields;

/**
 * A field function of integer type
 */
public interface QLBuilderFieldFunctionInteger extends QLBuilderFieldFunction {

    /**
     * Set auto increment for this field
     * @return a current pipeline
     */
    QLBuilderFieldFunction autoIncrement();

}
