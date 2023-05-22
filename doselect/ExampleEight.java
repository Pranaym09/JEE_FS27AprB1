package com.doselect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TransactionParty {
	String seller;
	String buyer;

	public TransactionParty(String seller, String buyer) {
		this.seller = seller;
		this.buyer = buyer;
	}
}

class Receipt {
	TransactionParty transactionParty;
	String productsQR;

	public Receipt(TransactionParty transactionParty, String productsQR) {
		this.transactionParty = transactionParty;
		this.productsQR = productsQR;
	}
}

class GenerateReceipt {
	public int verifyParty(Receipt r) {
		Pattern p = Pattern.compile("^[a-zA-Z]+([ '-][a-zA-Z]+)*$");
		Matcher mSeller = p.matcher(r.transactionParty.seller);
		Matcher mBuyer = p.matcher(r.transactionParty.buyer);
		if (mSeller.find() && mBuyer.find()) {
			return 2;
		} else if (mSeller.find() || mBuyer.find()) {
			return 1;
		} else {
			return 0;
		}
	}

	public String calcGST(Receipt r) {
		String regex = "[,@]";
		String[] numbers = r.productsQR.split(regex);
		int[] nums = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			nums[i] = Integer.parseInt(numbers[i]);
		}
		int gst = 0;
		for (int i = 0; i < 5; i = i + 2) {
			gst += (nums[i] * nums[i+1]);
		}
		gst = (int) (gst * 0.12);
		return String.valueOf(gst);
	}
}

public class ExampleEight {
	public static void main(String[] args) {
		TransactionParty tp = new TransactionParty("Daniel D'Cruz", "Giselle Dawn-Wright");
		Receipt r = new Receipt(tp, "250,10@100,3@50,7");
		GenerateReceipt g = new GenerateReceipt();
		System.out.println(g.verifyParty(r));
		System.out.println(g.calcGST(r));
	}
}