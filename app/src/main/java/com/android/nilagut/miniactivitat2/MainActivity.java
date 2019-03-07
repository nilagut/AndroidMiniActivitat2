package com.android.nilagut.miniactivitat2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(R.string.helloWorld);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setHint(R.string.hint);
        editText1.requestFocus();
        editText2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String text = editText1.getText().toString();
                String repeticions = editText2.getText().toString();
                if(text.isEmpty() || repeticions.isEmpty()){
                    Toast.makeText(getApplicationContext(),getString(R.string.toast),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    String byeMessage = CreateByeMessage(text, Integer.parseInt(repeticions));
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("byeMessage", byeMessage);
                    startActivityForResult(intent, 8);
                }
            }
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode == 8){
            if (resultCode == RESULT_OK){
                textView1.setText(data.getStringExtra("message"));
                editText1.getText().clear();
                editText2.getText().clear();
            }
        }
    }

    public String CreateByeMessage(String text, int repeticions){
        String byeMessage = "";
        for (int i=0; i<repeticions; i++ ){
            byeMessage += text + " ";
        }
        return byeMessage;
    }
 }
