package org.bank;

public class AxisBank extends BankInfo {
	
	public void deposit()
	{
		System.out.println("Intrest rate for deposit is 8");
	}
	

	public static void main(String[] args) {
		
		AxisBank bank=new AxisBank();
		bank.saving();
		bank.fixed();
		bank.deposit();

	}

}
