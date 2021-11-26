package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderField;
import com.github.playernguyen.qlbuilder.fields.mysql.QLBuilderFieldMySQL;
import com.github.playernguyen.qlbuilder.fields.mysql.QLBuilderFieldTypeMySQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLMySQLFieldTest {

    @Test
    public void shouldBeIntegerType() {
        QLBuilderFieldTypeMySQL type = QLBuilderFieldTypeMySQL.INTEGER;
        String name = "id";

        QLBuilderFieldMySQL fieldResponse = new QLBuilderFieldMySQL(type, name);
        Assertions.assertEquals(fieldResponse.getName(), name);
        Assertions.assertEquals(fieldResponse.getType(), type);
        Assertions.assertNotNull(fieldResponse.getFieldFunction());
        Assertions.assertEquals(fieldResponse.getType().toSQLType(), "INT");
    }

    @Test
    public void shouldHasNotNullInConstraints() {
        String fieldName = "id";
        List<QLBuilderField> fieldList = new ArrayList<>();

        fieldList.add(new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName));

        QLBuilderFieldMySQL field1 = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName);
        field1.setNullable((false));
        fieldList.add(field1);

        QLBuilderFieldMySQL field2 = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName);
        field2.setNullable(false);
        field2.setAutoIncrement(true);
        field2.setUnique(true);
        fieldList.add(field2);

        QLBuilderFieldMySQL field3 = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName);
        field3.setNullable(true);
        field3.setAutoIncrement(true);
        field3.setUnique(true);
        field3.setSize(255);
        fieldList.add(field3);

        QLBuilderFieldMySQL field4 = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName);
        field4.setNullable(true);
        field4.setAutoIncrement(true);
        field4.setUnique(true);
        field4.setPrimaryKey(true);
        field4.setSize(1);
        fieldList.add(field4);

        System.out.println(Arrays.toString(fieldList
                .stream()
                .map(QLBuilderField::toSQLQuery)
                .toArray()));
        Assertions.assertArrayEquals(fieldList
                        .stream()
                        .map(QLBuilderField::toSQLQuery)
                        .toArray(),
                Arrays.asList("`id` INT(255)",
                        "`id` INT(255) NOT NULL",
                        "`id` INT(255) UNIQUE NOT NULL AUTO_INCREMENT",
                        "`id` INT(255) UNIQUE AUTO_INCREMENT",
                        "`id` INT(1) UNIQUE AUTO_INCREMENT PRIMARY KEY"
                        ).toArray());
    }


}
