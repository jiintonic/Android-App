package itp341.yang.chingchuan.a10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class SellActivity extends AppCompatActivity {
    Stock stock;
    TextView productNameTextView, priceTextView, colorTextView, brandTextView, stockTextView;
    Button buyButton, sellButton, sellAllButton, deleteButton;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        stock = (Stock) getIntent().getSerializableExtra("stock");

        index = stock.get_id()-1;

        productNameTextView = (TextView) findViewById(R.id.textViewProductName);
        priceTextView = (TextView) findViewById(R.id.textViewPrice);
        colorTextView = (TextView) findViewById(R.id.textViewColor);
        brandTextView = (TextView) findViewById(R.id.textViewBrand);
        stockTextView = (TextView) findViewById(R.id.textViewStock);

        buyButton = (Button) findViewById(R.id.buttonBuy);
        sellButton = (Button) findViewById(R.id.buttonSell);
        sellAllButton = (Button) findViewById(R.id.buttonSellAll);
        deleteButton = (Button) findViewById(R.id.buttonDelete);

        if(stock.get_stock()== 0){
            sellButton.setEnabled(false);
            sellAllButton.setEnabled(false);
        }

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               StockManager.getInstance().buyStock(index);
                stockTextView.setText(String.valueOf(StockManager.getInstance().stockList.get(index).get_stock()));
                Toast.makeText(getApplicationContext(), "Bought one stock", Toast.LENGTH_SHORT).show();
                sellAllButton.setEnabled(true);
                sellButton.setEnabled(true);
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StockManager.getInstance().sellStock(index);
                stockTextView.setText(String.valueOf(StockManager.getInstance().stockList.get(index).get_stock()));
                Toast.makeText(getApplicationContext(), "Sold one stock", Toast.LENGTH_SHORT).show();
                if(stock.get_stock()== 0){
                    sellButton.setEnabled(false);
                    sellAllButton.setEnabled(false);
                }
            }
        });

        sellAllButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StockManager.getInstance().sellAll(index);
                stockTextView.setText("0");
                Toast.makeText(getApplicationContext(), "Sold All", Toast.LENGTH_SHORT).show();
                sellAllButton.setEnabled(false);
                sellButton.setEnabled(false);

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StockManager.getInstance().removeFromRecord(index);
                Toast.makeText(getApplicationContext(), "Successfully deleted stock", Toast.LENGTH_SHORT).show();
                deleteButton.setEnabled(false);
                sellAllButton.setEnabled(false);
                sellButton.setEnabled(false);
                buyButton.setEnabled(false);
            }
        });




        productNameTextView.setText(stock.getProductName());
        priceTextView.setText(stock.getPrice());
        colorTextView.setText(stock.getColor());
        brandTextView.setText(stock.getBrand());
        stockTextView.setText(String.valueOf(stock.get_stock()));



    }
}
