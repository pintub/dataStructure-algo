package com.bookyourshow.model;

import com.bookyourshow.Service.IFetchMovieService;

import java.util.List;

public class MovieGoer implements IPerson {

    private String lastName;
    private String firstName;
    private Address billingAddress;

    private IFetchMovieService fetchMovieService;

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    public List<Movie> getMovies() {
        return fetchMovieService.getMovies();
    }

    public List<Cinema> getCinemas() {
        //TODO similar to getMovies()
        return null;
    }

    public void bookTicket() {

    }

}
