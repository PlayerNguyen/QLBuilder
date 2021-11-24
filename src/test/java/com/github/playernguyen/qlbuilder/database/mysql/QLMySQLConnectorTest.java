package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.types.QLSQLDatabaseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QLMySQLConnectorTest extends QLMySQLMocker{

    @Test
    public void shouldTypeBeMySQL() {
        Assertions.assertEquals(getConnector().getType(), QLSQLDatabaseType.MYSQL);
    }

}
