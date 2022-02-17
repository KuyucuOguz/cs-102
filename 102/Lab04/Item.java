/**
 * represents an item
 * @author Oguz Kuyucu
 * @version 09.03.2021
 */
public class Item {
    //properties
    double weight;
    String content;

    //constructors
    /**
     * Creates an item
     * @param weight is the weight of an item
     * @param content is content of an item
     */
    Item(double weight, String content){
        this.weight = weight;
        this.content = content;
    }
    //methods

    /**
     * gets weight of an item
     * @return weight
     */
    public double getWeight(){
        return weight;
    }
    /**
     * gets content of an item
     * @return content
     */
    public String getContent(){
        return content;
    }
    /**
     * Converts an item to string
     * @return items weight and content
     */
    public String toString(){
        return " content: " + content + " weight: " + getWeight();
    }
}