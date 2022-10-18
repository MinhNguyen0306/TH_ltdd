package com.example.bt9_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcv_user);
        adapter = new UserAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.setData(getUsers());
        recyclerView.setAdapter(adapter);
    }

    public List<UserModel> getUsers(){
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel("Minh"));
        list.add(new UserModel("Nam"));
        list.add(new UserModel("Ha"));
        list.add(new UserModel("Truong"));
        list.add(new UserModel("Huy"));
        list.add(new UserModel("Kha"));
        list.add(new UserModel("Ngoc"));
        list.add(new UserModel("Yen"));
        return list;
    }
}