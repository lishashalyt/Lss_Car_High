package com.bawei.lss_car_high.presenter;

import android.util.Log;

import com.bawei.lss_car_high.Bean.DetailBean;
import com.bawei.lss_car_high.model.DetailModel;
import com.bawei.lss_car_high.view.IDetailView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by love_mysunshine on 2017/12/21.
 */

public class DetailPresenter {
    IDetailView iDetailView;
    DetailModel detailModel;
    List<DetailBean.SkuBean> detaillist=new ArrayList<>();

    public DetailPresenter(IDetailView iDetailView) {
        this.iDetailView = iDetailView;
        detailModel=new DetailModel();
    }

    public void dtailData(){
        String getid = iDetailView.getid();
        detailModel.getDetailData(getid,new Observer<DetailBean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("------","onError()"+e.toString());
            }

            @Override
            public void onNext(DetailBean detailBean) {
                detaillist.addAll(detailBean.getSku());
                iDetailView.showDetailData(detailBean);
            }

        });
    }
}
