/**
 * The FoodItem class represent a food product
 * @author Evyatar Weinberg
 * @version 2020a
 */
public class FoodItem {
    //variables declaration:
    private String _name;
    private long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;
    
    //finals declaration:
    private final long DEFAULT_CATALOGUE_NUM = 9999;
    private final int DEFAULT_QUANTITY = 0;
    private final int DEFAULT_PRICE = 1;
    
    private final long MIN_CATALOGUE_NUM = 1000;
    private final int MIN_QUANTITY = 0;
    private final int MIN_PRICE = 0;
    private final int MIN_AMOUNT = 0;
   
    private final long MAX_CATALOGUE_NUM = 9999;
    
    private final int NO_ITEMS = 0;
    
    //constractors
    /**
     * creates a new FoodItem object
     * @param name name of food item
     * @param catalogueNumber catalogue number of food item
     * @param quantity quantity of food item
     * @param productionDate production date
     * @param expiryDate expiry date
     * @param minTemperature minimum storage temperature
     * @param maxTemperature maximum storage temperature
     * @param price unit price
     */
    public FoodItem (String name, long catalogueNumber, int quantity, Date productionDate,
                     Date expiryDate, int minTemperature, int maxTemperature, int price)
    {
        if (expiryDate.before(productionDate))
            _expiryDate = new Date(productionDate.tomorrow());
        else _expiryDate = new Date(expiryDate);
        
        _productionDate = new Date(productionDate);
        
        if (minTemperature > maxTemperature) {
            _minTemperature = maxTemperature;
            _maxTemperature = minTemperature;
        }
        else {
            _minTemperature = minTemperature;
            _maxTemperature = maxTemperature;
        }
        
        if (name.isEmpty())
            _name = "item";
        else _name = name;
            
        if ((catalogueNumber < MIN_CATALOGUE_NUM) ||
            (catalogueNumber > MAX_CATALOGUE_NUM))
            _catalogueNumber = DEFAULT_CATALOGUE_NUM;
        else _catalogueNumber = catalogueNumber;
        
        if (quantity < MIN_QUANTITY)
            _quantity = DEFAULT_QUANTITY;
        else _quantity = quantity;
       
        if (price <= MIN_PRICE)
            _price = DEFAULT_PRICE;
        else _price = price;
    }
    
    /**
    * copy constractor
    * @param other the food item to be copied
    */
    public FoodItem (FoodItem other) {
        _name = other._name;
        _catalogueNumber = other._catalogueNumber;
        _quantity = other._quantity;
        _productionDate = new Date (other._productionDate);
        _expiryDate = new Date(other._expiryDate);
        _minTemperature = other._minTemperature;
        _maxTemperature = other._maxTemperature;
        _price = other._price;
    }
    
    //accessors:
    /**
     * gets the catalogue number
     * @return the catalogue number
     */
    public long getCatalogueNumber() {
        return _catalogueNumber;
    }
    
    /**
     * gets the expiry date
     * @return the expiry date
     */
    public Date getExpiryDate() {
        return new Date(_expiryDate);
    }
    
    /**
     * gets the maximum storage temperature
     * @return the maximum storage temperature
     */
    public int getMaxTemperature() {
        return _maxTemperature;
    }
    
    /**
     * gets the minimum storage temperature
     * @return the minimum storage temperature
     */
    public int getMinTemperature() {
        return _minTemperature;
    }
    
    /**
     * gets the name
     * @return the name
     */
    public String getName() {
        return new String(_name);
    }
    
    /**
     * gets the unit price
     * @return the unit price
     */
    public int getPrice() {
        return _price;
    }
    
    /**
     * gets the production date
     * @return the production date
     */
    public Date getProductionDate() {
        return new Date(_productionDate);
    }
    
    /**
     * gets the quantity
     * @return the quantity
     */
    public int getQuantity() {
        return _quantity;
    }
    
    //mutators:
    /**
     * set the price (only if positive)
     * @param n the price value to be set
     */
    public void setPrice(int p) {
        if (p > MIN_PRICE)
            _price = p;
        else return;
    }
    
    /**
     * set the expiry date (only if not before production date )
     * @param d expiry date value to be set
     */
    public void setExpiryDate(Date d) {
        if ((d.equals(_productionDate)) ||
           (d.after(_productionDate)))
            _expiryDate = new Date (d);
        else return;
    }
    
    /**
     * set the production date (only if not after expiry date)
     * @param d production date
     */
    public void setProductionDate(Date d) {
        if ((d.before(_expiryDate)) ||
           (d.equals(_expiryDate)))
            _productionDate = new Date (d);
        else return;
    }
    
    /**
     * set the quantity (only if not negative)
     * @param n the quantity value to be set
     */
    public void setQuantity(int q) {
        if (q >= MIN_QUANTITY)
            _quantity = q;
        else return;
    }
    
    /**
     * returns a String that represents this food item
     * @return String that represents this food item
     */
    public String toString() {
        return "FoodItem: " + _name + "\tCatalogueNumber: " + _catalogueNumber
        + "\tProductionDate: " + _productionDate + "\tExpiryDate: " + _expiryDate
        + "\tQuantity: " + _quantity;
    }
    
    /**
     * checks if 2 food items are the same (excluding the quantity values)
     * @param other the food item to compare this food item to
     * @return true if the food items are the same
     */
    public boolean equals(FoodItem other) {
        if ((_name.equals(other._name) == true) &&
           (_catalogueNumber == other._catalogueNumber) &&
           (_productionDate.equals(other._productionDate) == true) &&
           (_expiryDate.equals(other._expiryDate) == true) &&
           (_minTemperature == other._minTemperature) &&
           (_maxTemperature == other._maxTemperature) &&
           (_price == other._price))
            return true;
        else return false;
    }
    
    /**
     * check if this food item is fresh on the date d
     * @param d date to check
     * @return true if this food item is fresh on the date d
     */
    public boolean isFresh (Date d) {
        if ((d.after(_productionDate)||
            d.equals(_productionDate)) &&
            (d.before(_expiryDate) ||
            d.equals(_expiryDate)))
            return true;
        else return false;
    }
    
    /**
     * check if this food item is older than other food item
     * @param other food item to compare this food item to
     * @return true if this food item is older than other date
     */
    public boolean olderFoodItem(FoodItem other) {
        if(_productionDate.before(other._productionDate))
            return true;
        else return false;
    }

    /**
     * Matala 12 Question 2 - Using a class returns the number of units of products that can be purchased for a given amount
     * @param amount to purchase
     * @return the number of units can be purchased
     */
    public int howManyItems(int amount) {
        if (amount > MIN_AMOUNT) {
            int items = (amount/_price);
            if (items <= _quantity)
                return items;
            else return _quantity;
        }
        else return NO_ITEMS;
    }
    
    /**
     * checks if this food item is cheaper than other food item
     * @param other food item to compare this food item to
     * @return true if this food item is cheaper than other food item
     */
    public boolean isCheaper(FoodItem other) {
        if (_price < other._price)
            return true;
        else return false;
    }
}
