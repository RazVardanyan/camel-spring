package com.tutorial.camelmicroservicea.model;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class User {
    @DataField(pos = 1, columnName = "userId")
    private String userId;
    @DataField(pos = 2, columnName = "username")
    private String username;
}
