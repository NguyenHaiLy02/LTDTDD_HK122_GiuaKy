package com.example.nguyenhaily_ltdtdd_hk122_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListBookDetail extends Activity {

        private TextView ten;
        private TextView tacgia;
        private ImageView img;
        ImageButton btnreturn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_book_detail);

            btnreturn = (ImageButton) findViewById(R.id.btReturn);
            tacgia = findViewById(R.id.textviewTacGia);
            ten = findViewById(R.id.textviewTen);
            img=findViewById(R.id.imageviewHinh);

            btnreturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent=new Intent(ListBookDetail.this, ListBook.class);
                    startActivity(myIntent);
                }
            });

            String ten1 = getIntent().getStringExtra("Ten");
            String tacGia1 = getIntent().getStringExtra("TacGia");
            int hinh=getIntent().getIntExtra("Hinh",0);
            img.setImageResource(hinh);
            ten.setText(ten1);
            tacgia.setText(tacGia1);


        }
    }