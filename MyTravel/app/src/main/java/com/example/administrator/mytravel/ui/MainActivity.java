package com.example.administrator.mytravel.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.mytravel.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements  View.OnClickListener, ViewPager.OnPageChangeListener {


    private RadioButton btn1, btn2, btn3;
    private RadioGroup radioGroup;

    private ViewPager viewPager;
    private MyFragPagerAdapter myFragPagerAdapter;

    private ArrayList<Fragment> fragmentList;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
//    private OneFragment fourFragment;
//    private FiveFragment fiveFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }


    public void initView() {
        btn1 = (RadioButton) findViewById(R.id.mainactivity_btn_btn1);
        btn2 = (RadioButton) findViewById(R.id.mainactivity_btn_btn2);
        btn3 = (RadioButton) findViewById(R.id.mainactivity_btn_btn3);

        radioGroup = (RadioGroup) findViewById(R.id.mainactivity_rg_tabs);
        viewPager = (ViewPager) findViewById(R.id.mainactivity_vp_viewpager);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        if (twoFragment == null) {
            twoFragment = new TwoFragment();
        }
        if (threeFragment == null) {
            threeFragment = new ThreeFragment();
        }
//        if (fourFragment == null) {
//            fourFragment = new OneFragment();
//        }
//        if (fiveFragment == null) {
//            fiveFragment = new FiveFragment();
//        }
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        fragmentList.add(threeFragment);
//        fragmentList.add(fourFragment);
//        fragmentList.add(fiveFragment);
        viewPager.setOffscreenPageLimit(3);//把viewpager设定为5层才销毁

        myFragPagerAdapter = new MyFragPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myFragPagerAdapter);
        //viewPager.setOnPageChangeListener(this);
        //因为setOnPageChangeListener不推荐使用了，现在用的是addOnPageChangeListener替换它
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        radioGroup.check(R.id.mainactivity_btn_btn1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.mainactivity_btn_btn1:
                viewPager.setCurrentItem(0);
                radioGroup.check(R.id.mainactivity_btn_btn1);
                break;
            case R.id.mainactivity_btn_btn2:
                viewPager.setCurrentItem(1);
                radioGroup.check(R.id.mainactivity_btn_btn2);
                break;
            case R.id.mainactivity_btn_btn3:
                viewPager.setCurrentItem(2);
                radioGroup.check(R.id.mainactivity_btn_btn3);
                break;
//            case R.id.mainactivity_btn_btn4:
//                viewPager.setCurrentItem(3);
//                radioGroup.check(R.id.mainactivity_btn_btn4);
//                break;
//            case R.id.mainactivity_btn_btn5:
//                viewPager.setCurrentItem(4);
//                radioGroup.check(R.id.mainactivity_btn_btn5);
//                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.mainactivity_btn_btn1);
                break;
            case 1:
                radioGroup.check(R.id.mainactivity_btn_btn2);
                break;
            case 2:
                radioGroup.check(R.id.mainactivity_btn_btn3);
                break;
//            case 3:
//                radioGroup.check(R.id.mainactivity_btn_btn4);
//                break;
//            case 4:
//                radioGroup.check(R.id.mainactivity_btn_btn5);
//                break;
        }

    }


}

