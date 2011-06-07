package com.appsolut.adapter.collections;

import java.util.Collection;
import com.appsolut.adapter.collections.interactor.ICollectionsInteractor;
import com.appsolut.adapter.collections.view.DefaultViewFactory;
import com.appsolut.adapter.collections.view.ICollectionsAdapterViewFactory;
import com.appsolut.adapter.collections.view.TextViewFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

public class CollectionsAdapter<E> extends BaseAdapter implements ListAdapter, SpinnerAdapter {

	/** The collection which serves as data basis for this adapter **/
	private final Collection<E> content;
	
	/** The collection interactor which is used to retrieve items **/
	private final ICollectionsInteractor<E> interactor;
	
	/** The layout inflater system service **/
	private final LayoutInflater inflater;
	
	/** The context for this adapter **/
	private final Context context;
	
	/** The factory which is used to create the View elements **/
	private final ICollectionsAdapterViewFactory<E> viewFactory;
	
	/**
	 * Constructor which will create a new CollectionsAdapter with a TextView Layout as basis to display the items.
	 * The items toString method will be used to fill the text.
	 * @param context The context of the adapter.
	 * @param textViewResourceId The resource id which is referring to the text view element used for displaying items.
	 * @param content The collection containing the data.
	 */
	public CollectionsAdapter(Context context, int textViewResourceId, Collection<E> content) {
		this(context, content, new TextViewFactory<E>(textViewResourceId));
	}
	
	/**
	 * Constructor which will create a new CollectionsAdapter with a custom Layout which includes a TextView to display the items.
	 * The items toString method will be used to fill the text.
	 * @param context The context of the adapter.
	 * @param layoutResourceId The resource id which is referring to the layout which will be used for displaying items.
	 * @param textViewResourceId The resource id which is referring to the text view element used to fill in the text.
	 * @param content The collection containing the data.
	 */
	public CollectionsAdapter(Context context, int layoutResourceId, int textViewResourceId, Collection<E> content) {
		this(context, content, new DefaultViewFactory<E>(layoutResourceId, textViewResourceId));
	}
	
	/**
	 * Constructor which will create a new CollectionsAdapter which provides a custom ICollectionsAdapterViewFactory which will be used to create the view for the elements.
	 * Use this Constructor for implementing custom layouts (e.g. entries with multilpe lines, entries with images,..)
	 * @param context The context of the adapter.
	 * @param content The collection containing the data.
	 * @param viewFactory The factory which will be used to create the view elements of each entry.
	 */
	public CollectionsAdapter(Context context, Collection<E> content, ICollectionsAdapterViewFactory<E> viewFactory) {
		super();
		this.content = content;
		this.interactor = ICollectionsInteractor.Factory.getInteractor(content);
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		this.viewFactory = viewFactory;
	}
	

	@Override
	public int getCount() {
		return content.size();
	}

	@Override
	public E getItem(int position) {
		return interactor.getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return interactor.getItemId(position);
	}

	@Override
	public View getView(int position, View convertView,
			ViewGroup parent) {
		return viewFactory.getView(position, convertView, parent, getItem(position), inflater, context);
	}

	/**
	 * This method will add a new element to the Collection and then notify the attached view that the data has been changed.
	 * @see Collection#add
	 * @see BaseAdapter#notifyDataSetChanged
	 */
	public boolean add(E object) {
		if(content.add(object)) {
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	/**
	 * This method will add all elements from the given Collection to the Collection of this adapter and then notify the attached view that the data has been changed.
	 * @see Collection#addAll
	 * @see BaseAdapter#notifyDataSetChanged
	 */
	public boolean addAll(Collection<? extends E> c) {
		if(content.addAll(c)) {
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	/**
	 * This method will remove all items from the Collection of this adapter and then notify the attached view that the data has been changed.
	 * @see Collection#clear
	 * @see BaseAdapter#notifyDataSetChanged
	 */
	public void clear() {
		content.clear();
		notifyDataSetChanged();
	}

	/**
	 * This method will remove the given item from the Collection of this adapter and then notify the attached view that the data has been changed.
	 * @see Collection#remove
	 * @see BaseAdapter#notifyDataSetChanged
	 */
	public boolean remove(E object) {
		if(content.remove(object)) {
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	/**
	 * This method will remove all elements from the given Collection to the Collection of this adapter and then notify the attached view that the data has been changed.
	 * @see Collection#removeAll
	 * @see BaseAdapter#notifyDataSetChanged
	 */
	public boolean removeAll(Collection<?> c) {
		if(content.removeAll(c)) {
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	
	
	


}
