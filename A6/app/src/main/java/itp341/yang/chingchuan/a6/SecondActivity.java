package itp341.yang.chingchuan.a6;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Jin Yang on 2/21/2017.
 */

public class SecondActivity extends AppCompatActivity {
    SeekBar seekBarR, seekBarG, seekBarB;
    TextView textViewR, textViewG, textViewB, textViewColor;
    Button submitButton;
    int r, g, b, passed, ansR, ansG, ansB;
    Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        seekBarR = (SeekBar) findViewById(R.id.seekBarR);
        seekBarG = (SeekBar) findViewById(R.id.seekBarG);
        seekBarB = (SeekBar) findViewById(R.id.seekBarB);
        textViewR = (TextView) findViewById(R.id.textViewR);
        textViewG = (TextView) findViewById(R.id.textViewG);
        textViewB = (TextView) findViewById(R.id.textViewB);
        textViewColor = (TextView) findViewById(R.id.textViewColor);
        submitButton = (Button) findViewById(R.id.submitButton);
        r = 0;
        g = 0;
        b = 0;
        passed = 0;
        i = getIntent();


        ansR = i.getIntExtra("r", 0);
        ansG = i.getIntExtra("g", 0);
        ansB = i.getIntExtra("b", 0);
        i.putExtra("passed", passed);
        setResult(Activity.RESULT_CANCELED, i);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r == ansR && g == ansG && b == ansB)
                {
                    passed = 1;
                    i.putExtra("passed", passed);
                    setResult(Activity.RESULT_OK, i);
                }
            }
        });



        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewR.setText("R: " + progress);
                r = progress;
                textViewColor.setBackgroundColor(Color.rgb(r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewG.setText("G: " + progress);
                g = progress;
                textViewColor.setBackgroundColor(Color.rgb(r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewB.setText("B: " + progress);
                b = progress;
                textViewColor.setBackgroundColor(Color.rgb(r, g, b));
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
