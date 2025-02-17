package com.example.studentapp.form;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import static com.example.studentapp.form.StudentForm.int_items;

/**
 * Created by Admin on 3/1/2017.
 */

public class MyAdapterIs extends FragmentPagerAdapter {


    public MyAdapterIs(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PersonalFormFragment();
            case 1:
                return new EducationFormFragment();
            case 2:
                return new FamilyFormFragment();
            case 3:
                return new TechnicalFormFragment();

        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Personal";
            case 1:
                return "Education";
            case 2:
                return "Family";
            case 3:
                return "Technical";
        }

        return null;
    }
}
