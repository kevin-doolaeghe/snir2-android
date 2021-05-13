package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_lancerJeu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        button_lancerJeu = (Button) findViewById(R.id.button_lancerJeu);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        button_lancerJeu.setOnClickListener(this);
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
        int alea = ((int) (Math.random() * 99)) + 1;

        intent = new Intent(this, Jeu.class);

        bundle = new Bundle();
        bundle.putInt("alea", alea);
        intent.putExtra("bundle", bundle);

        startActivity(intent);
    }
}
