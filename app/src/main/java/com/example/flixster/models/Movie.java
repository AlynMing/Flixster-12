package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
//    String posterSize;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString(("backdrop_path"));
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");

    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }
/*public static List<String> toStringList(JSONArray movieJSONArray) throws JSONException {
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < movieJSONArray.length; i++){
            stringList.add(new String(String.valueOf(movieJSONArray.getJSONObject(i))));
        }
        return stringList;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public void setPosterSize(String posterSize) {
        this.posterSize = posterSize;
    }*/
}
