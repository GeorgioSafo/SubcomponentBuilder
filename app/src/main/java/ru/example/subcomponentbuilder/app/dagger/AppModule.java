package ru.example.subcomponentbuilder.app.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.example.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.example.subcomponentbuilder.first.FirstActivity;
import ru.example.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.example.subcomponentbuilder.second.SecondActivity;
import ru.example.subcomponentbuilder.second.dagger.SecondActivityComponent;

@Module(subcomponents = {FirstActivityComponent.class, SecondActivityComponent.class})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    @IntoMap
    @ClassKey(FirstActivity.class)
    ActivityComponentBuilder provideFirstActivityBuilder(FirstActivityComponent.Builder builder) {
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(SecondActivity.class)
    ActivityComponentBuilder provideSecondActivityBuilder(SecondActivityComponent.Builder builder) {
        return builder;
    }

}
