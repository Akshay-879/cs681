package edu.umb.cs681.hw18;

import java.util.concurrent.atomic.AtomicReference;

public class Aircraft {

    private AtomicReference<Position> pos;

    public Aircraft(Position position) {
        pos = new AtomicReference<>(position);
    }

    public Position getPosition() {
        return pos.get();
    }

    public void setPosition(Position position) {
        pos.set(position);
    }
}