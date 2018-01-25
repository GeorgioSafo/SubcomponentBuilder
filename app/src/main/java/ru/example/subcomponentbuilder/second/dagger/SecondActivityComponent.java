package ru.example.subcomponentbuilder.second.dagger;

import dagger.Subcomponent;
import ru.example.subcomponentbuilder.base.ActivityComponent;
import ru.example.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.example.subcomponentbuilder.second.SecondActivity;

@SecondActivityScope
@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent extends ActivityComponent<SecondActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SecondActivityComponent, SecondActivityModule> {

    }

}
