package com.fernandomulato.Domain.core.events;

public final class ClsLibraryEvent {
    private final LibraryEventType type;
    private final String message;

    public ClsLibraryEvent(LibraryEventType type, String message) {
        this.type = type;
        this.message = message;
    }

    public LibraryEventType getType() { return type; }
    public String getMessage() { return message; }
}

