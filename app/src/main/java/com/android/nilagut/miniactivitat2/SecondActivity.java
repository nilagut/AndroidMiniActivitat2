package com.android.nilagut.miniactivitat2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final String message = getIntent().getStringExtra("byeMessage").toString();

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                i.putExtra("message", message);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
