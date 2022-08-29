/***********************************************
 *                                             *
 *  Using a class to represent a given dates   *
 *                                             *
 * @author Evyatar Weinberg                    *
 * @version 2020a                              *
 ***********************************************/

public class Date {
    //variables declaration:
    private int _day;
    private int _month;
    private int _year;
    
    //finals declaration:
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;
    
    private final int DAY_MIN_VAL = 1;
    private final int MONTH_MIN_VAL = 1;
    private final int YEAR_MIN_VAL = 1000;
     
    private final int YEAR_MAX_VAL = 9999;
    private final int MONTH_MAX_VAL = 12;
    private final int DAY_MAX_VAL = 31;
    
    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int MARCH = 3;
    private final int APRIL = 4;
    private final int MAY = 5;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUGUST = 8;
    private final int SEPTEMBER = 9;
    private final int OCTOBER = 10;
    private final int NOVEMBER = 11;
    private final int DECEMBER = 12;
     
    private final int DAYS_IN_LEAP_FEB = 29;
    private final int DAYS_IN_REG_FEB = 28;
    private final int DAYS_SHORT_MONTH = 30;
    private final int DAYS_LONG_MONTH = 31;
    
    private final int DOUBLE_DIGIT_NUM = 10;
    private final int FIRST_DAY_OF_MONTH = 1;
    private final int MONTHS_IN_YEAR = 12;
    
    //constractors:
    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param _day the day in the month (1-31)
     * @param _month the month in the year (1-12)
     * @param _year the year (4 digits)
     */
    public Date(int day, int month, int year) {
        if (isDateValid(day, month, year) == true) {   
            _day = day;
            _month = month;
            _year = year;
        }
        else {
            _day=DEFAULT_DAY;
            _month=DEFAULT_MONTH;
            _year=DEFAULT_YEAR;
        }
    }
    
    /**
     * Copy Constructor
     * @param other the date to be copied
     */
    public Date(Date other){
        if (other != null) { //checks if the object is initialized
        
            _day = other._day;
            _month = other._month;
            _year = other._year;
        }
    }
   
    //accessors:
    /**
     * gets the year
     * @return the year
     */
    public int getYear(){
        return _year;
    }
    
    /**
     * gets the month
     * @return the month
     */
    public int getMonth(){
        return _month;
    }
    
    /**
     * gets the Day
     * @return the day
     */
    public int getDay(){
        return _day;
    }
    
    /**
     * sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet){
        if (isYearValid(yearToSet))
        _year = yearToSet;
    }
    
    /**
     * set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet){
        if (isMonthValid(monthToSet))
        _month = monthToSet;
    }
    
    /**
     * sets the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void  setDay(int dayToSet){
        if (isDayValid(dayToSet))
        _day = dayToSet;
    }

    /**
     *  check if 2 dates are the same
     *  @param other the date to compare this date to
     *  @return true if the dates are the same
     */
    public boolean equals(Date other)
     {
         if ((_year == other._year) &&
            (_month == other._month) &&
            (_day == other._day))
             return true;
         return false;
     }
    
    /**
     * check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date
     */

    public boolean before(Date other) {
        if (_year < other._year)
            return true;
        if (_year == other._year) {
            if (_month < other._month)
                return true;
            if (_month == other._month && _day < other._day)
                return true;
        }
        return false;
    }

    /**
     * check if this date is after other date
     * @param other date to compare this date to
     * @return true if this date is after other date
     */
    public boolean after(Date other) {
        return !before(other);
    }    

