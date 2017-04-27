package itp341.yang.chingchuan.a9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;


public class MovieListFragment extends Fragment {
    MovieAdapter movieAdapter;
    ImageView movieImageView;
    ListView movieList;
    public MovieListFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie_list, container, false);

        return v;
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieAdapter = new MovieAdapter(getActivity(), MovieManager.getInstance().movieList);
        movieList = (ListView) getView().findViewById(R.id.ListView);
        movieList.setAdapter(movieAdapter);

    }

    public void refresh(){
        movieAdapter.notifyDataSetChanged();
    }


}
