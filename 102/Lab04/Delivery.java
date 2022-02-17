
/**Represents a delivery
 * @author Oguz Kuyucu
 * @version 09.03.2021
 */
public abstract class Delivery{
    //properties
    int packageNo;
    Customer sender;
    Customer receiver;
    //constructors
    /**
     * Creates a delivery
     * @param sender is customer who sends the delivery
     * @param receiver is customer who receive the delivery
     * @param packageNo is number of package
     */
    public Delivery(Customer sender, Customer receiver, int packageNo){
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }
    //methods
    /**
     * gets weight of delivery
     */
    public abstract double getWeight();
    /**
     * gets the sender of the delivery
     * @return sender
     */
    public Customer getSender(){
        return sender;
    }
    /**
     * gets the receiver of the delivery
     * @return receiver
     */
    public Customer getReceiver(){
        return receiver;
    }
    /**
     * gets package number
     * @return package number
     */
    public int getpackageNo(){
        return packageNo;
    }
}