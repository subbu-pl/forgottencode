package com.hackathon.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackathon.dto.MonthlyUsageDto;
import com.hackathon.dto.UsageSlabDto;

public class BillingProcessorImpl implements BillingProcessorHelper {

	public void calculateBill(List<UsageSlabDto> slabRef,
			List<MonthlyUsageDto> billing) {
		System.out.println("Inside Calculate Bill MOdule");
		
		Map<Integer, Double> slbMp = new HashMap<Integer, Double>();
		if (slabRef != null) {
			for (UsageSlabDto slb : slabRef) {
				slbMp.put(slb.getSlabId(),slb.getRatePerUnit());
			}
		}
		if (billing != null) {
			for (MonthlyUsageDto bill: billing) {
				bill.setAmount(calBillAmt(bill.getMtrEnd() - bill.getMtrStart(), slbMp));
				bill.setAmount(calFinalAmt(bill.getAmount()));
			}
		}
		
		System.out.println("Exit Calculate Bill MOdule");
	}
	
	private double calFinalAmt(double amt) {
		return amt+(amt*10);
	}
	
	private double calPrice(double amt, int unt, double price) {
		return  amt+(unt*price);
	}
	
	private double calBillAmt(int diffUnts, Map<Integer,Double> slbMp) {
		int slbCnt = diffUnts/300;
		double amt = 0;
		System.out.println("slbCnt-->"+slbCnt);
		int bal = diffUnts%300;
		for (int i=0;i< slbCnt;i++) {
			if (i==0) {
				if (i == slbCnt-1 && bal > 0) {
					amt=(calPrice(amt, bal, slbMp.get(2)));
				}
				amt = ((calPrice(amt, 300, slbMp.get(1))));
			} else if (i==1) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, slbMp.get(3))));	
				}
				amt = ((calPrice(amt, 300, slbMp.get(2))));
				
			} else if (i==2) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, slbMp.get(4))));
				}
				amt = ((calPrice(amt, 300, slbMp.get(3))));	
			} else if (i>=3) {
				amt = ((calPrice(amt, diffUnts-900, slbMp.get(4))));
				break;
			}
		}
		System.out.println(amt);
		return amt;
	}
	/*
	private static void sample(){
		int diffUnts = 340;
		int slbCnt = diffUnts/300;
		double amt = 0;
		System.out.println("slbCnt-->"+slbCnt);
		int bal = diffUnts%300;
		for (int i=0;i< slbCnt;i++) {
			if (i==0) {
				if (i == slbCnt-1 && bal > 0) {
					amt=(calPrice(amt, bal, 1.75));
				}
				amt = ((calPrice(amt, 300, 1.25)));
			} else if (i==1) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, 2.25)));	
				}
				amt = ((calPrice(amt, 300, 1.75)));
				
			} else if (i==2) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, 2.75)));
				}
				amt = ((calPrice(amt, 300, 2.25)));	
			} else if (i>=3) {
				amt = ((calPrice(amt, diffUnts-900, 2.75)));
				break;
			}
		}
		System.out.println(amt);
	}
	
	public static void main(String[] args) {
		sample();
	}*/
}
