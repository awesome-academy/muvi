package com.example.muvi.data.source.remote

import com.example.muvi.data.model.Actor
import com.example.muvi.data.model.Movie
import com.example.muvi.data.model.Search
import com.example.muvi.data.model.Video
import com.example.muvi.utils.ApiEndPoint
import com.example.muvi.utils.ApiEndPoint.PARAMS_ID
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(ApiEndPoint.GET_TRENDING_MOVIE)
    fun getTrendingMovies(): Observable<List<Movie>>

    @GET(ApiEndPoint.GET_DISCOVERY_MOVIE)
    fun getDiscoveryMovies(@Query(ApiEndPoint.PARAMS_PAGE) page: Int? = null): Observable<List<Movie>>

    @GET(ApiEndPoint.GET_TOP_RATE_MOVIE)
    fun getTopRateMovies(@Query(ApiEndPoint.PARAMS_PAGE) page: Int? = null): Observable<List<Movie>>

    @GET(ApiEndPoint.GET_POPULAR_MOVIE)
    fun getPopularMovies(@Query(ApiEndPoint.PARAMS_PAGE) page: Int? = null): Observable<List<Movie>>

    @GET(ApiEndPoint.GET_RECOMMEND_MOVIE)
    fun getRecommendMovies(@Path(PARAMS_ID) movieId: Int): Observable<List<Movie>>

    @GET(ApiEndPoint.GET_ACTOR_OF_MOVIE)
    fun getActors(@Path(PARAMS_ID) movieId: Int): Observable<List<Actor>>

    @GET(ApiEndPoint.GET_VIDEO)
    fun getVideo(@Path(PARAMS_ID) movieId: Int): Observable<List<Video>>

    @GET(ApiEndPoint.SEARCH_MULTI)
    fun search(@Query("query") param: String): Observable<List<Search>>

    @GET(ApiEndPoint.GET_MOVIE_OF_ACTOR)
    fun getMoviesOfActor(@Path(PARAMS_ID) actorId: Int): Observable<List<Movie>>
}
