CREATE TABLE actor
(
    id    bigserial primary key,
    name  TEXT NOT NULL,
    movie_id bigint REFERENCES movieapp.public.movie(id),
    unique (name, movie_id)
);