/*
    This Class checking to make sure all the inital methods in LinkedBag and Resizable ArryBag work properly (testing purpuses). 
    This is not the drive class or client program. The bags will be tested using Strings.
    
    NOT COMPLETED (pretty sure they work though). 
*/

public class BagTesting {
    public static void main(String[] args)
    {
        //creating empty array bags
        BagInterface<String> aBag0 = new ResizableArrayBag<String>();

        // tests on an empty bag
        testIsEmpty(aBag0, true);

        // adding strings
        String[] contentsOfBagl = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag0, contentsOfBagl);
        testIsEmpty(aBag0, false);    aa
        
        // an array bag that will be full
        aBag0 = new ResizableArrayBag<String> (7);
        System.out.println("\nA new empty bag:");
        
        // tests on an empty bag
        testIsEmpty(aBag0, true);

        // adding strings
        String[] contentsofBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag0, contentsofBag2);
        testIsEmpty(aBag0, false);
    } // end main
    
    // Tests the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content)
    {
        System.out.print("Adding to the bag: ");
        for (int index =- 0; index < content. length; index++)
        {
            aBag.add(content[index]);
            System.out.print(content[index] +" ");
        } // end for
        System.out.println();
        displayBag(aBag);
    } // end testAdd
    
    // Tests the method isfull.
    // correctResult indicates what isFull should return.
    private static void testIsEmpty (BagInterface<String> aBag, boolean correctResult)
    {
        System.out.print("\nTesting the method isEmpty with ");
        if (correctResult)
            System.out.println("a empty bag:");
        else
            System.out.println("a bag that is not full:");
            System.out.print("isEmpty finds the bag ");
        if (correctResult && aBag.isEmpty())
            System.out.println("empty: OK.");
        else if (correctResult)
            System.out.println("not empty, but it is empty: ERROR.");
        else if (!correctResult && aBag.isEmpty())
            System.out.println("empty, but it is not empty: ERROR.");
        else
            System.out.println("not empty: OK.");
    } // end testisFull
        
    // Tests the method toArray while displaying the bag.
    private static void displayBag(BagInterface<String> aBag)
    {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
        System.out.print(bagArray[index] + " ");
        } // end for
        System.out.println();
    } // end displayBag
}
