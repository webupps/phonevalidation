package com.consultnet.app.phonevalidator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.consultnet.app.phonevalidator.model.Phone;
import com.consultnet.app.phonevalidator.repository.PhoneRespository;



@Service
public class PhoneService {
	@Autowired
	private PhoneRespository phoneRespository;
	
	public Phone getPhone(Integer Id){
		return phoneRespository.findById(Id).get();
	}
	
	public Iterable<Phone> getAll(){
		return phoneRespository.findAll();
	}
	
	public void addPhone(Phone phone){
		phoneRespository.save(phone);
	}
	
	public void updatePhone(Phone phone){
		phoneRespository.save(phone);
	}
	
	public void deleteUser(Integer Id){
		phoneRespository.delete(phoneRespository.findById(Id).get());
	}
	
	public List<Phone> getAllPhones(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Phone> pagedResult = phoneRespository.findAll(paging);
        ArrayList<Phone> newPhonelist = new ArrayList<Phone>();
      
        if(pagedResult.hasContent()) {

        	for(int i = 0; i< pagedResult.getContent().size(); i++){
        		String singleNumber = pagedResult.getContent().get(i).getNumber();
        		if (singleNumber.substring(singleNumber.length() - 1) == "0" ||
        				singleNumber.substring(singleNumber.length() - 1) == "1"){
        			//return pagedResult.getContent();
        			newPhonelist.add(pagedResult.getContent().get(i));
        		}
        		String[] letters = new String[] { };
        		switch(singleNumber.substring(singleNumber.length() - 1)) {
        		  case "2":
        			  letters = new String[] { "A", "B", "C"};
        		    break;
        		  case "3":
        			  letters = new String[] { "D", "E", "F"};
        		    break;
        		  case "4":
        			  letters = new String[] { "G", "H", "I"};
        		    break;
        		  case "5":
        			  letters = new String[] { "J", "K", "L"};
        		    break;
        		  case "6":
        			  letters = new String[] { "M", "N", "O"};
        		    break;
        		  case "7":
        			  letters = new String[] { "P", "Q", "R", "S"};
        		    break;
        		  case "8":
        			  letters = new String[] { "T", "U", "V"};
        		    break;
        		  case "9":
        			  letters = new String[] { "W", "X", "Y", "Z"};
        		    break;
        		  default:
        		    
        		}
        		
        		for(int l = 0; l< letters.length; l++){ 
        			String newNumber = singleNumber.substring(0,singleNumber.length() - 1) + letters[l] ;
        			

                  Phone newPhoneNumber = new Phone(pagedResult.getContent().get(i).getId(), newNumber);
                  newPhonelist.add(newPhoneNumber);
        		}
        		

        	}
        	return newPhonelist;
        } else {
            return new ArrayList<Phone>();
        }
    }
}
