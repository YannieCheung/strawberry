package edu.zipcloud.cloudstreetmarket.core.enums;

import java.beans.PropertyEditorSupport;

public class MarketCodeEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			setValue(MarketCode.valueOf(text));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("The provided value for the market code variable is invalid!");
		}
	}
	
}
