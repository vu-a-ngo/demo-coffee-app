package com.demo.coffee.app.jpa.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "promotion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

	public enum PromotionType {
		GLOBAL, SHOP, AMOUNT, COMBO, GIFTCARD, ONEOFF
	}

	public enum DiscountMethod {
		POINTS, DISCOUNT_AMOUNT, DISCOUNT_PERCENTAGE, EXTRA_ITEM
	}

	@Setter(AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_gen")
	@SequenceGenerator(name = "promotion_gen", sequenceName = "promotion_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private PromotionType type;

	@Column(name = "method", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private DiscountMethod method;

	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "start_date")
	@Temporal(value = TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(value = TemporalType.DATE)
	private Date endDate;

	@Column(name = "item_id")
	private Integer itemId;

	@Column(name = "discount_amount")
	private Float discountAmount;
}
