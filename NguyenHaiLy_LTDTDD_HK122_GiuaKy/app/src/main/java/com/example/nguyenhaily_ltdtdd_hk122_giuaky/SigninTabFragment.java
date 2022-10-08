package com.example.nguyenhaily_ltdtdd_hk122_giuaky;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

public class SigninTabFragment extends Fragment {

    Button signin;
    EditText edtUser,edtPass;
    CheckBox cbsavepass;
    SharedPreferences sharedPreferences;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signin_tab_fragment,container,false);
        sharedPreferences = getContext().getSharedPreferences("dataLogin",MODE_PRIVATE);
        signin = root.findViewById(R.id.signin);
        edtUser = root.findViewById(R.id.textUser);
        edtPass = root.findViewById(R.id.textPass);
        cbsavepass = root.findViewById(R.id.savepass);

        edtUser.setText(sharedPreferences.getString("taikhoan",""));
        edtPass.setText(sharedPreferences.getString("matkhau",""));
        cbsavepass.setChecked(sharedPreferences.getBoolean("checked",false));
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = edtUser.getText().toString().trim();
                String password = edtPass.getText().toString().trim();
                if(uname.equals("NguyenHaiLy")&& password.equals("2050531200231")){
                    Toast.makeText(getActivity(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    if(cbsavepass.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",uname);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getActivity(), "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }


}
