package com.example.bt9_recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<UserModel> list;

    public UserAdapter(Context context){this.context = context;}

    public void setData(List<UserModel> users) {
        this.list = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel userModel = list.get(position);
        if(userModel == null){
            return;
        }

        holder.tvicon.setText(String.valueOf(userModel.getFirstChar()));
        holder.tvname.setText(userModel.getName());
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvname;
        private TextView tvicon;

        public UserViewHolder (@NonNull View itemView){
            super(itemView);

            tvicon = itemView.findViewById(R.id.tv_icon);
            tvname = itemView.findViewById(R.id.tv_name);
        }
    }

}
