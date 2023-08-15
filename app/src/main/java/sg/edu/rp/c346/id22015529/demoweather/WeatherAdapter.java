package sg.edu.rp.c346.id22015529.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    Context parent_context ;
    int layout_id ;
    ArrayList<Weather> alWeather ;

    public WeatherAdapter(Context context, int resource, ArrayList<Weather> objects) {
        super(context, resource, objects) ;

        parent_context = context ;
        layout_id = resource ;
        alWeather = objects ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View rowView = inflater.inflate(layout_id, parent, false) ;

        TextView tv = rowView.findViewById(R.id.textView) ;
        ImageView iv = rowView.findViewById(R.id.imageView) ;

        Weather currentWeather = alWeather.get(position) ;

        tv.setText(currentWeather.toString()) ;
        if (currentWeather.getForecast().contains("Fair")){
            Picasso.get().load("https://www.nea.gov.sg/assets/images/icons/weather-bg/FA.png").into(iv) ;
        } else if (currentWeather.getForecast().contains("Cloudy")){
            Picasso.get().load("https://www.nea.gov.sg/assets/images/icons/weather-bg/CL.png").into(iv) ;
        }

        return rowView ;
    }
}
