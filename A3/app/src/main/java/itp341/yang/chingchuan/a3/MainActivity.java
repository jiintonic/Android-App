package itp341.yang.chingchuan.a3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static itp341.yang.chingchuan.a3.R.string.label_chinese;

public class MainActivity extends AppCompatActivity {
    ImageView chineseFood, americanFood, indianFood, italianFood, meFood, portugueseFood;
    int c, a, i, it, m, p ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            c = savedInstanceState.getInt("c", 0);
            p = savedInstanceState.getInt("p", 0);
            a = savedInstanceState.getInt("a", 0);
            i = savedInstanceState.getInt("i", 0);
            it = savedInstanceState.getInt("it", 0);
            m = savedInstanceState.getInt("m", 0);
        }
        setContentView(R.layout.activity_main);
        chineseFood = (ImageView) findViewById(R.id.chinesefood);
        americanFood = (ImageView) findViewById(R.id.americanfood);
        indianFood = (ImageView) findViewById(R.id.indianfood);
        italianFood = (ImageView) findViewById(R.id.italianfood);
        meFood = (ImageView) findViewById(R.id.mefood);
        portugueseFood = (ImageView) findViewById(R.id.portuguesefood);

        Glide.with(this).load(getResources().getString(R.string.label_chinese)).into(chineseFood);
        Glide.with(this).load(getResources().getString(R.string.label_america)).into(americanFood);
        Glide.with(this).load(getResources().getString(R.string.label_indian)).into(indianFood);
        Glide.with(this).load(getResources().getString(R.string.label_italian)).into(italianFood);
        Glide.with(this).load(getResources().getString(R.string.label_portuguese)).into(portugueseFood);
        Glide.with(this).load(getResources().getString(R.string.label_me)).into(meFood);
        chineseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                String display = "You Liked Chinese " + String.valueOf(c) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });

        americanFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                String display = "You Liked American " + String.valueOf(a) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });

        italianFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it++;
                String display = "You Liked Italian " + String.valueOf(it) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });

        portugueseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p++;
                String display = "You Liked Portuguese " + String.valueOf(p) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });

        meFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m++;
                String display = "You Liked Middle East " + String.valueOf(m) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });

        indianFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                String display = "You Liked Indian " + String.valueOf(i) + " times";
                Toast.makeText(MainActivity.this,
                        display,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
    protected void onSaveInstanceState(Bundle state) {

        state.putInt("c", c);
        state.putInt("a", a);
        state.putInt("i", i);
        state.putInt("it", it);
        state.putInt("p", p);
        state.putInt("m", m);
    }
}
