package com.hackathon.processor;

import java.util.List;

import com.hackathon.dto.MonthlyUsageDto;
import com.hackathon.dto.UsageSlabDto;

public interface BillingProcessorHelper {

	public void calculateBill(List<UsageSlabDto> slabRef, List<MonthlyUsageDto> billing);
	
}
