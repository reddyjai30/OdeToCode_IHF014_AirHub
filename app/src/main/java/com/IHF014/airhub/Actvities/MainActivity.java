package com.IHF014.airhub.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import com.IHF014.airhub.Fragments.Flights.FlightsFragment;
import com.IHF014.airhub.Fragments.HomeFragment;
import com.IHF014.airhub.Fragments.MapsFragment;
import com.IHF014.airhub.Fragments.MoreFragment;
import com.IHF014.airhub.Fragments.Transit.TransportationFragment;
import com.IHF014.airhub.R;
import com.IHF014.airhub.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;


public class MainActivity extends AppCompatActivity {

    ImageView i;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.main_content, new HomeFragment());
        homeTransaction.commit();

        binding.bottomNav.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i) {
                    case 0:
                        transaction.replace(R.id.main_content, new HomeFragment());
                        break;
                    case 1:
                        transaction.replace(R.id.main_content, new FlightsFragment());
                        break;
                    case 2:
                        transaction.replace(R.id.main_content, new MapsFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.main_content, new TransportationFragment());
                        break;

                    case 4:
                        transaction.replace(R.id.main_content, new MoreFragment());
                        break;
                }
                transaction.commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
