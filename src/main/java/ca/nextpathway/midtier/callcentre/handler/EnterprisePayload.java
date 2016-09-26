package ca.nextpathway.midtier.callcentre.handler;

public class EnterprisePayload {
	private String agent;
	private String customer;
	private String interaction;
	private String type;
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
