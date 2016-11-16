package com.vgalloy.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.vgalloy.myapplication.R;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 08/11/2016.
 */
public class HomeActivity extends AppCompatActivity {

    // TODO : angular way (vm) or Activity.this
    private final HomeActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button buttonContinue = (Button) findViewById(R.id.button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity, ReaderActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonChoose = (Button) findViewById(R.id.button_choose);
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity, ChooseActivity.class);
                startActivity(intent);
            }
        });
    }
}
