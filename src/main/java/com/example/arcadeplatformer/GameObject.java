package com.example.arcadeplatformer;

public interface GameObject {
    void reset();

    void markForDelettion();

    boolean isMarkedForDeletion();

    boolean toDo();
}