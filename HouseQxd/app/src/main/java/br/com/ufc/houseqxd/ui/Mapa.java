package br.com.ufc.houseqxd.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import br.com.ufc.houseqxd.MinhaLocalizacaoListener;
import br.com.ufc.houseqxd.R;

public class Mapa extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        configBtn();

    }

    private void configBtn() {
        button = findViewById(R.id.btnMapa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarInformacoesGPS();
            }
        });
    }
    public void buscarInformacoesGPS() {

        if (ActivityCompat.checkSelfPermission(Mapa.this, Manifest.permission.ACCESS_FINE_LOCATION)   != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(Mapa.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Mapa.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(Mapa.this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            ActivityCompat.requestPermissions(Mapa.this, new String[] {Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            return;
        }

        LocationManager mLocManager  = (LocationManager) getSystemService(Mapa.this.LOCATION_SERVICE);
        LocationListener mLocListener = new MinhaLocalizacaoListener();

        mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocListener);

        if (mLocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String texto = "Latitude.: " + MinhaLocalizacaoListener.latitude + "\n" +
                    "Longitude: " + MinhaLocalizacaoListener.longitude + "\n";
            Toast.makeText(Mapa.this, texto, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Mapa.this, "GPS DESABILITADO.", Toast.LENGTH_LONG).show();
        }

        this.mostrarGoogleMaps(MinhaLocalizacaoListener.latitude, MinhaLocalizacaoListener.longitude);
    }

    public void mostrarGoogleMaps(double latitude, double longitude) {
        WebView wv = findViewById(R.id.webv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com/maps/search/?api=1&query=" + latitude + "," + longitude);
    }
}