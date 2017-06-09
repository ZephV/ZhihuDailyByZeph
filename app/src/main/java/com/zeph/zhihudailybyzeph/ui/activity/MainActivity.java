package com.zeph.zhihudailybyzeph.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.astuetz.PagerSlidingTabStrip;
import com.zeph.zhihudailybyzeph.R;
import com.zeph.zhihudailybyzeph.adapter.PagerAdapter;

public class MainActivity extends FragmentActivity {

  private ViewPager pager;
  private PagerSlidingTabStrip tab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pager = (ViewPager) findViewById(R.id.pager);
    tab= (PagerSlidingTabStrip) findViewById(R.id.tab);
    pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    tab.setViewPager(pager);
  }
}
