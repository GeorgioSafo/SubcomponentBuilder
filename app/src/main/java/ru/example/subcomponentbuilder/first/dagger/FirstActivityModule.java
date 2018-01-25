package ru.example.subcomponentbuilder.first.dagger;

import dagger.Module;
import dagger.Provides;
import ru.example.subcomponentbuilder.base.ActivityModule;
import ru.example.subcomponentbuilder.first.FirstActivityPresenter;

@Module
public class FirstActivityModule implements ActivityModule {

    @FirstActivityScope
    @Provides
    FirstActivityPresenter provideFirstActivityPresenter() {
        return new FirstActivityPresenter();
    }

}
