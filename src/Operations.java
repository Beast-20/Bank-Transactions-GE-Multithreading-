class DepositOperation extends Thread {
    private Bank bank;
    private int customerID;
    private int amount;

    public DepositOperation(Bank bank, int customerID, int amount) {
        this.bank = bank;
        this.customerID = customerID;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.deposit(customerID, amount);
    }
}

class WithdrawOperation extends Thread {
    private Bank bank;
    private int customerID;
    private int amount;

    public WithdrawOperation(Bank bank, int customerID, int amount) {
        this.bank = bank;
        this.customerID = customerID;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.withdrawl(customerID, amount);
    }
}

class GetBalanceOperation extends Thread {
    private Bank bank;
    private int customerID;

    public GetBalanceOperation(Bank bank, int customerID) {
        this.bank = bank;
        this.customerID = customerID;
    }

    @Override
    public void run() {
        System.out.println("Balance of Account " + customerID + ": " + bank.get_balance(customerID));
    }
}