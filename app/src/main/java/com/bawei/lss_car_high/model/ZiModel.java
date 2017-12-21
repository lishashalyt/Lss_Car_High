package com.bawei.lss_car_high.model;

import com.bawei.lss_car_high.uri.RetrofitManager;
import com.bawei.lss_car_high.uri.ZiUri;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by love_mysunshine on 2017/12/20.
 */

public class ZiModel implements IZiModel{

    @Override
    public void getZiData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv3.yangkeduo.com/",client)
                .setCreate(ZiUri.class).getBanner()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
