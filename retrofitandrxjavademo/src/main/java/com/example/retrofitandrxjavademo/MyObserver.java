package com.example.retrofitandrxjavademo;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by libao on 2018/3/23.
 */

public class MyObserver<T> implements Observer<T> {
    private static final String TAG = "MyObserver";
    private ObserverOnNextListener observerOnNextListener;
    public MyObserver(ObserverOnNextListener observerOnNextListener){
        this.observerOnNextListener=observerOnNextListener;
    }
    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(T t) {

        observerOnNextListener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
