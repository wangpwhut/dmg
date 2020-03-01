package ribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired  
    private LoadBalancerClient loadBalancerClient;  

    @RequestMapping(value = "/test_ribon_access", method = RequestMethod.GET)
    public String add() {
    	this.loadBalancerClient.choose("access");//随机访问策略访问 access
        return restTemplate.getForEntity("http://access/ribbon_test", String.class).getBody();
    	
    }
    
}