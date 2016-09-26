package ca.nextpathway.midtier.callcentre.handler;

public class EnterpriseRequestBody {
	private String routing_key;
	private EnterprisePayload payload;
	public String getRouting_key() {
		return routing_key;
	}
	public void setRouting_key(String routing_key) {
		this.routing_key = routing_key;
	}
	public EnterprisePayload getPayload() {
		return payload;
	}
	public void setPayload(EnterprisePayload payload) {
		this.payload = payload;
	}
}
