package itp341.yang.chingchuan.a8;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tipButton, currencyButton, metricsButton;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipButton = (Button) findViewById(R.id.tipButton);
        currencyButton = (Button) findViewById(R.id.currencyButton);
        metricsButton = (Button) findViewById(R.id.unitButton);
        fragmentManager = getFragmentManager();


        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //you only have a transaction whenever you are doing a transaction.
                    fragmentTransaction = fragmentManager.beginTransaction();
                    tipCalculatorFragment tipFragment = new tipCalculatorFragment();
                    fragmentTransaction.replace(R.id.frameLayout, tipFragment);
                    fragmentTransaction.commit();
            }
        });

        currencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //you only have a transaction whenever you are doing a transaction.
                fragmentTransaction = fragmentManager.beginTransaction();
                CurrencyExchFragment currencyFragment = new CurrencyExchFragment();
                fragmentTransaction.replace(R.id.frameLayout, currencyFragment);
                fragmentTransaction.commit();
            }
        });

        metricsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //you only have a transaction whenever you are doing a transaction.
                fragmentTransaction = fragmentManager.beginTransaction();
                UnitConvFragment unitFragment = new UnitConvFragment();
                fragmentTransaction.replace(R.id.frameLayout, unitFragment);
                fragmentTransaction.commit();
            }
        });


    }
}