    /**
     * calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates
     */
    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }
    
    /**
     * returns a String that represents this date
     * @returns String that represents this date
     */
    public String toString() {
        if ((_month < DOUBLE_DIGIT_NUM) &&
            (_day < DOUBLE_DIGIT_NUM))
            return "0" + _day + "/" + "0" + _month + "/" + _year;
        if (_month < DOUBLE_DIGIT_NUM)
            return _day + "/" + "0" + _month + "/" + _year;
        if (_day < DOUBLE_DIGIT_NUM)
            return "0" + _day + "/" + _month + "/" + _year;
        return _day + "/" + _month + "/" + _year;
    }
    
    /**
     * calculates the date of the next day of a given date
     * @return the date of tomorrow
     */ 
    public Date tomorrow()
    {   Date d = new Date(_day, _month, _year);
        switch (_month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER: if (_day < DAYS_LONG_MONTH) {
                              ++d._day;
                              return d;
                          }     
                          if (_day == DAYS_LONG_MONTH) {   
                              d._day = FIRST_DAY_OF_MONTH;
                              ++d._month;
                              return d;
                          }  
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER: if(_day < DAYS_SHORT_MONTH) {   
                              ++d._day;
                              return d;
                           }
                           if (_day == DAYS_SHORT_MONTH) {    
                               d._day = FIRST_DAY_OF_MONTH;
                               ++d._month;
                               return d;
                           }
            case DECEMBER: if (_day < DAYS_LONG_MONTH) {    
                               ++d._day;
                               return d;
                           }
                           if ((_day == DAYS_LONG_MONTH) &&
                              (_year >= YEAR_MAX_VAL)) {
                               d._day = DEFAULT_DAY;
                               d._month = DEFAULT_MONTH;
                               d._year = DEFAULT_YEAR;
                               return d;
                           }
                           if (_day == DAYS_LONG_MONTH) {
                               d._day = FIRST_DAY_OF_MONTH;
                               d._month = JANUARY;
                               ++d._year;
                               return d;
                           }
            case FEBRUARY: if (_day < DAYS_IN_REG_FEB) {
                                  ++d._day;
                                  return d;
                              }
                              if ((_day == DAYS_IN_REG_FEB) &&
                                 (isLeap(_year) == true)) {
                                  ++d._day;
                                  return d;
                              }
                              if ((_day == DAYS_IN_REG_FEB) &&
                                 (isLeap(_year) == false)) {
                                  d._day = FIRST_DAY_OF_MONTH;
                                  d._month = MARCH;
                                  return d;
                              }
                              if (_day == DAYS_IN_LEAP_FEB) {
                                  d._day = FIRST_DAY_OF_MONTH;
                                  d._month = MARCH;
                                  return d;
                              }
            default: return d;
        }
    }
    
    //calculates the day of the week that this date occurs on
    /**
    * calculates the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
    * @return the day of the week that this date occurs on
    */
    public int dayInWeek()
    {   
        if ((_month == JANUARY) ||
           (_month == FEBRUARY)) {
            _month = _month + MONTHS_IN_YEAR;
            --_year;
        }
        int century = _year/100;
        int twoDigitYear = _year%100;
        
        float dayOfWeek = Math.floorMod(((_day + (26*(_month+1))/10 + (twoDigitYear) + (twoDigitYear)/4 
                          + (century)/4 - 2*(century))%7),7);
        return (int) dayOfWeek;
    }
    
    //checks if the year input is valid
    private boolean isYearValid (int year) {
        if ((year >= YEAR_MIN_VAL)||(year <= YEAR_MAX_VAL))
            return true;
        return false;
    }
    
    //checks if the month input is valid
    private boolean isMonthValid (int month) {
        if ((month >= MONTH_MIN_VAL) || (month <= MONTH_MAX_VAL))
            return true;
        return false;
    }
    
    //checks if the day input is valid
    private boolean isDayValid (int day) {
        if ((day >= DAY_MIN_VAL) || (day <= DAY_MAX_VAL))
            return true;
        return false;
    }
    
    //checks if the date input is valid
    private boolean isDateValid (int day, int month, int year) {
        if (isYearValid (year) == false)
            return false;
            
        if (isDayValid (day) == false)
            return false;
         
        //checks if the days input fits the month input
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER: return true;
            
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
            if (day <= DAYS_SHORT_MONTH)
                return true; 
            return false;
                              
            case FEBRUARY:
            if ((day == DAYS_IN_LEAP_FEB) &&
                (isLeap(year) == false))
                return false; 
                
            if (day <= DAYS_IN_LEAP_FEB)
                return true;
            return false;
                               
            default: return false;
        }
    }

    //checks if a year is a leap year
    private boolean isLeap (int year) {
        if (year % 4 != 0)
           return false;
        
        else if (year % 400 == 0)
                return true;
        
             else if (year % 100 == 0) 
                     return false;
                  
                  else
                  return true;       
    }
     
    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate ( int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    } 
} 
