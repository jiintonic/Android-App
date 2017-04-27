package itp341.yang.chingchuan.a6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class SecondRoom extends AppCompatActivity {
    Spinner spinner;
    Intent i;
    int ans, selection, passed;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_room);
        spinner = (Spinner) findViewById(R.id.spinner);
        submitButton = (Button) findViewById(R.id.submitButton);
        i = getIntent();
        ans = i.getIntExtra("ans", -1);
        passed = 0;
        i.putExtra("passed", passed);
        setResult(Activity.RESULT_CANCELED, i);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = spinner.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selection == ans)
                {
                    passed = 1;
                    i.putExtra("passed", passed);
                    setResult(Activity.RESULT_OK, i);
                }
            }
        });
    }
}
