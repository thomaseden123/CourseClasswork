/**
 * Prints out information of user.
 *
 * @author - Thomas Eden
 * @version - September 13, 2022
 */ 

public class UserInfo { 

   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   
   // constructor
   private static final int OFFLINE = 0, ONLINE = 1; 
   
   /**
    * User info name class.
    * @param firstNameIn - firstName.
    * @param lastNameIn - lastName.
    *
    */

   public UserInfo(String firstNameIn, String lastNameIn) { 
   
   // instance variables
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
      
   }
   /**
    * User inputs name, location, age, status.
    * @return inputs as String.
    */
   
   // methods   
   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) { // is the user offline?
         output += "Offline";
      } else { // is the user online?
         output += "Online";
      }   
      return output;
   }
   
   /**
    * Sets location of user.
    * @param locationIn - location.
    *
    */
   
   public void setLocation(String locationIn) { 
      location = locationIn;
   }      
   
   /**
    * Sets age of user.
    * @param ageIn - age.
    * @return isSet as String.
    */
    
   public boolean setAge(int ageIn) { 
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }   
      return isSet;
   }
   
   /**
    * Gets age of user.
    * @return age as String.
    */
   
   public int getAge() { 
      return age;
   }
   
   /**
    * Gets location of user.
    * @return location as String.
    */
    
   public String getLocation() {
      return location;
   }
   
   /**
    * User logs off.
    *
    */
    
   public void logOff() {
      status = OFFLINE;
   }
   
   /**
    * User logs on.
    *
    */
   
   public void logOn() {
      status = ONLINE;
   }            
}