package com.IHF014.airhub.Actvities.Hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.databinding.ActivityHotelsBinding;
import com.google.android.material.tabs.TabLayout;

public class HotelsActivity extends AppCompatActivity {

    ActivityHotelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), 11));
        binding.tabLayout2.setupWithViewPager(binding.viewPager);
        binding.tabLayout2.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}