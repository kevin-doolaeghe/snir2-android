package fr.doolaeghe.doolaeghetestintent01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_sendText_onclick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);

        EditText editText_textToSend = (EditText) findViewById(R.id.editText_textToSend);
        String editText_textToSend_text = editText_textToSend.getText().toString();
        intent.putExtra("editText_textToSend_text", editText_textToSend_text);

        startActivity(intent);
    }
}
