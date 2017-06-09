package com.zeph.zhihudailybyzeph.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zeph.zhihudailybyzeph.R;
import com.zeph.zhihudailybyzeph.ZhihuService;
import com.zeph.zhihudailybyzeph.adapter.NewsAdapter;
import com.zeph.zhihudailybyzeph.bean.RootEntity;
import com.zeph.zhihudailybyzeph.bean.StoriesEntity;
import com.zeph.zhihudailybyzeph.ui.activity.StoryDetailActivity;
import java.util.ArrayList;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class BaseFragment extends Fragment {

  private String mBaseUrl = "http://news-at.zhihu.com";

  public ZhihuService service;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    service = getService();
    return inflater.inflate(R.layout.fragment_base, container, false);
  }


  public ZhihuService getService() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    service = retrofit.create(ZhihuService.class);
    return service;
  }

  public void loadDataSetList(Observable<RootEntity> rootEntityObservable,
      final ListView listView) {
    rootEntityObservable.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .map(new Func1<RootEntity, ArrayList<StoriesEntity>>() {

          @Override
          public ArrayList<StoriesEntity> call(RootEntity rootEntity) {
            return rootEntity.getStories();
          }
        })
        .subscribe(new Subscriber<ArrayList<StoriesEntity>>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(final ArrayList<StoriesEntity> storiesEntities) {
            listView.setAdapter(new NewsAdapter(storiesEntities, getContext()));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), StoryDetailActivity.class);
                intent.putExtra("id", storiesEntities.get(position).getId());
                startActivity(intent);
              }
            });
          }
        });
  }
}
