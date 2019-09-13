package net.ecommerce.Repositories;

import net.ecommerce.Models.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, String> {
    @Query("FROM CategoryMenu category where category.roleID = :roleId order by category.moduleOrder")
    public abstract List<CategoryMenu> findAllByUserRole(@Param("roleId") int roleId);
}
