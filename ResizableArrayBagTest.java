/*
    This Class checking to make sure all the inital methods in LinkedBag and Resizable ArryBag work properly (testing purpuses). 
    This is not the drive class or client program. The bags will be tested using Strings.
    
    NOT COMPLETED (pretty sure they work though). 
*/

public class ResizableArrayBagTest {
    public static void main(String[] args)
    {
        //creating empty array bags
        BagInterface<String> aBag0 = new ResizableArrayBag<String>();

        // tests if IsEmpty is true with an empty bag 
        testIsEmpty(aBag0, true);

        // Tests if add works with Strings
        String[] contentsOfBagl = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag0, contentsOfBagl);

        //tests if IsEmpty is false with a non-empty bag
        testIsEmpty(aBag0, false); 

        // tests array bag that will be full
        aBag0 = new ResizableArrayBag<String> (7);
        System.out.println("\nA new empty bag:");
        
        // tests on an empty bag
        testIsEmpty(aBag0, true);

        // adding strings
        String[] contentsofBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag0, contentsofBag2);
        testIsEmpty(aBag0, false);

        //tests if adding to a full array works 
        System.out.print("Testing Full Array bag: ");
        String[] extracontents = {"Z", "Z"};
        testAdd(aBag0, extracontents);

        System.out.println("\nA new empty bag:");

        //tests on two bags for intersection 
        BagInterface<String> aBag3 = new ResizableArrayBag<String>();
        String[] contentsofBag3 = {"A", "A", "B", "A", "C", "A", "Y"};
        testAdd(aBag3, contentsofBag3);
        BagInterface<String> aBag4 = new ResizableArrayBag<String>();
        String[] contentsofBag4 = {"A", "B", "A", "C", "A", "F", "E"};
        testAdd(aBag4, contentsofBag4);
        testIntersection(aBag3, aBag4);
        System.out.println("Intersection should have: A A A B C");

        
        //tests on two bags with same content for intersection 
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags with exact same content");
        System.out.println("");

        
        BagInterface<String> aBag5 = new ResizableArrayBag<String>();
        String[] contentsofBag5 = {"A", "A", "B", "B", "G", "F", "Y"};
        testAdd(aBag5, contentsofBag5);
        BagInterface<String> aBag6 = new ResizableArrayBag<String>();
        String[] contentsofBag6 = {"A", "A", "B", "B", "G", "F", "Y"};
        testAdd(aBag6, contentsofBag6);
        testIntersection(aBag5, aBag6);
        System.out.println("Intersection should have: A A B B G F Y");

        //tests on two bags with same no similiar content for intersection 
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags with exact same content");
        System.out.println("");        

        BagInterface<String> aBag7 = new ResizableArrayBag<String>();
        String[] contentsofBag7 = {"A", "B", "C", "D", "E", "F", "G"};
        testAdd(aBag7, contentsofBag7);
        BagInterface<String> aBag8 = new ResizableArrayBag<String>();
        String[] contentsofBag8 = {"Z", "Y", "W", "V", "U", "T", "S"};
        testAdd(aBag8, contentsofBag8);
        testIntersection(aBag7, aBag8);
        System.out.println("Intersection should have: Empty"); 

        //tests on two bags with same no content
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags with no content");
        System.out.println("");        

        BagInterface<String> aBag9 = new ResizableArrayBag<String>();
        String[] contentsofBag9 = {};
        testAdd(aBag9, contentsofBag9);
        BagInterface<String> aBag10 = new ResizableArrayBag<String>();
        String[] contentsofBag10 = {};
        testAdd(aBag10, contentsofBag10);
        testIntersection(aBag9, aBag0);
        System.out.println("Intersection should have: Empty"); 

        //tests on two bags with one containing null entry
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags with no content");
        System.out.println("");        

        BagInterface<String> aBag70 = new ResizableArrayBag<String>();
        String[] contentsofBag70 = {"A", "Y", "X", "U"};
        testAdd(aBag70, contentsofBag70);
        BagInterface<String> aBag71 = new ResizableArrayBag<String>();
        String[] contentsofBag71 = {"F", "U"};
        testAdd(aBag71, contentsofBag71);
        testIntersection(aBag70, aBag71);
        System.out.println("Intersection should have: U"); 

        //tests random two bags
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags in likely client use");
        System.out.println("");

        
        BagInterface<String> aBag13 = new ResizableArrayBag<String>();
        String[] contentsofBag13 = {"A", "A", "B", "C"};
        testAdd(aBag13, contentsofBag13);
        BagInterface<String> aBag14 = new ResizableArrayBag<String>();
        String[] contentsofBag14 = {"A", "A", "B", "B", "B", "B", "B"};
        testAdd(aBag14, contentsofBag14);
        testIntersection(aBag13, aBag14);
        System.out.println("Intersection should have: A A B");

    } // end main
    
    // Tests the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content)
    {
        System.out.print("Adding to the full bag: ");
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
        System.out.print("Testing the method isEmpty with ");
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
        System.out.print("The bag now contains the following string(s): ");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
        System.out.print(bagArray[index] + " ");
        } // end for
        System.out.println();
    } // end displayBag

    //tests the intersection method
    private static void testIntersection(BagInterface<String> aBag, BagInterface<String> secondBag)
    {
        System.out.println("Using intersection with both bags: ");
        BagInterface<String> commonItems = aBag.intersection(secondBag);
        displayBag(commonItems);
    }
}
