package pl.martapiatek.weather;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marta on 19.07.2017.
 */

class TemperatureData {

public static final String CURRENT = "apparent";
    public static final String LOW = "minimum";
    public static final String HIGH = "maximum";
    public static final String DEW_POINT = "dew point";
    public final Context context;


    TemperatureData(Context context) {
        this.context = context;
    }


    protected List<TemperatureItem> getTemperatureItems() {
        List<TemperatureItem> items = new ArrayList<TemperatureItem>();
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon),"dziś", "słonecznie",
                "Słonecznie z temperaturą do 28 stopni. Wiatr północno-wschodni od 8 do 12 km/h."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "w nocy", "czyste niebo",
                "Czyste niebo z temperaturą minimalną 13 stopni. Wiatr północny z tendencją do pólnocno-wschodniego o sile od 5 do 10 km/h."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "środa", "słonecznie",
                "Słonecznie z temperaturą do 28 stopni. Wiatr północny od 7 do 11 km/h."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "środa w nocy", "mgliście",
                "Mgliście po 2 rano. Prawie bezchmurnie przy minimalnej temperaturze 15 stopnie. Wiatr od 8 do 12 km/h, północny; wieczorem cieplejszy."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "czwartek", "pochmurno",
                "Mgliście do 8 rano. Później pochmurno z temperaturą maksymalną do 22 stopni. Ciepły wiatr z południa w kodzinach popołudniowych."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "czwartek w nocy", "pogodnie",
                "Pogodnie z temperaturą minimalną 18."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "piątek", "słonecznie",
                "Słonecznie z tempearatura maksymalną 26."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "piątek w nocy", "niewielkie zachmurzenie",
                "Niewielkie zachmurzenie z temperaturą minimalną 18."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "sobota", "niewielkie zachmurzenie",
                "W większości słonecznie z tempearatura maksymalną 27."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "sobota w nocy", "niewielkie zachmurzenie",
                "Niewielkie zachmurzenie z temperaturą minimalną 16."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "niedziela", "niewielkie zachmurzenie",
                "W większości słonecznie z tempearatura maksymalną 28."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "niedziela w nocy", "pogodnie",
                "Pogodnie z temperaturą minimalną 18."));
        items.add(new TemperatureItem(drawable(R.drawable.sunny_icon), "poniedziałek", "słonecznie",
                "Słonecznie z tempearatura maksymalną 26."));
        return items;
    }

    private Drawable drawable(int resId) {
        return context.getResources().getDrawable(resId);
    }

    public Map<String, String> getCurrentConditions() {
        Map<String, String> currentConditions = new HashMap<String, String>();
        currentConditions.put(CURRENT,"26");
        currentConditions.put(LOW,"19");
        currentConditions.put(HIGH,"28");
        currentConditions.put(DEW_POINT,"12");
        return currentConditions;
    }
}
