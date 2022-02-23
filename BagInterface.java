/** An interface that describes the operations of a bag of objects. */
public interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		and return  The integer number of entries currently in the bag. */
	public int getCurrentSize();

	/** Sees whether this bag is empty.
		and return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
    /** Adds a new entry to this bag.
	    and param newEntry  The object to be added as a new entry.
	    and return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry);
	
    /** Removes one unspecified entry from this bag, if possible.
        and return  Either the removed entry, if the removal was successful, or null. */
	public T remove();
	
    /** Removes one occurrence of a given entry from this bag, if possible.
        and param anEntry  The entry to be removed.
        and return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry);
	
    /** Removes all entries from this bag. */
	public void clear();
	
    /** Counts the number of times a given entry appears in this bag.
	    and param anEntry  The entry to be counted.
		and return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
    /** Tests whether this bag contains a given entry.
		and param anEntry  The entry to find.
		and return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);
	
    /** Retrieves all entries that are in this bag.
		and return  A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
	public T[] toArray();
    
} // end BagInterface
