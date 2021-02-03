package android.example.pleaseworkthistime;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(@NonNull Context context,@NonNull List<Earthquake> objects) {
        super(context,0,objects);
    }
    private static final String LOCATION_SEPARATOR = " of ";

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View list=convertView;
        if(list==null)
            list= LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);


        Earthquake presentEartquake = getItem(position);
        TextView magTextView = (TextView) list.findViewById(R.id.mag);
        double mag = presentEartquake.getMag();

        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMag = formatter.format(mag);
        magTextView.setText(formattedMag);
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(presentEartquake.getMag());
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = presentEartquake.getPlace();
        String primaryLocation;
        String locationOffset;
        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String [] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }
        else{
           locationOffset = getContext().getString(R.string.near_the);
           primaryLocation = originalLocation;
        }

        TextView primaryLocationTextView = (TextView) list.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);

        TextView loationOffsetTextView = (TextView) list.findViewById(R.id.location_offset);
        loationOffsetTextView.setText(locationOffset);

        TextView timeTextView = (TextView) list.findViewById(R.id.time);
        String s3 = presentEartquake.getTime();
        timeTextView.setText(s3);

        TextView dateTextView = (TextView) list.findViewById(R.id.date);
        String s4 = presentEartquake.getDate();
        dateTextView.setText(s4);



        return  list;
    }

}
