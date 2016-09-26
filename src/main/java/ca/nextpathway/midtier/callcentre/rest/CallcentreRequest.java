package ca.nextpathway.midtier.callcentre.rest;

public class CallcentreRequest {
	private String customer;
	private String interaction;
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}

}
