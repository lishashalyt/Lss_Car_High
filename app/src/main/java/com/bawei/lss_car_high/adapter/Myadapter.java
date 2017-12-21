package com.bawei.lss_car_high.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.lss_car_high.Bean.ZiBean;
import com.bawei.lss_car_high.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by love_mysunshine on 2017/12/20.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<ZiBean.GoodsListBean> zilist=new ArrayList<>();

    /*点击rv的item跳转*/
    OnItemClickListener listener;
    public interface OnItemClickListener{
        /*注意参数*/
        public void OnItemClick(View v, int position, int id);
    }
    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }

    public Myadapter(Context context, List<ZiBean.GoodsListBean> zilist) {
        this.context = context;
        this.zilist = zilist;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rv,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;

        myViewHolder.tu.setImageURI(zilist.get(position).getImage_url());
        myViewHolder.zi.setText(zilist.get(position).getGoods_name());

         /*点击rv的item跳转*/
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    /*注意参数*/
                    listener.OnItemClick(v,position,zilist.get(position).getGoods_id());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return zilist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView tu;
        TextView zi;
        public MyViewHolder(View itemView) {
            super(itemView);
            tu = itemView.findViewById(R.id.tu);
            zi = itemView.findViewById(R.id.zi);
        }
    }
}
