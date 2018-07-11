package com.example.administrator.mytravel.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.dao.StrategyDAO;
import com.squareup.picasso.Picasso;

public class StrategyDetailsActivity extends AppCompatActivity {
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private StrategyInfo strategyInfo;
    private TextView tv_title;

    private TextView tv_content;
    private ImageView detail_iv_img;

    StrategyDAO strategyDAO = new StrategyDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_details);


        initView();
    }

    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        tv_title = (TextView) findViewById(R.id.strategydetail_tv_title);

        tv_content = (TextView) findViewById(R.id.strategydetail_tv_content);
        detail_iv_img = (ImageView) findViewById(R.id.detail_iv_img);

        topBar_tv_title.setText("我的日記");
        topBar_bt_right.setVisibility(View.GONE);

        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        String _id  = bundle.getString("_id");
        StrategyInfo strategyInfo = strategyDAO.find(Integer.parseInt(_id));

        tv_title.setText(strategyInfo.getStrategyTitle());
        tv_content.setText(strategyInfo.getStrategyContent());

        Picasso.with(this).load(Uri.parse(strategyInfo.getStrategyImageUri())).into(detail_iv_img);
    }
}
