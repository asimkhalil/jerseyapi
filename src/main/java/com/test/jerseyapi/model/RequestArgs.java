package com.test.jerseyapi.model;

import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RequestArgs {

	private String businessDate;

	private Collection<HashMap<String, String>> proposedRates;

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public Collection<HashMap<String, String>> getProposedRates() {
		return proposedRates;
	}

	public void setProposedRates(Collection<HashMap<String, String>> proposedRates) {
		this.proposedRates = proposedRates;
	}

}
