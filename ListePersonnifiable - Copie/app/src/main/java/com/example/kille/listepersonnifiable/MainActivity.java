package com.example.kille.listepersonnifiable;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mListView;

    private void initList(ArrayList<AndroidVersion> androidList) {

        AndroidVersion version = new AndroidVersion();
        version.setVersionName("Football");
        version.setVersionNumber("1.");
        androidList.add(version);

        AndroidVersion versionbasket = new AndroidVersion();
        versionbasket.setVersionName("Basketball");
        versionbasket.setVersionNumber("2.");
        androidList.add(versionbasket);

        AndroidVersion versionhand = new AndroidVersion();
        versionhand.setVersionName("Handball");
        versionhand.setVersionNumber("3.");
        androidList.add(versionhand);

        AndroidVersion versionRug = new AndroidVersion();
        versionRug.setVersionName("Rugby");
        versionRug.setVersionNumber("4.");
        androidList.add(versionRug);

        AndroidVersion versionvolley = new AndroidVersion();
        versionvolley.setVersionName("Volleyball");
        versionvolley.setVersionNumber("5.");
        androidList.add(versionvolley);

        AndroidVersion versiontennis = new AndroidVersion();
        versiontennis.setVersionName("Tennis");
        versiontennis.setVersionNumber("6.");
        androidList.add(versiontennis);

        AndroidVersion versionski = new AndroidVersion();
        versionski.setVersionName("Ski");
        versionski.setVersionNumber("7.");
        androidList.add(versionski);

        AndroidVersion versionhockey = new AndroidVersion();
        versionhockey.setVersionName("Hockey");
        versionhockey.setVersionNumber("8.");
        androidList.add(versionhockey);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AndroidVersion> androidList = new ArrayList<AndroidVersion>();

        initList(androidList);

        Context context;
        AndroidAdapter adapter = new AndroidAdapter( context: this, R.layout.List_Layout, androidList);
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                AndroidVersion selectedItem = (AndroidVersion) adapter.getItemAtPosition(position);
                String tag;
                Object msg;
                Log.v(tag: "CustomAdapterExemple", msg: "Element selectionne : " + selectedItem.getVersionName());
            }
        });

        mListView = (ListView) findViewById(R.id.listView);

        /*final ArrayAdapter<Void> adapter = new ArrayAdapter<Void>(MainActivity.this,
                android.R.layout.simple_list_item_1,initList());
        mListView.setAdapter(adapter);*/
    }

}