package com.demo.Websocket;

import java.util.Date;

public class Case {
	
	private String cusip;
	private String marketAction;
	private Date date;
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	public String getMarketAction() {
		return marketAction;
	}
	public void setMarketAction(String marketAction) {
		this.marketAction = marketAction;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Case [cusip=" + cusip + ", MarketAction=" + marketAction + "]";
	}
	
	
	

}
