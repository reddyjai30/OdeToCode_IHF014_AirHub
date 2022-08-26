package com.IHF014.airhub.Actvities;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.IHF014.airhub.Adapters.FragmentAdapter;
import com.IHF014.airhub.R;
import com.google.android.material.tabs.TabLayout;


public class Transit_Parking extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit__parking);



        viewPager=findViewById(R.id.view_pager_parkng);
        tabLayout=findViewById(R.id.tab_layout_parking);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),10));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

}