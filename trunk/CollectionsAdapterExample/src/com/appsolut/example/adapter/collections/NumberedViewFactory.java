package com.appsolut.example.adapter.collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsolut.adapter.collections.view.ICollectionsAdapterViewFactory;

public class NumberedViewFactory<T> implements
		ICollectionsAdapterViewFactory<T> {

	@Override
	public View getView(int position, View convertView,
			ViewGroup parent, T item, LayoutInflater inflater,
			Context context) {
		View layoutView;
		if (convertView == null) {
			layoutView = inflater.inflate(R.layout.listview_entry, parent, false);
		} else {
			layoutView = convertView;
		}
		final TextView segmentText = (TextView)layoutView.findViewById(R.id.textSegment);
		segmentText.setText(item.toString());
		
		final TextView segmentNumber = (TextView)layoutView.findViewById(R.id.segmentNumber);
		segmentNumber.setText(Integer.toString(position) + ". ");
		
		final ImageView imageView = (ImageView)layoutView.findViewById(R.id.image);
		if(position%2 == 0) {
			imageView.setBackgroundResource(android.R.drawable.presence_online);
		} else {
			imageView.setBackgroundResource(android.R.drawable.presence_invisible);
		}
		
		return layoutView;
	}

}
