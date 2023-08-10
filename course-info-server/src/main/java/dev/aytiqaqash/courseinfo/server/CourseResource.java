package dev.aytiqaqash.courseinfo.server;

import dev.aytiqaqash.courseinfo.domain.Course;
import dev.aytiqaqash.courseinfo.repository.CourseRepository;
import dev.aytiqaqash.courseinfo.repository.RepositoryException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Path("/courses")
public class CourseResource {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResource.class);

    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(){
        try {
            return courseRepository
                    .getALlCourses()
                    .stream()
                    .sorted(Comparator.comparing(Course::id))
                    .toList();
        }catch (RepositoryException e){
            LOG.error("Could not retrieve courses from the database", e);
            throw new NotFoundException();
        }

    }
}
