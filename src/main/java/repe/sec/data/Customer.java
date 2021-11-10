package repe.sec.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Customer {
    
    private String name;
	@Id
    private String username;
    private String password;
	@Enumerated(EnumType.STRING)
    private Role role;
    
    

    public Customer(String name, String username, String password, Role role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

    public Customer() {}


	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public Role getRole() {return role;}

	public void setRole(Role role) {this.role = role;}

}
