package com.example.ktck_thltdd_nguyenleminh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private List<CaSi> caSiList;
    private CaSiAdapter adapter;
    private RecyclerView rcv;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rcv = (RecyclerView) findViewById(R.id.rcv_casi);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);

        adapter = new CaSiAdapter(this);
        adapter.setData(getAllCaSi());
        rcv.setAdapter(adapter);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }

    private List<CaSi> getAllCaSi(){
        caSiList = new ArrayList<>();
        caSiList.add(new CaSi("Ariana Grande", "AG", "USA", 5, R.drawable.ariana));
        caSiList.add(new CaSi("Adele", "ADE", "USA", 5, R.drawable.ariana));
        caSiList.add(new CaSi("Taylor Swift", "TL", "USA", 5, R.drawable.ariana));
        return caSiList;
    }

    public void Logout(){
        Intent intent = new Intent(ListActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}