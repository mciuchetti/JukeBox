package it.voltapg.jukebox;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThirdActivity extends AppCompatActivity {
    final String TAG = "ThirdActivity";
    TextView testo;
    ImageButton like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        testo = findViewById(R.id.idTestoCanzone);
        like = findViewById(R.id.idVoto);

        //recupero i dati inviati dalla seconda Activity
        Intent intent = getIntent();
        String t = intent.getStringExtra("titolo");
        Log.d(TAG, "Titolo " + t);
        testo.setText(leggiFile(t,getApplicationContext()));
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        testo.startAnimation(anim);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Grazie per aver votato!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public String leggiFile(String nomeFile, Context c){

        String esito = "";

        AssetManager am = c.getAssets();
        String line;
        try {
            //1) APERTURA FILE
            InputStream is = am.open(nomeFile);
            //2) LETTURA DEL FILE
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                esito += line;
                esito += "\n";
            }
        } catch(FileNotFoundException ex){
            Log.e("TAG", "file non esistente");
            esito = "errore apertura";
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.e("TAG", "errore lettura");
            esito = "errore lettura";
        }
        return esito;
    }
}
