public class Package extends Delivery{
    //properties
    Item packedItem;
    //constructors
    public Package(Item content, Customer sender, Customer receiver, int packageNo){
        super(sender, receiver, packageNo);
        packedItem = content;
    }
    //methods
    /**
     * Gets weight of a package
     * @return weight of a package
     */
    public double getWeight(){
        return packedItem.getWeight();
    }
    /**
     * Transforms package to String which includes item's name, sender, receiver and package number
     * @return string representation of package
     */
    public String toString(){
        return "package " + packedItem + " " + sender + " to " + receiver + " no: " + packageNo + " ";
    }
}