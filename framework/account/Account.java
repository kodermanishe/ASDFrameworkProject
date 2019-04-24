package framework.account;

import framework.account.entry.Entry;
import framework.account.entry.IEntry;
import framework.party.Customer;
import framework.rules.NotifyRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	private String accNumber;
	private List<IEntry> entries;
	protected double interest = 0.05;
	protected Customer customer;
	protected String expDate;

	public Account() {
	}

	public Account(Customer party, String accNumber) {
		this.accNumber = accNumber;
		this.customer = party;
		this.entries = new ArrayList<>();
	}

	@Override
	public double getLastMonthBalance(){
		LocalDate d = LocalDate.now().minusMonths(1);
		LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
		return getEntries().stream().filter(e -> e.getDate().isBefore(end))
				.mapToDouble(e -> e.getAmount()).sum();
	}

	@Override
	public double getTotalCredits(){
		LocalDate d = LocalDate.now();
		LocalDate st = d.withDayOfMonth(1);
		LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
		return getEntries().stream().filter(e -> e.getName().equals("deposit")
				&& e.getDate().isAfter(st) && e.getDate().isBefore(end))
				.mapToDouble(e -> e.getAmount()).sum();
	}

	@Override
	public double getCharges(){
		LocalDate d = LocalDate.now();
		LocalDate st = d.withDayOfMonth(1);
		LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
		return getEntries().stream().filter(e -> e.getName().equals("withdraw")
				&& e.getDate().isAfter(st) && e.getDate().isBefore(end))
				.mapToDouble(e -> e.getAmount()).sum()*(-1);
	}

	@Override
	public double getNewMonthlyBalance(){
		return getLastMonthBalance() - getTotalCredits() + getCharges()
				+ getInterest() * (getLastMonthBalance() - getTotalCredits());
	}

	@Override
	public double getMonthlyAmountDue(){
		return getMP() * getNewMonthlyBalance();
	}

	@Override
	public double getMP() {
		// Default for Bronze
		return 0.14;
	}

	@Override
	public String getExpDate() {
		return expDate;
	}

	@Override
	public String getType() {
		return "";
	}

	@Override
	public double getInterest() {
		return interest;
	}

	@Override
    public double getCurrentBalance() {
		return entries.stream().mapToDouble(e -> e.getAmount()).sum();
    }

	@Override
	public void addEntry(IEntry entry) {
		entries.add(entry);
		notifyCustomer();
	}

	@Override
	public void notifyCustomer() {
		if (new NotifyRule().test(this)) {
			customer.SendEmailToCustomer();
		}
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public double getLastAmountTransaction() {
		return entries.get(entries.size()-1).getAmount();
	}

	@Override
	public List<IEntry> getEntries() {
		return this.entries;
	}

	@Override
	public void addInterest() {
		double rate = getCurrentBalance() * this.interest;
		if (rate > 0) {
			this.entries.add(new Entry(rate, LocalDate.now(), "Interest Added"));
		}
	}

	@Override
	public String getAccNumber() {
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
