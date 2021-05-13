package fr.tp4_ex2.kevin.doolaeghe_tp4_ex2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    //private Bundle bundle;

    private Button button_sms, button_mms, button_appel, button_web, button_map;
    private EditText editText_num, editText_url, editText_geoLon, editText_geoLat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_sms = findViewById(R.id.button_sms);
        button_mms = findViewById(R.id.button_mms);
        button_appel = findViewById(R.id.button_appel);
        button_web = findViewById(R.id.button_web);
        button_map = findViewById(R.id.button_map);

        editText_num = findViewById(R.id.editText_num);
        editText_url = findViewById(R.id.editText_url);
        editText_geoLon = findViewById(R.id.editText_geoLon);
        editText_geoLat = findViewById(R.id.editText_geoLat);

        button_sms.setOnClickListener(this);
        button_mms.setOnClickListener(this);
        button_appel.setOnClickListener(this);
        button_web.setOnClickListener(this);
        button_map.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        if(v.getId() == R.id.button_sms) {
            System.out.println(button_sms.getText());

            Uri sms = Uri.parse("smsto:" + editText_num.getText().toString());
            intent = new Intent(Intent.ACTION_SENDTO, sms);

            intent.putExtra("sms_body", "Hello !");

            startActivity(intent);
        }

        if(v.getId() == R.id.button_mms) {
            System.out.println(button_mms.getText());

            Uri mms = Uri.parse("mmsto:" + editText_num.getText().toString());
            intent = new Intent(Intent.ACTION_SENDTO, mms);

            startActivity(intent);
        }

        if(v.getId() == R.id.button_appel) {
            System.out.println(button_appel.getText());

            Uri appel = Uri.parse("tel:" + editText_num.getText().toString());
            intent = new Intent(Intent.ACTION_DIAL, appel);

            startActivity(intent);
        }

        if(v.getId() == R.id.button_web) {
            System.out.println(button_web.getText());

            Uri web = Uri.parse("http://" + editText_url.getText().toString());
            intent = new Intent(Intent.ACTION_VIEW, web);

            startActivity(intent);
        }

        if(v.getId() == R.id.button_map) {
            System.out.println(button_map.getText());

            Uri map = Uri.parse("geo:" + editText_geoLon.getText().toString() + "," + editText_geoLat.getText().toString() + "?q=");
            intent = new Intent(Intent.ACTION_VIEW, map);

            startActivity(intent);
        }
    }
}
