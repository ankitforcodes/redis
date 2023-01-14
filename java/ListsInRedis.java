import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class ListsInRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("Connection success!");
		
		// Redis Lists
		// SET
		jedis.rpush("cars", "bmw");
		jedis.rpush("cars", "honda");
		jedis.rpush("cars", "toyota");
		jedis.rpush("cars", "tata");
		List<String> mylist=new ArrayList<String>();
		mylist = jedis.lrange("cars", 0, -1);
		System.out.println(mylist);

	}

}
