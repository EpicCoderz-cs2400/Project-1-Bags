
 public class LinkedBagTest
{
    public static void main(String[] args) 
	{
      System.out.println("Creating an empty Linekdbag.");
      BagInterface<String> aBag = new LinkedBag<>();
      testIsEmpty(aBag, true);
		displayBag(aBag);
      
      String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);

      //tests on two bags for intersection 
      System.out.println("\nCreating an empty LinkedBag.");
      System.out.println("Testing intersection on two normal bags");
      BagInterface<String> aBag1 = new LinkedBag<>();
      String[] contentsofBag1 = {"A", "A", "B", "A", "C", "A", "Y"};
      testAdd(aBag1, contentsofBag1);
      BagInterface<String> aBag4 = new LinkedBag<>();
      String[] contentsofBag4 = {"A", "B", "A", "C", "A", "F", "E"};
      testAdd(aBag4, contentsofBag4);
      testIntersection(aBag1, aBag4);
      System.out.println("Intersection should have: A A A B C");

      /*//tests on two bags for intersection 
      System.out.println("\nCreating an empty LinkedBag.");
      System.out.println("Testing intersection on two normal bags");
      BagInterface<String> aBag1 = new LinkedBag<String>();
      String[] contentsofBag1 = {"A", "F", "d", "E", "e", "A", "Y"};
      testAdd(aBag1, contentsofBag1);
      BagInterface<String> aBag2 = new LinkedBag<String>();
      String[] contentsofBag2 = {"B", "e", "Y"};
      testAdd(aBag2, contentsofBag2);
      testIntersection(aBag1, aBag2);
      System.out.println("Intersection should have: e Y");
      */


      /*System.out.println("\nCreating an empty LinkedBag.");
      System.out.println("Testing intersection with one empty bag");
      BagInterface<String> aBag5 = new LinkedBag<String>();
      String[] contentsofBag5 = {""};
      testAdd(aBag5, contentsofBag5);
      BagInterface<String> aBag6 = new LinkedBag<String>();
      String[] contentsofBag6 = {"A", "B", "A", "C", "A", "F", "E"};
      testAdd(aBag6, contentsofBag6);
      testIntersection(aBag6, aBag5);
      System.out.println("Intersection should be null");*/
	} // end main
   
   // Tests the method isEmpty.
   // Precondition: If the bag is empty, the parameter empty should be true;
   // otherwise, it should be false.
	private static void testIsEmpty(BagInterface<String> bag, boolean empty)
   {
      System.out.print("\nTesting isEmpty with ");
      if (empty)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	} // end testIsEmpty
   
   // Tests the method add.
   private static void testAdd(BagInterface<String> aBag, String[] content)
   {
      System.out.print("Adding the following strings to the bag: ");
      for (int index = 0; index < content.length; index++)
      {
         if (aBag.add(content[index]))
            System.out.print(content[index] + " ");
         else
            System.out.print("\nUnable to add " + content[index] +
                             " to the bag.");
      } // end for
      System.out.println();
      
      displayBag(aBag);
   } // end testAdd
   
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

   private static void testIntersection(BagInterface<String> aBag, BagInterface<String> secondBag)
   {
       System.out.print("After intersection ");
       BagInterface<String> commonItems = aBag.intersection(secondBag);
       displayBag(commonItems);
   }

}
