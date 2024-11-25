import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Represents a menu app of hexagonal prisms in list.
 * @author - Thomas Eden
 * @version - October 2, 2022
 *
 */
public class HexagonalPrismListMenuApp {

/**
 * Project 6.
 * Displays HexagonalPrism List System Menu.
 * @param args - not used.
 * @throws FileNotFoundException if the file cannot be opened.
 */

   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner userInput = new Scanner(System.in);
      ArrayList<HexagonalPrism> prismList = new ArrayList<HexagonalPrism>();
      String list = "";
      HexagonalPrismList hpList = new HexagonalPrismList(list, prismList);
      
      String fileName = "";
      
      System.out.println("HexagonalPrism List System Menu\n"
                       + "R - Read File and Create HexagonalPrism List\n"
                       + "P - Print HexagonalPrism List\n" 
                       + "S - Print Summary\n"  
                       + "A - Add HexagonalPrism\n"
                       + "D - Delete HexagonalPrism\n"
                       + "F - Find HexagonalPrism\n"
                       + "E - Edit HexagonalPrism\n"
                       + "Q - Quit");
      
        
      char choice = 'Q';
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch(choice) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = userInput.nextLine();
               hpList = hpList.readFile(fileName);
               System.out.println("\tFile read in and "
                           + "HexagonalPrism List created\n");            
               break;
            case 'P':
               System.out.println();
               System.out.println(hpList);
               break;
            case 'S':
               System.out.println();
               System.out.println(hpList.summaryInfo());
               System.out.println();
               break;
            case 'A':
               String newLabel = "";
               double newEdge = 0;
               double newHeight = 0;
               System.out.print("\tLabel: ");
               newLabel = userInput.nextLine();
               System.out.print("\tEdge: ");
               newEdge = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               newHeight = Double.parseDouble(userInput.nextLine());
               hpList.addHexagonalPrism(newLabel, newEdge, newHeight);
               System.out.println("\t*** HexagonalPrism added ***\n");  
               break;
               
            case 'D':
               String deleteLabel = "";
               System.out.print("\tLabel: ");
               deleteLabel = userInput.nextLine();
               HexagonalPrism delete = hpList.deleteHexagonalPrism(deleteLabel);
               if (delete != null) {
                  System.out.println("\t\"" + delete.getLabel() 
                                 + "\" deleted\n");
               } else {
                  System.out.println("\t\"" + deleteLabel 
                                 + "\" not found\n");
               }   
                  
               break;
               
            case 'F':
               String findLabel = "";
               System.out.print("\tLabel: ");
               findLabel = userInput.nextLine();
               HexagonalPrism find = hpList.findHexagonalPrism(findLabel);
               if (find != null) {
                  System.out.println(find + "\n");
               } else {
                  System.out.println("\t\"" + findLabel + "\" not found\n");
               }   
               break;
               
            case 'E':
               String editLabel = "";
               double editEdge = 0;
               double editHeight = 0;
               System.out.print("\tLabel: ");
               editLabel = userInput.nextLine();
               System.out.print("\tEdge: ");
               editEdge = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               editHeight = Double.parseDouble(userInput.nextLine());
               boolean edit = hpList.editHexagonalPrism(editLabel, 
                           editEdge, editHeight);   
               if (edit) {
                  HexagonalPrism p = hpList.findHexagonalPrism(editLabel);
                  System.out.println("\t\"" + p.getLabel() 
                                    + "\" successfully edited\n");
               } else {
                  System.out.println("\t\"" + editLabel 
                                    + "\" not found\n");
               }     
               break;
               
            case 'Q': 
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
         }      
      } while (choice != 'Q');
       
   }

}