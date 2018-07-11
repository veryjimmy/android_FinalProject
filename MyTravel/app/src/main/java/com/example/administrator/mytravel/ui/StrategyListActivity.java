package com.example.administrator.mytravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.dao.StrategyDAO;

import java.util.ArrayList;
import java.util.List;

public class StrategyListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lv_all;
    private List<StrategyInfo> list = new ArrayList<StrategyInfo>();
    private StrategyAdapter strategyAdapter;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_list);


        initView();

    }


    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        lv_all = (ListView) findViewById(R.id.strategyList_lv_all);
        lv_all.setOnItemClickListener(this);
        topBar_bt_right.setVisibility(View.GONE);
        topBar_tv_title.setText("我的日記");
        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        showInfo();


    }

    private void showInfo() {

        StrategyDAO stratrgyDAO = new StrategyDAO(this);
        list = stratrgyDAO.getScrollData(0, (int)stratrgyDAO.getCount());

        strategyAdapter = new StrategyAdapter(this,list);
        lv_all.setAdapter(strategyAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(StrategyListActivity.this,StrategyDetailsActivity.class);

        intent.putExtra("_id", String.valueOf(list.get(position).get_id()));// 设置传递数据
        startActivity(intent);
        finish();
    }

}
