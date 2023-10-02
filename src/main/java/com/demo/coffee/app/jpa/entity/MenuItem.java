package com.demo.coffee.app.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "menu_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
	@Setter(AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item_gen")
	@SequenceGenerator(name = "menu_item_gen", sequenceName = "menu_item_sequence", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "item_name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "currency")
	private String currency;

	@ManyToMany(mappedBy = "menuItems")
	private Set<Menu> menus;

}
