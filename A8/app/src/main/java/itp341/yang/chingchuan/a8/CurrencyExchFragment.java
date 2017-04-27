package itp341.yang.chingchuan.a8;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CurrencyExchFragment extends Fragment {

    EditText amountEditText;
    int amount;
    Button convertButton;
    Spinner toSpinner, fromSpinner;
    TextView resultTextView;


    public CurrencyExchFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_currency_exch, container,false);
        amountEditText = (EditText) v.findViewById(R.id.amountEditText);
        toSpinner = (Spinner) v.findViewById(R.id.toSpinner);
        fromSpinner = (Spinner) v.findViewById(R.id.fromSpinner);

        amountEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String amountString = amountEditText.getText().toString();
                if( amountString.equals("")){
                    amount = 0;
                }
                else{
                    amount = Integer.parseInt(amountString);
                }
                return false;
            }
        });
        convertButton = (Button) v.findViewById(R.id.convertButton);
        resultTextView = (TextView) v.findViewById(R.id.resultTextView);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int toSelection = toSpinner.getSelectedItemPosition();
                int fromSelection = fromSpinner.getSelectedItemPosition();
            if(toSelection == fromSelection) {
                resultTextView.setText("Result: " + amount);
            }
            else if(toSelection == 0){
                if (fromSelection == 1){
                    double result = 0.15* amount;
                    resultTextView.setText("Result: " + result);
                }
                else{
                    double result = 1.12* amount;
                    resultTextView.setText("Result: " + result);
                }

            }
            else if(toSelection == 1){
                if(fromSelection == 0){
                    double result = 6.51* amount;
                    resultTextView.setText("Result: " + result);
                }
                else{
                    double result = 7.27* amount;
                    resultTextView.setText("Result: " + result);
                }
            }
            else{
                if(fromSelection == 0){
                    double result = 0.9* amount;
                    resultTextView.setText("Result: " + result);
                }
                else{
                    double result = 0.14* amount;
                    resultTextView.setText("Result: " + result);
                }
            }


            }
        });

        return v;
    }


}
