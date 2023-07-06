package com.example.application_quartz_ex.controller;

import com.example.application_quartz_ex.service.QuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
@Api(tags = "List api run job")
@RequestMapping("/api/quartz")
public class QuartzController {

    @Resource
    private QuartzService quartzService;

    @PostMapping("/run")
    @ApiOperation("Api run job ")
    public ResponseEntity<?> run() {
        quartzService.runJob();
        return new ResponseEntity<>("Run job success ", HttpStatus.OK);
    }
}
