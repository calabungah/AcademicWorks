/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextdate;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
/**
 *
 * @author callum kaspick
 * 
 * program that responds to any date given by returning the next day.
 */


public class Content {

    String[] validMonths = new String[]{"Jan","Feb","Mar","Apr","May",
            "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    
    public String nextDate(String month, int day, int year){
        
        Dictionary<String,String> numOfDays;
        numOfDays = new Hashtable<>();
        numOfDays.put(validMonths[0], "31");
        numOfDays.put(validMonths[1], "28");
        numOfDays.put(validMonths[2], "31");
        numOfDays.put(validMonths[3], "30");
        numOfDays.put(validMonths[4], "31");
        numOfDays.put(validMonths[5], "30");
        numOfDays.put(validMonths[6], "31");
        numOfDays.put(validMonths[7], "31");
        numOfDays.put(validMonths[8], "30");
        numOfDays.put(validMonths[9], "31");
        numOfDays.put(validMonths[10], "30");
        numOfDays.put(validMonths[11], "31");

        //Check to see if entered month string is valid
        if(!Arrays.asList(validMonths).contains(month)){
            throw new IllegalArgumentException("String for month not valid!");
        }
        
        //Checking to see if the day is within the days of that specific month
        else if(day > 0 && day <= Integer.parseInt(numOfDays.get(month))){
            if(day == Integer.parseInt(numOfDays.get(month))){
                if(month == validMonths[11]){
                    return (nextMonth(month) + " 01 " + (year+1));
                }
                else{
                    return (nextMonth(month) + " 01 " + year); 
                }
            }
            else{
                if(day < 10){
                    return (month + " " + 0 + (day+1) + " " + year);
                }
                else{
                    return (month + " " + (day+1) + " " + year);
                }
            }
        }
        
        //Checking if the month is Feb and if so, wheteher its a leap year
        else if(month == validMonths[1] && day == 29){
            if(isLeapYear(year)){
                return (nextMonth(month) + " 01 " + year); 
            }
            else{
                throw new IllegalArgumentException("Not that many days in "
                            + "the month!");
            }
        }
        else{
                throw new IllegalArgumentException("Not that many days in "
                            + "the month!");
        }
    }
    
    //Check if parameter year is leap year
    public boolean isLeapYear(int year){
        if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //return next month
    public String nextMonth(String month){
        switch(month){
            case "Jan":
                return "Feb";
            case "Feb":
                return "Mar";
            case "Mar":
                return "Apr";
            case "Apr":
                return "May";
            case "May":
                return "Jun";
            case "Jun":
                return "Jul";
            case "Jul":
                return "Aug";
            case "Aug":
                return "Sep";
            case "Sep":
                return "Oct";
            case "Oct":
                return "Nov";
            case "Nov":
                return "Dec";
            case "Dec":
                return "Jan";
            default:
                throw new IllegalArgumentException("Wrong month String.");
        }
    }
}
