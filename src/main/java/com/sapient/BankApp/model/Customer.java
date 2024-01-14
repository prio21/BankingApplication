package com.sapient.BankApp.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//
//@jakarta.persistence.Entity
//@jakarta.persistence.Table(name = "customer_table")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_table")
public class Customer implements UserDetails {

//	
//	  @OneToMany(mappedBy = "user")
//	  private List<Token> tokens;

	
	@Enumerated(EnumType.STRING)
	Role role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.name()));
		
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	@NotNull(message = "Id can not be null")
    @Id
    private String aadhar;
	
	@Valid
	@NotEmpty(message = "name entity cannot be null")
    private String name;
	

	@NotEmpty 
    private String email;
	
	@NotNull
	private String password;
    private float balance; 
    
    
    
    //cus is updated
//    @OneToMany(mappedBy = "cus",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transactions> transactions;
//    
}
