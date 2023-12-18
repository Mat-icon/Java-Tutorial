public class BankAccount {
    private double balance;
    private String name;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount){
        if(amount <= balance) {
            balance -= amount;
        } else{
            System.err.println("Withdrawal unsucessful");
        }
    }

    public void transfer(double amount, BankAccount acc){
        if (this.balance < amount) {
            System.err.println("transfer fails");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println( this.name +" have Sucessfully Transferred "+ amount );
            System.out.println( acc.name +" have Sucessfully Recieved "+ amount );
            System.out.println("Transfer Sucessful Remaining balance is " + this.balance);
            System.out.println("Transfer Recieved Current balance is " + acc.balance);
        }
    }

    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount sender = new BankAccount("John Doe", 2000.0);
        BankAccount reciever = new BankAccount("mia", 5000);

        // Displaying initial balance and name
        System.out.println("Initial balance: " + sender.getBalance());
        System.out.println("Account holder name: " + sender.getName());
        System.out.println("Initial balance: " + reciever.getBalance());
        System.out.println("Account holder name: " + reciever.getName());


        // Depositing funds
        sender.deposit(500.0);
        sender.transfer(30, reciever);


        //withdrawing funds
        sender.withdraw(230);


        // Displaying new balance after deposit
        System.out.println("Balance after deposit: " + sender.getBalance());
          System.out.println("Balance after deposit: " + reciever.getBalance());
    }
}
