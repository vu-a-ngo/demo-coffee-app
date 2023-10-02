package com.demo.coffee.app.redis.queue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

	public static List<String> messageList = new ArrayList<String>();

	@Override
	public void onMessage(final Message message, final byte[] pattern) {
		messageList.add(message.toString());
	}
}
