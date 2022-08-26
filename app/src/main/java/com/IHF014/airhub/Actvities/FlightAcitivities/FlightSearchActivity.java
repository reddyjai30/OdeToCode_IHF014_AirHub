package com.IHF014.airhub.Actvities.FlightAcitivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.databinding.ActivityFlightSearchBinding;
import com.google.android.material.tabs.TabLayout;

public class FlightSearchActivity extends AppCompatActivity {

    ActivityFlightSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlightSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpagerFlights.setAdapter(new FragmentAdapter(getSupportFragmentManager(),2));
        binding.tabLayout2.setupWithViewPager(binding.viewpagerFlights);
        binding.tabLayout2.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}