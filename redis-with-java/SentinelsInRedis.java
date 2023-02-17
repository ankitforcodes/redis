import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelsInRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Set<String> sentinels = new HashSet<String>();
		  sentinels.add(new HostAndPort("192.168.46.137", 26376).toString());
		  sentinels.add(new HostAndPort("192.168.46.137", 26377).toString());
		  sentinels.add(new HostAndPort("192.168.46.137", 26378).toString());
		  JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster", sentinels);
		  
		  System.out.println("Current master: " + sentinelPool.getCurrentHostMaster().toString());
		  
		  Jedis master = sentinelPool.getResource();
		  master.set("username","ankit");
		  
		  System.out.println(master.get("username"));
		  
		  sentinelPool.close();
		  sentinelPool.destroy();
	}

}
