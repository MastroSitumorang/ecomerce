package net.ecommerce.Models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String id;
    @Column(name = "role_id")
    private int roleID;
    @SuppressWarnings("unused")
	private String name;
    @SuppressWarnings("unused")
	private String email;
    @SuppressWarnings("unused")
	private String address;
    @Column(name = "is_male")
    private boolean isMale;
    @SuppressWarnings("unused")
	private String username;
    @SuppressWarnings("unused")
	private String password;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public User() {
    }

    public User(String id, int roleID, String name, String email, String address, boolean isMale, String username,
                String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.roleID = roleID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isMale = isMale;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
