import redis.clients.jedis.Jedis;

public class ConnectionToRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("Connection success!");
		System.out.println(jedis.ping());
		
		// SIMPLE KEY-VALUES
		jedis.set("events/city/rome", "32,15,223,828");
		String cachedResponse = jedis.get("events");
		
		
	}

}
