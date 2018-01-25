package ru.example.subcomponentbuilder.app.dagger;

import dagger.Component;
import ru.example.subcomponentbuilder.app.ComponentsHolder;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
