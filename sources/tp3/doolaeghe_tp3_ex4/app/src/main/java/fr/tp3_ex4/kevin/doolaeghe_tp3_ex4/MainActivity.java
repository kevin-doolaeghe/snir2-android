package fr.tp3_ex4.kevin.doolaeghe_tp3_ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_modifHaut, button_modifBas;
    private TextView nom, prenom, tel, num, rue, codePost, ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_modifHaut = findViewById(R.id.MainActivity_Button_modifHaut);
        button_modifBas = findViewById(R.id.MainActivity_Button_modifBas);

        nom = findViewById(R.id.MainActivity_TextView_nom);
        prenom = findViewById(R.id.MainActivity_TextView_prenom);
        tel = findViewById(R.id.MainActivity_TextView_tel);
        num = findViewById(R.id.MainActivity_TextView_num);
        rue = findViewById(R.id.MainActivity_TextView_rue);
        codePost = findViewById(R.id.MainActivity_TextView_codePost);
        ville = findViewById(R.id.MainActivity_TextView_ville);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        button_modifHaut.setOnClickListener(this);
        button_modifBas.setOnClickListener(this);
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

        if(requestCode == 1) {
            bundle = data.getBundleExtra("bundle");

            nom.setText(bundle.getString("nom"));
            prenom.setText(bundle.getString("prenom"));
            tel.setText(bundle.getString("tel"));
        }

        if(requestCode == 2) {
            bundle = data.getBundleExtra("bundle");

            num.setText(bundle.getString("num"));
            rue.setText(bundle.getString("rue"));
            codePost.setText(bundle.getString("codePost"));
            ville.setText(bundle.getString("ville"));
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.MainActivity_Button_modifHaut) {
            intent = new Intent(this, ModifHaut.class);

            bundle = new Bundle();
            bundle.putString("nom", nom.getText().toString());
            bundle.putString("prenom", prenom.getText().toString());
            bundle.putString("tel", tel.getText().toString());
            intent.putExtra("bundle", bundle);

            startActivityForResult(intent, 1);
        }

        if(v.getId() == R.id.MainActivity_Button_modifBas) {
            intent = new Intent(this, ModifBas.class);

            bundle = new Bundle();
            bundle.putString("num", num.getText().toString());
            bundle.putString("rue", rue.getText().toString());
            bundle.putString("codePost", codePost.getText().toString());
            bundle.putString("ville", ville.getText().toString());
            intent.putExtra("bundle", bundle);

            startActivityForResult(intent, 2);
        }
    }
}
