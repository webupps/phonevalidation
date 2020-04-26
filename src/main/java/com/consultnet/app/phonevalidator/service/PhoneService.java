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
        
      
        if(pagedResult.hasContent()) {

        	//List<Phone> phoneList = pagedResult.getContent();
        	///pagedResult.getContent().stream().forEach(elem -> System.out.println("element " + elem));
        	for(int i = 0; i< pagedResult.getContent().size(); i++){
        		String singleNumber = pagedResult.getContent().get(i).getNumber();
        		if (singleNumber.substring(singleNumber.length() - 1) == "0" ||
        				singleNumber.substring(singleNumber.length() - 1) == "1"){
        			return pagedResult.getContent();
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
        			//String newNumber = singleNumber.substring(0,singleNumber.length() - 1) + letters[l] ;
        			
        			//System.out.println(newNumber);
        			///phonelist.add(new Phone(newNumber));
        			//Phone objt = new Phone(newNumber);
        			//phoneList.add(new Phone(pagedResult.getContent().get(i).getId(),newNumber));
        			 //phoneList.add(index, element);
        			///phoneList.add(i, new Phone(pagedResult.getContent().get(i).getId(), newNumber));
        			//pagedResult.getContent().add(pagedResult.getContent().get(i).getId(), new Phone(newNumber));
        				//phoneList.add(1, new Phone(newNumber));
        			//System.out.println(phoneList.add(i, new Phone(newNumber)));
        		}
        		
        		//System.out.println((i+1) + " . " + pagedResult.getContent().get(i).getNumber().substring(pagedResult.getContent().get(i).getNumber().length() - 1)  + " . " + pagedResult.getContent().get(i).getId());

        	}
        	//System.out.println(phoneList.isEmpty());
           return pagedResult.getContent();
        } else {
            return new ArrayList<Phone>();
        }
    }
}
