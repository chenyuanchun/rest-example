package ca.nextpathway.midtier.callcentre.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ca.nextpathway.midtier.callcentre.handler.EnterpriseRestService;

@Controller
public class CallCentreController {
	private static final String AGENT_ID = "{agentId}";

	private static final Logger logger = LoggerFactory.getLogger(CallCentreController.class);
	
	private static final String CALLCENTRE_V1_BASE = "/callcentre/v1/";
	private static final String INTERACTION_BASE = CALLCENTRE_V1_BASE + "interaction/";
	private static final String APPLICATION_BASE = CALLCENTRE_V1_BASE + "agentapplication/";
	
	public static final String INTERACTION = INTERACTION_BASE + AGENT_ID;
	public static final String AGENT_APPLICATION = APPLICATION_BASE + AGENT_ID;
	
	@Autowired
	private EnterpriseRestService enterprise;
	
    @RequestMapping(value = INTERACTION, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<InteractionResponse> startInteraction(
    		@PathVariable String agentId, 
    		@RequestBody RequestPostJson request) {
    	logger.debug("start interaction: {}", agentId);
		logger.debug("customer: {}, interaction: {}, payload: {}", 
				request.getCustomer(),
				request.getInteraction(),
				request.getPayload());
			
//		EnterpriseRestService enterprise = new EnterpriseRestService();
		HttpStatus status = enterprise.process(agentId, "start", request);
    	
        return reply(request, status);
    }
    
    @RequestMapping(value = INTERACTION, method = RequestMethod.PUT)
    public HttpStatus update(
    		@PathVariable String agentId, 
    		@RequestBody RequestPostJson request) {
		logger.debug("customer: {}, interaction: {}, payload: {}", 
				request.getCustomer(),
				request.getInteraction(),
				request.getPayload());
		
		EnterpriseRestService enterprise = new EnterpriseRestService();
		HttpStatus status = enterprise.process(agentId, "update", request);
    	
        return status;
    }
    
    @RequestMapping(value = AGENT_APPLICATION, method = RequestMethod.POST)
    public HttpStatus updateApp(
    		@PathVariable String agentId, 
    		@RequestBody CallcentreRequest request) {
    	EnterpriseRestService enteprise = new EnterpriseRestService();
    	HttpStatus status = enteprise.processApp(request);
    	return status;
    }
    
    private ResponseEntity<InteractionResponse> reply(RequestPostJson request, HttpStatus status) {
    	InteractionResponse body = new InteractionResponse();
    	if (request != null) {
	    	body.setCustomer(request.getCustomer());
	    	body.setInteraction(request.getInteraction());
	    	body.setStatus(status.name());
    	}
    	
		ResponseEntity<InteractionResponse> res = new ResponseEntity<InteractionResponse>(body, status);
    	return res;
    }
}
