package itp341.yang.chingchuan.a10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    EditText editTextProductName, editTextBrand, editTextPrice, editTextColor, editTextStock;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        editTextProductName = (EditText) findViewById(R.id.editTextProductName);
        editTextBrand = (EditText) findViewById(R.id.editTextBrand);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextColor = (EditText) findViewById(R.id.editTextColor);
        editTextStock = (EditText) findViewById(R.id.editTextStock);
        saveButton = (Button) findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName, brand, price, color, stock;

                productName = editTextProductName.getText().toString();
                brand = editTextBrand.getText().toString();
                price = editTextPrice.getText().toString();
                color = editTextColor.getText().toString();

                stock = editTextStock.getText().toString();

                if(!productName.equals("") && !brand.equals("") && !price.equals("") && !color.equals("") && !stock.equals("")){
                    StockManager.getInstance().add(new Stock(productName, price, color, brand, StockManager.getInstance().getIndex(), Integer.parseInt(stock)));
                }

                finish();
            }
        });


    }
}
