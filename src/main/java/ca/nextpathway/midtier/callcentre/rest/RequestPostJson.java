package ca.nextpathway.midtier.callcentre.rest;

public class RequestPostJson extends CallcentreRequest {
	private String payload;
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
}
