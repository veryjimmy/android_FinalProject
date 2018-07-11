package com.example.administrator.mytravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mytravel.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.mytravel.ui.OneFragment.thisActivity;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {

    private List<String[]> scoreList = new ArrayList<String[]>();
    public static String d, e;
    private Context mContext;

    static class ItemViewHolder {
        TextView name;
        TextView score;
    }

    public ItemArrayAdapter(Context context, int resource) {
        super(context, resource);
        mContext = context;
    }

    static  public void a(String b, String c) {
        d = b;
        e = c;

        //Toast.makeText(thisActivity, d + " " + e, Toast.LENGTH_SHORT).show();
    }

    public void add(String[] object) {
        if (object[1].compareToIgnoreCase(d) == 0 && object[2].compareToIgnoreCase(e) == 0) {
            scoreList.add(object);
        }
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int position) {
        return this.scoreList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) row.getTag();
        }

        String[] stat = getItem(position);
        viewHolder.name.setText(stat[3]);
        viewHolder.score.setText(stat[4]);
        return row;
    }
}
