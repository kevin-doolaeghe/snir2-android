package com.calc.doolaeghe.calcdoolaeghe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button reset;
    private Button equals;
    private Button leave;
    private RadioGroup operations;
    private EditText val1;
    private EditText val2;
    private TextView view_result;

    private double nb1, nb2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = (Button) findViewById(R.id.button_reset);
        equals = (Button) findViewById(R.id.button_equals);
        leave = (Button) findViewById(R.id.button_leave);
        operations = (RadioGroup) findViewById(R.id.radioGroup_operations);
        val1 = (EditText) findViewById(R.id.editText_val1);
        val2 = (EditText) findViewById(R.id.editText_val2);
        view_result = (TextView) findViewById(R.id.textView_res);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_result.setText("");
                val1.setText("");
                val2.setText("");
                operations.check(R.id.radioButton_addition);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (val1.getText().toString().isEmpty()) {
                    val1.setText("1");
                    nb1 = 1;
                } else nb1 = Double.parseDouble(val1.getText().toString());

                if (val2.getText().toString().isEmpty()) {
                    val2.setText("1");
                    nb2 = 1;
                } else nb2 = Double.parseDouble(val2.getText().toString());

                switch (operations.getCheckedRadioButtonId()) {
                    case R.id.radioButton_addition:
                        result = nb1 + nb2;
                        break;
                    case R.id.radioButton_substraction:
                        result = nb1 - nb2;
                        break;
                    case R.id.radioButton_multiplication:
                        result = nb1 * nb2;
                        break;
                    case R.id.radioButton_division:
                        result = nb1 / nb2;
                        break;
                }

                view_result.setText(Double.toString(result));
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
