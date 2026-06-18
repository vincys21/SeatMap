package it.benefind.seatmap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role",schema = "public")
@IdClass(UserRoleId.class)
public class UserRole {


	@Id
    @ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "role_id")
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
