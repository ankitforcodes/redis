import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class HashesInRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("68.183.90.231", 6379);
		System.out.println("Connection success!");
		
		Map<String,String> mymap=new HashMap<String,String>();
		mymap.put("name", "Ankit");
		mymap.put("location", "Hyd");
		mymap.put("role", "developer");
		
		jedis.hmset("Ankit1", mymap);
		
		
		Map<String, String> map_out=new HashMap<String,String>();
		map_out = jedis.hgetAll("Ankit1");
		System.out.println(map_out);
		
	}

}
