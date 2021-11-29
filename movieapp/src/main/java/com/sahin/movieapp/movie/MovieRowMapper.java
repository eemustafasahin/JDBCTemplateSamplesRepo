package com.sahin.movieapp.movie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by M.Şahin on 30/11/2021
 */
public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                null,
                 LocalDate.parse(rs.getString("release_date"))
        );
    }
}
