package com.example.retrofitandrxjavademo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by libao on 2018/3/23.
 */

public interface ApiService  {

    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start,@Query("count") int count);
}
