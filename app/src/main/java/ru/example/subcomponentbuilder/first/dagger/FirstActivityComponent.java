package ru.example.subcomponentbuilder.first.dagger;

import dagger.Subcomponent;
import ru.example.subcomponentbuilder.base.ActivityComponent;
import ru.example.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.example.subcomponentbuilder.first.FirstActivity;

@FirstActivityScope
@Subcomponent(modules = FirstActivityModule.class)
public interface FirstActivityComponent extends ActivityComponent<FirstActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<FirstActivityComponent, FirstActivityModule> {

    }


}
