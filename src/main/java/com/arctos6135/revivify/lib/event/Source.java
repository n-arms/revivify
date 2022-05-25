package com.arctos6135.revivify.lib.event;

import java.util.function.Consumer;

public interface Source {
    public void addEventListener(Consumer<Event> listener);
}
