import redis.clients.jedis.Jedis;

public class SimpleKeyValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("Connection success!");
		
		// SIMPLE KEY-VALUES
		// SET
		jedis.set("events", "training");
		
		String cachedResponse = jedis.get("events");
		System.out.println(cachedResponse);
	}

}
