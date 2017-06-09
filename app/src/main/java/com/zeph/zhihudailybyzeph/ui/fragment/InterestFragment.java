package com.zeph.zhihudailybyzeph.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import com.zeph.zhihudailybyzeph.R;

public class InterestFragment extends BaseFragment {

  private ListView lv;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    lv = (ListView) view.findViewById(R.id.lvnews);
    loadDataSetList(service.getInterest(), lv);
  }
}
