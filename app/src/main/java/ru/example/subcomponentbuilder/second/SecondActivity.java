package ru.example.subcomponentbuilder.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.startandroid.subcomponentbuilder.R;
import ru.example.subcomponentbuilder.app.App;
import ru.example.subcomponentbuilder.second.dagger.SecondActivityComponent;
import ru.example.subcomponentbuilder.second.dagger.SecondActivityModule;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ARGS = "args";

    @Inject
    SecondActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle args = getIntent().getBundleExtra(EXTRA_ARGS);
        SecondActivityComponent component =
                (SecondActivityComponent) App.getApp(this).getComponentsHolder()
                        .getActivityComponent(getClass(), new SecondActivityModule(args));
        component.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseActivityComponent(getClass());
        }

    }
}
