package com.sahin.movieapp.movie;

import com.sahin.movieapp.actor.Actor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by M.Şahin on 29/11/2021
 */
@Repository
public class MovieDaoImpl implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDaoImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*  ups function definition
        create or replace function ups(name varchar(100))
        returns varchar(100) as $$
            begin
                return name || '-' || 'musti';
            end;
            $$ language plpgsql;

     */
    @Override
    public List<Movie> selectMovies()
    {
        var sql = """
                select id,initcap(name) as name,movieapp.public.ups(name) as ups,release_date from movieapp.public.movie limit 10;
                """;

        return jdbcTemplate.query(sql, (rs,rows) -> {
            return new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    List.of(new Actor(1,rs.getString("ups"))),
                    LocalDate.parse(rs.getString("release_date"))
            );
        });
    }

    @Override
    public int insertMovie(Movie movie)
    {
       String sql = """
            INSERT INTO movieapp.public.movie(name,release_date) values(?,?);
            """;

       return jdbcTemplate.update(sql,movie.name(),movie.releaseDate());
    }

    @Override
    public int deleteMovie(int id)
    {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public Optional<Movie> selectMovieById(int id)
    {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
