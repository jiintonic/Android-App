package itp341.yang.chingchuan.a9;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    int index;
    ImageView iv;
    TextView title, desc;
    private ArrayList<Movie> array;
    ArrayList<String> comments;
    ArrayAdapter<String> arrayAdpt;
    Movie m;
    Button commentButton;
    EditText commentEditText;
    ListView commentListView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       index = getIntent().getIntExtra("movie", 0);


        array = MovieManager.getInstance().movieList;
        m = array.get(index);
        iv = (ImageView) findViewById(R.id.movieImage);
        title = (TextView) findViewById(R.id.titleTextView);
        title.setText(m.getTitle());
        commentButton = (Button) findViewById(R.id.commentButton);
        commentEditText = (EditText) findViewById(R.id.commentEditText);
        commentListView = (ListView) findViewById(R.id.ListView);

        desc = (TextView) findViewById(R.id.descriptionTextView);
        desc.setText(m.getDescription());

        int genre = m.getGenre();
        if(genre == 0){
            iv.setImageDrawable(getResources().getDrawable(R.drawable.horror));
        }
        else if (genre == 1)
        {
            iv.setImageDrawable(getResources().getDrawable(R.drawable.drama));
        }
        else if(genre ==2)
        {
            iv.setImageDrawable(getResources().getDrawable(R.drawable.comedy));
        }
        else if(genre == 3)
        {
            iv.setImageDrawable(getResources().getDrawable(R.drawable.action));
        }
        else{
            iv.setImageDrawable(getResources().getDrawable(R.drawable.sci_fi));
        }
        comments = m.getComments();

        if(comments == null)
            comments = new ArrayList<String>();
        arrayAdpt= new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, comments);
        commentListView.setAdapter(arrayAdpt);

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String comment = commentEditText.getText().toString();

                comments.add(comment);
                arrayAdpt.notifyDataSetChanged();
                m.setComments(comments);
            }
        });





    }
}
