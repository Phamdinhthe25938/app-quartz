package com.example.application_quartz_ex.controller;

import com.example.application_quartz_ex.model.Student;
import com.example.application_quartz_ex.service.MutilDataSourceService;
import com.example.application_quartz_ex.service.QuartzService;
import com.example.application_quartz_ex.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

@RestController
@CrossOrigin("*")
@Api(tags = "List Api Student Running")
@RequestMapping("/api/student")
public class StudentController {

  @Resource
  private StudentService studentService;
  @Resource
  private MutilDataSourceService mutilDataSourceService;

  @PostMapping(path = "/create")
  @ApiOperation("Api create student ")
  public ResponseEntity<?> create(@RequestBody Student student) {
    studentService.create(student);
    return new ResponseEntity<>("Create student success", HttpStatus.OK);
  }

  @GetMapping(path = "/get-all")
  @ApiOperation("Api get all student ")
  public ResponseEntity<?> getAll() {
    return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
  }

  @DeleteMapping(path = "/delete/{id}")
  @ApiOperation("Api delete student ")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    studentService.delete(id);
    return new ResponseEntity<>("Delete student success", HttpStatus.OK);
  }

  @GetMapping(path = "/get-data-source-user")
  @ApiOperation("Api get data from source user ")
  public ResponseEntity<?> dataUser() throws SQLException {
    mutilDataSourceService.searchUser("the");
    return new ResponseEntity<>("Delete student success", HttpStatus.OK);
  }

  @GetMapping(path = "/get-data-source-admin")
  @ApiOperation("Api get data from source admin ")
  public ResponseEntity<?> dataAdmin() throws SQLException {
    mutilDataSourceService.searchAdmin("the");
    return new ResponseEntity<>("Delete student success", HttpStatus.OK);
  }
}
