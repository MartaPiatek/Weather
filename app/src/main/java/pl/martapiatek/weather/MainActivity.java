package pl.martapiatek.weather;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


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

    private void onDataLoaded(){

        ((TextView) findViewById(R.id.currentDayOfWeek)).setText(
                weekdays[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1]);

        ((TextView) findViewById(R.id.currentTemperature)).setText(
                temperatureData.getCurrentConditions().get(TemperatureData.CURRENT));

        ((TextView) findViewById(R.id.currentDewPoint)).setText(
                temperatureData.getCurrentConditions().get(TemperatureData.DEW_POINT));

        ((TextView) findViewById(R.id.currentHigh)).setText(
                temperatureData.getCurrentConditions().get(TemperatureData.HIGH));

        ((TextView) findViewById(R.id.currentLow)).setText(
                temperatureData.getCurrentConditions().get(TemperatureData.LOW));

        if(splashDialog != null){
            splashDialog.dismiss();
            splashDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public void run() {

        temperatureData = new TemperatureData(this);
        temperatureAdapter.setTemperatureData(temperatureData);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onDataLoaded();
            }
        }, 5000);



    }
}
