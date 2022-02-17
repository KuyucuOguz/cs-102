import java.util.Scanner;
import java.util.ArrayList;
public class CompanyTesterThree {
    public static void main(String[]args)throws Exception{
        //constants

        //variables
        Company company;
        String response;
        ArrayList <Customer> customers;
        ArrayList <Employee> employees;
        ArrayList <Item> items;
        //program code
        company = new Company(0, 0);
        customers = new ArrayList<Customer>();
        items = new ArrayList<Item>();
        employees = new ArrayList<Employee>();
        Scanner scan = new Scanner(System.in);
        do {  
            System.out.println("What do you want to do?");
            System.out.println("if you want to send item, type send, false means your item couldn't ben send ");
            System.out.println("if you want to see company type company");
            System.out.println("if you want to employ 1 more person, type employ");
            System.out.println("if you want to deliver, type deliver");
            System.out.println("if you want to fire employee, type fire");
            System.out.println("if you want to add a customer, type addcustomer");
            System.out.println("if you want to add an item type additem");
            response = scan.next();
            //send items
            if(response.equals("send")){
                System.out.println("Please type sender's number, item's number and receiver's number with sequence ");
                System.out.println(customers.get(scan.nextInt()).
                sendItem(company, items.get(scan.nextInt()), customers.get(scan.nextInt())));
            }
            //show company
            else if(response.equals("company")){
                System.out.println(company);
            }
            //employ 1 more person
            else if(response.equals("employ")){
                System.out.println("Please type employee's number and name");
                company.addEmployee(new Employee(scan.nextInt(), scan.next()));
            }
            //deliver packages and show them
            else if(response.equals("deliver"))
                company.deliverPackages();
            //fire an employee
            else if(response.equals("fire")){
                System.out.println("Please write which employee you want to fire");
                company.terminateContract(scan.nextInt());
            }
            //add a customer
            else if(response.equals("addcustomer")){
                System.out.println("Please write customer's name x coordinate and y coordinate");
                customers.add(new Customer(scan.next(), scan.nextInt(), scan.nextInt()));
            }
            //add an item
            else if(response.equals("additem")){
                System.out.println("Please type item's weight and content");
                items.add(new Item(scan.nextDouble(), scan.next()));
            }
        } while (!response.equals("exit"));

    }
}

