package com.example.nguyenhaily_ltdtdd_hk122_giuaky;




import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SigninAdapter extends FragmentPagerAdapter {


    int totalTabs;

    public SigninAdapter(FragmentManager fm, int totalTabs){
        super(fm,totalTabs);

    }

    @Override
    public int getCount() {
        return 2;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:

                return new SigninTabFragment();
            case 1:

                return new SignupTabFragment();
            default:
                return  new SignupTabFragment();
        }
    }
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0:
                title ="SIGN IN";
                break;
            case 1:
                title ="SIGN UP";
                break;
        }
        return title;
    }
}
