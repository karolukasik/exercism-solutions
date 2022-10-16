
public class BankAccount {
    double balance;
    boolean isOpen;

    public BankAccount() {
        this.balance = 0;
        this.isOpen = false;
    }

    public synchronized void open() {
        this.isOpen = true;
        this.balance = 0;
    }

    public synchronized double getBalance() throws BankAccountActionInvalidException {
        checkIfAccountIsOpen();
        return this.balance;

    }

    public synchronized void deposit(double value) throws BankAccountActionInvalidException {
        checkIfAccountIsOpen();
        checkIfValueIsNegative(value);

        this.balance += value;
    }

    public synchronized void withdraw(double value) throws BankAccountActionInvalidException {
        checkIfAccountIsOpen();
        checkIfValueIsNegative(value);
        checkIfAccountIsEmpty();
        checkIfValueIsBiggerThanBalance(value);
        this.balance -= value;

    }

    private void checkIfValueIsBiggerThanBalance(double value) throws BankAccountActionInvalidException {
        if (this.balance < value) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    private void checkIfAccountIsEmpty() throws BankAccountActionInvalidException {
        if (this.balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
    }

    private void checkIfValueIsNegative(double value) throws BankAccountActionInvalidException {
        if (value < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

    private void checkIfAccountIsOpen() throws BankAccountActionInvalidException {
        if (!this.isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    public synchronized void close() {
        this.isOpen = false;
    }

}