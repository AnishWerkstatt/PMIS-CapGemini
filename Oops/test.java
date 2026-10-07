package Oops;

class BankAccount{
    String AccountHolder;
    double Balance;

    BankAccount(String AccountHolder, double Balance){
        this.AccountHolder = AccountHolder;
        this.Balance = Balance;
    }



    void deposit(double amount){
        Balance += amount;
        System.out.println("Deposited: "+ amount);
        System.out.println("balance: "+ Balance);


    }
    void withdraw(double amount){
        if(amount<=Balance){
            Balance -= amount;
            System.out.println("Withdrawal amount: " + amount);
            System.out.println("Balance: "+ Balance);
        }
        else{
            System.out.println("Current Balance: "+Balance);
            System.out.println("Insufficient Balance.");
        }


    }
    void displaySummary(){
        System.out.println("Name: " + AccountHolder);
        System.out.println("Balance: "+ Balance);

    }

}

public class test{
    public static void main(String[] args){
        BankAccount b1 = new BankAccount("Anish Korade",42030 );

        b1.displaySummary();
        b1.deposit(10000);
        b1.withdraw(1000);
        

    }
}