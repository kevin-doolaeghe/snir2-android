package fr.doolaeghe.doolaeghetestintent01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView_textRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String editText_textToSend_text = intent.getStringExtra("editText_textToSend_text");

        textView_textRecieved = (TextView) findViewById(R.id.textView_textRecieved);

        if(!editText_textToSend_text.isEmpty()) textView_textRecieved.setText(editText_textToSend_text);
    }
}
