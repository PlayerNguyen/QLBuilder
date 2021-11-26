package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.types.QLSQLDatabaseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class QLMySQLConnectorTest extends QLMySQLMocker{

    @Test
    public void shouldTypeBeMySQL() {
        Assertions.assertEquals(getConnector().getType(), QLSQLDatabaseType.MYSQL);
        Assertions.assertNotEquals(getConnector().getType(), QLSQLDatabaseType.SQLITE);
    }

    @Test
    public void shouldConnectedToServer() throws SQLException {
        Assertions.assertNotNull(getConnector().getConnection());
    }


}
