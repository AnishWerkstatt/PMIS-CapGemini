// Bank Account management system
package Oops;
class BankAccount{

String accountHolder;
double balance;
BankAccount(String accountHolder, double balance){
    this.accountHolder = accountHolder;
    this.balance = balance;


}
// Deposit
void deposit(double amount){
    balance += amount;
    System.out.println("Deposited: "+ amount);
    System.out.println("New Balance: "+ balance );
}
void withdraw(double amount){
    if(amount <= balance){
        balance -= amount;
        System.out.println("Withdawal: "+ amount);
        System.out.println("Updated Balance: " + balance);
    }
    else{
        System.out.println("Insufficient Balance");
    }
}
//Display account
void displayAccount() {
    System.out.println("Account Holder Name: "+ accountHolder);
    System.out.println("Current Balance: " + balance +"\n");
}
}



public class test{
    public static void main(String[] args){
        // Creating an object
        BankAccount b1 = new BankAccount("Diksha", 100000);
        BankAccount b2 = new BankAccount("Purva",150000 );

        
    
        b2.withdraw(2000);


    }
}

