package itp341.yang.chingchuan.a5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar sBar;
    TextView pTextView, tipTextView, totalTextView, personTextView, personAmountTextView;
    EditText amountEditText;
    Spinner spinner;
    double percent = .15;
    double totalAmount = 0;
    double tipAmount = 0;
    int amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sBar = (SeekBar) findViewById(R.id.seekBar);
        sBar.setProgress(15);
        spinner = (Spinner) findViewById(R.id.spinner);
        personTextView = (TextView) findViewById(R.id.PersonTextView);
        personAmountTextView = (TextView) findViewById(R.id.PersonAmountTextView);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selection = spinner.getSelectedItemPosition();
                if(selection == 0){
                    personAmountTextView.setText("");
                    personTextView.setText("");
                }
                else if (selection == 1)
                {
                    personTextView.setText("Per Person");
                    double perPersonAmount = amount/2;
                    String display = String.format("%.2f", perPersonAmount);
                    personAmountTextView.setText(display);
                }
                else if(selection ==2)
                {
                    personTextView.setText("Per Person");
                    double perPersonAmount = amount/3;
                    String display = String.format("%.2f", perPersonAmount);
                    personAmountTextView.setText(display);
                }
                else
                {
                    personTextView.setText("Per Person");
                    double perPersonAmount = amount/4;
                    String display = String.format("%.2f", perPersonAmount);
                    personAmountTextView.setText(display);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                personAmountTextView.setText("");
                personTextView.setText("");

            }
        });

        pTextView = (TextView) findViewById(R.id.percentTextView);
        amountEditText = (EditText) findViewById(R.id.editText);
        tipTextView = (TextView) findViewById(R.id.TipAmountTextView);
        totalTextView = (TextView) findViewById(R.id.TotalAmountTextView);
        amountEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String amountString = amountEditText.getText().toString();
                if( amountString.equals("")){
                    amount = 0;
                    tipTextView.setText("");
                    totalTextView.setText("");
                }
                else{
                    amount = Integer.parseInt(amountString);
                    totalAmount = amount *(1+percent);
                    tipAmount = amount * percent;
                    String tipDisplay = String.format("%.2f", tipAmount);
                    String totalDisplay = String.format("%.2f", totalAmount);
                    tipTextView.setText(tipDisplay);
                    totalTextView.setText(totalDisplay);
                }
                return false;
            }
        });

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pTextView.setText(progress + "%");
                percent = progress/100.;
                totalAmount = amount *(1+percent);
                tipAmount = amount * percent;
                String tipDisplay = String.format("%.2f", tipAmount);
                String totalDisplay = String.format("%.2f", totalAmount);
                tipTextView.setText(tipDisplay);
                totalTextView.setText(totalDisplay);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
