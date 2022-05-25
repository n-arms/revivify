package com.arctos6135.revivify.lib;

import com.arctos6135.revivify.lib.util.Pair;
import com.arctos6135.revivify.lib.action.Action;
import com.arctos6135.revivify.lib.event.Event;
import java.util.List;

public interface State {
    public Pair<State, List<Action>> update(Event event);
}
