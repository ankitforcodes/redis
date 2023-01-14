import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class PipeliningInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Pipeline p = jedis.pipelined();
		
		p.set("key1", "value1");
		p.set("key2", "value2");
		p.set("key3", "value3");
		
		Response<String> myresponse1 = p.get("key1");
		Response<String> myresponse2 = p.get("key2");
		
		p.sync();
		
		System.out.println(myresponse1.get());
		System.out.println(myresponse2.get());
		
		
		
		System.out.println("Program Over!");
	}

}
