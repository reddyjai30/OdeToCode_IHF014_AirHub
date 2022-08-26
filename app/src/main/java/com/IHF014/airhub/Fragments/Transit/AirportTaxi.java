package com.IHF014.airhub.Fragments.Transit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.R;
import com.google.android.material.tabs.TabLayout;

public class AirportTaxi extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    public AirportTaxi() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_airport_taxi, container, false);

        viewPager = v.findViewById(R.id.viewpagerairport);
        tabLayout = v.findViewById(R.id.tabLayout_airport);

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), 16));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return v;
    }
}