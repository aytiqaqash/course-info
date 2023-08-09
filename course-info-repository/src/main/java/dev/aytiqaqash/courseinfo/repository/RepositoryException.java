package dev.aytiqaqash.courseinfo.repository;

import java.sql.SQLException;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message, SQLException sqlException) {
        super(message);
    }
}
