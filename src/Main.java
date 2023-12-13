public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();  //Creating new Bank

        //Adding customers to that bank
        int Himanshu = bank.add_customer(2000);  //This return customer id alloted by bank
        int Omkar = bank.add_customer(1000);  //This return customer id alloted by bank
        

        Customer c1 = new Customer(Himanshu, bank);
        Customer c2 = new Customer(Omkar, bank);
        

        //Both customer start their operations
        c1.start();
        c2.start();
    }
}
