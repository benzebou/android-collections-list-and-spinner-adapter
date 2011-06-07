package com.appsolut.adapter.collections.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DefaultViewFactory<E> implements
		ICollectionsAdapterViewFactory<E> {
	
	/** The resource id of the layout which should be used **/
	private final int layoutResourceId;
	
	/** The resource id of the text view which will be used to display the text of the element **/
	private final int textViewResourceId;
	
	/**
	 * Constructor which will create a new DefaultViewFactory with a given layout resource id and a text view resource id.
	 * The elements will be represented by their toString method.
	 * @param layoutResourceId The resource id of the layout which should be used
	 * @param textViewResourceId The resource id of the text view within the layout which will be used to display the item.
	 */
	public DefaultViewFactory(int layoutResourceId, int textViewResourceId) {
		super();
		this.layoutResourceId = layoutResourceId;
		this.textViewResourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView,
			ViewGroup parent, E item, LayoutInflater inflater,
			Context context) {
		View layoutView;
		if (convertView == null) {
			layoutView = inflater.inflate(layoutResourceId, parent, false);
		} else {
			layoutView = convertView;
		}
		final View text = layoutView.findViewById(textViewResourceId);
		if (text instanceof TextView) {
			((TextView)text).setText(item.toString());
		} else {
			throw new ClassCastException("The textViewResourceId does not belong to a TextView element.");
		}

		return layoutView;
	}

}
