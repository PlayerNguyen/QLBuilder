package com.github.playernguyen.qlbuilder.database.mysql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class QLMySQLSchemaTest extends QLMySQLMocker {

    /**
     * Create a table users with id, name, and price.
     *
     * @throws SQLException connection errors.
     */
    private void buildUserTable() throws SQLException {
        this.getBuilder().schema.createTable("users",
                (table) -> {
                    table.addInteger("id").autoIncrement().primaryKey();
                    table.addVarchar("name").notNull();
                    table.addInteger("price").notNull();
                }
        );
    }

    @BeforeEach
    public void setUp() throws SQLException {
        this.buildUserTable();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        this.dropTable("users");
    }

    @Test
    public void shouldHasTableFunction() throws SQLException {

        Assertions.assertTrue(this.getBuilder().schema.hasTable("users"));
        Assertions.assertFalse(this.getBuilder().schema.hasTable("this_is_a_feat_table"));

    }

    @Test
    public void shouldNotHasTable() throws SQLException {
//        dropTable("users");
        Assertions.assertFalse(this.getBuilder().schema.hasTable("users0001"));
    }

    @Test
    public void shouldThrowsErrorTableExisted() {
//        this.buildUserTable();
        Assertions.assertThrows(SQLException.class, this::buildUserTable);
    }

}
