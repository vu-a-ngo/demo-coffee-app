package com.demo.coffee.app.redis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class QueueingOrder implements Serializable {
}
