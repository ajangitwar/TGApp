package com.example.studentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Profile extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile,container,false);

        TabLayout tabLayout = view.findViewById(R.id.tablayout_id);
        ViewPager viewPager = view.findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.AddFragment(new PersonalFragment(),"Personal");
        adapter.AddFragment(new EducationFragment(),"Education");
        adapter.AddFragment(new FamilyFragment(),"Family");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        getActivity().setTitle("Profile");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
