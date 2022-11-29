package com.example.ktck_lan3_nguyenleminh_1911505310235;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ImageView imageView;
    private RecyclerView rcv;
    private TextView tenNgonNgu;
    private List<Language> languages;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initUI();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);

        languages = getAllItem();
        adapter = new Adapter(this, languages);
        rcv.setAdapter(adapter);
    }

    public void initUI() {
        rcv = (RecyclerView) findViewById(R.id.rcv_ngonngu);
        imageView = (ImageView) findViewById(R.id.img_item);
        tenNgonNgu = (TextView) findViewById(R.id.ngonngu);
    }

    public List<Language> getAllItem(){
        List<Language> languages = new ArrayList<>();
        languages.add(new Language(1, "Tiếng Nga"));
        languages.add(new Language(2, "Tiếng Trung QUoc"));
        languages.add(new Language(3, "Tiếng Anh"));
        languages.add(new Language(4, "Tiếng Nhật"));
        languages.add(new Language(5, "Tiếng Hàn"));

        return  languages;
    }
}