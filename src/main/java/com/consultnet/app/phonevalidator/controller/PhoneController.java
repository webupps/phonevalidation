package com.consultnet.app.phonevalidator.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.consultnet.app.phonevalidator.model.Phone;
import com.consultnet.app.phonevalidator.service.PhoneService;
import com.consultnet.app.phonevalidator.service.PhoneValidatorService;


@RestController
@RequestMapping("/api/phone")
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private PhoneValidatorService phoneValidatorService;
	
	@GetMapping("/test")
	public String testing(){
		return "working";
    }
	
	@PostMapping("/add")
	public @ResponseBody Map<String,Boolean> addNewPhone(@Valid @RequestBody Phone obj) {			
		if(phoneValidatorService.validatePhoneNumber(obj.getNumber())) {
			phoneService.addPhone(obj);
		}
		return Collections.singletonMap("succeed", phoneValidatorService.validatePhoneNumber(obj.getNumber()));
	}
	
	
	@PostMapping("/update")
	public @ResponseBody Map<String,Boolean> updatePhone(@Valid @RequestBody Phone obj) {		
			
		if(phoneValidatorService.validatePhoneNumber(obj.getNumber())) {
			phoneService.updatePhone(obj);
		}
		return Collections.singletonMap("succeed",phoneValidatorService.validatePhoneNumber(obj.getNumber()));
	}
	
	@GetMapping( value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Phone getPhone(@PathVariable("id") Integer id) {		
		return phoneService.getPhone(id);	
	}
	
	@GetMapping(path = "/getall", params = { "pageNo", "pageSize", "sortBy" })
	public ResponseEntity<List<Phone>> getAllPhones(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "1") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
		List<Phone> list = phoneService.getAllPhones(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<Phone>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@GetMapping("/del/{id}")
	public @ResponseBody Map<String,Boolean> deleteUser(@PathVariable("id") Integer id) {		
		phoneService.deleteUser(id);
		return Collections.singletonMap("succeed",true);
	}
	
}

