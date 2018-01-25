package ru.example.subcomponentbuilder.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.startandroid.subcomponentbuilder.R;
import ru.example.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.example.subcomponentbuilder.second.SecondActivity;
import ru.example.subcomponentbuilder.app.App;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        ButterKnife.bind(this);
        FirstActivityComponent component =
                (FirstActivityComponent) App.getApp(this).getComponentsHolder()
                        .getActivityComponent(getClass());
        component.inject(this);
    }

    @OnClick(R.id.goToSecondActivity)
    void onGoToSecondActivityClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseActivityComponent(getClass());
        }
    }
}
