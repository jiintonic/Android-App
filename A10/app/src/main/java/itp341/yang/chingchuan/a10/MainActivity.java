package itp341.yang.chingchuan.a10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    JSONArray stockArray;
    Button addButton;
    ListView listView;
    StockAdapter stockAdapter;
    Context context;

    static final int REQUEST_CODE_CREATE_ACTIVITY = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);
        context = this;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateActivity.class);
                startActivityForResult(i, REQUEST_CODE_CREATE_ACTIVITY);
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www-bcf.usc.edu/~parke/itp341/a10/stocks.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            public void onResponse(String response){
                try {
                    stockArray = (JSONArray) new JSONTokener(response).nextValue();
                    JSONObject j;
                    String productName;
                    Stock s;
                    for(int i = 0; i <stockArray.length(); i++){
                        j = stockArray.getJSONObject(i);
                        productName = j.keys().next().toString();
                        j = j.getJSONObject(productName);
                        s = new Stock(productName, j.getString("price"), j.getString("color"),
                                j.getString("brand"),j.getInt("id"), j.getInt("stock"));
                        StockManager.getInstance().add(s);

                    }
                    stockAdapter = new StockAdapter(context, StockManager.getInstance().stockList);
                    listView.setAdapter(stockAdapter);


                }catch(JSONException e){
                    Log.d("JSON parsing error", e.getMessage());
                }
            }

        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error){

            }
    });
        queue.add(stringRequest);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                Stock stk = (Stock) lv.getItemAtPosition(position);
                Intent i = new Intent(context, SellActivity.class);
                i.putExtra("stock", stk);
                startActivityForResult(i, 2);
            }
        });



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       stockAdapter.notifyDataSetChanged();
    }
}
