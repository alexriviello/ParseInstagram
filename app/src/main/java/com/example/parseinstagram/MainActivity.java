package com.example.parseinstagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.parseinstagram.fragments.ComposeFragment;
import com.example.parseinstagram.fragments.StreamFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final FragmentManager fragmentManager = getSupportFragmentManager();

    bottomNavigationView = findViewById(R.id.bottom_navigation);

    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    fragment = new StreamFragment();
                    //  Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_compose:
                    fragment = new ComposeFragment();
                    // Toast.makeText(MainActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_profile:
                default:
                    // TODO swap fragment here
                    fragment = new ComposeFragment();
                    // Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    break;
            }
            fragmentManager.beginTransaction().replace(R.id.fragmentLayoutContainer, fragment).commit();
            return true;
            }
    });
    bottomNavigationView.setSelectedItemId(R.id.action_home);
}
}
