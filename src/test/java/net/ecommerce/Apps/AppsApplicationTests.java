package net.ecommerce.Apps;

import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.JsonParseException;

import net.ecommerce.Models.User;
import net.ecommerce.Repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppsApplicationTests {
	   protected MockMvc mvc;
	   @Autowired
	   WebApplicationContext webApplicationContext;

	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws IOException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }

	@Test
	public void contextLoads() {
	}
	
	  @Autowired
	  private UserRepository userRepository;

	  @Test
	  public void saveTest() {
	    User user = new User("Tono", 0, null, null, null, false, null, null, null, null);
	    userRepository.save(user);
	    Assert.assertNotNull(userRepository.findById("Tono"));
	  }
	  
}
