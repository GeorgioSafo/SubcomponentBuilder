package ru.example.subcomponentbuilder.second.dagger;

import android.os.Bundle;

import dagger.Module;
import dagger.Provides;
import ru.example.subcomponentbuilder.base.ActivityModule;
import ru.example.subcomponentbuilder.second.SecondActivityPresenter;

@Module
public class SecondActivityModule implements ActivityModule {

    private final Bundle args;

    public SecondActivityModule(Bundle args) {
        this.args = args;
    }

    @SecondActivityScope
    @Provides
    SecondActivityPresenter provideSecondActivityPresenter() {
        return new SecondActivityPresenter(args);
    }

}
