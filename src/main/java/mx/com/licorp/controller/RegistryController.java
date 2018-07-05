package mx.com.licorp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.licorp.business.RegistryBO;
import mx.com.licorp.entity.AspectReg;
import mx.com.licorp.entity.RegistryBean;
import mx.com.licorp.entity.ResponseTO;





@RestController
@RequestMapping("/v1/registries")
public class RegistryController {
	
	@Autowired
	RegistryBO registryBO;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<RegistryBean> findAll() throws Exception {
        return registryBO.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistryBean findOne(@PathVariable("id") Long id) throws Exception {
    	return registryBO.findOne(id);
    }
	
    @AspectReg
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestHeader String extraData, @RequestBody RegistryBean resource) {
    	
    	ResponseTO response = new ResponseTO();
    	try {
    		resource.setExtraData(extraData);
    		registryBO.create(resource);
    		response.setCode("0");
    		response.setMessage("Success");
		} catch (Exception e) {
			response.setCode("-1");
    		response.setMessage("Fail");
    		return new ResponseEntity<>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		registryBO.delete(id);
    	ResponseTO response = new ResponseTO();
		response.setCode("0");
		response.setMessage("Success");
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    
    
}