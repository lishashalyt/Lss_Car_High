package com.bawei.lss_car_high.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bawei.lss_car_high.Bean.ZiBean;
import com.bawei.lss_car_high.R;
import com.bawei.lss_car_high.adapter.Myadapter;
import com.bawei.lss_car_high.presenter.ZiPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private RecyclerView mRv;
    private Myadapter myadapter;
    private ZiPresenter ziPresenter;
    private  List<ZiBean.GoodsListBean> zilist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       /* mRv.setLayoutManager(new LinearLayoutManager(this));*/
      mRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ziPresenter = new ZiPresenter(this);
        ziPresenter.ziData();
        zilist=new ArrayList<>();
        showZiData(zilist);
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }


    @Override
    public void showZiData(List<ZiBean.GoodsListBean> zilist) {
        myadapter=new Myadapter(MainActivity.this,zilist);
        mRv.setAdapter(myadapter);

          /*点击rv的item跳转*/
    myadapter.setOnItemClick(new Myadapter.OnItemClickListener() {
        @Override
        public void OnItemClick(View v, int position, int id) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
              /* 传ID在Main2Activity接受*/
                intent.putExtra("id",id);
            startActivity(intent);
        }
    });
    }
}
