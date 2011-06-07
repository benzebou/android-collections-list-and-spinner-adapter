package com.appsolut.adapter.collections.interactor;

import java.util.Collection;
import java.util.List;

public interface ICollectionsInteractor<E> {
	
	/**
	 * Method which will return an item located at the given position.
	 * @param position The position of the item which should be returned
	 * @return The item which is located at the given position
	 */
	public E getItem(int position);
	
	/**
	 * Method which will return an item id for a given position.
	 * @param position The position of the item for which the item id should be returned
	 * @return The item id for the item which is located at the given position
	 */
	public long getItemId(int position);
	
	
	
	
	public class Factory {
		/**
		 * Factory for creating a CollectionsInteractor Object.
		 * Follows the principles of the Factory Method Pattern defined by:
		 * 		Gamma, Erich; Helm, Richard; Johnson, Ralph; Vlissides, John (1994).
		 * 		Design Patterns: Elements of Reusable Object-Oriented Software.
		 * 		Addison-Wesley. ISBN 0-201-63361-2.
		 * @param content The collection
		 * @return The interactor matching this collection
		 */
		public static <E> ICollectionsInteractor<E> getInteractor(Collection<E> content) {
			if(content instanceof List) {
				return new ListCollectionsInteractor<E>((List<E>)content);
			} else {
				return new GenericCollectionsInteractor<E>(content);
			}
		}
	}
}
