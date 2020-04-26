package com.consultnet.app.phonevalidator.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneControllerTest {
    
	private MockMvc mockMvc;
	
	@InjectMocks
	private PhoneController phoneController;
	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(phoneController).build();
	}
	
	@Test
	public void testGetSpecificNumber() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/phone/test")
				).andExpect(MockMvcResultMatchers.status().isOk()); 
	
	}

}
