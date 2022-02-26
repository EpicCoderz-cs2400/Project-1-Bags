/*
    Class of bags using linked nodes.
*/
public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries =0;
    }

    public boolean add(T newEntry) //adds new entry to the bag
    {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;

        return true;
    } // end add

    public T[] toArray() //Retrieves all entries in the bag and returns an array of them
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        
        return result;
    }

	public int getFrequencyOf(T anEntry) //Returns the number of times an entry appears in the bag
	{
	  int frequency = 0;

      int counter = 0;
      Node currentNode =firstNode;
      while ((counter < numberOfEntries) && (currentNode != null))
      {
         if (anEntry.equals(currentNode.getData()))
         {
            	frequency++;
         } // end if
         counter++;
         currentNode = currentNode.getNextNode();
     }// end while

     return frequency;
	} // end getFrequencyOf

    public boolean isEmpty() //Tests whther this bag is empty
	{
     	return numberOfEntries == 0;
	} // end isEmpty

	public int getCurrentSize() //returns number of entries in the bag
	{
      	return numberOfEntries;
	} // end getCurrentSize

	public boolean remove(T anEntry) //removes one occuranve of given entry from the bag
	{
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if(nodeN != null)
        {

            nodeN.setData(firstNode.getData());

            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
	} 

    private Node getReferenceTo(T anEntry) //Locates a given entry in the bag
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null));
        {
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
            currentNode = currentNode.getNextNode(); 
        }
        return currentNode;
    } 

	public void clear() //Removes all entries from bag
	{
      while (!isEmpty())
         	remove();
	} // end clear

    public boolean contains(T anEntry) //Tests whether bag contains given entry
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    } // end contains
    
    public T remove() { //removes one unspecified entry from the bag
        
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }

        return result;
    }
    
    //private inner class
    private class Node
    {
        private T data;    // Entry in bag
        private Node next; // Link to next node
   
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor
   
        private Node(T dataPortion, Node nextNode)
        {
        data = dataPortion;
        next = nextNode;
        } // end constructor
   
        private T getData()
        {
            return data;
        } // end getData
   
        private void setData(T newData)
        {
            data = newData;
        } // end setData
   
        private Node getNextNode()
        {
            return next;
        } // end getNextNode
   
    } // end Node

    public BagInterface<T> intersection(BagInterface<T> secondBag)
    {
        //prep the return object    
        BagInterface<T> intersectBag = new LinkedBag<T>();
  
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
        BagInterface<T> cBag2 = new LinkedBag<T>();
        for (int index = 0; index < contentsBag2.length; index++)
        {
            cBag2.add(contentsBag2[index]);
        } 
         
        //while cbag2 isnt empty and the index is less than bag 1 array size, remove entries from intersect bag.  
        int index =0;
        while (index < contentsBag1.length && !cBag2.isEmpty())
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
    }//end intersection

}
