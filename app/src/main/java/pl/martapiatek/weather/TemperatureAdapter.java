package pl.martapiatek.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 19.07.2017.
 */

class TemperatureAdapter extends BaseAdapter {
    private final Context context;
    List<TemperatureItem>items;


    public TemperatureAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<TemperatureItem>();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView != null ? convertView : createView(parent);
        TemperatureItem temperatureItem = items.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageIcon);
        imageView.setImageDrawable(temperatureItem.getImageDrawable());
        if(temperatureItem.getIconLink()!=null){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.progress_animation);
            animation.setInterpolator(new LinearInterpolator());
            imageView.startAnimation(animation);
            ((ViewHolder) view.getTag()).setIconLink(temperatureItem.getIconLink());
        }
        ((TextView) view.findViewById(R.id.dayTextView)).setText(temperatureItem.getDay());
        ((TextView) view.findViewById(R.id.briefForecast)).setText(temperatureItem.getForecast());
        ((TextView) view.findViewById(R.id.description)).setText(temperatureItem.getDescription());
        return view;
    }

    class ViewHolder {
        private final View view;
        private String iconLink;
        private AsyncTask<String, Integer, Bitmap> asyncTask;

        public ViewHolder(View view) {
            this.view = view;
        }

        public void setIconLink(String iconLink) {
            final ImageView imageView = (ImageView) view.findViewById(R.id.imageIcon);

        }
    }
    private View createView(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflatedView = inflater.inflate(R.layout.temperature_summary, parent, false);
        inflatedView.setTag(new ViewHolder(inflatedView));
        return inflatedView;
    }

    public void setTemperatureData(TemperatureData temperatureData) {
        items = temperatureData.getTemperatureItems();
        notifyDataSetChanged();
    }
}