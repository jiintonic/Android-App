package itp341.yang.chingchuan.a8;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UnitConvFragment extends Fragment {
    EditText amountEditText;
    int amount;
    RadioGroup radioFrom, radioTo;
    RadioButton radioButtonFrom, radioButtonTo;
    Button convertButton;
    TextView resultTextView;
    public UnitConvFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_unit_conv, container,false);
        amountEditText = (EditText) v.findViewById(R.id.amountEditText);
        radioFrom = (RadioGroup) v.findViewById(R.id.radioFrom);
        radioTo = (RadioGroup) v.findViewById(R.id.radioTo);
        convertButton = (Button) v.findViewById(R.id.convertButton);
        resultTextView = (TextView) v.findViewById(R.id.resultTextView);



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


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioFrom.getCheckedRadioButtonId();
                Log.d("String", String.valueOf(selectedId));
                radioButtonFrom = (RadioButton) v.findViewById(radioFrom.getCheckedRadioButtonId());
                selectedId = radioTo.getCheckedRadioButtonId();
                radioButtonTo = (RadioButton) v.findViewById(radioTo.getCheckedRadioButtonId());

                String from = radioButtonFrom.getText().toString();
                //String from = "centimeters";
                String to = radioButtonTo.getText().toString();
                //String to = "feet";

                if(from.equals(to)) {
                    resultTextView.setText("Result: " + amount);
                }
                else if(from.equals("centimeters")){
                    if (to.equals("meters")){
                        double result = 0.01* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if(to.equals("feet")){
                        double result = 0.0328* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if (to.equals("miles")){
                        double result = 6.21* amount/1000000;
                        resultTextView.setText("Result: " + result);
                    }
                    else{
                        double result = amount/100000;
                        resultTextView.setText("Result: " + result);
                    }

                }
                else if(from.equals("meters")){
                    if (to.equals("centimeters")){
                        double result = 100* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if(to.equals("feet")){
                        double result = 3.2808* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if (to.equals("miles")){
                        double result = 6.21* amount/10000;
                        resultTextView.setText("Result: " + result);
                    }
                    else{
                        double result = amount*0.01;
                        resultTextView.setText("Result: " + result);
                    }

                }
                else if(from.equals("feet")){
                    if (to.equals("centimeters")){
                        double result = 30.48* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if(to.equals("meters")){
                        double result = 0.3048* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if (to.equals("miles")){
                        double result = 1.89* amount/10000;
                        resultTextView.setText("Result: " + result);
                    }
                    else{
                        double result = 3.04*amount/10000;
                        resultTextView.setText("Result: " + result);
                    }

                }
                else if(from.equals("miles")){
                    if (to.equals("centimeters")){
                        double result = 160934* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if(to.equals("meters")){
                        double result = 1609.34* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if (to.equals("feet")){
                        double result = 5280* amount/10000;
                        resultTextView.setText("Result: " + result);
                    }
                    else{
                        double result = 1.60934*amount;
                        resultTextView.setText("Result: " + result);
                    }

                }
                else{
                    if (to.equals("centimeters")){
                        double result = 100000* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if(to.equals("meters")){
                        double result = 1000* amount;
                        resultTextView.setText("Result: " + result);
                    }
                    else if (to.equals("feet")){
                        double result = 3280.84* amount/10000;
                        resultTextView.setText("Result: " + result);
                    }
                    else{
                        double result = 0.62137*amount;
                        resultTextView.setText("Result: " + result);
                    }
                }



            }
        });


        return v;
    }

}
