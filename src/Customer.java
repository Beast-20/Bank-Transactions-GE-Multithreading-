class Customer extends Thread {
    private int customerID;
    private Bank bank;

    public Customer(int customerID, Bank bank){
        this.customerID = customerID;
        this.bank = bank;
    }

    @Override
    public void run(){
       System.out.println("Operations for customer "+customerID+" started");
       new DepositOperation(bank,customerID,500).start();
       try{
       Thread.sleep(1000);
       }
       catch(InterruptedException e){
        e.printStackTrace();
       }

       new WithdrawOperation(bank, customerID, 200).start();
       new WithdrawOperation(bank, customerID, 700).start();

    try{
        Thread.sleep(2000);
    }
    catch (InterruptedException exception){
        exception.printStackTrace();
    }

       System.out.println("Operations for customer "+customerID+" finished");
   }
}
