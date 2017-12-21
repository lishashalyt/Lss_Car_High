package com.bawei.lss_car_high.model;

import rx.Observer;

/**
 * Created by love_mysunshine on 2017/12/21.
 */

public interface IDetailModel {
    public void getDetailData(String goods_id,Observer observer);

}
