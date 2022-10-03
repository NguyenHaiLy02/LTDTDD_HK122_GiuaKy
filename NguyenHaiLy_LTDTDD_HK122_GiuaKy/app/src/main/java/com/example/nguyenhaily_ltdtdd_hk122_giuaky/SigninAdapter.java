package com.example.nguyenhaily_ltdtdd_hk122_giuaky;



import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SigninAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public SigninAdapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                SigninTabFragment signinTabFragment = new SigninTabFragment();
                return signinTabFragment;
            case 1:
                SignupTabFragment signupTabFragment= new SignupTabFragment();
                return signupTabFragment;
            default:
                return  null;
        }
    }
}
