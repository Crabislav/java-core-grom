package gromcode.main.lesson8.accounts;

public class Account {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Account(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void depositMoney(int amount) {
        moneyAmount += amount;
    }

    //overloading
    void depositMoney() {
        moneyAmount += 1000;
        System.out.println("Deposit was successful");
    }

    void changeOwnerName(String newOwnerName) {
        ownerName = newOwnerName;
    }


}
