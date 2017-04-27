package itp341.yang.chingchuan.a9;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    MovieListFragment movieListFragment;

    static final int REQUEST_CODE_CREATE_ACTIVITY = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        movieListFragment = new MovieListFragment();
        fragmentTransaction.add(R.id.movieListLayout, movieListFragment);
        fragmentTransaction.commit();

        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), CreateActivity.class);
                startActivityForResult(i, REQUEST_CODE_CREATE_ACTIVITY);

            }
        });

    //    ArrayAdapter<Movie> arrayAdpt= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies);
        //movieList.setAdapter(arrayAdpt);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_ACTIVITY) {
            movieListFragment.refresh();
        }
    }
}
