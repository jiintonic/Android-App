package itp341.yang.chingchuan.a9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


public class CreateFragment extends Fragment {

    Spinner genreSpinner;
    ImageView movieImageView;
    EditText titleEditText, descriptionEditText;
    Button saveButton;
    int selection;
    String title, description;

    public CreateFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        genreSpinner = (Spinner) getView().findViewById(R.id.genreSpinner);
        movieImageView = (ImageView) getView().findViewById(R.id.movieImage);
        titleEditText = (EditText) getView().findViewById(R.id.titleEditText);
        descriptionEditText = (EditText) getView().findViewById(R.id.descriptionEditText);
        saveButton = (Button) getView().findViewById(R.id.saveButton);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = genreSpinner.getSelectedItemPosition();
                if(selection == 0){
                    movieImageView.setImageDrawable(getResources().getDrawable(R.drawable.horror));
                }
                else if (selection == 1)
                {
                    movieImageView.setImageDrawable(getResources().getDrawable(R.drawable.drama));
                }
                else if(selection ==2)
                {
                    movieImageView.setImageDrawable(getResources().getDrawable(R.drawable.comedy));
                }
                else if(selection == 3)
                {
                    movieImageView.setImageDrawable(getResources().getDrawable(R.drawable.action));
                }
                else{
                    movieImageView.setImageDrawable(getResources().getDrawable(R.drawable.sci_fi));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                title = titleEditText.getText().toString();
                description = descriptionEditText.getText().toString();
                Movie m = new Movie(title, description, selection);
                MovieManager.getInstance().add(m);
                getActivity().finish();

            }
        });
    }
}
