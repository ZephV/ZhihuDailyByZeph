package com.zeph.zhihudailybyzeph.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.zeph.zhihudailybyzeph.ui.fragment.InterestFragment;
import com.zeph.zhihudailybyzeph.ui.fragment.SafetyFragment;
import com.zeph.zhihudailybyzeph.ui.fragment.SportFragment;
import com.zeph.zhihudailybyzeph.ui.fragment.TodayFragment;
import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

  private final String[] title = {"今日日报", "不许无聊", "互联网安全", "体育日报"};
  private List<Fragment> fragments = new ArrayList<Fragment>();

  public PagerAdapter(FragmentManager fm) {
    super(fm);
    fragments.add(new TodayFragment());
    fragments.add(new InterestFragment());
    fragments.add(new SafetyFragment());
    fragments.add(new SportFragment());
  }

  public String getPageTitle(int position) {
    return title[position];
  }

  @Override
  public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override
  public int getCount() {
    return fragments.size();
  }
}
