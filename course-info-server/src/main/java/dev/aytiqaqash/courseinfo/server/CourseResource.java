package dev.aytiqaqash.courseinfo.server;

import dev.aytiqaqash.courseinfo.domain.Course;
import dev.aytiqaqash.courseinfo.repository.CourseRepository;
import dev.aytiqaqash.courseinfo.repository.RepositoryException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/courses")
public class CourseResource {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResource.class);

    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Course> getCourses(){
        try {
            return courseRepository
                    .getAllCourses()
                    .stream()
                    .sorted(Comparator.comparing(Course::id));
        }catch (RepositoryException e){
            LOG.error("Could not retrieve courses from the database", e);
            throw new NotFoundException();
        }

    }

    @POST
    @Path("/{id}/notes")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addNotes(@PathParam("id") String id, String notes){
        courseRepository.addNotes(id,notes);
    }
}
