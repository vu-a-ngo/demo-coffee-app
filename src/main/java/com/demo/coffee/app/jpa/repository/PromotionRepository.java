package com.demo.coffee.app.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.coffee.app.jpa.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	@Query("SELECT p FROM promotion p WHERE p.type = :type")
	List<Promotion> getPromotionsByType(@Param("type") Promotion.PromotionType type);

	@Query("SELECT p FROM promotion p WHERE p.startDate <= CURRENT_DATE AND p.endDate > CURRENT_DATE ")
	List<Promotion> getActivePromotion();
}
