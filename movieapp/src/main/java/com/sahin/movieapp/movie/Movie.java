package com.sahin.movieapp.movie;

import com.sahin.movieapp.actor.Actor;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by M.Şahin on 29/11/2021
 */
public record Movie(Integer id, String name, List<Actor> actors, LocalDate releaseDate)
{

}
