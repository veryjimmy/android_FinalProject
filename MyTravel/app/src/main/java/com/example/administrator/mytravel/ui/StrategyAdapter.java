package com.example.administrator.mytravel.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class StrategyAdapter extends BaseAdapter {
    private Context context;
    private List<StrategyInfo> list;

    public StrategyAdapter(Context context, List<StrategyInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategylist, null);

            holder.iv_img = (ImageView) convertView.findViewById(R.id.strategyList_iv_img);
            holder.tv_title = (TextView) convertView.findViewById(R.id.strategyList_tv_title);
            holder.tv_username = (TextView) convertView.findViewById(R.id.strategyList_tv_username);


            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /**设置TextView显示的内容，即我们存放在动态数组中的数据*/
        holder.tv_title.setText("用戶："+list.get(position).getUsername());
        holder.tv_username.setText("日記標題："+list.get(position).getStrategyTitle());

        Picasso.with(context).load(Uri.parse(list.get(position).getStrategyImageUri())).into(holder.iv_img);

        return convertView;
    }


    public final class ViewHolder {
        public TextView tv_title;
        public TextView tv_username;
        public ImageView iv_img;
    }

}
