package itp341.yang.chingchuan.a6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    TextView messageTextView;
    Intent i;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        i = getIntent();
        messageTextView = (TextView) findViewById(R.id.textView);
        messageTextView.setText(i.getStringExtra("message"));

    }
}
