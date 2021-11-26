package com.github.playernguyen.qlbuilder.database.mysql;

import org.junit.jupiter.api.Test;

public class QLMySQLSchemaTest extends QLMySQLMocker {

    @Test
    public void shouldCreateTable() {
        this.getBuilder().schema.createTable("users",
                (table) -> table.addInteger("id").autoIncrement().primaryKey().notNull()
        );
    }

}
