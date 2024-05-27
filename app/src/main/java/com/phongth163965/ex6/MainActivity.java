package com.phongth163965.ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtMa, txtTen, txtSL;
    Button btnLoad, btnThem, btnSua, btnXoa;
    ListView lv;
    SanPhamDAO sanPhamDAO;
    ArrayAdapter<String> arrayAdapter;
    List<String> ds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMa = findViewById(R.id.ex6TxtMaSP);
        txtTen = findViewById(R.id.ex6TxtTenSP);
        txtSL = findViewById(R.id.ex6TxtSLSP);
        btnLoad = findViewById(R.id.ex6BtnLoad);
        btnThem = findViewById(R.id.ex6BtnAdd);
        btnSua = findViewById(R.id.Slot6BtnUpdate);
        btnXoa = findViewById(R.id.ex6BtnDelete);
        lv = findViewById(R.id.ex6lv);
        sanPhamDAO = new SanPhamDAO(this);
        ds.clear();
        ds = sanPhamDAO.getAllProductToString();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds);
        lv.setAdapter(arrayAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham s = new SanPham();
                s.setMasp(txtMa.getText().toString());
                s.setTensp(txtTen.getText().toString());
                s.setSoLuongSP(Integer.parseInt(txtSL.getText().toString()));
                int kq = sanPhamDAO.insertProduct(s);
                if(kq==-1){
                    Toast.makeText(getApplicationContext(),
                            "Insert that bai", Toast.LENGTH_SHORT).show();
                }if(kq==1){
                    Toast.makeText(getApplicationContext(),
                            "Insert thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = sanPhamDAO.deleteProduct(txtMa.getText().toString());
                if(kq==-1){
                    Toast.makeText(getApplicationContext(),
                            "Delete that bai", Toast.LENGTH_SHORT).show();
                }if(kq==1){
                    Toast.makeText(getApplicationContext(),
                            "Delete thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham s = new SanPham();
                s.setMasp(txtMa.getText().toString());
                s.setTensp(txtTen.getText().toString());
                s.setSoLuongSP(Integer.parseInt(txtSL.getText().toString()));
                int kq = sanPhamDAO.updateProduct(s);
                if(kq==-1){
                    Toast.makeText(getApplicationContext(),
                            "Sua that bai", Toast.LENGTH_SHORT).show();
                }if(kq==1){
                    Toast.makeText(getApplicationContext(),
                            "Sua thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds.clear();
                ds = sanPhamDAO.getAllProductToString();
                arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, ds);
                lv.setAdapter(arrayAdapter);
            }
        });
    }
}