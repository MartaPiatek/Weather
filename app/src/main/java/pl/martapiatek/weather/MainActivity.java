package pl.martapiatek.weather;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ListActivity implements Runnable {

    private Handler handler;
    private TemperatureAdapter temperatureAdapter;
    private TemperatureData temperatureData;
    private Dialog splashDialog;
    String [] weekdays = {"niedziela", "poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        temperatureAdapter = new TemperatureAdapter(this);
        setListAdapter(temperatureAdapter);
        showSplashScreen();
        handler = new Handler();
        AsyncTask.execute(this);

    }

    private void showSplashScreen() {

        splashDialog = new Dialog(this, R.style.splash_screen);
        splashDialog.setContentView(R.layout.activity_splash);
        splashDialog.setCancelable(false);
        splashDialog.show();

    }


    @Override
    public void run() {

    }
}
