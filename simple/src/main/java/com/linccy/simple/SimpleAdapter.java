package com.linccy.simple;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linccy.adapterdraweeview.AdaptiveSimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 自适应图片大小的SimpleDraweeView 适配器
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<LocalData.DataBean> dataBeanList = new ArrayList<>();

    public SimpleAdapter() {
    }

    public SimpleAdapter(List<LocalData.DataBean> dataBeanList) {
        this.dataBeanList.clear();
        this.dataBeanList.addAll(dataBeanList);
    }

    public void setNewData(List<LocalData.DataBean> dataBeanList) {
        this.dataBeanList.clear();
        this.dataBeanList.addAll(dataBeanList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adaptive_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocalData.DataBean item = dataBeanList.get(position);
        holder.tvContent.setText(item.getText());
        holder.img.setImageURI(item.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return dataBeanList == null ? 0 : dataBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        AdaptiveSimpleDraweeView img;

        ViewHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            img = (AdaptiveSimpleDraweeView) itemView.findViewById(R.id.img_big_adaptive);
        }
    }
}
