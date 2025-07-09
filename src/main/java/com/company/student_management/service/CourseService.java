package com.company.student_management.service;

import com.company.student_management.entity.Course;
import com.company.student_management.repository.CourseRepository;
import io.jmix.rest.annotation.RestService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestService("course_List")
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<String> getCourseNames() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Course::getCourseName)
                .collect(Collectors.toList());
    }

    public List<Course> getAllCourses() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
