package com.zeph.zhihudailybyzeph;


import com.zeph.zhihudailybyzeph.bean.RootEntity;
import com.zeph.zhihudailybyzeph.bean.StoryDetailsEntity;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
public interface ZhihuService {

  //今日头条
  @GET("/api/4/news/latest")
  Observable<RootEntity> getLatestNews();
  //互联网安全
  @GET("/api/4/theme/10")
  Observable<RootEntity> getSafety();
  //不准无聊
  @GET("/api/4/theme/11")
  Observable<RootEntity> getInterest();
  //体育日报
  @GET("/api/4/theme/8")
  Observable<RootEntity> getSport();
  //传入id查看详细信息
  @GET("/api/4/news/{id}")
  Observable<StoryDetailsEntity> getNewsDetails(@Path("id") int id);


}
