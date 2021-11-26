package com.github.playernguyen.qlbuilder.database.mysql;

import com.github.playernguyen.qlbuilder.fields.QLBuilderField;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldMySQL;
import com.github.playernguyen.qlbuilder.fields.QLBuilderFieldTypeMySQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QLMySQLFieldTest {

    @Test
    public void shouldNotNullInstance() {
        QLBuilderFieldTypeMySQL type = QLBuilderFieldTypeMySQL.INTEGER;
        String name = "id";

        QLBuilderFieldMySQL fieldResponse = new QLBuilderFieldMySQL(type, name);
        Assertions.assertEquals(fieldResponse.getName(), name);
        Assertions.assertEquals(fieldResponse.getType(), type);
        Assertions.assertNotNull(fieldResponse.getFieldFunction());
    }

    @Test
    public void shouldHasNotNullInConstraints() {
        String fieldName = "id";
        List<QLBuilderField> fieldList = new ArrayList<>();

        fieldList.add(new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName));
        // Not Null
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
        fieldList.add(field3);

        QLBuilderFieldMySQL field4 = new QLBuilderFieldMySQL(QLBuilderFieldTypeMySQL.INTEGER, fieldName);
        field4.setNullable(true);
        field4.setAutoIncrement(true);
        field4.setUnique(true);
        field4.setPrimaryKey(true);
        fieldList.add(field4);

        System.out.println(Arrays.toString(fieldList
                .stream()
                .map(QLBuilderField::toSQLQuery)
                .toArray()));
        Assertions.assertArrayEquals(fieldList
                        .stream()
                        .map(QLBuilderField::toSQLQuery)
                        .toArray(),
                Arrays.asList("`id` INT",
                        "`id` INT NOT NULL",
                        "`id` INT UNIQUE NOT NULL AUTO INCREMENT",
                        "`id` INT UNIQUE AUTO INCREMENT",
                        "`id` INT UNIQUE AUTO INCREMENT PRIMARY KEY"
                        ).toArray());
    }



}
