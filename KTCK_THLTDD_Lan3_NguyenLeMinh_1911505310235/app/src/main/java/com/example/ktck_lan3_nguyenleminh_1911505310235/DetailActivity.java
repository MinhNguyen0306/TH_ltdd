package com.example.ktck_lan3_nguyenleminh_1911505310235;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView txtTenNN;
    private EditText edtThemViDu;
    private RecyclerView rcv;
    private ImageView imgDetail;
    private Button btnBack;
    private Button btnLuu;

    private List<String> viduList;
    private ViDuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnLuu = (Button) findViewById(R.id.btn_luu);
        txtTenNN = (TextView) findViewById(R.id.detail_ten_ngonngu);
        edtThemViDu = (EditText) findViewById(R.id.edt_them_vidu);
        rcv = (RecyclerView) findViewById(R.id.rcv_detail_ngonngu);
        imgDetail = (ImageView) findViewById(R.id.img_detail_ngonngu);

        Bundle bundle = getIntent().getBundleExtra("data");
        if(bundle != null){
            Language language = (Language) bundle.getSerializable("language");
            txtTenNN.setText(language.getLanguageName());
            imgDetail.setImageResource(language.getAnhBia());

//            viduList = language.getExample();
        }



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);

        adapter = new ViDuAdapter(this, viduList);
        rcv.setAdapter(adapter);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themViDu(edtThemViDu.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBackList();
            }
        });
    }

    private void themViDu(String vidu) {
        viduList.add(vidu);
        adapter.notifyDataSetChanged();
    }

    private void onClickBackList() {
        Intent intent = new Intent(DetailActivity.this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}