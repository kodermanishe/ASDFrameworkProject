package framework.account;

import framework.account.entry.Entry;
import framework.account.entry.IEntry;
import framework.party.Customer;
import framework.rules.NotifyRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	private int accNumber;
	private List<IEntry> entries;
	private double interest = 0.05;
	protected Customer party;

	public Account(Customer party, int accNumber) {
		this.accNumber = accNumber;
		this.party = party;
		this.entries = new ArrayList<>();
	}

	@Override
    public double getCurrentBalance() {
		return entries.stream().mapToDouble(e -> e.amount()).sum();
    }

	@Override
	public void addEntry(IEntry entry) {
		entries.add(entry);
		notifyCustomer();
	}

	public void notifyCustomer() {
		if (new NotifyRule().test(this)) {
			party.SendEmailToCustomer();
		}
	}

	@Override
	public void addInterest() {
		double rate = getCurrentBalance() * this.interest;
		if (rate > 0) {
			this.entries.add(new Entry(rate, LocalDate.now(), "Interest Added"));
		}
	}

	@Override
	public int getAccNumber() {
		return this.accNumber;
	}

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Account)) {
            return false;
        }

        Account account = (Account) object;
        return this.accNumber == account.getAccNumber();
	}
}
