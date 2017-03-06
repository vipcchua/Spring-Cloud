package com.CchuaSpace.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CchuaSpace.Mapper.TableUserMapper;
import com.CchuaSpace.Model.TableUser;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
	@Autowired
	private TableUserMapper tableUserMapper;
	
	
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }


  
  /*
	@RequestMapping("/Seldsada")
	public List<TableUser> allusers() {
        ServiceInstance instance = client.getLocalServiceInstance();
		List<TableUser> user = tableUserMapper.allusers();
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
	return user ;

}
   */
   
   
    
 
    
    
    
}