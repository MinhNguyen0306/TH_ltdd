package com.example.ktck_thltdd_nguyenleminh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView edtTenKhoaHoc;
    private TextView edtTenThuongGoi;
    private TextView edtDacTinh;
    private TextView edtMauSac;
    private TextView edtHinhAnh;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnBack = (Button) findViewById(R.id.btn_back);
        edtTenKhoaHoc = (TextView) findViewById(R.id.detail_tenkhoahoc);
        edtTenThuongGoi = (TextView) findViewById(R.id.detail_tenthuonggoi);
        edtDacTinh = (TextView) findViewById(R.id.detail_dactinh);
        edtMauSac = (TextView) findViewById(R.id.detail_mausac);
        edtHinhAnh = (TextView) findViewById(R.id.detail_hinhanh);

        Bundle bundle = getIntent().getBundleExtra("data");
        if(bundle != null){
            Ca ca = (Ca) bundle.getSerializable("ca");
            edtTenKhoaHoc.setText(ca.getTenKhoaHoc());
            edtTenThuongGoi.setText(ca.getTenThuongGoi());
            edtDacTinh.setText(ca.getDacTinh());
            edtMauSac.setText(ca.getMauSac());
            edtHinhAnh.setText(String.valueOf(ca.getHinhAnh()));
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBackList();
            }
        });
    }

    private void onClickBackList() {
        Intent intent = new Intent(DetailActivity.this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}