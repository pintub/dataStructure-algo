package com.bookyourshow.Service;

import com.bookyourshow.model.Genre;
import com.bookyourshow.model.Movie;

import java.util.List;

public interface IMovieRepository {

    void addMovie(Movie movie);

    void deleteMovie(Movie movie);

    List<Movie> getMovies();

    List<Movie> getMovies(String movieName);

    List<Movie> getMovies(Genre genre);
}
