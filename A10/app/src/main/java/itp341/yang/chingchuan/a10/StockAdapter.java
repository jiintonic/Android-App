package itp341.yang.chingchuan.a10;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jin Yang on 4/6/2017.
 */

public class StockAdapter extends ArrayAdapter<Stock> {
    private ArrayList<Stock> array;
    ImageView iv;
    TextView productName, num;
    Activity context;
    Stock s;
    int p;

    public StockAdapter(Context context, ArrayList<Stock> data) {
        super(context, 0, data);
        this.context = (Activity)context;
        this.array = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        s = array.get(position);
        p = position;

        if(convertView == null)
        {
            convertView = context.getLayoutInflater().inflate(R.layout.stock_item_layout, null);
        }


        productName = (TextView) convertView.findViewById(R.id.textView_name);
        productName.setText(s.getProductName());

        num = (TextView) convertView.findViewById(R.id.textView_num);
        num.setText(String.valueOf(s.get_stock()));
        iv = (ImageView) convertView.findViewById(R.id.imageView);

        String brand = s.getBrand();
        if(brand.equals("Apple")){
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.apple));
        }
        else if (brand.equals("Microsoft"))
        {
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.microsoft));
        }
        else if(brand.equals("Samsung"))
        {
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.samsung));
        }

        else{
            iv.setImageDrawable(convertView.getResources().getDrawable(R.drawable.logo));
        }


        return convertView;
    }
}
