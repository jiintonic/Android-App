package itp341.yang.chingchuan.a6;

import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, solveButton;
    int numWin;
    TextView textView1, textView2, textView3;
    private static final int REQUEST_CODE_FIRST_ACTIVITY = 1;
    private static final int REQUEST_CODE_SECOND_ACTIVITY = 2;
    private static final int REQUEST_CODE_THIRD_ACTIVITY = 3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        numWin = 0;
        solveButton = (Button) findViewById(R.id.buttonSolve);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                String message = "You WIN!";
                if(numWin != 3) message = "Try again.";
                i.putExtra("message", message);
                startActivity(i);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("r", 0);
                i.putExtra("g", 0);
                i.putExtra("b", 255);
                i.putExtra("numWin", numWin);
                startActivityForResult(i, REQUEST_CODE_FIRST_ACTIVITY);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondRoom.class);
                i.putExtra("ans", 2);
                startActivityForResult(i, REQUEST_CODE_SECOND_ACTIVITY);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThirdRoom.class);
                i.putExtra("ans", "AI");
                startActivityForResult(i, REQUEST_CODE_THIRD_ACTIVITY);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_FIRST_ACTIVITY)
        {
            int passed = data.getIntExtra("passed", 0);
            if(numWin+1 == REQUEST_CODE_FIRST_ACTIVITY && passed == 1)
            {
                numWin++;
                textView1.setTextColor(Color.rgb(0, 255, 0));

            }
        }
        else if(requestCode == REQUEST_CODE_SECOND_ACTIVITY)
        {
            int passed = data.getIntExtra("passed", 0);
            if(numWin+1 == REQUEST_CODE_SECOND_ACTIVITY && passed == 1)
            {
                numWin++;
                textView2.setTextColor(Color.rgb(0, 255, 0));
            }

        }
        else if(requestCode == REQUEST_CODE_THIRD_ACTIVITY)
        {
            int passed = data.getIntExtra("passed", 0);
            if(numWin+1 == REQUEST_CODE_THIRD_ACTIVITY && passed == 1)
            {
                numWin++;
                textView3.setTextColor(Color.rgb(0, 255, 0));
            }
        }
    }
}
