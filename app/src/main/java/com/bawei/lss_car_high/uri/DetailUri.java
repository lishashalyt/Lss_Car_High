package com.bawei.lss_car_high.uri;

import com.bawei.lss_car_high.Bean.CartBean;
import com.bawei.lss_car_high.Bean.DetailBean;
import com.bawei.lss_car_high.Bean.Tianjia;
import com.bawei.lss_car_high.Bean.XQBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by love_mysunshine on 2017/12/21.
 */

public interface DetailUri {
    @GET("v5/goods/202517471?pdduid=3470667255")
    Observable<DetailBean> getDatail(@Query("Goods_id") String goods_id);
    @GET("getProductDetail")
    Observable<XQBean> getXQ(@Query("pid")int pid, @Query("source")String str);
    @GET("addCart")
    Observable<Tianjia> getMsg(@Query("uid")int uid, @Query("pid")int pid, @Query("source")String str);
    @GET("getCarts")
    Observable<CartBean> getCart(@Query("uid")int uid, @Query("source")String str);
}
