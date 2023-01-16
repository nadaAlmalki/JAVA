public class Account {
    String Account_ID;
    String name;
    static int balance;

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

    public void setAccount_ID(String account_ID) {
        Account_ID = account_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static int credit(int amount) {

        balance = balance + amount;
        return balance;
    }

    public static int debit(int amount) {

        if (balance > amount) {
            balance = balance - amount;
            return balance;
        } else {
            return 0;
        }
    }

    public void transferTo(int amount, Account secondAccount) {
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

