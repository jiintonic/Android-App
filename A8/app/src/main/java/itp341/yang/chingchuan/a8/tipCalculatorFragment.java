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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;



public class tipCalculatorFragment extends Fragment {
    SeekBar sBar;
    TextView pTextView, tipTextView, totalTextView, personTextView, personAmountTextView;
    EditText amountEditText;
    Spinner spinner;
    double percent = .15;
    double totalAmount = 0;
    double tipAmount = 0;
    int amount = 0;

    private OnFragmentInteractionListener mListener;

    public tipCalculatorFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tip_calculator, container,false);
        sBar = (SeekBar) v.findViewById(R.id.seekBar);
        sBar.setProgress(15);
        spinner = (Spinner) v.findViewById(R.id.spinner);
        personTextView = (TextView) v.findViewById(R.id.PersonTextView);
        personAmountTextView = (TextView) v.findViewById(R.id.PersonAmountTextView);

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

        pTextView = (TextView) v.findViewById(R.id.percentTextView);
        amountEditText = (EditText) v.findViewById(R.id.editText);
        tipTextView = (TextView) v.findViewById(R.id.TipAmountTextView);
        totalTextView = (TextView) v.findViewById(R.id.TotalAmountTextView);
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



        return v;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
