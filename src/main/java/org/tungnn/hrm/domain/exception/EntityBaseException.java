package org.tungnn.hrm.domain.exception;

public class EntityBaseException extends RuntimeException {
    public EntityBaseException() {
        super();
    }

    public EntityBaseException(String message) {
        super(message);
    }

    public EntityBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityBaseException(Throwable cause) {
        super(cause);
    }
}
