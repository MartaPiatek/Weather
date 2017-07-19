package pl.martapiatek.weather;

import android.graphics.drawable.Drawable;

/**
 * Created by Marta on 19.07.2017.
 */

public class TemperatureItem {

    private final Drawable image;
    private final String day;
    private final String forecast;
    private final String description;


    public TemperatureItem(Drawable image, String day, String forecast, String description) {
        this.image = image;
        this.day = day;
        this.forecast = forecast;
        this.description = description;
    }

    public Drawable getImageDrawable() {
        return image;
    }

    public String getDay() {
        return day;
    }

    public String getForecast() {
        return forecast;
    }

    public String getDescription() {
        return description;
    }
}
