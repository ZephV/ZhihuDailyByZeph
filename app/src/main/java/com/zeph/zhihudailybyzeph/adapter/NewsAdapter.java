package com.zeph.zhihudailybyzeph.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zeph.zhihudailybyzeph.R;
import com.zeph.zhihudailybyzeph.bean.StoriesEntity;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

  private List<StoriesEntity> newsList;
  private LayoutInflater layoutInflater;
  private Context context;

  public NewsAdapter(List<StoriesEntity> newsList, Context context) {
    this.newsList = newsList;
    this.context = context;
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
    return newsList.size();
  }

  @Override
  public Object getItem(int position) {
    return newsList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = layoutInflater.inflate(R.layout.new_items, null);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    }
    viewHolder = (ViewHolder) convertView.getTag();
    StoriesEntity news = newsList.get(position);
    TextView tvNews = viewHolder.textView;
    ImageView ivNews = viewHolder.imageView;
    tvNews.setText(news.getTitle());
    if (news.getImages() == null) {

      ivNews.setVisibility(View.GONE);
    } else {
      ivNews.setVisibility(View.VISIBLE);
      Glide.with(context).load(news.getImages().get(0)).into(ivNews);
    }
    return convertView;
  }

  private class ViewHolder {
    ImageView imageView;
    TextView textView;
    public ViewHolder(View view) {
      imageView = (ImageView) view.findViewById(R.id.ivnews);
      textView = (TextView) view.findViewById(R.id.tvnews);
    }
  }
}
