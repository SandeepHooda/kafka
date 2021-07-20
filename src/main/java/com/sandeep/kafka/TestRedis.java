package com.sandeep.kafka;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		System.out.println( jedis.get("name"));

	}

}
