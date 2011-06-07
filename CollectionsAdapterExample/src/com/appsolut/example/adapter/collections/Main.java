package com.appsolut.example.adapter.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.appsolut.adapter.collections.CollectionsAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;

public class Main extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Initiliaze the List View */
        final List<String> listViewContent = new ArrayList<String>();
        final CollectionsAdapter<String> listViewAdapter = new CollectionsAdapter<String>(this, listViewContent,new NumberedViewFactory<String>());
        final ListView listView = (ListView)findViewById(R.id.exampleListView);
        listView.setAdapter(listViewAdapter);
        
        /* Initialize the Spinner and add items */
        final Set<UUID> spinnerContent = new HashSet<UUID>();
        for(int i = 0; i < 10; i++) {
        	spinnerContent.add(UUID.randomUUID());
        }
        final CollectionsAdapter<UUID> spinnerAdapter = new CollectionsAdapter<UUID>(this, android.R.layout.simple_spinner_item, spinnerContent);
        final Spinner spinner = (Spinner)findViewById(R.id.exampleSpinner);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				listViewAdapter.clear();
				for(String split: spinnerAdapter.getItem(position).toString().split("-")) {
					listViewAdapter.add(split);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				listViewAdapter.clear();
			}
		});
       
        
    }
}