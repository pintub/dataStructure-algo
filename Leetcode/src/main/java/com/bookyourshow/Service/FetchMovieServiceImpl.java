package com.bookyourshow.Service;

import com.bookyourshow.model.Movie;

import java.util.List;

public class FetchMovieServiceImpl implements IFetchMovieService {

    private IMovieRepository repository;

    @Override
    public List<Movie> getMovies(String movieName) {
        return repository.getMovies(movieName);
    }

    @Override
    public List<Movie> getMovies() {
        return repository.getMovies();
    }

}