public class Employee extends Person{
    //properties
    final int MAX_JOBS = 5;
    int currentJobs;
    Delivery deliveries[];
    double salary;
    int employeeNo;
    boolean available;
    //constructors
    public Employee(int employeeNo, String name){
        super(name);
        this.employeeNo = employeeNo;
        currentJobs = 0;
        salary = 1000;
        available = getAvailability();
        deliveries = new Delivery[MAX_JOBS]; 
    }
    //methods
    /**
     * Changes employee's salary
     * @param newSalary is new salary which will be adjusted
     */
    public void adjustSalary(int newSalary){
        salary = newSalary;
    }
    /**
     * Gets the availibility of the employee by checking how many work he has
     * @return true if he has less than 5 jobs, otherwise false
     */
    public boolean getAvailability(){
        if(currentJobs < MAX_JOBS ){
            available = true;
            return true;
        }
        available = false;
        return false;
    }
    /**
     * Adds job to employee
     * @param sendItem is item which will ben sended
     * @param sender is sender of delivery
     * @param receiver is person who will receive delivery
     * @param packageNo is packaage no of delivery
     */
    public void addJob(Item sendItem, Customer sender, Customer receiver, int packageNo){
        if(sendItem.getWeight() <= 0.1){
            deliveries[currentJobs] = new Mail(sendItem.getContent() + sendItem, sender, receiver, packageNo);
        }
        else{
            deliveries[currentJobs] = new Package(sendItem, sender, receiver, packageNo);
        }
        currentJobs = currentJobs + 1;
    }
    /**
     * Delivers packages of employee
     */
    public void deliverPackages(){
        for(int deliverySoFar = 0; deliverySoFar < currentJobs; deliverySoFar++ ){
            System.out.print(deliveries[deliverySoFar]);
            System.out.println();
            deliveries[deliverySoFar] = null;
        }
        currentJobs = 0;
    }
    /**
     * Transform employee to String which includes employee's salary, current jobs numbeer,
     * availibility number, name and his packages.
     * @return string representation of employee
     */
    public String toString(){
        String employee;
        int deliverySoFar;
        employee = "Employee " + getName() + "\n salary: " + salary + "\n current jobs:" 
        + currentJobs + " \n availabiliy :" + available + " \n employee no :" + employeeNo + " \n deliveries are: \n";
        for(deliverySoFar = 0; deliverySoFar < currentJobs; deliverySoFar++){
            employee = employee + deliveries[deliverySoFar] +"\n ";
        }
        return employee;
    }

}