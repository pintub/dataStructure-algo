package com.bookyourshow.Service;

import com.bookyourshow.model.Movie;

import java.util.List;

public interface IFetchMovieService {

    List<Movie> getMovies(String movieName);

    List<Movie> getMovies();
}
