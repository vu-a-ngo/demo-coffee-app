package com.demo.coffee.app.jpa.entity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shop")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
	@Setter(AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_gen")
	@SequenceGenerator(name = "shop_gen", sequenceName = "shop_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "city", nullable = false)
	private String city;

	/**
	 * For simplicity's sake, we'd assume that a shop's location only contain of: country, city and street address
	 */
	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "contact")
	private String contact;

	@Column(name = "is_active")
	private boolean active;

	@ManyToMany(mappedBy = "shops")
	private Set<User> shopUsers;

	@ManyToMany
	@JoinTable(name = "shop_to_menu", joinColumns = @JoinColumn(name = "shop_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private Set<Menu> menus;

	public Set<User> getOwners() {
		return shopUsers.stream().filter(User::isOwner).collect(Collectors.toSet());
	}

	public Set<User> getAdmins() {
		return shopUsers.stream().filter((User::isAdmin)).collect(Collectors.toSet());
	}
}
