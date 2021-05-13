package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Jeu extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_validerVal;
    private TextView textView_hint;
    private EditText editText_tentative;

    private int alea, nbTentatives;
    private int tentative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        alea = bundle.getInt("alea");
        nbTentatives = 1;

        button_validerVal = (Button) findViewById(R.id.button_validerVal);
        textView_hint = (TextView) findViewById(R.id.textView_hint);
        editText_tentative = (EditText) findViewById(R.id.editText_tentative);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        button_validerVal.setOnClickListener(this);
        editText_tentative.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()) {
                    int value = Integer.parseInt(s.toString());
                    if (value < 1)
                        editText_tentative.setText("1");
                    if (value > 100)
                        editText_tentative.setText("100");
                    editText_tentative.setSelection(editText_tentative.getText().length());
                }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        if(editText_tentative.getText().toString().isEmpty()) {
            tentative = 1;
            editText_tentative.setText("1");
            editText_tentative.setSelection(editText_tentative.getText().length());
        } else
            tentative = Integer.parseInt(editText_tentative.getText().toString());

        if(tentative == alea) {
            intent = new Intent(this, Fin.class);

            bundle = new Bundle();
            bundle.putInt("alea", alea);
            bundle.putInt("nbTentatives", nbTentatives);
            intent.putExtra("bundle", bundle);

            startActivity(intent);
        } else {
            if(tentative < alea)
                textView_hint.setText(R.string.textView_hint_text_inf);
            if(tentative > alea)
                textView_hint.setText(R.string.textView_hint_text_sup);

            nbTentatives++;
        }
    }
}
