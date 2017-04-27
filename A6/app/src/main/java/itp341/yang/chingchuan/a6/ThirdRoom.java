package itp341.yang.chingchuan.a6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ThirdRoom extends AppCompatActivity {
    EditText editText;
    Intent i;
    int passed;
    Button submitButton;
    String userInput ="", ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdroomlayout);
        editText = (EditText) findViewById(R.id.editText);
        submitButton = (Button) findViewById(R.id.submitButton);
        i = getIntent();
        ans = i.getStringExtra("ans");
        passed = 0;
        i.putExtra("passed", passed);
        setResult(Activity.RESULT_CANCELED, i);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                userInput = editText.getText().toString();
                return false;
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInput.equals(ans))
                {
                    passed = 1;
                    i.putExtra("passed", passed);
                    setResult(Activity.RESULT_OK, i);
                }
            }
        });

    }
}
