public class Account {
    String Account_ID;
    String name;

     int balance =0 ;

    public Account() {
    }

    public Account(String Account_ID, String name) {
        this.Account_ID = Account_ID;
        this.name = name;
    }

    public Account(String Account_ID, String name, int balance) {
        this.Account_ID = Account_ID;
        this.name = name;
        this.balance = balance;
    }

    public String getAccount_ID() {
        return Account_ID;
    }


    public String getName() {
        return name;
    }


    public int getBalance() {
        return balance;
    }


    public static int credit(int amount, Account account) {

       // int balance =0;
        account.balance= account.balance + amount;
        return account.balance;
    }

    public static int debit(int amount, Account account) {

        if (account.balance > amount) {
            account.balance = account.balance - amount;
            return account.balance;
        } else {
            return 0;
        }
    }

    public void transferTo(int amount, Account secondAccount) {
        //int balance = 0;
        if(this.balance >= amount){
            this.balance = this.balance - amount;
            secondAccount.balance = secondAccount.balance + amount;
            System.out.println(" Transfer successfued.");
        } else {
            System.out.println("Transfer UNsuccessful");
        }
    }

   @Override
    public String toString() {
        return "Account Details(" +
                "Account_ID='" + Account_ID + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ')';
    }

}

