package com.bawei.lss_car_high.uri;

import com.bawei.lss_car_high.Bean.ZiBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by love_mysunshine on 2017/12/20.
 */

public interface ZiUri {
    @GET("v5/newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255")
    Observable<ZiBean> getBanner();
}
