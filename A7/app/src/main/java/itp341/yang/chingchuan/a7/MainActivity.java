package itp341.yang.chingchuan.a7;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import itp341.yang.chingchuan.a7.Model.Card;
import itp341.yang.chingchuan.a7.Model.Ticket;

public class MainActivity extends AppCompatActivity {

    int totalTickets;
    Ticket myTicket;
    Card myCard;
    Button useButton, verifyButton;
    RadioGroup radioType, radioPriority;
    RadioButton radioButton;
    Spinner startSpinner, endSpinner;
    static final int REQUEST_CODE_CARD_ACTIVITY = 1;
    static final int REQUEST_CODE_ORDER_ACTIVITY = 2;
    TextView ticketSoldTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            totalTickets = savedInstanceState.getInt("total_ticket", 0);
        }
        else{
            totalTickets = 0;
        }

        myCard = new Card();
        myTicket = new Ticket();

        useButton = (Button) findViewById(R.id.UseCardbutton);
        verifyButton = (Button) findViewById(R.id.VerifyButton);
        radioType = (RadioGroup) findViewById(R.id.radioType);
        radioPriority = (RadioGroup) findViewById(R.id.radioPriority);
        startSpinner = (Spinner) findViewById(R.id.startLocationspinner);
        endSpinner = (Spinner) findViewById(R.id.endLocationspinner);
        ticketSoldTextView = (TextView) findViewById(R.id.ticketSoldTextView);
        useButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CardActivity.class);
                i.putExtra("card", myCard);
                startActivityForResult(i, REQUEST_CODE_CARD_ACTIVITY);

            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewOrderActivity.class);
                int selectedId = radioType.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                myTicket.setType(radioButton.getText().toString());

                selectedId = radioPriority.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                myTicket.setPriority(radioButton.getText().toString());

                String startCity = startSpinner.getSelectedItem().toString();
                myTicket.setStart(startCity);

                String endCity = endSpinner.getSelectedItem().toString();
                myTicket.setEnd(endCity);

                i.putExtra("ticket", myTicket);
                i.putExtra("card", myCard);
                startActivityForResult(i, REQUEST_CODE_ORDER_ACTIVITY);

            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CARD_ACTIVITY)
        {
            myCard = (Card) data.getSerializableExtra("card");
        }

        else if(requestCode == REQUEST_CODE_ORDER_ACTIVITY){
            myCard = (Card) data.getSerializableExtra("card");

            if(resultCode == RESULT_CANCELED){
                Toast.makeText(MainActivity.this,
                        "Please make necessary edits",
                        Toast.LENGTH_SHORT).show();

            }
            else if(resultCode == RESULT_OK){
                Toast.makeText(MainActivity.this,
                        "Thank you for purchasing a ticket",
                        Toast.LENGTH_SHORT).show();
                totalTickets++;
                ticketSoldTextView.setText(String.valueOf(totalTickets));

            }
        }



    }
}



