package com.example.muvi.data.repository

import com.example.muvi.data.model.*
import com.example.muvi.data.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable

class MovieRepositoryType(private val remote: MovieDataSource.Remote) : MovieRepository {

    override fun getMoviesByType(type: MovieType, page: Int?): Observable<List<Movie>> =
        when (type) {
            MovieType.TopRate -> remote.getTopRateMovies(page)
            MovieType.Popular -> remote.getPopularMovies(page)
            MovieType.Discovery -> remote.getDiscoveryMovies(page)
            MovieType.Trending -> remote.getTrendingMovies()
        }.map { getMovies(it) }

    override fun getRecommendMovies(movieId: Int): Observable<List<Movie>> =
        remote.getRecommendMovies(movieId).map {
            getMovies(it).filter { movie ->
                !movie.poster.isNullOrEmpty()
            }
        }

    override fun getActors(movieId: Int): Observable<List<Actor>> =
        remote.getActors(movieId).map {
            it.filter { actor ->
                !actor.avatar.isNullOrEmpty()
            }
        }

    override fun getVideo(movieId: Int): Observable<Video> =
        remote.getVideo(movieId).map { getTrailer(it) }

    override fun search(param: String): Observable<List<Search>> =
        remote.search(param).map {
            it.filter { item ->
                item.mediaType == Search.MOVIE || item.mediaType == Search.PERSON
            }
        }

    override fun getMoviesOfActor(actorId: Int): Observable<List<Movie>> =
        remote.getMoviesOfActor(actorId).map {
            getMovies(it)
        }

    private fun getMovies(movies: List<Movie>): List<Movie> =
        movies.mapNotNull {
            try {
                Movie(it)
            } catch (exception: IllegalArgumentException) {
                null
            }
        }

    private fun getTrailer(videos: List<Video?>): Video =
        videos.first {
            it?.type == Video.TYPE_TRAILER
        } ?: Video()
}
