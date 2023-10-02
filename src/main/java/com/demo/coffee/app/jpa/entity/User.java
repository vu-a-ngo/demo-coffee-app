package com.demo.coffee.app.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shop_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	public enum Role {
		OWNER, ADMIN, CUSTOMER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
	@SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "shoprole", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Role role;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "passwd", nullable = false)
	private String password;

	@Column(name = "lastname")
	private String firstName;

	@Column(name = "firstname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String phoneNumber;

	@ManyToMany
	@JoinTable(name = "user_to_shop", joinColumns = @JoinColumn(name = "shop_user_id"), inverseJoinColumns = @JoinColumn(name = "shop_id"))
	private Set<Shop> shops;

	/**
	 * Whether the user is the shop owner or shop admin
	 *
	 * For simplicity's sake, we'd assume that a {@link User} can only be either OWNER or ADMIN,
	 * even if the own/manage multiple shops.
	 * @return true if role is OWNER, false otherwise
	 */
	public boolean isOwner() {
		return this.role == Role.OWNER;
	}

	public boolean isAdmin() {
		return this.role == Role.ADMIN;
	}

	public boolean isCustomer() {
		return this.role == Role.CUSTOMER;
	}
}
