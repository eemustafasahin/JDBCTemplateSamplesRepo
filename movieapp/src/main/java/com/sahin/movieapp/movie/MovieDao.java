package com.sahin.movieapp.movie;

import java.util.List;
import java.util.Optional;

/**
 * Created by M.Şahin on 29/11/2021
 */
public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
    // TODO: Update
}
