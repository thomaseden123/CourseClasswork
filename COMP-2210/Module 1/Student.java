/**
 * Student.java
 * A class to represent student data, for the
 * purpose of illustrating order by Comparable
 * and Comparator.
 */
public class Student implements Comparable<Student> {

   private String fname;
   private String lname;
   private int section;

   /** Creates a new student. */
   public Student(String last, String first, int sec) {
      lname = last;
      fname = first;
      section = sec;
   }

   /** Returns this student's first name. */
   public String getFirstName() {
      return fname;
   }

   /** Returns this student's last name. */
   public String getLastName() {
      return lname;
   }

   /** Returns this student's section. */
   public int getSection() {
      return section;
   }

   /**
    * Implement compareTo so that students are ordered in the
    * following way: in ascending order of last name, then in
    * ascending order of first name, and then in ascending order
    * of section.
    */
   @Override
   public int compareTo(Student s) {
      int a = this.fname.compareTo(s.fname);
      int b = this.lname.compareTo(s.lname);
      if (a > 0) {
         return 1;
      }
      else if (a < 0) {
         return -1;
      }
      else {
         if (b > 0) {
            return 1;
         }
         else if (b < 0) {
            return -1;
         } 
         else {
            if (this.section > s.section) {
               return 1;
            } else if (this.section < s.section) {   
               return -1;
            } else {
               return 0;
            }
         }
      }     
   }

   /** Returns a string representation of this student. */
   @Override
   public String toString() {
      return section + ", " + lname + ", " + fname;
   }
}
