package com.arctos6135.revivify.lib;

import com.arctos6135.revivify.lib.event.Source;
import com.arctos6135.revivify.lib.action.Interpreter;
import com.arctos6135.revivify.lib.State;

public class Core {
    private final Source eventSource;
    private final Interpreter actionInterpreter;
    private State robotState;

    public Core(Source eventSource, Interpreter actionInterpreter, State robotState) {
        this.eventSource = eventSource;
        this.actionInterpreter = actionInterpreter;
        this.robotState = robotState;
    }
}
