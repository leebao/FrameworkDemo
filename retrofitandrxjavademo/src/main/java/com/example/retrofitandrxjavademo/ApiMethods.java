package com.example.retrofitandrxjavademo;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by libao on 2018/3/23.
 */

public class ApiMethods {
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public static void getTopMovie(Observer<Movie> observer,int start,int count){
        ApiSubscribe(Api.getApiService().getTopMovie(start,count),observer);
    }
}
