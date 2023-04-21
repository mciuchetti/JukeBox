package it.voltapg.jukebox;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    final String TAG = "SecondActivity";
    TextView titolo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Metodo onCreate()");
        setContentView(R.layout.activity_second);

        //recupero i dati inviati dalla prima Activity
        Intent intent = getIntent();
        //String s = intent.getStringExtra("numero");
        Bundle b = intent.getExtras();
        int i = b.getInt("numero");
        Log.d(TAG, "Numero estratto " + i);

        titolo = findViewById(R.id.idTitolo);
        ImageView cover = findViewById(R.id.idImmagine);

        if (i == 10)
        {
            titolo.setText("Stars");
            cover.setImageResource(R.drawable.stars);
        }
        else {
            titolo.setText("Patience");
            cover.setImageResource(R.drawable.patience);
        }
    }

    public void visualizza(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("titolo", titolo.getText());
        startActivity(intent);
    }
}
