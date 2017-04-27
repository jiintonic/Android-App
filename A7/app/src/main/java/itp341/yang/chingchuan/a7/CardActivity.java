package itp341.yang.chingchuan.a7;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import itp341.yang.chingchuan.a7.Model.Card;

public class CardActivity extends AppCompatActivity {

    Intent i;
    EditText cardNumEditText, nameEditText;
    int cardNum;
    String name;
    Button saveButton;
    Card mycard;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        i = getIntent();
        saveButton = (Button) findViewById(R.id.saveButton);
        mycard = (Card) i.getSerializableExtra("card");
        cardNumEditText = (EditText) findViewById(R.id.editTextCardNumber);
        nameEditText = (EditText) findViewById(R.id.editTextName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEditText.getText().toString();
                if(!name.equals(""))
                    mycard.setName(name);

                String cardNumString = cardNumEditText.getText().toString();
                if( !cardNumString.equals("")){
                    cardNum = Integer.parseInt(cardNumString);
                    mycard.setCardNumber(cardNum);
                }

                i.putExtra("card", mycard);
                setResult(Activity.RESULT_OK, i);
                finish();

            }
        });

    }
}
