package com.example.retrofitandrxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    public static String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){

//        Observer<Movie> observer=new Observer<Movie>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(Movie movie) {
//
//                Log.d(TAG, "onNext: " + movie.getTitle());
//                List<Movie.Subjects> list = movie.getSubjects();
//                for (Movie.Subjects sub : list) {
//                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: " + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: Over!");
//            }
//        };
//        ApiMethods.getTopMovie(observer,0,10);

        ObserverOnNextListener<Movie> observerOnNextListener=new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                Log.d(TAG, "onNext: " + movie.getTitle());
                List<Movie.Subjects> list = movie.getSubjects();
                for (Movie.Subjects sub : list) {
                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
            }
        };
        //分支
        ApiMethods.getTopMovie(new MyObserver<Movie>(observerOnNextListener),0,10);
    }
}
