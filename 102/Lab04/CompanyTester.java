public class CompanyTester{
    public static void main(String[]args)throws Exception{
        //constants

        //variables
        Company company;
        Item item1;
        Item item2;
        Item item3;
        Item item4;
        Item item5;
        Item item6;

        Customer customer1;
        Customer customer2;
        Customer customer3;
        Employee employee1;
        Employee employee2;
        //program code
        item1 = new Item(0.1, "massage");
        item2 = new Item(0.05,"mail");
        item3 = new Item(2, "computer");
        item4 = new Item(15, "table");
        item5 = new Item(0.5, "medicine");
        item6 = new Item(0.2, "knife");

        customer1 = new Customer("Ahmet", 1, 0);
        customer2 = new Customer("Ayşe", 0, 5);
        customer3 = new Customer("Fatma", 6, 7);

        employee1 = new Employee(1, "Rıfat");
        employee2 = new Employee(2,"Barış");
        
        company = new Company(0, 0);
        company.addEmployee(employee1);

        //1.send items between customers
        System.out.println(customer1.sendItem(company, item1, customer2));
        System.out.println(customer2.sendItem(company, item2, customer3));
        System.out.println(customer3.sendItem(company, item3, customer1));
        System.out.println(customer1.sendItem(company, item4, customer3));
        System.out.println(customer2.sendItem(company, item5, customer1));

        //2.this item cannot be send because there is not available employee
        System.out.println(customer3.sendItem(company,item6,customer2));
        System.out.println();

        //3.print employee1 and company
        System.out.println(employee1);
        System.out.println(company);
        //4.employ 1 more person

        company.addEmployee(employee2);
        //5.this item an be send this time beccause employee2 is available

        System.out.println(customer3.sendItem(company,item6,customer2));
        System.out.println();
        //6.print company again, there must be 2 employee and 6 packages

        System.out.println(company);
        //7.deliver packages and print company again, there shouldn't be packages

        company.deliverPackages();
        System.out.println();
        //8.terminate contract of one of the employees and print company again

        company.terminateContract(2);
        System.out.println(company);
        System.out.println(customer1.getItem());
    }
}