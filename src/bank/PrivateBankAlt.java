package bank;

import bank.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivateBankAlt implements Bank{
    private String name;
    double incomingInterest;
    double outgoingInterest;
    Map<String,List <Transaction>> accountToTransactions = new HashMap<String,List <Transaction>>();

    //Copy constructor
    public PrivateBankAlt(PrivateBankAlt bank){
        this.name=bank.name;
        this.incomingInterest=bank.incomingInterest;
        this.outgoingInterest=bank.outgoingInterest;
    }

    //Constructor
    public PrivateBankAlt(String name, double incomingInterest, double outgoingInterest){
        this.name=name;
        this.incomingInterest=incomingInterest;
        this.outgoingInterest=outgoingInterest;
    }
    public String getName(){
        return name;
    }
    public double getIncomingInterest(){
        return incomingInterest;
    }
    public double getOutgoingInterest(){
        return outgoingInterest;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setIncomingInterest(double incomingInterest){
        if(incomingInterest < 0 || incomingInterest > 1){
            throw new IllegalArgumentException("Incoming interest must be between 0 and 1");
        }else{
            this.incomingInterest=incomingInterest;
        }
    }
    public void setOutgoingInterest(double outgoingInterest){
        if(outgoingInterest < 0 || outgoingInterest > 1){
            throw new IllegalArgumentException("Outgoing interest must be between 0 and 1");
        }else{
            this.outgoingInterest=outgoingInterest;
        }
    }

    public void print(){
        System.out.println(toString());
        for(String account : accountToTransactions.keySet()){
            System.out.println("Account: " + account);
            for(Transaction transaction : accountToTransactions.get(account)){
                System.out.println(transaction.toString());
            }
        }
    }

    @Override
    public String toString(){
        return "PRIVATEBANK ALTERNATIV, Name: " + name + " Incoming interest: " + incomingInterest + " Outgoing interest: " + outgoingInterest;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof PrivateBankAlt)){
            return false;
        }
        PrivateBankAlt bank = (PrivateBankAlt) o;
        return name.equals(bank.name)
                && incomingInterest == bank.incomingInterest
                && outgoingInterest == bank.outgoingInterest
                && accountToTransactions.equals(bank.accountToTransactions);
    }

    /**
     * Adds an account to the bank.
     *
     * @param account the account to be added
     * @throws AccountAlreadyExistsException if the account already exists
     */
    @Override
    public void createAccount(String account) throws AccountAlreadyExistsException{
        if(accountToTransactions.containsKey(account)){
            throw new AccountAlreadyExistsException();
        }else{
            accountToTransactions.put(account, new ArrayList<Transaction>());
        }
    }

    /**
     * Adds an account (with specified transactions) to the bank.
     * Important: duplicate transactions must not be added to the account!
     *
     * @param account      the account to be added
     * @param transactions a list of already existing transactions which should be added to the newly created account
     * @throws AccountAlreadyExistsException    if the account already exists
     * @throws TransactionAlreadyExistException if the transaction already exists
     * @throws TransactionAttributeException    if the validation check for certain attributes fail
     */
    @Override
    public void createAccount(String account, List<Transaction> transactions)
            throws AccountAlreadyExistsException, TransactionAlreadyExistException, TransactionAttributeException{
        if(accountToTransactions.containsKey(account)){
            throw new AccountAlreadyExistsException();
        }else{
            for(Transaction transaction : transactions){
                if(transaction.getAmount() < 0) {
                    throw new TransactionAttributeException();
                }
            }
            accountToTransactions.put(account, transactions);
        }
    }
    /**
     * Adds a transaction to an already existing account.
     *
     * @param account     the account to which the transaction is added
     * @param transaction the transaction which should be added to the specified account
     * @throws TransactionAlreadyExistException if the transaction already exists
     * @throws AccountDoesNotExistException     if the specified account does not exist
     * @throws TransactionAttributeException    if the validation check for certain attributes fail
     */
    @Override
    public void addTransaction(String account, Transaction transaction)
            throws TransactionAlreadyExistException, AccountDoesNotExistException, TransactionAttributeException{
        if(!accountToTransactions.containsKey(account)){
            throw new AccountDoesNotExistException();
        }else if(accountToTransactions.get(account).contains(transaction)){
            throw new TransactionAlreadyExistException();
        }else if(transaction.getAmount() < 0){
            throw new TransactionAttributeException();
        }else{
            if(transaction instanceof Payment){
                ((Payment)transaction).setOutgoingInterest(outgoingInterest);
                ((Payment)transaction).setIncomingInterest(incomingInterest);
            }
            accountToTransactions.get(account).add(transaction);
        }
    }
    /**
     * Removes a transaction from an account. If the transaction does not exist, an exception is
     * thrown.
     *
     * @param account     the account from which the transaction is removed
     * @param transaction the transaction which is removed from the specified account
     * @throws AccountDoesNotExistException     if the specified account does not exist
     * @throws TransactionDoesNotExistException if the transaction cannot be found
     */
    @Override
    public void removeTransaction(String account, Transaction transaction)
            throws AccountDoesNotExistException, TransactionDoesNotExistException {
        if (!accountToTransactions.containsKey(account)) {
            throw new AccountDoesNotExistException();
        } else if (!accountToTransactions.get(account).contains(transaction)) {
            throw new TransactionDoesNotExistException();
        } else {
            accountToTransactions.get(account).remove(transaction);
        }
    }
    /**
     * Checks whether the specified transaction for a given account exists.
     *
     * @param account     the account from which the transaction is checked
     * @param transaction the transaction to search/look for
     */
    @Override
    public boolean containsTransaction(String account, Transaction transaction){
        if(accountToTransactions.containsKey(account)){
            return accountToTransactions.get(account).contains(transaction);
        }else{
            return false;
        }
    }
    /**
     * Calculates and returns the current account balance.
     *
     * @param account the selected account
     * @return the current account balance
     */
    @Override
    public double getAccountBalance(String account){
        double balance = 0;
        for(Transaction transaction : accountToTransactions.get(account)){
            if(transaction instanceof Transfer){
                Transfer transfer = (Transfer) transaction;
                if(transfer.getSender().equals(account)){
                    balance -= transaction.calculate();
                }else{
                    balance += transaction.calculate();
                }
            }else{
                balance += transaction.calculate();
            }
        }
        return balance;
    }
    /**
     * Returns a list of transactions for an account.
     *
     * @param account the selected account
     * @return the list of all transactions for the specified account
     */
    @Override
    public List<Transaction> getTransactions(String account){
        return accountToTransactions.get(account);
    }
    /**
     * Returns a sorted list (-> calculated amounts) of transactions for a specific account. Sorts the list either in ascending or descending order
     * (or empty).
     *
     * @param account the selected account
     * @param asc     selects if the transaction list is sorted in ascending or descending order
     * @return the sorted list of all transactions for the specified account
     */
    @Override
    public List<Transaction> getTransactionsSorted(String account, boolean asc) {
        List<Transaction> transactions = accountToTransactions.get(account);
        if(asc){
            transactions.sort((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
        }else{
            transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));
        }
        return transactions;
    }
    /**
     * Returns a list of either positive or negative transactions (-> calculated amounts).
     *
     * @param account  the selected account
     * @param positive selects if positive or negative transactions are listed
     * @return the list of all transactions by type
     */
    @Override
    public List<Transaction> getTransactionsByType(String account, boolean positive){
        List<Transaction> transactions = new ArrayList<Transaction>();
        for(Transaction transaction : accountToTransactions.get(account)){
            if(positive && transaction.getAmount() > 0){
                transactions.add(transaction);
            }else if(!positive && transaction.getAmount() < 0){
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
