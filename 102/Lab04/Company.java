import java.util.ArrayList;
public class Company implements Locatable{
    //properties
    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees;
    ArrayList<Customer> customers;
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;
    //constructors
    Company(int x, int y){
        posX = x;
        posY = y;
        employeeNo = 0;
        packageNo = 0;
        customers = new ArrayList<Customer>();
        employees = new Employee[EMPLOYEE_CAPACITY];
    }
    //methods
    /**
     * Adds an employee to company
     * @param candidate is employee which will be added
     * @return true if employee capacity is not loaded, otherwise false
     */
    public boolean addEmployee(Employee candidate){
        if(employeeNo < EMPLOYEE_CAPACITY){
            employees[employeeNo] = candidate;
            employeeNo = employeeNo + 1;
            return true;
        }
        return false;
    }
    /**
     * Adds customer to company
     * @param customer is customer which will be added
     */
    public void addCustomer (Customer customer){
        customers.add(customer);
    }
    @Override
    /**
     * Gets x location of company
     * @return x location
     */
    public int getX() {
        return posX;
    }

    @Override
    /**
     *@return y location
     */
    public int getY() {
        return posY;
    }
    /**
     * Changes companies location
     * @param x is new x location of company
     * @param y is new y location of company
     */
    @Override
    public void setPos(int x, int y) {
        posX = x;
        posY = y;

    }
    /**
     * Terminates contract of an employee with given index
     * @param employeeIndex is employee's index whose contract will be over
     * @return true if there is employee with given index, otherwise false
     */
    public boolean terminateContract(int employeeIndex){
        if(employees[employeeIndex - 1] != null){
            employees[employeeIndex - 1] = null;
            while(employeeIndex <= employeeNo){
                employees[employeeIndex - 1] = employees[employeeIndex];
                employeeIndex = employeeIndex + 1;
            }
            employeeNo = employeeNo - 1;
            return true;
        }
        return false;
    }
    /**
     * Creates a delivery
     * @param sendItem is item which will be sent
     * @param sender is sender of an item 
     * @param receiver is receiver of an item
     * @return true if there is an available employee, otherwise false
     */
    public boolean createDeliverable(Item sendItem, Customer sender, Customer receiver){
        if(!customers.contains(sender)){
            addCustomer(sender);
        }
        if(!customers.contains(receiver)){
            addCustomer(receiver);
        }
        for(int employeeSoFar = 0; employeeSoFar < employeeNo; employeeSoFar++ ){
            if(employees[employeeSoFar].getAvailability()){
                employees[employeeSoFar].addJob(sendItem, sender, receiver, packageNo);
                packageNo = packageNo + 1;
                receiver.setItem(sendItem);
                return true;
            }
        }
        return false;
    }
    /**
     * Delivers pacckages
     */
    public void deliverPackages(){
        for(int employeeSoFar = 0; employeeSoFar < employeeNo; employeeSoFar++){
            employees[employeeSoFar].deliverPackages();
        }
    }
    /**Transform a company to string which includes employees, packages and customers
     * @return String representation of company
     */
    public String toString(){
        String company;
        company = "company  ";
        company = company + "employees are : \n ";
        for(int employeeSoFar = 0; employeeSoFar < employeeNo; employeeSoFar++){
            company = company + employees[employeeSoFar].toString();
        }
        company = company + " \n customers are: ";
        for(Customer c: customers){
            company = company + "\n" + c;
        }
        return company;
    }
}