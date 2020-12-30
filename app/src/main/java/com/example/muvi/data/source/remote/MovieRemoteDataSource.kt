package com.example.muvi.data.source.remote

import com.example.muvi.data.model.Actor
import com.example.muvi.data.model.Movie
import com.example.muvi.data.model.Search
import com.example.muvi.data.model.Video
import com.example.muvi.data.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable

class MovieRemoteDataSource(private val movieService: MovieService) : MovieDataSource.Remote {

    override fun getTrendingMovies(): Observable<List<Movie>> = movieService.getTrendingMovies()

    override fun getDiscoveryMovies(page: Int?): Observable<List<Movie>> =
        movieService.getDiscoveryMovies(page)

    override fun getTopRateMovies(page: Int?): Observable<List<Movie>> =
        movieService.getTopRateMovies(page)

    override fun getPopularMovies(page: Int?): Observable<List<Movie>> =
        movieService.getPopularMovies(page)

    override fun getRecommendMovies(movieId: Int): Observable<List<Movie>> =
        movieService.getRecommendMovies(movieId)

    override fun getActors(movieId: Int): Observable<List<Actor>> = movieService.getActors(movieId)

    override fun getVideo(movieId: Int): Observable<List<Video>> = movieService.getVideo(movieId)

    override fun search(param: String): Observable<List<Search>> = movieService.search(param)

    override fun getMoviesOfActor(actorId: Int): Observable<List<Movie>> =
        movieService.getMoviesOfActor(actorId)
}
