package com.example.ktck_thltdd_nguyenleminh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private List<Ca> caList;
    private CaAdapter adapter;
    private RecyclerView rcv;
    private Button btnLogout;
    private Button btnThem;
    private EditText edtId;
    private EditText edtTenKhoaHoc;
    private EditText edtTenThuongGoi;
    private EditText edtDacTinh;
    private EditText edtMauSac;
    private EditText edtHinhAnh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rcv = (RecyclerView) findViewById(R.id.rcv_casi);
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnThem = (Button) findViewById(R.id.btn_add_ca);
        edtId = (EditText) findViewById(R.id.edt_id);
        edtTenKhoaHoc = (EditText) findViewById(R.id.edt_tenkhoahoc);
        edtTenThuongGoi = (EditText) findViewById(R.id.edt_tenthuonggoi);
        edtDacTinh = (EditText) findViewById(R.id.edt_dactinh);
        edtMauSac = (EditText) findViewById(R.id.edt_mausac);
        edtHinhAnh = (EditText) findViewById(R.id.edt_hinhanh);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);

        caList = new ArrayList<>();
        adapter = new CaAdapter(this, caList, new CaAdapter.IClickListener() {
            @Override
            public void onCLickDeleteItem(Ca ca) {
                onCLickDeleteData(ca);
            }
        });
//        adapter.setData(getAllCaFromFirebase());
        rcv.setAdapter(adapter);

        getAllCaFromFirebase();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString().trim());
                String tenKhoaHoc = edtTenKhoaHoc.getText().toString().trim();
                String MauSac = edtMauSac.getText().toString().trim();
                String tenThuongGoi = edtTenThuongGoi.getText().toString().trim();
                String dacTinh = edtDacTinh.getText().toString().trim();
                int hinhAnh = Integer.parseInt(edtHinhAnh.getText().toString().trim());

                Ca ca = new Ca(id, tenKhoaHoc, tenThuongGoi, dacTinh, MauSac, hinhAnh);
                onCLickAddCa(ca);
            }
        });
    }

    private void onCLickDeleteData(Ca ca) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage("Ban co chac muon xoa item khong?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("list_ca");

                        myRef.child(String.valueOf(ca.getId())).removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Toast.makeText(ListActivity.this, "Delete success!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    public void onCLickAddCa(Ca ca) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_ca");

        String pathObject = String.valueOf(ca.getId());
        myRef.child(pathObject).setValue(ca, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Log.e("SCCC", "Add ca success!!");
                Toast.makeText(ListActivity.this, "Added success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllCaFromFirebase(){
//        caSiList = new ArrayList<>();
//        caSiList.add(new CaSi("Ariana Grande", "AG", "USA", 5, R.drawable.ariana));
//        caSiList.add(new CaSi("Adele", "ADE", "USA", 5, R.drawable.ariana));
//        caSiList.add(new CaSi("Taylor Swift", "TL", "USA", 5, R.drawable.ariana));
//        return caSiList;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_ca");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Ca ca = snapshot.getValue(Ca.class);
                if(ca != null) {
                    caList.add(ca);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Ca ca = snapshot.getValue(Ca.class);

                if(ca == null || caList == null || caList.isEmpty()) {
                    return;
                }

                for(int i = 0; i < caList.size(); i++){
                    if(ca.getId() == caList.get(i).getId()) {
                        caList.remove(caList.get(i));
                        break;
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Logout(){
        Intent intent = new Intent(ListActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}