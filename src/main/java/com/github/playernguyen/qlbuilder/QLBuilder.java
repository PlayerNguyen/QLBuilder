package com.github.playernguyen.qlbuilder;

import com.github.playernguyen.qlbuilder.connectors.QLConnector;
import com.github.playernguyen.qlbuilder.schemas.QLBuilderSchema;
import com.github.playernguyen.qlbuilder.schemas.QLBuilderSchemaMySQL;

/**
 * A builder instance to execute more query
 */
public class QLBuilder {

    /**
     * A connector to establish connection
     */
    private final QLConnector connector;
    public QLBuilderSchema schema;

    public QLBuilder(QLConnector connector) {
        this.connector = connector;
        // Branch function
        switch (connector.getType()) {
            case MYSQL: {
                this.schema = new QLBuilderSchemaMySQL(connector);
                break;
            }
            case SQLITE: {
                // TODO: sqlite add
                break;
            }
            default: throw new IllegalArgumentException("Connector type not found or invalid.");
        }
    }

    public QLConnector getConnector() {
        return connector;
    }
}
