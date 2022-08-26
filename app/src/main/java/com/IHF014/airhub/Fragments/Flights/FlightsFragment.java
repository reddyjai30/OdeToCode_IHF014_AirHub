package com.IHF014.airhub.Fragments.Flights;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.Actvities.FlightAcitivities.FlightSearchActivity;
import com.IHF014.airhub.databinding.FragmentFlightsBinding;
import com.google.android.material.tabs.TabLayout;


public class FlightsFragment extends Fragment {

    public FlightsFragment() {
        // Required empty public constructor
    }

    FragmentFlightsBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFlightsBinding.inflate(getLayoutInflater());

        viewPager = binding.viewpagerFlights;
        tabLayout = binding.tabLayout2;

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),1));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FlightSearchActivity.class));
            }
        });

        return binding.getRoot();
    }

}