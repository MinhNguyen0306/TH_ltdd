package com.example.ktck_thltdd_nguyenleminh;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class CaSiAdapter extends RecyclerView.Adapter<CaSiAdapter.FoodViewHolder>{
    Context context;
    List<CaSi> caSiList;

    public CaSiAdapter(Context mcontext) {
        this.context = mcontext;
    }

    public void setData(List<CaSi> list) {
        this.caSiList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        CaSi caSi = caSiList.get(position);

        holder.imgCasi.setImageResource(caSi.getImage());
        holder.txtTen.setText(caSi.getTen());
        holder.txtNgheDanh.setText(caSi.getNgheDanh());
        holder.txtQuocGia.setText(caSi.getQuocGia());
    }

    @Override
    public int getItemCount() {
        if(caSiList != null){
            return caSiList.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCasi;
        private TextView txtTen;
        private TextView txtNgheDanh;
        private TextView txtQuocGia;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCasi = itemView.findViewById(R.id.img_casi);
            txtNgheDanh = itemView.findViewById(R.id.txt_ngedanh);
            txtTen = itemView.findViewById(R.id.txt_ten);
            txtQuocGia = itemView.findViewById(R.id.txt_quocgia);
        }
    }
}
