package org.tungnn.hrm.domain.exception;

public class EntityNotFoundException extends EntityBaseException {
    public EntityNotFoundException() {
        super("Entity not found");
    }
}
