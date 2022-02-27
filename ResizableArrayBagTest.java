/*
    This Class checking to make sure all the inital methods Resizable ArryBag work properly (testing purposes). 
    This is not the drive class or client program. The bags will be tested using Strings.
    NOT COMPLETED 
*/

public class ResizableArrayBagTest {
    public static void main(String[] args)
    {
        // tests if IsEmpty is true with an empty bag
        BagInterface<String> aBag0 = new ResizableArrayBag<String>();
        testIsEmpty(aBag0, true);

        // Tests if add works with Strings
        String[] contentsOfBagl = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag0, contentsOfBagl);

        //tests if IsEmpty is false with a non-empty bag
        testIsEmpty(aBag0, false); 

        // tests array adding to a bag that is full
        aBag0 = new ResizableArrayBag<String> (7);
        System.out.println("\nA new empty bag:");
        testIsEmpty(aBag0, true);
        String[] contentsofBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag0, contentsofBag2);
        testIsEmpty(aBag0, false);
        System.out.print("Testing Full Array bag: ");
        String[] extracontents = {"Z", "Z", "Z"};
        testAdd(aBag0, extracontents);

        //tests on two new bags for 
        System.out.println("\nA new Test:");
        BagInterface<String> aBag3 = new ResizableArrayBag<String>();
        String[] contentsofBag3 = {"A", "A", "B", "A", "C", "A", "Y"};
        testAdd(aBag3, contentsofBag3);
        BagInterface<String> aBag4 = new ResizableArrayBag<String>();
        String[] contentsofBag4 = {"A", "B", "A", "C", "A", "F", "E"};
        testAdd(aBag4, contentsofBag4);
        testIntersection(aBag3, aBag4);
        System.out.println("Intersection should have: A A A B C");
        testDifference(aBag3, aBag4);
        System.out.println("Difference should have: A Y");
        
        //tests on two bags with same content for intersection 
        System.out.println("\nA new empty bag:");
        System.out.println("Two bags with exact same content");
        System.out.println("");
        testUnion(aBag3, aBag4);
        System.out.println("Union should have A A B A C A Y A B A C A F E");

        
        //tests on two bags with same entries 
        System.out.println("\nA new Test:");
        System.out.println("Two bags with exact same entries");
        BagInterface<String> aBag5 = new ResizableArrayBag<String>();
        String[] contentsofBag5 = {"A", "A", "B", "B", "G", "F", "Y"};
        testAdd(aBag5, contentsofBag5);
        BagInterface<String> aBag6 = new ResizableArrayBag<String>();
        String[] contentsofBag6 = {"A", "A", "B", "B", "G", "F", "Y"};
        testAdd(aBag6, contentsofBag6);
        testIntersection(aBag5, aBag6);
        System.out.println("Intersection should have: A A B B G F Y");
        testDifference(aBag5, aBag6);
        System.out.println("Difference should have: Empty");

        //tests on two bags with same no similiar content for intersection 
        System.out.println("\nA new Test:");
        System.out.println("Two bags with exact no similiar entries");
        System.out.println("");        
        BagInterface<String> aBag7 = new ResizableArrayBag<String>();
        String[] contentsofBag7 = {"A", "B", "C", "D", "E", "F", "G"};
        testAdd(aBag7, contentsofBag7);
        BagInterface<String> aBag8 = new ResizableArrayBag<String>();
        String[] contentsofBag8 = {"Z", "Y", "W", "V", "U", "T", "S"};
        testAdd(aBag8, contentsofBag8);
        testIntersection(aBag7, aBag8);
        System.out.println("Intersection should have: Empty");
        testDifference(aBag7, aBag8);
        System.out.println("Difference should have: A B C D E F G");
        testUnion(aBag7, aBag8);
        System.out.println("Union should have A B C D E F G Z Y W V U T S");

        //tests on two bags empty bags
        System.out.println("\nA new Test:");
        System.out.println("Two bags with no entries");
        System.out.println("");        
        BagInterface<String> aBag9 = new ResizableArrayBag<String>();
        BagInterface<String> aBag10 = new ResizableArrayBag<String>();
        testIntersection(aBag9, aBag10);
        System.out.println("Intersection should have: Empty");
        testUnion(aBag9, aBag10);
        System.out.println("Union should have Empty");

        //tests on two bags. Bag 1 is empty. Bag 2 is not
        System.out.println("\nA new Test:");
        System.out.println("Two bags. Bag 1 is empty. Bag 2 is not");
        System.out.println("");        
        String[] contentsofBag10 = {"A", "L", "M", "G", "G"};
        testAdd(aBag10, contentsofBag10);
        testIntersection(aBag9, aBag0);//you used aBag0 and not aBag10
        System.out.println("Intersection should have: Empty");
        testDifference(aBag9, aBag10); 
        System.out.println("Difference should have: Empty");
        testIntersection(aBag9, aBag10);
        System.out.println("Intersection should have: Empty");
        testUnion(aBag9, aBag10);
        System.out.println("Union should have: A L M G G");

        //tests on two bags. Bag 1 is not empty. Bag 2 is.
        System.out.println("\nA new Test:");
        System.out.println("Two bags. Bag 1 is not empty. Bag 2 is.");
        System.out.println("");        
        testIntersection(aBag10, aBag9);
        System.out.println("Intersection should have: Empty");
        testUnion(aBag10, aBag9);
        System.out.println("Union should have: A L M G G");    

        //tests on two bags. Bag 1 is bigger than bag 2
        System.out.println("\nA new Test:");
        System.out.println("Two bags. Bag 1 is bigger than bag 2");
        System.out.println("");        
        BagInterface<String> aBag70 = new ResizableArrayBag<String>();
        String[] contentsofBag70 = {"A", "Y", "X", "U"};
        testAdd(aBag70, contentsofBag70);
        BagInterface<String> aBag71 = new ResizableArrayBag<String>();
        String[] contentsofBag71 = {"F", "U"};
        testAdd(aBag71, contentsofBag71);
        testIntersection(aBag70, aBag71);
        System.out.println("Intersection should have: U"); 
        testUnion(aBag70, aBag71);
        System.out.println("Union should have A Y X U F U");

        //tests on two bags. Bag 1 is smaller than Bag 2
        System.out.println("\nA new Test:");
        System.out.println("Two bags. Bag 1 is smaller than Bag 2");
        System.out.println("");
        BagInterface<String> aBag13 = new ResizableArrayBag<String>();
        String[] contentsofBag13 = {"A", "A", "B", "C"};
        testAdd(aBag13, contentsofBag13);
        BagInterface<String> aBag14 = new ResizableArrayBag<String>();
        String[] contentsofBag14 = {"A", "A", "B", "B", "B", "B", "B"};
        testAdd(aBag14, contentsofBag14);
        testIntersection(aBag13, aBag14);
        System.out.println("Intersection should have: A A B");
        testDifference(aBag13, aBag14);
        System.out.println("Difference should have: C");

        //Some more tests with difference
        System.out.println("\nSome more test cases\n");
        System.out.println("\nTest case when bag 1 is bigger than bag 2");
        displayBag(aBag14);
        displayBag(aBag13);
        testDifference(aBag14, aBag13);
        System.out.println("Difference should have: B B B B");


        System.out.println("\nTest case when only bag 1 is empty");
        displayBag(aBag10);
        displayBag(aBag13);
        testDifference(aBag10, aBag13);
        System.out.println("Difference should have:");

        System.out.println("\nTest case when only bag 2 is empty");
        displayBag(aBag14);
        displayBag(aBag10);
        testDifference(aBag14, aBag10);
        System.out.println("Difference should have: A A B B B B B");
        testUnion(aBag13, aBag14);
        System.out.println("Union should have A A B C A A B B B B B");

        //tests on two bags. One RAB and one Linked.
        System.out.println("\nA new Test:");
        System.out.println("One RAB bag and one LinkedBag");
        System.out.println("");        
        BagInterface<String> aBag12 = new LinkedBag<>();
        String[] contentsofBag12 = {"A", "B", "D", "D", "E", "F", "G"};
        testAdd(aBag12, contentsofBag12);
        BagInterface<String> aBag11 = new ResizableArrayBag<String>();
        String[] contentsofBag11 = {"D", "Y", "D", "V", "U", "T", "G"};
        testAdd(aBag11, contentsofBag11);
        testIntersection(aBag11, aBag12);
        System.out.println("Intersection should have: D D G");
        testUnion(aBag11, aBag12);
        System.out.println("Union should have D Y D V U T G G F E D D B A");

        //add better tests

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

    //Tests the difference method
    private static void testDifference(BagInterface<String> bag1, BagInterface<String> bag2)
    {
        System.out.println("Using difference with both bags: ");
        bag1.difference(bag2);
        BagInterface<String> uniqueItems = bag1.difference(bag2);
        displayBag(uniqueItems);
    }
    
    //tests the union method
    private static void testUnion(BagInterface<String> aBag, BagInterface<String> aBag2)
    {
        System.out.println("Using union with both bags: ");
        BagInterface<String> allItems = aBag.union(aBag2);
        displayBag(allItems);
    }
}
