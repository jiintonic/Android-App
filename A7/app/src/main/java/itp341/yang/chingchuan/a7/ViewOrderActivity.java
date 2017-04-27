package itp341.yang.chingchuan.a7;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import itp341.yang.chingchuan.a7.Model.Card;
import itp341.yang.chingchuan.a7.Model.Ticket;

public class ViewOrderActivity extends AppCompatActivity {

    Intent i;
    Card myCard;
    Ticket myTicket;
    TextView startTextView, endTextView, typeTextView, priorityTextView, numberTextView, nameTextView;
    Button ticketButton, cardButton, purchaseButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        i = getIntent();
        myCard = (Card) i.getSerializableExtra("card");
        myTicket = (Ticket) i.getSerializableExtra("ticket");
        startTextView = (TextView) findViewById(R.id.startTextView);
        endTextView = (TextView) findViewById(R.id.endTextView);
        typeTextView = (TextView) findViewById(R.id.typeTextView);
        priorityTextView = (TextView) findViewById(R.id.priorityTextView);
        numberTextView = (TextView) findViewById(R.id.textViewNumber);
        nameTextView = (TextView) findViewById(R.id.textViewName);
        ticketButton = (Button) findViewById(R.id.ticketButton);
        cardButton = (Button) findViewById(R.id.cardButton);
        purchaseButton = (Button) findViewById(R.id.purchaseButton);

        startTextView.setText(myTicket.getStart());
        endTextView.setText(myTicket.getEnd());
        typeTextView.setText(myTicket.getType());
        priorityTextView.setText(myTicket.getPriority());
        numberTextView.setText(String.valueOf(myCard.getCardNumber()));
        nameTextView.setText(myCard.getName());

        ticketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("card", myCard);
                setResult(Activity.RESULT_CANCELED, i);
                finish();

            }
        });

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("card", myCard);
                setResult(Activity.RESULT_OK, i);
                finish();

            }
        });
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardIntent = new Intent(getApplicationContext(), CardActivity.class);
                cardIntent.putExtra("card", myCard);
                startActivityForResult(cardIntent, 1);

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            myCard = (Card) data.getSerializableExtra("card");
            numberTextView.setText(String.valueOf(myCard.getCardNumber()));
            nameTextView.setText(myCard.getName());
        }


    }
}
