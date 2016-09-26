package ca.nextpathway.midtier.enterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.nextpathway.midtier.callcentre.handler.EnterprisePayload;
import ca.nextpathway.midtier.callcentre.handler.EnterpriseRequestBody;

@Controller
public class EnterpriseController {
	private static final String EXCHANGE = "{exchange}";

	private static final Logger logger = LoggerFactory.getLogger(EnterpriseController.class);
	
	public static final String ENTERPRISE_V1_BASE = "/midtier/v1/";
	public static final String ENTERPRISE_URI = ENTERPRISE_V1_BASE + EXCHANGE;
	
    @RequestMapping(value = ENTERPRISE_URI, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EnterpriseResponseJson> startInteraction(
    		@PathVariable String exchange, 
    		@RequestBody EnterpriseRequestBody request) {
    	logger.debug("start interaction: {}", exchange);
    	EnterprisePayload payload = request.getPayload();
		logger.debug("customer: {}, interaction: {}, type: {}", 
				payload.getCustomer(),
				payload.getInteraction(),
				payload.getType());
		
		EnterpriseResponseJson res = new EnterpriseResponseJson();
		res.setRouted(true);
        return new ResponseEntity<EnterpriseResponseJson>(res, HttpStatus.OK);
    }
    
    
}
