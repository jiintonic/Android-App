package itp341.yang.chingchuan.a2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    private Button mbutton_coffee;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton_coffee = (Button) findViewById(R.id.button_coffee);
        mbutton_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage(v);
            }
        });

    }

    public void displayMessage(View view) {
        Toast.makeText(MainActivity.this,
                R.string.label_order,
                Toast.LENGTH_SHORT).show();
    }


}
