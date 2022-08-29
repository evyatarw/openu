/********************************************
* this class organize data of food products *
*                                           *
* @author Evyatar Weinberg                  *
* @version 2020a                            *
*********************************************/

public class Stock
{
    //declaration:
    private int noOfItems;
    private final int MAX_NO_OF_ITEMS = 100;
    private FoodItem newItem;

    //constructor:
    /**
    * creates a new FoodItem Stock Arrey
    * @param _stock stock of all food items
    */
    private FoodItem[] _stock = new FoodItem[MAX_NO_OF_ITEMS];
        
    //methods:
    /**
    * gets the number of the items in the stock
    * @return the number of the items
    */
    public int getNumOfItems() {
        noOfItems = 0;
        for(int i=0; i<MAX_NO_OF_ITEMS && _stock[i] != null; i++)
        {
            noOfItems++;
        }
        return noOfItems;
    }
        
    /**
    * Adds a product as follows:
    *   â€¢
