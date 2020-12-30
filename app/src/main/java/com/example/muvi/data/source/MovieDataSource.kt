package com.example.muvi.data.source

import com.example.muvi.data.model.Actor
import com.example.muvi.data.model.Movie
import com.example.muvi.data.model.Search
import com.example.muvi.data.model.Video
import io.reactivex.rxjava3.core.Observable

interface MovieDataSource {
    interface Remote {
        fun getTrendingMovies(): Observable<List<Movie>>
        fun getDiscoveryMovies(page: Int? = null): Observable<List<Movie>>
        fun getTopRateMovies(page: Int? = null): Observable<List<Movie>>
        fun getPopularMovies(page: Int? = null): Observable<List<Movie>>
        fun getRecommendMovies(movieId: Int): Observable<List<Movie>>
        fun getActors(movieId: Int): Observable<List<Actor>>
        fun getVideo(movieId: Int): Observable<List<Video>>
        fun search(param: String): Observable<List<Search>>
        fun getMoviesOfActor(actorId: Int): Observable<List<Movie>>
    }
}
