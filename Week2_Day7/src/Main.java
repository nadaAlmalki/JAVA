public class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        System.out.println("\n");

       Account account = new Account();
        account.setBalance(3500);
        account.setName("AlRajhi");
        account.setAccount_ID("444");
        System.out.println("The current Balnce for the first is:  "+account.getBalance());
        System.out.println( "The new Balance is (+ 400): "+account.credit(400));
        System.out.println( "The new Balance after debit (-600) : "+account.debit(600));
        System.out.println(account.toString());

        System.out.println("\n");
        Account account2 = new Account();

        int transfer =account.debit(2700) -3300;
        account.transferTo(transfer, account2);
         System.out.print(" Balance for the second Account after transfer:( 600 ) "+  account2.getBalance());
        System.out.println("\n");


        Employee emp = new Employee();
        emp.setEmp_ID("456");
        emp.setEmp_name("NADA");
        emp.setSalary(9500);
        System.out.println(emp.toString());
        System.out.println("Salary after promotion: "+emp.raisedSalary(.50));
        System.out.println("Annoual Salary : "+ emp.getAnnoualSalary());


    }
}