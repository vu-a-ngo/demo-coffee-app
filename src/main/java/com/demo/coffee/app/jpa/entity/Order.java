package com.demo.coffee.app.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(
		@TypeDef(name = "int-array", typeClass = IntArrayType.class)
)
public class Order {

	public enum OrderStatus {
		PAID, COMPLETED, CANCELLED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
	@SequenceGenerator(name = "order_gen", sequenceName = "order_seq")
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "status", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private OrderStatus status;

	@Column(name = "total_amount")
	private Float totalAmount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "items")
	@Type(type = "int-array")
	private Integer[] menuItemIds;

	@Column(name = "applied_promotions")
	@Type(type = "int-array")
	private Integer[] appliedPromotions;
}
