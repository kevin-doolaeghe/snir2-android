package fr.tp4_ex3.kevin.doolaeghe_tp4_ex3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    //private Bundle bundle;

    private TextView textView_uri;
    private ImageView imageView_image;
    private Button button_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_uri = findViewById(R.id.textView_uri);
        imageView_image = findViewById(R.id.imageView_image);
        button_load = findViewById(R.id.button_load);

        button_load.setOnClickListener(this);
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

        if(requestCode == 0) {
            //imageView_image.setImageURI(data.getData());
            //textView_uri.setText(data.getData().toString());

            try {
                // ----- préparer les options de chargement de l’image
                BitmapFactory.Options option = new BitmapFactory.Options();
                option.inMutable = true; // l’image pourra être modifiée

                // ------ chargement de l’image - valeur retournée null en cas d’erreur
                Bitmap bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()), null, option);

                imageView_image.setImageBitmap(bm);
                textView_uri.setText(data.getData().toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_load) {
            System.out.println(button_load.getId());

            //Uri content = Uri.parse("");

            intent = new Intent(Intent.ACTION_GET_CONTENT);
            //intent.setData(content);
            intent.setType("image/*");

            startActivityForResult(intent, 0);
        }
    }
}
