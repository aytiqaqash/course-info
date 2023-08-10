package dev.aytiqaqash.courseinfo.server;

import dev.aytiqaqash.courseinfo.domain.Course;
import dev.aytiqaqash.courseinfo.repository.CourseRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Path("/courses")
public class CourseResource {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResource.class);

    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    public String getCourses(){
        return courseRepository
                .getALlCourses()
                .stream()
                .map(Course::toString)
                .collect(Collectors.joining(", "));
    }
}
