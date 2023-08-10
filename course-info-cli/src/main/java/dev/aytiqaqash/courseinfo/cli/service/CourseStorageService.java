package dev.aytiqaqash.courseinfo.cli.service;

import dev.aytiqaqash.courseinfo.domain.Course;
import dev.aytiqaqash.courseinfo.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";
    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses){
        for(PluralsightCourse psCourse: psCourses){
            Course course = new Course(
                    psCourse.id(),
                    psCourse.title(),
                    psCourse.durationInMinutes(),
                    PS_BASE_URL + psCourse.contentUrl(),
                    Optional.empty());
            courseRepository.saveCourse(course);
        }
    }
}
