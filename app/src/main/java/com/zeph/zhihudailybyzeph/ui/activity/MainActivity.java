package com.zeph.zhihudailybyzeph.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.zeph.zhihudailybyzeph.R;
import com.zeph.zhihudailybyzeph.adapter.PagerAdapter;

public class MainActivity extends FragmentActivity {

  private ViewPager pager;
  private TabLayout tab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pager = (ViewPager) findViewById(R.id.pager);
    tab = (TabLayout) findViewById(R.id.tab);
    pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    tab.setupWithViewPager(pager);
  }
}
