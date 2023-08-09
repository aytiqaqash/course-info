package dev.aytiqaqash.courseinfo.repository;

import dev.aytiqaqash.courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    List<Course> getALlCourses();
}