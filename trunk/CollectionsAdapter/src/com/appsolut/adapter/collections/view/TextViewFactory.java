package com.appsolut.adapter.collections.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextViewFactory<E> implements ICollectionsAdapterViewFactory<E> {
	
	/** The resource id of the text view layout which will be used to display the text of the element **/
	private final int layoutResource;
	
	/**
	 * Constructor which will create a new TextViewFactory with a text view resource id.
	 * The elements will be represented by their toString method.
	 * @param layoutResource The resource id of the text view within the layout which will be used to display the item.
	 */
	public TextViewFactory(int layoutResource) {
		this.layoutResource = layoutResource;
	}
	@Override
	public View getView(int position, View convertView,
			ViewGroup parent, E item, LayoutInflater inflater,
			Context context) {
		View text;
		if (convertView == null || !(convertView instanceof TextView)) {
			text = inflater.inflate(layoutResource, parent, false);
		} else {
			text = convertView;
		}
		if (text instanceof TextView) {
			((TextView)text).setText(item.toString());
		} else {
			throw new ClassCastException("The textViewResourceId does not belong to a TextView element.");
		}
		return text;
	}


}
