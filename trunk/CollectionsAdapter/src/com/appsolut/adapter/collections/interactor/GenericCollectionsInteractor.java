package com.appsolut.adapter.collections.interactor;

import java.util.Collection;
import java.util.Iterator;

public class GenericCollectionsInteractor<E> implements
		ICollectionsInteractor<E> {
	
	/** The content which will be used by the interactor **/
	private final Collection<E> content;
	
	/**
	 * A generic interactor which works for all Collections.
	 * @param content The which will be used by the interactor
	 */
	public GenericCollectionsInteractor(Collection<E> content) {
		super();
		this.content = content;
	}

	@Override
	public E getItem(int position) {
		final Iterator<E> iterator = content.iterator();
		for(int i = 0; i < position; i++) {
			iterator.next();
		}
		return iterator.next();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
