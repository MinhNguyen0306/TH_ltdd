package com.example.ktck_lan3_nguyenleminh_1911505310235;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViDuAdapter extends RecyclerView.Adapter<ViDuAdapter.ModelViewHolder>{

    Context context;
    List<String> viduList;

    public ViDuAdapter(Context context, List<String> vidu) {
        this.context = context;
        this.viduList = vidu;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vidu, parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        String vidu = viduList.get(position);
        holder.txtViDu.setText(vidu);
    }

    @Override
    public int getItemCount() {
        if(viduList != null){
            return viduList.size();
        }
        return 0;
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        private TextView txtViDu;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViDu = itemView.findViewById(R.id.vidu);
        }
    }
}
