package com.example.nguyenhaily_ltdtdd_hk122_giuaky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListBook extends AppCompatActivity {
    private ListView lvSach;
    ArrayList<Sach> arraySach;
    SachAdapter adapter;
    private com.google.android.material.bottomnavigation.BottomNavigationView BottomNavigationView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        BottomNavigationView = findViewById(R.id.navigationView);
        AnhXa();

        adapter = new SachAdapter(this,R.layout.dong_sach,arraySach);
        lvSach.setAdapter(adapter);

        lvSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInforSach(i);
                return false;
            }
        });

        lvSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteSach(i);
            }
        });
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(),Profile.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
    private void AnhXa() {
        lvSach = (ListView) findViewById(R.id.listview_Sach);
        arraySach = new ArrayList<>();
        arraySach.add(new Sach("Đắc nhân tâm","Dale Carnegie",R.drawable.dacnhantam));
        arraySach.add(new Sach("Cách nghĩ để thành công","Napoleon Hill",R.drawable.cachnghidethanhcong));
        arraySach.add(new Sach("Cuộc sống không giới hạn","Nick Vujic",R.drawable.cuocsongkhonggioihan));
        arraySach.add(new Sach("Hạt giống tâm hồn","Nhiều tác giả",R.drawable.hatgiongtamhon));
        arraySach.add(new Sach("Tốc độ của niềm tin","Stephen R.Covey",R.drawable.tocdocuaniemtin));


    }


    private void showInforSach(int position){
        Sach s = arraySach.get(position);

        Intent i = new Intent(this, ListBookDetail.class);

        i.putExtra("Ten", s.getTen());
        i.putExtra("TacGia", s.getTacGia());
        i.putExtra("Hinh",s.getHinh());
        startActivity(i);
    }

    private void deleteSach(final int position){
        new AlertDialog.Builder(this)
                .setTitle("XÓA SÁCH")
                .setMessage("Bạn có chắc chắc muốn xóa?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arraySach.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null)
                .show();
    }

}