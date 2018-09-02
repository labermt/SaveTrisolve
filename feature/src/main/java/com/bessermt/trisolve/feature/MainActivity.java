package com.bessermt.trisolve.feature;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

// import com.google.android.material.floatingactionbutton.FloatingActionButton;
// import com.google.android.material.snackbar.Snackbar;
// import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.appcompat.widget.Toolbar;
// import androidx.fragment.app.Fragment;
// import androidx.fragment.app.FragmentManager;
// import androidx.fragment.app.FragmentPagerAdapter;
// import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity
        implements DrawFragment.OnFragmentInteractionListener,
        AnalyzeFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    private ViewPager viewPager_;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DrawFragment(), "Draw");
        adapter.addFragment(new AnalyzeFragment(), "Analyze");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter.
        viewPager_ = findViewById(R.id.container);
        setupViewPager(viewPager_);

        final TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager_);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_draw_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_analyze_24dp);

        // https://stackoverflow.com/questions/34562117/how-do-i-change-the-color-of-icon-of-the-selected-tab-of-tablayout

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onFragmentInteraction(Uri uri) {
        // TODO: Remove this and the
        // implements DrawFragment.OnFragmentInteractionListener,
        // AnalyzeFragment.OnFragmentInteractionListener
        // if this is never used.
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        // TODO: watch https://www.youtube.com/watch?v=bNpWGI_hGGg

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        public void addFragment(final Fragment fragment, final String title)
        {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            CharSequence result = null;
            //if (position < fragmentTitleList.size()) {
            //    result = fragmentTitleList.get(position);
            //}
            //else {
            //    Log.e(TAG, "getPageTitle(int) domain error.");
            //}

            return result;
        }

        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            // return PlaceholderFragment.newInstance(position + 1);

            Fragment result = null;
            if (position < fragmentList.size()) {
                result = fragmentList.get(position);
            }
            else {
                Log.e(TAG, "getItem(int) domain error.");
            }

            return result;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
