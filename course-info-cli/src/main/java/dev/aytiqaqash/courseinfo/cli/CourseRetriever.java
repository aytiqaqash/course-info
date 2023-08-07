package dev.aytiqaqash.courseinfo.cli;

import dev.aytiqaqash.courseinfo.cli.service.CourseRetrieverService;
import dev.aytiqaqash.courseinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("CourserRetriever is starting!");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as a first argument.");
            return;
        }
        try{
            retrieveCourses(args[0]);
        }catch (Exception e){
           LOG.error("Something went wrong", e);
        }

    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();

        List<PluralsightCourse> coursesToStore = courseRetrieverService.getCoursesFor(authorId)
                .stream()
                .filter(not(PluralsightCourse::isRetired))
                .toList();
        LOG.info("Retrieved the following courses {}", coursesToStore);
    }


}
