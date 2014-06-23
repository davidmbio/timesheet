package com.komodo.timesheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by david on 10/06/14.
 */

public class TypesAdapter extends BaseAdapter {

    private DayliTaskFragment dayliTaskFragment;
    private Context context;
    private ArrayList<String> activityTypes;
    private LayoutInflater inflater;

    public static class ViewHolder{
        TextView tvTypeName;
        ImageButton ibQuickAcces;
        ImageButton ibDetailAccess;
    }

    public TypesAdapter(DayliTaskFragment dayliTaskFragment, ArrayList<String> activityTypes){
        this.context = dayliTaskFragment.getActivity();
        this.dayliTaskFragment = dayliTaskFragment;
        this.activityTypes=activityTypes;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.activityTypes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.activityTypes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view==null){
            view=inflater.inflate(R.layout.list_item_activity_type, null);

            holder= new ViewHolder();

            holder.tvTypeName = (TextView)view.findViewById(R.id.tv_activity_type);
            holder.ibQuickAcces = (ImageButton)view.findViewById(R.id.ibQuickAcces);
            holder.ibDetailAccess = (ImageButton)view.findViewById(R.id.ibDetailAccess);
            if(position >= 3 ) {
                ((ViewGroup) view).removeView(holder.ibQuickAcces);
            }
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvTypeName.setText(activityTypes.get(position));

        if(position < 3){
            holder.ibQuickAcces.setImageResource(R.drawable.ic_action_quick_access);
            holder.ibQuickAcces.setOnClickListener((View.OnClickListener)dayliTaskFragment);
            holder.ibQuickAcces.setTag(position);
        }

        holder.ibDetailAccess.setImageResource(R.drawable.ic_action_detail_task);
        holder.ibDetailAccess.setOnClickListener((View.OnClickListener)dayliTaskFragment);
        holder.ibDetailAccess.setTag(position+6);

        return view;
    }
}