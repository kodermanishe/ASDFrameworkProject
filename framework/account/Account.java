package framework.account;

import framework.account.entry.Entry;
import framework.account.entry.IEntry;
import framework.party.AbstractCustomer;
import framework.party.ICompany;
import framework.rules.NotifyRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	
	private String accountNumber;
	private List<IEntry> entries;
	private double interestRate = 0.05;
	protected AbstractCustomer party;

	public Account(AbstractCustomer party, String accountNumber) {
		this.accountNumber = accountNumber;
		this.party = party;
		
		entries = new ArrayList<>();
	}
	
    public double getBalance() {
        return entries.stream().mapToDouble(e->e.getAmount()).sum();
    }

    public double getInterestRate() {
		return this.interestRate;
	}

    public List<IEntry> getEntries(){
    	return entries;
    }

    public void depositMoney(double money) {
    	entries.add(new Entry(money, LocalDate.now(), "Deposit Money"));

    	sendNotification();
    }

	public void withdrawMoney(double money) {
		entries.add(new Entry(-money, LocalDate.now(), "Withdraw Money"));

		sendNotification();
	}

	public void sendNotification() {
		if(new NotifyRule().chech(this)) party.notifyOwner();
	}

    public ICompany getOwner() {
        return party;
    }
    
    public void report() {
    	System.out.println(entries);
    }
    
    public void addInterest() {
    	double rate = getBalance() * getInterestRate();
    	if (rate > 0) this.getEntries().add(new Entry(rate, LocalDate.now(), "Interest Added"));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return this.accountNumber.equals(account.getAccountNumber());
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
