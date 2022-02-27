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

    public BagInterface<T> union(BagInterface<T> bag2)
    {
        //sanitize user input 
        checkIntegrity();
        //prep return object
        BagInterface<T> unionBag = new ResizableArrayBag<T>();

        if(isEmpty() && bag2.isEmpty()) //returns empty bag if both bags are empty
            return unionBag;
        if(!isEmpty() && bag2.isEmpty()) //If only one bag contains entries, returns that bag
            return this;
        if(isEmpty() && !bag2.isEmpty()) //If only one bag contains entries, returns that bag
            return bag2;
        else 
            //add entries in bag 2 to new bag
            for(int i =0; i < getCurrentSize(); i++){
                unionBag.add(bag[i]);
            }
            //create an array to copy bag 2 contents
            T[] contentsBag2 = bag2.toArray();
            for(int i =0; i < contentsBag2.length; i++){
                unionBag.add(contentsBag2[i]); //add entries to union bag
            }
            //return union bag
            return unionBag; 
    }

   public BagInterface<T> intersection(BagInterface<T> secondBag)
   {
        //sanitize user input
        checkIntegrity();

        //prep the return object    
        BagInterface<T> intersectBag = new ResizableArrayBag<T>();
 
        //if either bags are empty, return empy intersect bag. (impossible to have intersecting entries)
        if(isEmpty() || secondBag.isEmpty())
            return intersectBag;
        
        //prepare copies of both bags
        T[] contentsBag1 = toArray(); 
        T[] contentsBag2 = secondBag.toArray();
        
        //use intersect bag as the copy for bag 1
        for (int index = 0; index < getCurrentSize(); index++)
        {
            intersectBag.add(contentsBag1[index]);
        } 
        
        //add entries to copy of bag2
        BagInterface<T> cBag2 = new ResizableArrayBag<T>(secondBag.getCurrentSize());
        for (int index = 0; index < contentsBag2.length; index++)
        {
            cBag2.add(contentsBag2[index]);
        } 
        
        //while cbag2 isnt empty and the index is less than bag 1 array size, remove entries from intersect bag.  
        int index =0;
        while (index < contentsBag1.length)
        {
            T value = contentsBag1[index]; //gets entry at [index] in bag1 array

            //remove the entry from intersect if bag2 does not contain it
            if(!cBag2.contains(value))
                intersectBag.remove(value);
            //if both contain the value, keep value in intersect, but remove from bag 2 copy. 
            else{
                cBag2.remove(value);
            }
            index++;
        } 
        //return the new bag
        return intersectBag;
   }

   public BagInterface<T> difference(BagInterface<T> bag2)
   {
       //Sanitize user input
       checkIntegrity();

       //Prep return object
       BagInterface<T> diffBag = new ResizableArrayBag<T>();

       //Check to see if bag 1 is empty
       if(numberOfEntries == 0) {
           return diffBag;
       }

       //Start return object as copy of bag1
       for(int i = 0; i < numberOfEntries; i++){
           diffBag.add(bag[i]);
       }

       //Check to see if bag 2 is empty
       if(bag2.isEmpty()) {
           //return copied bag
           return diffBag;
       }

       //Convert bag 2 to an array
       T[] bag2Contents = bag2.toArray();

       //Initalize element of bag2
       T element = null;

       //Loop through contents of bag2
       for(int i = 0; i < bag2Contents.length; i++) {
           //Copy currently indexed element of bag2
           element = bag2Contents[i];

           //Remove element from diffBag if possible
           diffBag.remove(element);
       }

       //Return edited bag
       return diffBag;
   }

}