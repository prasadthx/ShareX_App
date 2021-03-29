package com.intersekt.sharex.views;

import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.intersekt.sharex.R;
import com.intersekt.sharex.viewmodels.mediaFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    mediaFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.nav_view);

        NavigationView navigationView=findViewById(R.id.navigation_view);
        //navigationView.setNavigationItemSelectedListener(this);
        //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new HomeFragment());
        Toolbar toolbar=findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new mediaFragmentAdapter(fragmentManager, getLifecycle());

        viewPager2.setAdapter(adapter);

//        tabLayout.addTab(tabLayout.newTab().setText("First"));
//        tabLayout.addTab(tabLayout.newTab().setText("Second"));
//        tabLayout.addTab(tabLayout.newTab().setText("Third"));
//        tabLayout.addTab(tabLayout.newTab().setText("Fourth"));
//        tabLayout.addTab(tabLayout.newTab().setText("Fifth"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Context context = getApplicationContext();
                CharSequence text = String.format("%d",tab.getPosition());
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
               tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//        switch (menuItem.getItemId())
//        {
//
//            case R.id.home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new HomeFragment()).commit();
//                break;
//            case R.id.user:
//                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new UserFragment()).commit();
//                break;
//
//            case R.id.camera:
//                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new CameraFragment()).commit();
//                break;
//
//
//            case R.id.send:
//                Intent intent=new Intent(this,sendActivity.class);
//                startActivity(intent);
//                break;
//
//
//        }
//
//        drawerLayout.closeDrawer(GravityCompat.START);
//
//        return true;
//    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }



    }
}