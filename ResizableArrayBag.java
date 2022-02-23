/*
    A class that implements a bag of objects with a resizable array.
*/

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>{

    private T[] bag;
    private int numberOfEntries;
    private static int DEFAULT_CAPACITY =25;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK =false;

    public ResizableArrayBag() //Cosntructor that creates a bag with default capacity
    {
        this(DEFAULT_CAPACITY);
    } //end default constructor

    public ResizableArrayBag(int desiredCapacity) //Constructor that creates bag with given initial capacity
    {
        checkCapacity(desiredCapacity);

        @SuppressWarnings("unchecked")

        T[] tempBag = (T[])new Object[desiredCapacity];
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public boolean add(T newEntry) //add entry to the bag
    {
        checkIntegrity();
        if (isFull())
        {
            doubleCapacity();
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    } 

    public T[] toArray() //retrieves all entries that are in the bag and returns them as an array
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index<numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        
        return result;
    }

    private boolean isFull() //checks if bag is full and returns ture if so
    { 
        return numberOfEntries == bag.length;
    }

	public int getFrequencyOf(T anEntry) //count the number of times a given entry appears in the bag
	{
	  checkIntegrity();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            	counter++;
         } // end if
     }// end for
     return counter;
	} // end getFrequencyOf

    public boolean isEmpty() //Tests whether the bag is empty
	{
     	return numberOfEntries == 0;
	} // end isEmpty

	//get current number of entries in the bag
    public int getCurrentSize() 
	{
      	return numberOfEntries;
	} // end getCurrentSize

	public boolean remove(T anEntry) //remove on occurance of an entry
	{
	  checkIntegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);         
      return anEntry.equals(result);
	} 

    private int getIndexOf(T anEntry) //Locates a given entry within the bag
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            } // end if
            index++;
        } // end while

        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array
      
        return where;
    } // end getIndexOf

    private T removeEntry(int givenIndex) //Removes and returns the entry given
    {
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];                   // Entry to remove
         bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
         bag[numberOfEntries - 1] = null;            // Remove last entry
         numberOfEntries--;
		} // end if
      
      return result;
    } // end removeEntry   

	public void clear() //Removes all entries
	{
      while (!isEmpty())
         	remove();
	} // end clear

    //tests wheter the bag contains a given entry. Reutrns true if does
    public boolean contains(T anEntry) 
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1; // or >= 0
    } // end contains
    
    public T remove() { //remove one unspecified entry from the bag 
        checkIntegrity();
        T result = removeEntry(numberOfEntries-1);
        return result;
    }

    //checks integtrity of the bag
    private void checkIntegrity() 
    {
        if(!integrityOK)
            throw new SecurityException("ArrayBag object is currupt.");
    }

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
    } // end checkCapacity
      
   private void doubleCapacity() // Doubles the size of the array bag.
   {
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
   } // end doubleCapacity

}