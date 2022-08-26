package com.IHF014.airhub.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.databinding.ActivityShoppingBinding;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.view.View;

public class ShoppingActivity extends AppCompatActivity {

    ActivityShoppingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),8));
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