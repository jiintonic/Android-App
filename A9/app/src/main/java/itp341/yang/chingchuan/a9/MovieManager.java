package itp341.yang.chingchuan.a9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Jin Yang on 3/29/2017.
 */

public class MovieManager {

        private static MovieManager instance;
        ArrayList<Movie> movieList;

        Context context;

        MovieManager(Context context)
        {
            this.context = context;
        }
    protected MovieManager(){
        movieList = new ArrayList<Movie>();
    }


        public static MovieManager getInstance() {
            if(instance == null)
                instance = new MovieManager();
            return instance;
        }

    public void add(Movie m){
        movieList.add(m);
    }


}
