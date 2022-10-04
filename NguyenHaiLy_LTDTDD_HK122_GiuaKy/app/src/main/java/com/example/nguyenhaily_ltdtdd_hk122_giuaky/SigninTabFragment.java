package com.example.nguyenhaily_ltdtdd_hk122_giuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SigninTabFragment extends Fragment {
    TextView tvNewuser;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signin_tab_fragment,container,false);

        tvNewuser = root.findViewById(R.id.textviewNewUser);
        tvNewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SignupTabFragment.class);
                startActivity(intent);
            }
        });

        return root;



    }
}
