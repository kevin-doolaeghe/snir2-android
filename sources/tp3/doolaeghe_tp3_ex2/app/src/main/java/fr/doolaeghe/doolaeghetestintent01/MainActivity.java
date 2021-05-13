package fr.doolaeghe.doolaeghetestintent01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_edit_onclick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String editText_textToSend_text = data.getStringExtra("editText_textToSend_text");

                TextView textView_textRecieved = (TextView) findViewById(R.id.textView_textRecieved);
                textView_textRecieved.setText(editText_textToSend_text);
            }
        }
    }
}
