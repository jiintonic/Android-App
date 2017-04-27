package itp341.yang.chingchuan.a9;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jin Yang on 3/23/2017.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {
    private ArrayList<Movie> array;
    ImageView iv;
    TextView title, desc;
    Button detailButton;
    Context context;
    Movie m;
    int p;
    int REQUEST_CODE_DETAIL_ACTIVITY = 2;


    public MovieAdapter(Context context, ArrayList<Movie> data) {
        super(context, 0, data);
        this.context = context;
        array = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        m = getItem(position);
        p = position;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_movie, parent, false);
        }


        title = (TextView) convertView.findViewById(R.id.titleTextView);
        title.setText(m.getTitle());

        desc = (TextView) convertView.findViewById(R.id.descriptionTextView);
        desc.setText(m.getDescription());
        iv = (ImageView) convertView.findViewById(R.id.movieImage);
        int genre = m.getGenre();
        if(genre == 0){
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.horror));
        }
        else if (genre == 1)
        {
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.drama));
        }
        else if(genre ==2)
        {
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.comedy));
        }
        else if(genre == 3)
        {
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.action));
        }
        else{
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.sci_fi));
        }


        detailButton = (Button) convertView.findViewById(R.id.detailButton);
        detailButton.setTag(position);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                p = Integer.parseInt(v.getTag().toString());
                i.putExtra("movie", p);
                getContext().startActivity(i);

            }
        });



        return convertView;
    }
}
