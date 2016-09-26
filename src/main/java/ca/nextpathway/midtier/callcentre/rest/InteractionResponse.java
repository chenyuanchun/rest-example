package ca.nextpathway.midtier.callcentre.rest;

public class InteractionResponse {
	private String customer;
	private String interaction;
	private String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
