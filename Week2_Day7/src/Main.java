public class Main {
    public static void main(String[] args) {
     Account account = new Account("4444", "AlRajhi",3500);
     //  int transfer =account.debit(2700) -3300;
     //account2.transferTo(600, account);

     System.out.println("\n");
        System.out.println("The current Balnce for the first is:  "+account.getBalance());
        System.out.println( "The new Balance is (+ 400): "+account.credit(400, account)+" "+account.getBalance());
        System.out.println( "The new Balance after debit (-600) : "+account.debit(600, account)+"   " +account.getBalance());
        System.out.println(account.toString());

        System.out.println("\n");
        Account account2 = new Account("555", "AlRajhi",200);
        account.transferTo(600, account2);

        System.out.print(" Balance for the second Account after transfer:( 600 ) "+  account2.getBalance());
        System.out.println("\n");
        System.out.println("The sceond Account Details: "+account2.toString());


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