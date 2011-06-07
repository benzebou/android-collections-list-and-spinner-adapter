package com.appsolut.adapter.collections.interactor;

import java.util.List;

public class ListCollectionsInteractor<E> implements
		ICollectionsInteractor<E> {
	
	/** The content which will be used by the interactor **/
	private final List<E> content;
	
	/**
	 * An optimized interactor which works for Lists.
	 * @param content The which will be used by the interactor
	 */
	public ListCollectionsInteractor(List<E> content) {
		super();
		this.content = content;
	}

	@Override
	public E getItem(int position) {
		return content.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
