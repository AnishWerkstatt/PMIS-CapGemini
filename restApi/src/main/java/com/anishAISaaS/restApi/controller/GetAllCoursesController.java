package com.anishAISaaS.restApi.controller;

import com.anishAISaaS.restApi.entity.Course;
import com.anishAISaaS.restApi.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * This controller demonstrates GET /courses.
 *
 * GET is used when the client wants to read data.
 * This file returns every course.
 */
@RestController
@RequestMapping("/courses")
public class GetAllCoursesController {

    private final CourseService courseService;

    public GetAllCoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}
