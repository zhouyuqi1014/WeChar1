package com.example.wechar2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechar2.MainActivity2;
import com.example.wechar2.R;
import com.example.wechar2.data.item_data_bean;
import com.example.wechar2.data.item_datas_titles;
import com.example.wechar2.data.item_datas_icons;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<item_data_bean> mData;
    private View view;

    public RecyclerViewAdapter(Context con,List<item_data_bean> data){
        this.mData = data;
        context = con;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建ViewHolder，返回布局
        view = LayoutInflater.from(context).inflate(R.layout.friends_item_view,parent,false);
        RecyclerViewAdapter.MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        //设置数据
//        item_data_bean  a = mData.get(position);
//
//        holder.mIcon.setImageResource(a.icons);
//        holder.mTitle.setText(a.title);
        holder.mTitle.setText(item_datas_titles.titles[position]);
        holder.mIcon.setImageResource(item_datas_icons.icons[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击条目进行跳转
                Intent intent = new Intent(context, MainActivity2.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //返回条目的数量
        if (mData != null){
            return mData.size();
        }
        return 0;
    }
   public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;

        //定义一个方法找到对应的控件
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);
        }

//        //定义一个方法将数据传入控件
//        public void setItem_data_beans(item_data_bean data){
//            mIcon.setImageResource(data.icons);
//            mTitle.setText(data.title);
//
//        }
    }
}
