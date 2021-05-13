package fr.tp5_ex1.kevin.doolaeghe_tp5_ex1;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    //private Bundle bundle;

    private Uri uri;

    private TextView textView_uri;
    private ImageView imageView_image;
    private Bitmap bitmap_image;
    private Button button_load;
    private Button button_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uri = Uri.EMPTY;

        textView_uri = findViewById(R.id.textView_uri);
        imageView_image = findViewById(R.id.imageView_image);
        button_load = findViewById(R.id.button_load);
        button_reset = findViewById(R.id.button_reset);

        registerForContextMenu(imageView_image);

        button_load.setOnClickListener(this);
        button_reset.setOnClickListener(this);
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

        if (requestCode == 0) {
            //imageView_image.setImageURI(data.getData());
            //textView_uri.setText(data.getData().toString());

            try {
                // ----- préparer les options de chargement de l’image
                BitmapFactory.Options option = new BitmapFactory.Options();
                option.inMutable = true; // l’image pourra être modifiée

                uri = data.getData();
                // ------ chargement de l’image - valeur retournée null en cas d’erreur
                bitmap_image = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()), null, option);

                imageView_image.setImageBitmap(bitmap_image);
                textView_uri.setText(data.getData().toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_load) {
            System.out.println(button_load.getId());

            //Uri content = Uri.parse("");

            intent = new Intent(Intent.ACTION_GET_CONTENT);
            //intent.setData(content);
            intent.setType("image/*");

            startActivityForResult(intent, 0);
        }

        if (v.getId() == R.id.button_reset) {
            try {
                // ----- préparer les options de chargement de l’image
                BitmapFactory.Options option = new BitmapFactory.Options();
                option.inMutable = true; // l’image pourra être modifiée

                // ------ chargement de l’image - valeur retournée null en cas d’erreur
                bitmap_image = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, option);

                imageView_image.setImageBitmap(bitmap_image);
                textView_uri.setText(uri.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());

        switch (item.getItemId()) {
            case R.id.menuItem_mirHor:
                try {
                    int width = bitmap_image.getWidth();
                    int height = bitmap_image.getHeight();

                    Matrix matrix = new Matrix();
                    matrix.preScale(-1, 1);
                    Bitmap i = Bitmap.createBitmap(bitmap_image, 0, 0, width, height, matrix, false);
                    bitmap_image = i;

                    imageView_image.setImageBitmap(bitmap_image);
                } catch (Exception e) {
                    System.err.println("Aucune image sélectionnée");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Aucune image sélectionnée").setTitle("Error");

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                return true;

            case R.id.menuItem_mirVer:
                try {
                    int width = bitmap_image.getWidth();
                    int height = bitmap_image.getHeight();

                    Matrix matrix = new Matrix();
                    matrix.preScale(1, -1);
                    Bitmap i = Bitmap.createBitmap(bitmap_image, 0, 0, width, height, matrix, false);
                    bitmap_image = i;

                    imageView_image.setImageBitmap(bitmap_image);
                } catch (Exception e) {
                    System.err.println("Aucune image sélectionnée");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Aucune image sélectionnée").setTitle("Error");

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                return true;

            case R.id.menuItem_rotHor:
                try {
                    int width = bitmap_image.getWidth();
                    int height = bitmap_image.getHeight();

                    Matrix matrix = new Matrix();
                    matrix.postRotate(90);
                    Bitmap i = Bitmap.createBitmap(bitmap_image, 0, 0, width, height, matrix, false);
                    bitmap_image = i;

                    imageView_image.setImageBitmap(bitmap_image);
                } catch (Exception e) {
                    System.err.println("Aucune image sélectionnée");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Aucune image sélectionnée").setTitle("Error");

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                return true;

            case R.id.menuItem_rotAntiHor:
                try {
                    int width = bitmap_image.getWidth();
                    int height = bitmap_image.getHeight();

                    Matrix matrix = new Matrix();
                    matrix.postRotate(-90);
                    Bitmap i = Bitmap.createBitmap(bitmap_image, 0, 0, width, height, matrix, false);
                    bitmap_image = i;

                    imageView_image.setImageBitmap(bitmap_image);
                } catch (Exception e) {
                    System.err.println("Aucune image sélectionnée");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Aucune image sélectionnée").setTitle("Error");

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        int width = bitmap_image.getWidth();
        int height = bitmap_image.getHeight();

        switch (item.getItemId()) {
            case R.id.menuItem_invCouleurs:
                for(int x = 0; x < width; x++) {
                    for(int y = 0; y < height; y++) {
                        int alpha = (bitmap_image.getPixel(x, y) >> 24) & 0xff;
                        int red = 255 - (bitmap_image.getPixel(x, y) >> 16) & 0xff;
                        int green = 255 - (bitmap_image.getPixel(x, y) >> 8) & 0xff;
                        int blue = 255 - (bitmap_image.getPixel(x, y)) & 0xff;

                        /*
                        Color c =  new Color();
                        c.alpha(alpha);
                        c.red(255 - red);
                        c.green(255 - green);
                        c.blue(255 - blue);
                        */

                        int color = (alpha & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);

                        bitmap_image.setPixel(x, y, color);
                    }
                }

                imageView_image.setImageBitmap(bitmap_image);

                return true;

            case R.id.menuItem_niveauxGris1:
                for(int x = 0; x < width; x++) {
                    for(int y = 0; y < height; y++) {
                        int alpha = (bitmap_image.getPixel(x, y) >> 24) & 0xff;
                        int red = (bitmap_image.getPixel(x, y) >> 16) & 0xff;
                        int green = (bitmap_image.getPixel(x, y) >> 8) & 0xff;
                        int blue = (bitmap_image.getPixel(x, y)) & 0xff;

                        int moyenne = (red + green + blue) / 3;

                        /*
                        Color c =  new Color();
                        c.alpha(alpha);
                        c.red(moyenne);
                        c.green(moyenne);
                        c.blue(moyenne);
                        */

                        int color = (alpha & 0xff) << 24 | (moyenne & 0xff) << 16 | (moyenne & 0xff) << 8 | (moyenne & 0xff);

                        bitmap_image.setPixel(x, y, color);
                    }
                }

                imageView_image.setImageBitmap(bitmap_image);

                return true;

            case R.id.menuItem_niveauxGris2:
                for(int x = 0; x < width; x++) {
                    for(int y = 0; y < height; y++) {
                        int alpha = (bitmap_image.getPixel(x, y) >> 24) & 0xff;
                        int red = (bitmap_image.getPixel(x, y) >> 16) & 0xff;
                        int green = (bitmap_image.getPixel(x, y) >> 8) & 0xff;
                        int blue = (bitmap_image.getPixel(x, y)) & 0xff;

                        int moyenne = (Math.max(Math.max(red, green), blue) + Math.min(Math.min(red, green), blue)) / 2;

                        /*
                        Color c =  new Color();
                        c.alpha(alpha);
                        c.red(moyenne);
                        c.green(moyenne);
                        c.blue(moyenne);
                        */

                        int color = (alpha & 0xff) << 24 | (moyenne & 0xff) << 16 | (moyenne & 0xff) << 8 | (moyenne & 0xff);

                        bitmap_image.setPixel(x, y, color);
                    }
                }

                imageView_image.setImageBitmap(bitmap_image);

                return true;

            case R.id.menuItem_niveauxGris3:
                for(int x = 0; x < width; x++) {
                    for(int y = 0; y < height; y++) {
                        int alpha = (bitmap_image.getPixel(x, y) >> 24) & 0xff;
                        int red = (bitmap_image.getPixel(x, y) >> 16) & 0xff;
                        int green = (bitmap_image.getPixel(x, y) >> 8) & 0xff;
                        int blue = (bitmap_image.getPixel(x, y)) & 0xff;

                        int moyenne = (int) (0.21 * red + 0.72 * green + 0.07 * blue);

                        /*
                        Color c =  new Color();
                        c.alpha(alpha);
                        c.red(moyenne);
                        c.green(moyenne);
                        c.blue(moyenne);
                        */

                        int color = (alpha & 0xff) << 24 | (moyenne & 0xff) << 16 | (moyenne & 0xff) << 8 | (moyenne & 0xff);

                        bitmap_image.setPixel(x, y, color);
                    }
                }

                imageView_image.setImageBitmap(bitmap_image);

                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
