public class Customer extends Person{
    //properties
    Item currentItem;
    //constructors
    /**Creates customer
     * @param name is name of customer
     * @param x is x coordinate of customer
     * @param y is y coordinate of customer
     */
    Customer(String name, int x, int y){
        super(name, x, y);
        currentItem = null;
    }
    //methods
    /**
     * Changes item
     * @param newItem is item which will be setted
     */
    public void setItem(Item newItem){
        currentItem = newItem;
    }
    /**
     * Gets the item of customer
     * @return currentItem
     */
    public Item getItem(){
        return currentItem;
    }
    /**
     * Sends an item to other customer
     * @param company is delivery compant
     * @param item is item which will be send
     * @param receiver is another customer who will recceive the item
     * @return true if company has employee, otherwise false
     */
    public boolean sendItem(Company company, Item item, Customer receiver){
        if(company.createDeliverable(item, this, receiver)){
            receiver.setItem(item);
            return true;
        }
        return false;
    }
    /**
     * Transform customer to string
     * @return string representation of customer
     */
    public String toString(){
        return "" + getX() + " " + getY() + " " + name ; 
    }   
}