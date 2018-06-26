package com.sg.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
public class SpringBootWebApplicationTests extends BaseIT {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Test
    public void testRoosterServicePass() throws Exception {
		test = extent.createTest("Rooster Service Pass", "This test will check the post request of rooster service");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger", ExtentColor.BLUE));
		test.log(Status.INFO, "web context initialized successfully");
		mockMvc.perform(post("/api/search")
				.content("Tamil"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.sounds",Matchers.is("kocoraco")));
    }
	@Test
    public void testRoosterServiceFail() throws Exception {
		test = extent.createTest("Rooster Service Fail", "This test will check the post request of rooster service");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger", ExtentColor.BLUE));
		test.log(Status.INFO, "web context initialized successfully");
		mockMvc.perform(post("/api/search")
				.content("French"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.sounds",Matchers.is("kocoraco")));
    }

}