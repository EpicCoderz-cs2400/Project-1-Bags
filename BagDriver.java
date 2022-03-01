import java.util.*;
import java.util.Scanner;

public class BagDriver
{
    public static void main(String[] args) {

        //bags for use
        BagInterface<String> bag1 = new ResizableArrayBag<String>();
        BagInterface<String> bag2 = new ResizableArrayBag<String>();
        BagInterface<String> bag3 = new LinkedBag<>();
        BagInterface<String> bag4 = new LinkedBag<>();
        Scanner scnr = new Scanner(System.in);
        
        //initial introduction
        System.out.println("Welcome to the letter bag simulator:");
        System.out.println("");
        
        //local fields
        String response;
        boolean adding = true;
        String choice = "";
        String quitter = "";

        //first bag intro
        System.out.println("Please select an option for your first bag (Type the letter):");
        System.out.println("R: Creates an Resizable Array Bag.");
        System.out.println("L: Creates a Linked Bag.");
        response = scnr.nextLine();

        //user selects RAB
        if(response.equals("R")){  
            System.out.println("R: Resizable Array Bag Selected.");
            do{
                //printing menu
                printMenu(); 
                System.out.println("Choose option(Type letter)");
                choice = scnr.nextLine();

                //adding
                if(choice.equals("A")){//adding
                    do{
                        System.out.println("Type letter you want to add:");
                        choice = scnr.nextLine();
                        bag1.add(choice);
                        System.out.println(choice + " was added."); 
                        System.out.println("Would you like to add another letter? Y: yes N: no");
                        quitter = scnr.nextLine();
                        if(quitter.equals("N")){
                            adding = false;
                        }
                    }while(adding);
                    choice = "";
                }
                //removing
                else if(choice.equals("R")){//removing an entry NOT DONE
                    System.out.println("Type the letter you want removed.");
                    choice = scnr.nextLine();
                    bag1.remove(choice);
                }

                //clearing all entries
                else if(choice.equals("Cl")){//clearing a list NOT DONE
                    bag1.clear();
                    System.out.println("All entries were cleared");
                }
                //prints all entries
                else if(choice.equals("P")){//
                    System.out.println("List:");
                    System.out.println(Arrays.toString(bag1.toArray()));
                }
                //Prints the size of the bag
                else if(choice.equals("S")){
                    System.out.println("The bag has " + bag1.getCurrentSize() + " entries");
                }
                //two bag methods
                else if(choice.equals("I")){
                    System.out.println("Not availbale with only one bag:");
                }
                else if(choice.equals("U")){
                    System.out.println("Not availbale with only one bag:");
                }
                else if(choice.equals("D")){
                    System.out.println("Not availbale with only one bag:");
                }
            }while(!choice.equals("Q"));
            response = "";
            adding = true;
        }

        //user selects linked bag
        else if(response.equals("L")){
            System.out.println("Linked Bag Selected.");
            
            do{
                //printing menu
                printMenu(); 
                System.out.println("Choose option(Type letter)");
                choice = scnr.nextLine();

                //adding
                if(choice.equals("A")){//adding
                    do{
                        System.out.println("Type letter you want to add:");
                        choice = scnr.nextLine();
                        bag3.add(choice);
                        System.out.println(choice + " was added."); 
                        System.out.println("Would you like to add another letter? Y: yes N: no");
                        quitter = scnr.nextLine();
                        if(quitter.equals("N")){
                            adding = false;
                        }
                    }while(adding);
                    choice = "";
                }
                //removing
                else if(choice.equals("R")){//removing an entry NOT DONE
                    System.out.println("Type the letter you want removed.");
                    choice = scnr.nextLine();
                    bag3.remove(choice);
                }

                //clearing all entries
                else if(choice.equals("Cl")){//clearing a list NOT DONE
                    bag3.clear();
                    System.out.println("All entries were cleared");
                }
                //prints all entries
                else if(choice.equals("P")){//
                    System.out.println("List:");
                    System.out.println(Arrays.toString(bag3.toArray()));
                }
                //Prints the size of the bag
                else if(choice.equals("S")){
                    System.out.println("The bag has " + bag3.getCurrentSize() + " entries");
                }
                //two bag methods
                else if(choice.equals("I")){
                    System.out.println("Not availbale with only one bag:");
                }
                else if(choice.equals("U")){
                    System.out.println("Not availbale with only one bag:");
                }
                else if(choice.equals("D")){
                    System.out.println("Not availbale with only one bag:");
                }else
                    System.out.println("Not Valid entry");
            }while(!choice.equals("Q"));
            response = "";
        }

        //bag 2 into
        System.out.println("Please select an option for your second bag:");
        System.out.println("R: Creates an Resizable Array Bag.");
        System.out.println("L: Creates a Linked Bag.");
        response = scnr.nextLine();

        //user selects RAB
        if(response.equals("R")){  
            System.out.println("R: Resizable Array Bag Selected.");
            do{
                //printing menu
                printMenu(); 
                System.out.println("Choose option(Type letter)");
                choice = scnr.nextLine();

                //adding
                if(choice.equals("A")){//adding
                    do{
                        System.out.println("Type letter you want to add:");
                        choice = scnr.nextLine();
                        bag2.add(choice);
                        System.out.println(choice + " was added."); 
                        System.out.println("Would you like to add another letter? Y: yes N: no");
                        quitter = scnr.nextLine();
                        if(quitter.equals("N")){
                            adding = false;
                        }
                    }while(adding);
                    choice = "";
                }
                //removing
                else if(choice.equals("R")){//removing an entry NOT DONE
                    System.out.println("Type the letter you want removed.");
                    choice = scnr.nextLine();
                    bag2.remove(choice);
                }

                //clearing all entries
                else if(choice.equals("Cl")){//clearing a list NOT DONE
                    bag2.clear();
                    System.out.println("All entries were cleared");
                }
                //prints all entries
                else if(choice.equals("P")){//
                    System.out.println("List:");
                    System.out.println(Arrays.toString(bag2.toArray()));
                }
                //Prints the size of the bag
                else if(choice.equals("S")){
                    System.out.println("The bag has " + bag2.getCurrentSize() + " entries");
                }
                //two bag methods
                else if(choice.equals("I")){
                    if(!bag1.isEmpty() && bag3.isEmpty())
                        System.out.println("The intersection is: " + Arrays.toString(bag1.intersection(bag2).toArray()));{
                    }
                    if(bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The intersection is: " + Arrays.toString(bag3.intersection(bag2).toArray()));
                    }
                    if(bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The intersection is: " + Arrays.toString(bag1.intersection(bag2).toArray()));
                    }
                }
                else if(choice.equals("U")){
                    if(!bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag1.union(bag2).toArray()));
                    }
                    if(bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag3.union(bag2).toArray()));
                    }
                    if(bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag1.union(bag2).toArray()));
                    }
                }
                else if(choice.equals("D")){
                    if(!bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag1.difference(bag2).toArray()));
                    }
                    if(bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag3.difference(bag2).toArray()));
                    }
                    if(bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag1.difference(bag2).toArray()));
                    }
                }
            }while(!choice.equals("Q"));
            response = "";
            adding = true;
        }
        
        //user selects linked bag
        else if(response.equals("L")){
            System.out.println("R: Resizable Array Bag Selected.");
            do{
                //printing menu
                printMenu(); 
                System.out.println("Choose option(Type letter)");
                choice = scnr.nextLine();

                //adding
                if(choice.equals("A")){//adding
                    do{
                        System.out.println("Type letter you want to add:");
                        choice = scnr.nextLine();
                        bag4.add(choice);
                        System.out.println(choice + " was added."); 
                        System.out.println("Would you like to add another letter? Y: yes N: no");
                        quitter = scnr.nextLine();
                        if(quitter.equals("N")){
                            adding = false;
                        }
                    }while(adding);
                    choice = "";
                }
                //removing
                else if(choice.equals("R")){//removing an entry NOT DONE
                    System.out.println("Type the letter you want removed.");
                    choice = scnr.nextLine();
                    bag4.remove(choice);
                }

                //clearing all entries
                else if(choice.equals("Cl")){//clearing a list NOT DONE
                    bag4.clear();
                    System.out.println("All entries were cleared");
                }
                //prints all entries
                else if(choice.equals("P")){//
                    System.out.println("List:");
                    System.out.println(Arrays.toString(bag4.toArray()));
                }
                //Prints the size of the bag
                else if(choice.equals("S")){
                    System.out.println("The bag has " + bag4.getCurrentSize() + " entries");
                }
                //two bag methods
                else if(choice.equals("I")){
                    if(!bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The intersection is: " + Arrays.toString(bag1.intersection(bag4).toArray()));
                    }
                    if (bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The intersection is: " + Arrays.toString(bag3.intersection(bag4).toArray()));
                    }
                    if (bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The intersection is: " + Arrays.toString(bag1.intersection(bag4).toArray()));
                    }
                }
                else if(choice.equals("U")){
                    if(!bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag1.union(bag4).toArray()));
                    }
                    if(bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag3.union(bag4).toArray()));
                    }
                    if(bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The union is: " + Arrays.toString(bag1.union(bag4).toArray()));
                    }
                }
                else if(choice.equals("D")){
                    if(!bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag1.difference(bag4).toArray()));
                    }
                    if(bag1.isEmpty() && !bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag3.difference(bag4).toArray()));
                    }
                    if(bag1.isEmpty() && bag3.isEmpty()){
                        System.out.println("The difference is: " + Arrays.toString(bag1.difference(bag4).toArray()));
                    }
                }else
                    System.out.println("Not Valid entry");
            }while(!choice.equals("Q"));
        
        }
        
        //close snanner
        scnr.close();

    }

    public static void printMenu(){
        System.out.println("");
        System.out.println("Please select an option. (Type letter that corresponds with action)");
        System.out.println("");
        System.out.println("A: Add letter(s) to the bag");
        System.out.println("R: Remove a letter from the bag");
        System.out.println("Cl: Clears all letters from your bag");
        System.out.println("P: Print a list of letters in your bag");
        System.out.println("S: Get the size of your bag");
        System.out.println("I: Creates new bag using intersection (Only available after creation of bag2)");
        System.out.println("U: Creates new bag using union (Only available after creation of bag2)");
        System.out.println("D: Creates new bag using difference (Only available after creation of bag2)");
        System.out.println("Q: Finished with bag 1.");
    }

}