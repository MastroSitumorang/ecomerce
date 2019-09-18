package net.ecommerce.Controllers;

import net.ecommerce.Apps.AppsApplicationTests;
import net.ecommerce.Models.CategoryMenu;
import net.ecommerce.Repositories.CategoryMenuRepository;
import net.ecommerce.Repositories.UserRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.*;

import com.nimbusds.openid.connect.sdk.Prompt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

@RestController
@RequestMapping("category/")
public class CategoryMenuCotroller extends AppsApplicationTests{

    @Autowired
    private CategoryMenuRepository categoryMenuRepository;
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/get-all/{user_id}", produces="application/json")
    @Test
    public @ResponseBody
    Map getAllCategoryForUserA(@PathVariable("user_id") String userId)
    {
        int roleId = userRepository.findRoleIdByUserId(userId);
        List<CategoryMenu> categoryMenu = categoryMenuRepository.findAllByUserRole(roleId);
        HashMap<String, Object> data;
        List allCategory = new ArrayList();
        for (CategoryMenu category : categoryMenu) {
            data = new HashMap<>();
            data.put("moduleOrder", category.getModuleOrder());
            data.put("moduleName", category.getModuleOrder());
            allCategory.add(data);
        }

        HashMap<String, List> returnData = new HashMap<>();
        returnData.put("modules", allCategory);
        return returnData;
    }
    	@Test
    	public void getAllCategoryForUserA() throws Exception {
	      String uri = "/user";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Produces[] userlist = (Produces[]) super.mapFromJson(content, Prompt[].class);
	      assertTrue(userlist.length > 0);
	   }
}
