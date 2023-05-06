package com.example.problemwydawaniareszty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText ek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        ek=findViewById(R.id.ek);
        tv.setText("");
        ek.setHint("Kwota");
    }

    public void wydajreszte(View view){
        tv.setText("");
        final double[] NOMINALY = {500.,200.0,100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01};
        double reszta = 0;
        String wynik="";
        try {
            reszta = Double.parseDouble(ek.getText().toString());
            wynik = "Reszta z kwoty "+reszta+" PLN:\r\n\r\n";

            for (int i = 0; ((i < NOMINALY.length) && (reszta > 0.00)); i++) {
                if (reszta >= NOMINALY[i]) {
                    int temp = (int)Math.floor(reszta/NOMINALY[i]);
                    wynik += NOMINALY[i] + " PLN x " + temp + "\n";
                    reszta = (double) Math.round(100*(reszta-(temp*NOMINALY[i])))/100;
                }
            }
        }
        catch (Exception ex) {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }finally {
            tv.setText(wynik);
            ek.setText("");
        }
    }
}