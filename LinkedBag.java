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
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private Node getNextNode()
        {
            return next;
        }
    }
}
