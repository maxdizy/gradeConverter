/*Max Dizy
December 8th, 2020
ICS4U
Mr. Hofstatter
gradeConverter
Grade converter that takes a percent grade for a selected subject and creates a report card for all students with letter grades*/

import java.util.*;

public class gradeConverter{

  //method to check student name input
  public static boolean checkName(String name){
    boolean confirmed = false;
    boolean ifString = false;
    char[] nameArray = name.toCharArray();
    char[] alph = "abcdefghijklmnopqrstuvwrxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    for (char digit : nameArray){
      confirmed = false;
      for (char letter : alph){
        if (digit == letter){
          confirmed = true;
        }
      }
      if (confirmed == false){
        System.out.println("Sorry I don\'t understand, Please only use letters and try again: ");
        return false;
      }
    }
    return true;
  }

  //method to check if input is a vilid subject
  public static boolean checkSubject(String subject){
    boolean confirmed = false;
    String[] possible = {"english", "fucntions", "calculus", "math", "religion", "chemistry", "physics", "science", "computer science", "robotics", "civics and careers", "music", "art"};
    for (String valid : possible){
      confirmed = false;
        if (subject.equals(valid)){
          return true;
        }
      }
      if (confirmed == false){
        char[] subjectArray = subject.toCharArray();
        char[] alph = "abcdefghijklmnopqrstuvwrxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char digit : subjectArray){
          confirmed = false;
          for (char letter : alph){
            if (digit == letter){
              confirmed = true;
            }
          }
          if (confirmed == false){
            System.out.println("Sorry I don\'t understand, Please only use letters and try again: ");
            return false;
          }
        }
        if (confirmed == true){
          Scanner scan = new Scanner(System.in);
          while(confirmed){
            System.out.print("\nThis subject is not in my database. Would you like to continue?(\'yes\' or \'no\'): ");
            String answer = scan.next().toLowerCase();
            if (answer.equals("yes")){
              return true;
            }
            else if (answer.equals("no")){
              return false;
            }
            else{
              System.out.println("Sorry I don\'t understand, please answer \'yes\' or \'no\' and try again: ");
            }
          }
        }
      }

      else if (confirmed == false){
        System.out.println("Sorry I don\'t understand, Please only use letters and try again: ");
        return false;
      }
      return false;
    }

  //method to check if grade is a number
  public static boolean checkGrade(String grade){
    char[] possibleEntries = "0123456789.".toCharArray();
    char[] gradeArray = grade.toCharArray();
    boolean verified = false;
    for (char digit : gradeArray){
      verified = false;
      for (char options : possibleEntries){
        if (digit == options){
          verified = true;
        }
      }
    if(!verified){
        System.out.println("invalid response. please enter a whole number and try again:");
        return false;
      }
    }
    double gradeInt = Double.parseDouble(grade);
    if (gradeInt > 100){
      System.out.print("invalid response. please enter a grade under 100");
    }
    if (gradeInt < 0){
      System.out.print("invalid response. please enter a grade over 0");
    }
    return true;
  }

  //method to convert grade to letter
  public static String convertGrade(String grade){
    int gradeInt = Integer.parseInt(grade);
    if (gradeInt >= 95){
      return "A+";
    }
    if (gradeInt >= 90){
      return "A";
    }
    if (gradeInt >= 85){
      return "A-";
    }
    if (gradeInt >= 80){
      return "B";
    }
    if (gradeInt >= 70){
      return "C";
    }
    if (gradeInt >= 60){
      return "D";
    }
    if (gradeInt < 60){
      return "F";
    }
    return "null";
  }

  //method to print report print report cards
  public static void printReportCards(List <String> nameList, Dictionary <String, Object> names, Dictionary <String, String> data){
    for (String name : nameList){
      System.out.print(name + names.get(name));
      }
    }

  //main method
  public static void main(String[] args){
    //variables
    Scanner scan = new Scanner(System.in);
    boolean pass = false;

    //initialize list
    List <String> nameList = new ArrayList <String> ();

    //initialize dictionaries
    Dictionary <String, Object> names = new Hashtable <String, Object> ();
    Dictionary <String, String> data = new Hashtable <String, String> ();

    //welcome
    System.out.println("Welcome to the Grade Book");

    //program
    while(!pass){
      //name
      boolean check = false;
      String name = "";
      while(!check){
        System.out.print("\nPlease enter the students name to continue: ");
        name = scan.nextLine().toLowerCase();
        check = checkName(name);
        if (check){
          nameList.add(name);
        }
      }

      //subject
      check = false;
      String subject = "";
      while(!check){
        System.out.print("\nPlease enter the subject you would like to input a grade for: ");
        subject = scan.nextLine().toLowerCase();
        check = checkSubject(subject);
      }

      //grade
      check = false;
      String grade = "";
      while(!check){
        System.out.print("\nPlease enter the grade achived: ");
        grade = scan.nextLine();
        check = checkGrade(grade);
        if (check){
          grade = convertGrade(grade);
        }
      }

      //store data
      data.put(subject, grade);
      names.put(name, data);

      //continue
      check = false;
      while(!check){
        System.out.print("\nPlease enter \'n\' to input another student and \'p\' to print report cards: ");
        String answer = scan.nextLine().toLowerCase();
        if (answer.equals("n")){
          check = true;
        }
        else if (answer.equals("p")){
          pass = true;
          check = true;
        }
        else{
          System.out.print("Sorry I don\'t understand please enter \'n\' or \'p\' and try again: ");
        }
      }
    }

    printReportCards(nameList, names, data);

  }
}
