package itp341.yang.chingchuan.a9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jin Yang on 3/22/2017.
 */

public class Movie {
    String title, description, url;
    int genre;
    ArrayList<String> comments;

    public Movie(String title, String description, String url, int genre, ArrayList<String> comments) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.genre = genre;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", genre=" + genre +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public Movie(String title, String description, int genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.url = "";
        this.comments = null;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public int getGenre() {
        return genre;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
}
