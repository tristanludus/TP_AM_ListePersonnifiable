package com.example.kille.listepersonnifiable;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kille on 14/02/2018.
 */

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    private ArrayList<AndroidVersion> androidVersionList;
    private Context context;

    private int viewRes;
    private Resources res;

    public AndroidAdapter(Context context, int textViewResourceId,
                          ArrayList<AndroidVersion> versions) {
        super(context, textViewResourceId, versions);
        this.androidVersionList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        ViewHolder holder;
        if (v == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            boolean attachToRoot;
            v = layoutInflater.inflate(viewRes, parent, attachToRoot: false);
            holder = new ViewHolder();
            holder.title = (TextView) v.findViewById(R.id.title);
            holder.desc = (TextView) v.findViewById(R.id.desc);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }
        final AndroidVersion androidVersion = androidVersionList.get(position);
        if (androidVersion != null) {
            final String versionName = String.format(res.getString(R.string.list_title), androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format(res.getString(R.string.list_desc), androidVersion.getVersionNumber());
            holder.desc.setText(versionNumber);
        }
        return v;
    }
    static class ViewHolder{
        TextView title;
        TextView desc;
    }
}
