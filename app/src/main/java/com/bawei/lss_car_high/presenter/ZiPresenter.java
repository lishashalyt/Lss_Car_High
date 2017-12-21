package com.bawei.lss_car_high.presenter;

import android.util.Log;

import com.bawei.lss_car_high.Bean.ZiBean;
import com.bawei.lss_car_high.model.ZiModel;
import com.bawei.lss_car_high.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by love_mysunshine on 2017/12/20.
 */

public class ZiPresenter {
    IMainActivity iMainActivity;
    ZiModel ziModel;
    List<ZiBean.GoodsListBean> zilist=new ArrayList<>();

    public ZiPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        ziModel=new ZiModel();
    }

    public void ziData(){
        ziModel.getZiData(new Observer<ZiBean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("------","onError()"+e.toString());
            }

            @Override
            public void onNext(ZiBean ziBean) {
                zilist.addAll(ziBean.getGoods_list());
                iMainActivity.showZiData(zilist);
            }

        });
    }
}
