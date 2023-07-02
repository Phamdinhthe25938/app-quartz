package com.example.application_quartz_ex.service;

import com.example.application_quartz_ex.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private static final List<Student> list = new ArrayList<>();


    static {
        list.add(new Student(1L, "minh", 32L, "viet nam", "dai hoc quoc gia"));
        list.add(new Student(2L, "duc", 20L, "viet nam", "san khau dien anh"));
    }

    public void create(Student student) {
        list.add(student);
    }

    public List<Student> getAll() {
        return list;
    }

    public void delete(Long id) {
        list.removeIf(e -> Objects.equals(e.getId(), id));
    }
}
