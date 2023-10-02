package com.demo.coffee.app.redis.queue;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisMessagePublisher {

	private final RedisTemplate<String, Object> redisTemplate;

	private final ChannelTopic topic;

	public void publish(final String message) {
		redisTemplate.convertAndSend(topic.getTopic(), message);
	}
}
