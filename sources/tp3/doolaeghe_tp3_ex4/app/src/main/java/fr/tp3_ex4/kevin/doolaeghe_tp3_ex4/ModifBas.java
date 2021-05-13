package fr.tp3_ex4.kevin.doolaeghe_tp3_ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifBas extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Bundle bundle;

    private Button button_valid;
    private EditText num, rue, codePost, ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_bas);

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        button_valid = findViewById(R.id.ModifBas_Button_valid);

        num = findViewById(R.id.ModifBas_EditText_num);
        rue = findViewById(R.id.ModifBas_EditText_rue);
        codePost = findViewById(R.id.ModifBas_EditText_codePost);
        ville = findViewById(R.id.ModifBas_EditText_ville);

        num.setText(bundle.getString("num"));
        rue.setText(bundle.getString("rue"));
        codePost.setText(bundle.getString("codePost"));
        ville.setText(bundle.getString("ville"));

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
        bundle.putString("num", num.getText().toString());
        bundle.putString("rue", rue.getText().toString());
        bundle.putString("codePost", codePost.getText().toString());
        bundle.putString("ville", ville.getText().toString());
        intent.putExtra("bundle", bundle);

        setResult(2, intent);
        finish();
    }
}
