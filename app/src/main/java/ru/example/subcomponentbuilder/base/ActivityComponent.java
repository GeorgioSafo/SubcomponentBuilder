package ru.example.subcomponentbuilder.base;

public interface ActivityComponent<A> {
    void inject(A activity);
}
