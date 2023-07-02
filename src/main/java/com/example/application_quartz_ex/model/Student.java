package com.example.application_quartz_ex.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @CsvBindByName(column = "id")
    private Long id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "age")
    private Long age;

    @CsvBindByName(column = "national")
    private String national;

    @CsvBindByName(column = "universityName")
    private String universityName;
}
