package fr.tp3_ex4.kevin.doolaeghe_tp3_ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifHaut extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_valid;
    private EditText nom, prenom, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_haut);

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        button_valid = findViewById(R.id.ModifHaut_Button_valid);

        nom = findViewById(R.id.ModifHaut_EditText_nom);
        prenom = findViewById(R.id.ModifHaut_EditText_prenom);
        tel = findViewById(R.id.ModifHaut_EditText_tel);

        nom.setText(bundle.getString("nom"));
        prenom.setText(bundle.getString("prenom"));
        tel.setText(bundle.getString("tel"));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        button_valid.setOnClickListener(this);
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
        intent = new Intent(this, MainActivity.class);

        bundle = new Bundle();
        bundle.putString("nom", nom.getText().toString());
        bundle.putString("prenom", prenom.getText().toString());
        bundle.putString("tel", tel.getText().toString());
        intent.putExtra("bundle", bundle);

        setResult(1, intent);
        finish();
    }
}
