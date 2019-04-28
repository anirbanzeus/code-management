/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fse.assignment.controller;

import com.fse.assignment.persistence.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author gino
 */
@RestController
public class SimpleController {

  private static final String template = "Sample, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${spring.application.name}")
    String appName;


    @RequestMapping("/greeting")
    public Sample test(@RequestParam(value="name", defaultValue="Application") String name) {
        return new Sample(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
