package com.fernandomulato.Domain.core.events;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Observer pattern: Subject / publisher of events. Views subscribe, model/service publishes.
 */
public final class ClsLibraryEventBus {
    private final List<ILibraryObserver> observers = new CopyOnWriteArrayList<>();

    public void subscribe(ILibraryObserver observer) {
        if (observer != null) observers.add(observer);
    }

    public void unsubscribe(ILibraryObserver observer) {
        observers.remove(observer);
    }

    public void publish(ClsLibraryEvent event) {
        for (var o : observers) {
            o.onEvent(event);
        }
    }
}

