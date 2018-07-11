package com.example.administrator.mytravel.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.adapter.ItemArrayAdapter;
import com.example.administrator.mytravel.util.CSVReader;
import com.example.administrator.mytravel.util.SPUtils;

import java.io.InputStream;
import java.util.List;

public class OneFragment extends Fragment {

    public  static Activity thisActivity = null;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;
    private String[] type = new String[]{"中正區", "大同區", "中山區", "松山區", "大安區", "萬華區", "信義區", "士林區", "北投區", "內湖區", "南港區", "文山區"};//載入第一下拉選單

    private String[] tea = new String[]{"公共藝術", "戶外踏青", "宗教信仰", "春季活動", "單車遊蹤", "養生溫泉", "歷史建築", "親子共遊", "藝文館所"};//起始畫面時預先載入第二下拉選單
    //第一下拉選取後載入第二下拉選單
    private String[][] type2 = new String[][]{{"公共藝術", "戶外踏青", "其他", "宗教信仰", "歷史建築", "親子共遊", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "歷史建築", "親子共遊", "藍色公路", "藝文館所"},
            {"戶外踏青", "其他", "宗教信仰", "歷史建築", "親子共遊", "藍色公路", "藝文館所"},
            {"公共藝術", "其他", "宗教信仰", "親子共遊", "藍色公路", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "歷史建築", "親子共遊", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "單車遊蹤", "歷史建築", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "歷史建築", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "單車遊蹤", "養生溫泉", "歷史建築", "親子共遊", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "春季活動", "單車遊蹤", "養生溫泉", "歷史建築", "親子共遊", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "單車遊蹤", "親子共遊", "藍色公路", "藝文館所"},
            {"公共藝術", "戶外踏青", "歷史建築", "親子共遊", "藝文館所"},
            {"公共藝術", "戶外踏青", "其他", "宗教信仰", "單車遊蹤", "親子共遊", "藝文館所"},};
    private Spinner sp;//第一個下拉選單
    private Spinner sp2;//第二個下拉選單
    private Context context;
    public static String aa = "中正區", bb = "公共藝術";//宣告全域變數，取得chosen item string

    ArrayAdapter<String> adapter;

    ArrayAdapter<String> adapter2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        context = getActivity();
        thisActivity = getActivity();
        initView(view);
        return view;
    }

    private void initView(View view) {

        listView = (ListView) view.findViewById(R.id.list_view);
        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) view.findViewById(R.id.topbar_btn_left);
        topBar_tv_title.setText("景點資訊");
        topBar_bt_left.setVisibility(View.GONE);
        topBar_bt_right.setVisibility(View.GONE);
        //程式剛啟始時載入第一個下拉選單
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp = (Spinner) view.findViewById(R.id.type);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(selectedListener);

        //因為下拉選單第一個為茶類，所以先載入茶類群組進第二個下拉選單
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, tea);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2 = (Spinner) view.findViewById(R.id.type2);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(selectedListener2);

    }


    private AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            //讀取第一個下拉選單是選擇第幾個
            int pos = sp.getSelectedItemPosition();
            //重新產生新的Adapter，用的是二維陣列type2[pos]
            aa = sp.getSelectedItem().toString();
            adapter2 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, type2[pos]);
            //載入第二個下拉選單Spinner
            sp2.setAdapter(adapter2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private AdapterView.OnItemSelectedListener selectedListener2 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            bb = sp2.getSelectedItem().toString();
            itemArrayAdapter.a(aa, bb);

            itemArrayAdapter = new ItemArrayAdapter(getActivity(), R.layout.single_list_item);

            Parcelable state = listView.onSaveInstanceState();
            listView.setAdapter(itemArrayAdapter);
            listView.onRestoreInstanceState(state);

            InputStream inputStream = getResources().openRawResource(R.raw.newnew);
            CSVReader csv = new CSVReader(inputStream);
            List<String[]> scoreList = csv.read();

            for (String[] scoreData : scoreList) {
                itemArrayAdapter.add(scoreData);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}
