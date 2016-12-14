package com.example.samgar.funplanet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(""));

        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));

        tabLayout.getTabAt(0).setIcon(R.drawable.tab1);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab2);
        tabLayout.getTabAt(2).setIcon(R.drawable.tab3);
        tabLayout.getTabAt(3).setIcon(R.drawable.tab4);


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);





        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

    tab.setIcon(R.drawable.tabselect);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if(tab==tabLayout.getTabAt(0))

                    tabLayout.getTabAt(0).setIcon(R.drawable.tab1);
                if(tab==tabLayout.getTabAt(1))
                tabLayout.getTabAt(1).setIcon(R.drawable.tab2);
                if(tab==tabLayout.getTabAt(2))
                tabLayout.getTabAt(2).setIcon(R.drawable.tab3);
                if(tab==tabLayout.getTabAt(3))
                tabLayout.getTabAt(3).setIcon(R.drawable.tab4);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.tabselect);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}