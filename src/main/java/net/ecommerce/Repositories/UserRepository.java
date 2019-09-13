package net.ecommerce.Repositories;

import net.ecommerce.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT user.roleID FROM User user where user.id = :id")
    public int findRoleIdByUserId(@Param("id") String id);
}
