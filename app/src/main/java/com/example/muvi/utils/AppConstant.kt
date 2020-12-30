package com.example.muvi.utils

object ApiConfig {
    private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "api_key"
}

object ApiEndPoint {
    const val PARAMS_ID = "id"
    const val PARAMS_PAGE = "page"
    const val GET_TRENDING_MOVIE = "trending/movie/day"
    const val GET_DISCOVERY_MOVIE = "discover/movie?sort_by=popularity.desc"
    const val GET_TOP_RATE_MOVIE = "movie/top_rated"
    const val GET_POPULAR_MOVIE = "movie/popular"
    const val GET_RECOMMEND_MOVIE = "movie/{id}/recommendations"
    const val GET_VIDEO = "movie/{id}/videos"
    const val SEARCH_MULTI = "search/multi"
    const val GET_MOVIE_OF_ACTOR = "person/{id}/movie_credits"
    const val GET_ACTOR_OF_MOVIE = "movie/{id}/credits"
}
