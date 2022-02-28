/*
    LinkedBag Class
*/
public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag() { //Create an empty linked bag.
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor
/**
 * @return The current number of entires that the bag can hold
 * 
 */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    public boolean add(T newEntry) { //Add a new entry to this bag.	      
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode;      // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add
     
    public T[] toArray() { //Retrieve all entries that are in this bag.
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        Node currentNode = firstNode;
        for (int i = 0; i < result.length; ++i) {
            result[i] = currentNode.data;
            currentNode = currentNode.next;
        } // end for

        return result;
    } // end toArray
/**
 * 
 * Counts number of times 'an entry' appears in said bag
 * @param anEntry The entry to be located
 * @return frequency of 'an entry'
 */
    public int getFrequencyOf(T anEntry) {  //Count the number of times a given entry appears in this bag.
        int frequency = 0;

        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                frequency++;
            } // end if

            currentNode = currentNode.next;
        } // end while

        return frequency;
    } // end getFrequencyOf
        
    /**
         * 
        Tests whether this bag contains a given entry.
         @param anEntry The entry to locate.
         @return true if the bag contains anEntry, or false otherwise.
     */

    public boolean contains(T anEntry) { 
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        } // end while

        return false;
    } // end contains

    public T remove() { //Remove one unspecified entry from this bag, if possible
        T result = null;
        if (firstNode != null) {
            result = remove(firstNode);
        } // end if

        return result;
    } // end remove

    public boolean remove(T anEntry) { //Remove one occurrence of a given entry from this bag, if possible.
        boolean result = false;
        Node nodeN = findNode(anEntry);

        if (nodeN != null) {
            remove(nodeN);
            result = true;
        } // end if

        return result;
    } // end remove

    private Node findNode(T anEntry) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        } // end while

        return null;
    } // end findNode

    /**
        Check bag is empty.
        @return True if this bag is empty, or false if not.
    */
    public boolean isEmpty() { 
        
        return numberOfEntries ==0;
    }

    public void clear() { //clear all entries 
        while(!isEmpty())
            remove();
        
    }

    private T remove(Node n) { //Remove the given node's data from this bag.
        T result = n.data;

        n.data = firstNode.data;
        firstNode = firstNode.next;
        numberOfEntries--;

        return result;
    }

    //A class to hold the data in a linked structure.
    private class Node {
        private T    data; // Entry in bag
        private Node next; // Link to next node

        /**
         * Create an unlinked node holding the given data.
         */
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        /**
         * Create a linked node holding the given data.
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
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
         
        //while cbag2 isnt empty and the index is less than bag 1 array size, remove entries from intersect bag and cBag2.  
        int index =0;
        while (index < contentsBag1.length)
        {
            T value = contentsBag1[index]; //gets entry at [index] in bag1 array
 
            //remove the entry from intersect if bag2 does not contain it
            if(!cBag2.contains(value))
                intersectBag.remove(value); 
            else{//remove the entry from bag 2 copy
                cBag2.remove(value);
            }
            index++;
        } 
        //return the new bag
        return intersectBag;
    }//end intersection

    public BagInterface<T> union(BagInterface<T> bag2)
    {
        //prep return object
        BagInterface<T> unionBag = new ResizableArrayBag<T>();
        //return if
        if(isEmpty() && bag2.isEmpty())
            return unionBag;
        if(!isEmpty() && bag2.isEmpty())
            return this;
        if(isEmpty() && !bag2.isEmpty())
            return bag2;
        else{
            //add objects in bag 2 to new bag
            T[] contentsBag1 = toArray();
            for(int i =0; i < getCurrentSize(); i++){
                unionBag.add(contentsBag1[i]);
            }
            T[] contentsBag2 = bag2.toArray();
            for(int i =0; i < contentsBag2.length; i++){
                unionBag.add(contentsBag2[i]);
            }
            //return new bag
            return unionBag; 
        }
    }

    public BagInterface<T> difference(BagInterface<T> bag2){
        //Prep return object
        BagInterface<T> diffBag = new LinkedBag<T>();

        //Check to see if bag 1 is empty
        if (numberOfEntries == 0) {
            return diffBag;
        }

        //Convert bag 1 to array to populate copy
        T[] first = toArray();
    
        //Fill copy of bag 1 with first array
        for (int i = 0; i < first.length; i++) {
            diffBag.add(first[i]);
        }

        //Check to see if bag 2 is empty
        if (bag2.isEmpty()) {
            return diffBag;
        }

        //Convert bag 2 to array
        T[] bag2Contents = bag2.toArray();

        //Initalize element of bag 2
        T element = null;

        //Loop through bag2
        for (int i = 0; i < bag2Contents.length; i++) {
            //Get currently indexed element of bag2
            element = bag2Contents[i];

            //Try and remove each element of bag2 from bag 1 if possible
            diffBag.remove(element);
        }
            
        return diffBag;
    }

}
