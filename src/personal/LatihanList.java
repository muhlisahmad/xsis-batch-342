package personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatihanList {
  public static void main(String[] args) {
    // Immutable List
    List<String> immutablelist = new ArrayList<>(List.of("Muhlis", "Amario", "Pridana"));
    System.out.println("Immutable List\t: " + immutablelist);
    System.out.println();

    // Mutable List
    List<String> mutableList = new ArrayList<>();

    mutableList.add("Muhlis");
    mutableList.add("Amario");
    mutableList.add("Pridana");

    System.out.println("Mutable List\t: " + mutableList);
    mutableList.reversed(); // this is not a void method, so it would not change the original list
    System.out.println("Reversed List\t: " + mutableList); // the list would remains the same
    System.out.println();
    
    // assign it to a new List to contain it
    List<String> reversedMutableList = mutableList.reversed();
    System.out.println("New List\t: " + reversedMutableList);
    System.out.println();
    
    System.out.println("Unsorted List\t: " + mutableList);
    mutableList.sort((e1, e2) -> e2.compareTo(e1));
    System.out.println("Des Sorted List\t: " + mutableList);
    mutableList.sort((e1, e2) -> e1.compareTo(e2));
    System.out.println("Asc Sorted List\t: " + mutableList);
    System.out.println();

    String [] arrFromList = mutableList.toArray(new String[mutableList.size()]);
    System.out.println("From `toArray`\t: " + Arrays.toString(arrFromList));
    System.out.println();
    
    System.out.println("Unmodified List\t: " + mutableList);
    // replace all of list elements with new value based on the current value (modifying it basically).
    mutableList.replaceAll(element -> "Name = " + element);
    System.out.println("Modified List\t: " + mutableList);
    System.out.println();
    
    System.out.println("Complete List\t: " + mutableList);
    // even tho it is returns a boolean, it still removes the element in place
    mutableList.removeIf(element -> element.contains("Pridana"));
    System.out.println("Removed List\t: " + mutableList);
    System.out.println();

    // How to initialize a list with initial values

    // can add and remove
    @SuppressWarnings("unused")
    List<String> canAddAndRemoveList = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven"));

    // cannot add and remove (modify only)
    @SuppressWarnings("unused")
    List<String> modifyOnlyList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
  }
}
