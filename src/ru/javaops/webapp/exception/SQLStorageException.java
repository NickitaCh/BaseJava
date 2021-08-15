package ru.javaops.webapp.exception;

import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class SQLStorageException {
    private SQLStorageException() {
    }

    public static StorageException existSQLException(SQLException e) {
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageException(null);
            }
        }
        return new StorageException(e);
    }
}