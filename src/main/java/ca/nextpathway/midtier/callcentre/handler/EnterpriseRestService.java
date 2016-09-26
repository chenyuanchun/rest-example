package ca.nextpathway.midtier.callcentre.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ca.nextpathway.midtier.callcentre.rest.CallcentreRequest;
import ca.nextpathway.midtier.callcentre.rest.RequestPostJson;
import ca.nextpathway.midtier.enterprise.EnterpriseController;
import ca.nextpathway.midtier.enterprise.EnterpriseResponseJson;

@Component
public class EnterpriseRestService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public HttpStatus process(String agentId, String type, RequestPostJson request) {
		EnterpriseRequestBody data = EnterpriseBuilder.build(agentId, type, request);
		String uri = "http://localhost:19002/";
		uri = uri + EnterpriseController.ENTERPRISE_V1_BASE+"exchange1";
		ResponseEntity<EnterpriseResponseJson> res = restTemplate.postForEntity(uri, data, EnterpriseResponseJson.class);
		return res.getStatusCode();
	}

	public HttpStatus processApp(CallcentreRequest request) {
		return HttpStatus.OK;
	}
}
