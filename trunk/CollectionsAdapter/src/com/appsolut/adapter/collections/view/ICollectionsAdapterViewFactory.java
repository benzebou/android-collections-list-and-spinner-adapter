package com.appsolut.adapter.collections.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface ICollectionsAdapterViewFactory<E> {
	
	/**
	 * Method which should return the view element which is representing the given item.
	 * @param position The position of the given item
	 * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using. If it is not possible to convert this view to display the correct data, this method can create a new view.
	 * @param parent The parent that this view will eventually be attached to
	 * @param item The item which should be displayed by this view
	 * @param inflater The layout inflater service used to inflate xml layouts
	 * @param context The current context
	 * @return The view representing the element.
	 */
	public View getView(int position, View convertView,
			ViewGroup parent, E item, LayoutInflater inflater, Context context);
}
