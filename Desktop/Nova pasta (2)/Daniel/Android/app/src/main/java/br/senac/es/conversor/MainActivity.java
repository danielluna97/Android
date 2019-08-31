package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimentros = 0;

    int altura1 = 80;
    int altura2 = 20;
    int altura3 = 20;

    private String formataValorComDoisDigitos(int valor){
        String retorno = String.format(Locale.FRANCE,"%.2f", valor);
        return "retorno da funçâo";


    }

    private String formataValorComDoisDigitos(double valor){
        return String.format(Locale.FRANCE, "%.2f", valor);

    }
    private int calcularMedia(int alt1, int alt2, int alt3){
        int mediaF = alt1 + alt2 + alt3 / 3;
        return mediaF;
    }
    @Override
    //protected =
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        final TextView txtMedia = (TextView) findViewById(R.id.txtMedia);

        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);

        txtMetros.setText(String.valueOf(alturaEmCentimentros));

        final   TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.skbMetros);

        final Button btnConverter = (Button) findViewById(R.id.btnconverter);

        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alturaEmCentimentros = progress;
                String texto = formataValorComDoisDigitos(progress / 100.0);
                texto += "m.";
                txtMetros.setText(texto);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPes.setText("Toque em Coverter");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Button btnconverter = (Button) findViewById(R.id.btnconverter);
        btnConverter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double alturaEmPes = alturaEmCentimentros / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += "pé(s)";
                txtPes.setText(texto);

                double eu = calcularMedia(altura1,altura2,altura3);

                if(alturaEmCentimentros > eu){
                    txtMedia.setText("Maior" + eu);
                }else{
                txtMedia.setText("Menor" + eu);
                }

                }
        });

    }
}
