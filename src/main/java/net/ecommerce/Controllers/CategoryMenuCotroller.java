package net.ecommerce.Controllers;

import net.ecommerce.Models.CategoryMenu;
import net.ecommerce.Repositories.CategoryMenuRepository;
import net.ecommerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category/")
public class CategoryMenuCotroller {

    @Autowired
    private CategoryMenuRepository categoryMenuRepository;
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/get-all/{user_id}", produces="application/json")
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
}
