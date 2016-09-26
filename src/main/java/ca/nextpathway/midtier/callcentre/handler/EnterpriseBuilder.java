package ca.nextpathway.midtier.callcentre.handler;

import ca.nextpathway.midtier.callcentre.rest.CallcentreRequest;

public class EnterpriseBuilder {
	public static EnterpriseRequestBody build(String agent, String type, CallcentreRequest request) {
		EnterprisePayload payload = new EnterprisePayload();
		payload.setAgent(agent);
		payload.setCustomer(request.getCustomer());
		payload.setInteraction(request.getInteraction());
		payload.setType(type);
		
		EnterpriseRequestBody body = new EnterpriseRequestBody();
		body.setPayload(payload);
		body.setRouting_key("interaction");
		
		return body;
	}
}
