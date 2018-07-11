package com.example.administrator.mytravel.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.dao.ActDAO;
import com.example.administrator.mytravel.dao.StrategyDAO;
import com.example.administrator.mytravel.util.SPUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ThreeFragment extends Fragment implements View.OnClickListener{

    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private TextView tv_one;
    private LinearLayout ll_actImages;
    private LinearLayout ll_strategyImages;

    private List<ActInfo> actInfoList = new ArrayList<ActInfo>();
    private List<StrategyInfo> strategyInfoList = new ArrayList<StrategyInfo>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        tv_one = (TextView) view.findViewById(R.id.center_tv_one);

        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) view.findViewById(R.id.topbar_btn_left);
        ll_actImages = (LinearLayout) view.findViewById(R.id.center_ll_actImages);
        ll_strategyImages = (LinearLayout) view.findViewById(R.id.center_ll_strategyImages);
        ll_actImages.setOnClickListener(this);
        ll_strategyImages.setOnClickListener(this);
        topBar_tv_title.setText("個人中心");
        tv_one.setText(String.valueOf(SPUtils.get(getActivity(), "username", "小包子")));

        topBar_bt_left.setVisibility(View.GONE);
        topBar_bt_right.setVisibility(View.GONE);

        showInfo();
    }

    private void showInfo() {
//展示发起活动的信息
        ActDAO actDAO = new ActDAO(getActivity());
        actInfoList = actDAO.getScrollData(0, (int) actDAO.getCount());
        ImageView actImageView;
        for (int i = 0; i < actInfoList.size(); i++) {

            actImageView = new ImageView(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            lp.height = 200;
            lp.width = 200;
            actImageView.setLayoutParams(lp);
            actImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            Picasso.with(getActivity()).load(Uri.parse(actInfoList.get(i).getActImageUri())).into(actImageView);
            ll_actImages.addView(actImageView);
        }
//展示旅游攻略的信息
        StrategyDAO strategyDAO = new StrategyDAO(getActivity());
        strategyInfoList = strategyDAO.getScrollData(0, (int) strategyDAO.getCount());
        ImageView strategyImageView;
        for (int i = 0; i < strategyInfoList.size(); i++) {

            strategyImageView = new ImageView(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            lp.height = 200;
            lp.width = 200;
            strategyImageView.setLayoutParams(lp);
            strategyImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            Picasso.with(getActivity()).load(Uri.parse(strategyInfoList.get(i).getStrategyImageUri())).into(strategyImageView);
            ll_strategyImages.addView(strategyImageView);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.center_ll_actImages:
                Intent intent1 = new Intent(getActivity(),ActListActivity.class);
                startActivity(intent1);
                break;
            case R.id.center_ll_strategyImages:
                Intent intent2 = new Intent(getActivity(),StrategyListActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
