package com.demo.coffee.app.service.impl;

import org.springframework.stereotype.Service;

import com.demo.coffee.app.jpa.repository.PromotionRepository;
import com.demo.coffee.app.service.PromotionServiceInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromotionService implements PromotionServiceInterface {

	private final PromotionRepository promotionRepository;
}
