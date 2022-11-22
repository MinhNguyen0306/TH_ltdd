package com.example.ktck_thltdd_nguyenleminh;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class CaAdapter extends RecyclerView.Adapter<CaAdapter.CaViewHolder>{

    Context context;
    List<Ca> caList;
    private IClickListener mIClickListener;

    public interface IClickListener {
        void onCLickDeleteItem(Ca ca);
    }

    public CaAdapter(Context mcontext, List<Ca> caList, IClickListener listener) {
        this.context = mcontext;
        this.caList = caList;
        this.mIClickListener = listener;
    }

//    public void setData(List<Ca> list) {
//        this.caList = list;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public CaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaViewHolder holder, int position) {
        Ca ca = caList.get(position);

//        holder.imgCa.setImageResource(ca.getHinhAnh());
        holder.txtTenKhoaHoc.setText(ca.getTenKhoaHoc());
        holder.txtTenThuongGoi.setText(ca.getTenThuongGoi());
        holder.txtDacTinh.setText(ca.getDacTinh());
        holder.txtMauSac.setText(ca.getMauSac());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(ca);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIClickListener.onCLickDeleteItem(ca);
            }
        });
    }

    private void onClickGoToDetail(Ca ca){
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("ca", (Serializable) ca);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if(caList != null){
            return caList.size();
        }
        return 0;
    }

    public class CaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCa;
        private TextView txtTenKhoaHoc;
        private TextView txtTenThuongGoi;
        private TextView txtMauSac;
        private TextView txtDacTinh;
        private Button btnDelete;
        private LinearLayout layoutItem;

        public CaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCa = itemView.findViewById(R.id.img_ca);
            txtDacTinh = itemView.findViewById(R.id.txt_dac_tinh);
            txtMauSac = itemView.findViewById(R.id.txt_mau_sac);
            txtTenKhoaHoc = itemView.findViewById(R.id.txt_ten_khoa_hoc);
            txtTenThuongGoi = itemView.findViewById(R.id.txt_ten_thuong_goi);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            layoutItem = itemView.findViewById(R.id.item_ca);

        }
    }
}
