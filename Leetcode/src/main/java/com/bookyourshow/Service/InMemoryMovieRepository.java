package com.bookyourshow.Service;

import com.bookyourshow.model.Genre;
import com.bookyourshow.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieRepository implements IMovieRepository{

    private List<Movie> movies = new ArrayList<>();

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        //delete
    }

    @Override
    public List<Movie> getMovies() {
        return null;
    }

    @Override
    public List<Movie> getMovies(String movieName) {
        return null;
    }

    @Override
    public List<Movie> getMovies(Genre genre) {
        return null;
    }
}
