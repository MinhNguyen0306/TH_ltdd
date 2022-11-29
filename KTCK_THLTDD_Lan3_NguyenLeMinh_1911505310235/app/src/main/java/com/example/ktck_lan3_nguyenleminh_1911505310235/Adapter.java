package com.example.ktck_lan3_nguyenleminh_1911505310235;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ModelViewHolder>{

    Context context;
    List<Language> languages;


    public Adapter(Context context, List<Language> languages) {
        this.context = context;
        this.languages = languages;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        Language language = languages.get(position);


        holder.imageView.setImageResource(language.getAnhBia());
        holder.txtNgonNgu.setText(language.getLanguageName());


        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(language);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(languages != null){
            return languages.size();
        }
        return 0;
    }

    private void onClickGoToDetail(Language language){
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("language", (Serializable) language);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtNgonNgu;
        private LinearLayout layoutItem;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item);
            txtNgonNgu = itemView.findViewById(R.id.ngonngu);
            layoutItem = itemView.findViewById(R.id.item_list);
        }
    }
}
