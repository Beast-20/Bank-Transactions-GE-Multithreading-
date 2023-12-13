import java.util.HashMap;

public class Bank{
    HashMap<Integer, Integer> accounts;
    int account_track = 0;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public int add_customer(int balance){
        account_track++;
        accounts.put(account_track,balance);
        System.out.println("Customer added successfully with customerID "+account_track+" and initial balance of "+balance);
        return account_track;
    }
    
    //Synchronized methods to avoid data inconsistency
    
    synchronized public void deposit(int customerID, int amount){
        if(!accounts.containsKey(customerID)){
            System.out.println("Sorry no such customer exists!");
            return;
        }
        int initial_balance = accounts.get(customerID);
        accounts.put(customerID, initial_balance+amount);
        System.out.println("Amount "+amount+" deposited successfully of customerID:- "+customerID+" updated balance is "+get_balance(customerID));

    }

    synchronized public void withdrawl(int customerID, int amount){
        if(!accounts.containsKey(customerID)){
            System.out.println("Sorry no such customer exists");
            return;
        }
        if(accounts.get(customerID)<amount){
            System.out.println("Operation cannot be performed due to insufficient balance");
            return;
        }
        int initial_balance = accounts.get(customerID);
        accounts.put(customerID, initial_balance-amount);
        System.out.println("Amount "+amount+" withdrawl done successfully of customerID:- "+customerID+" updated balance is "+get_balance(customerID));
    }

    synchronized public int get_balance(int customerID){
        if(!accounts.containsKey(customerID)){
            System.out.println("Sorry no such customer exists");
            return -1;
        }
        return accounts.get(customerID);
    }
}