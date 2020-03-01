package access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	 @Autowired
	 private DiscoveryClient client;
	 
	@RequestMapping(value = "/ribbon_test", method = {RequestMethod.GET})
	public String hello() {
		ServiceInstance instance = client.getLocalServiceInstance();
        String str= "path=/ribbon_test,  service_id:" + instance.getServiceId()+" port:" + instance.getPort() ;
       
		System.out.println("this data access server ... ");
		return "ribbon_test,this data access server! "+"\n"+str;
	}
	

	
}
