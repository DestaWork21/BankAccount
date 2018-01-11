import java.util.Random;

import javax.security.auth.login.AccountNotFoundException;

public class BankAccount {
    public String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int  numAccounts  = 0;
    private static double totalRevenue = 0;
    private static Random rand = new Random();

	public BankAccount(double checking,double savings){
        accountNumber = BankAccount.genAccountNum();
        checkingBalance   = checking;
        savingsBalance    = savings;
        totalRevenue += checkingBalance +savingsBalance;
        numAccounts++;
    }

    public BankAccount(double checking){
        this(checking,0);
    }

    public BankAccount(){
        this(0,0);
    }
    private static String genAccountNum(){
        

        return Integer.toString(rand.nextInt(2000000000)+1);
        

    }

    public void setCheckingBalance(double checking){
        checkingBalance += checking;
    }

    public void setSavingsBalance(double savings){
        savingsBalance += savings;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;

    }
    public void deposit(double checking,double savings){

        this.setCheckingBalance(checking);

        this.setSavingsBalance(savings);

        totalRevenue += checking+savings;

    }
    public void deposit(double checking){

        this.setCheckingBalance(checking);

        totalRevenue += checking;

    }

    public void withdrawal(double checking,double savings){

        if(this.getCheckingBalance() < 1 && this.getSavingsBalance() < 1){
            System.out.println("the balance is in sufficent");
            return;
        }

        this.setCheckingBalance(-checking);

        this.setSavingsBalance(-savings);



        double total = this.getSavingsBalance()+this.getCheckingBalance();

        totalRevenue -= total;

    }

    public void withdrawal(double checking){

        this.withdrawal(checking,0);

    }


    public void show(){

        double total = this.getCheckingBalance()+this.getSavingsBalance();
        System.out.print(this.accountNumber);
        System.out.println(" Total Balance: "+total);
    }
    public static void main(String[] args) {

        BankAccount efrata    = new BankAccount(123456,123456);

        efrata.show();

        BankAccount rael   = new BankAccount(3456,3456);

        rael.show();

        BankAccount adonay  = new BankAccount(23456,23456);

        adonay.show();
        

        BankAccount alem = new BankAccount(1000,3000);

        

        alem.show();

        alem.deposit(300);

        alem.show();

        alem.withdrawal(50);

        alem.show();

        

        

    }

}

