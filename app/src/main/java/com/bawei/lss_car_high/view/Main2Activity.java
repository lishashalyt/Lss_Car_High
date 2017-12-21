package com.bawei.lss_car_high.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bawei.lss_car_high.Bean.DetailBean;
import com.bawei.lss_car_high.R;
import com.bawei.lss_car_high.presenter.DetailPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main2Activity extends AppCompatActivity implements IDetailView {

    private String id;
    private SimpleDraweeView mTu02;
    private TextView mZi02;
   /* private Button button;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        new DetailPresenter(this).dtailData();
/*接收MainActivity传来的ID*/
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
    }


    @Override
    public void showDetailData(DetailBean detailBean) {
        String goods_name = detailBean.getGoods_name();
        String image_url = detailBean.getImage_url();
        Uri uri=Uri.parse(image_url);
        mTu02.setImageURI(uri);
        mZi02.setText(goods_name);

    }

    @Override
    public String getid() {
        return id;
    }

    private void initView() {
        mTu02 = (SimpleDraweeView) findViewById(R.id.tu02);
        mZi02 = (TextView) findViewById(R.id.zi02);
       /* button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
