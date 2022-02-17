public class Mail extends Delivery{
    //properties
    String content;
    //constructors
    /**
     * Creates a mail
     * @param content is ccontent of the mail
     * @param sender is customer who is sender of the mail
     * @param receiver is receiver who is receiver of the mail
     * @param packageNo is package number
     */
    public Mail(String content, Customer sender, Customer receiver, int packageNo){
        super(sender, receiver, packageNo);
        this.content = content;
    }
    /**gets weight of mail
     * @return 0.1
     */
    public double getWeight(){
        return 0.1;
    }
    @Override
    /**
     * Transform mail to string
     * @return string representation off  mail
     */
    public String toString(){
        return "mail " + content + "  " + sender + " to " + receiver + " no: " + packageNo + " ";
    }
}