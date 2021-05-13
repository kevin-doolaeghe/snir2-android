package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_retourMenu;
    private TextView textView_nbTentatives;
    private TextView textView_valAlea;

    private int alea, nbTentatives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        alea = bundle.getInt("alea");
        nbTentatives = bundle.getInt("nbTentatives");

        button_retourMenu = (Button) findViewById(R.id.button_retourMenu);
        textView_valAlea = (TextView) findViewById(R.id.textView_valAlea);
        textView_nbTentatives = (TextView) findViewById(R.id.textView_nbTentatives);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        textView_valAlea.setText(R.string.textView_valAlea_text);
        textView_valAlea.append(" " + String.valueOf(alea));

        textView_nbTentatives.setText(R.string.textView_nbTentatives_text);
        textView_nbTentatives.append(" " + String.valueOf(nbTentatives));

        button_retourMenu.setOnClickListener(this);
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
        intent = new Intent(this, Menu.class);

        startActivity(intent);
    }
}
