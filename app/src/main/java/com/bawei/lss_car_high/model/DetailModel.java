package com.bawei.lss_car_high.model;

import com.bawei.lss_car_high.uri.DetailUri;
import com.bawei.lss_car_high.uri.RetrofitManager;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by love_mysunshine on 2017/12/21.
 */

public class DetailModel implements IDetailModel{

    @Override
    public void getDetailData(String goods_id, Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv4.yangkeduo.com/",client)
                .setCreate(DetailUri.class).getDatail(goods_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
