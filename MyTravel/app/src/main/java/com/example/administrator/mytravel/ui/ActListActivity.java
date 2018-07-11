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
import com.example.administrator.mytravel.dao.ActDAO;

import java.util.ArrayList;
import java.util.List;

public class ActListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lv_all;
    private List<ActInfo> list = new ArrayList<ActInfo>();
    private ActAdapter actAdapter;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_list);



        initView();


    }




    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        lv_all = (ListView) findViewById(R.id.actList_lv_all);
        lv_all.setOnItemClickListener(this);
        topBar_bt_right.setVisibility(View.GONE);
        topBar_tv_title.setText("活動列表");
        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //展示信息
        showInfo();


    }

    private void showInfo() {

        ActDAO actDAO = new ActDAO(this);// 创建InaccountDAO对象
        // 获取所有收入信息，并存储到List泛型集合中
        list = actDAO.getScrollData(0, (int) actDAO.getCount());
        actAdapter = new ActAdapter(this,list);
        lv_all.setAdapter(actAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ActListActivity.this,ActDetailsActivity.class);

        intent.putExtra("_id", String.valueOf(list.get(position).get_id()));// 设置传递数据
        startActivity(intent);// 执行Intent操作
        finish();
    }

}
