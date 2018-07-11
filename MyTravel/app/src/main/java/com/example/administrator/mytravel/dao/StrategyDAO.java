package com.example.administrator.mytravel.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.mytravel.ui.StrategyInfo;

import java.util.ArrayList;
import java.util.List;


public class StrategyDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;


    public StrategyDAO(Context context) {
        helper = new DBOpenHelper(context);
    }

    public void add(StrategyInfo strategyInfo){
        db = helper.getWritableDatabase();
        db.execSQL("insert into tb_strategy (_id, username, strategyTitle, strategyContent, strategyImageUri) values (?,?,?,?,?)",
                new Object[] {strategyInfo.get_id(),strategyInfo.getUsername(),strategyInfo.getStrategyTitle(), strategyInfo.getStrategyContent(), strategyInfo.getStrategyImageUri()});

    }

    public List<StrategyInfo> getScrollData(int start, int count){
        List<StrategyInfo> strategyInfos = new ArrayList<StrategyInfo>();
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from tb_strategy limit ?,?",
                new String[]{ String.valueOf(start),String.valueOf(count)});
        while (cursor.moveToNext()){
            // 将遍历到的收入信息添加到集合中
            strategyInfos.add(new StrategyInfo(
                    cursor.getInt(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("username")),
                    cursor.getString(cursor.getColumnIndex("strategyTitle")),
                    cursor.getString(cursor.getColumnIndex("strategyContent")),
                    cursor.getString(cursor.getColumnIndex("strategyImageUri"))
                    ));
        }

        return strategyInfos;
    }


    /**
     * 查找支出信息
     *
     * @param id
     * @return
     */
    public StrategyInfo find(int id) {
        db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db
                .rawQuery(
                        "select _id, username, strategyTitle, strategyContent, strategyImageUri from tb_strategy where _id = ?",
                        new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext())// 遍历查找到的支出信息
        {
            // 将遍历到的支出信息存储到Tb_outaccount类中
            return new StrategyInfo(
                    cursor.getInt(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("username")),
                    cursor.getString(cursor.getColumnIndex("strategyTitle")),
                    cursor.getString(cursor.getColumnIndex("strategyContent")),
                    cursor.getString(cursor.getColumnIndex("strategyImageUri")));

        }
        return null;// 如果没有信息，则返回null
    }


    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db
                .rawQuery("select count(_id) from tb_strategy", null);// 获取收入信息的记录数
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getLong(0);// 返回总记录数
        }
        return 0;// 如果没有数据，则返回0
    }


    /**
     * 获取收入最大编号
     *
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(_id) from tb_strategy", null);// 获取收入信息表中的最大编号
        while (cursor.moveToLast()) {// 访问Cursor中的最后一条数据
            return cursor.getInt(0);// 获取访问到的数据，即最大编号
        }
        return 0;// 如果没有数据，则返回0
    }



}
