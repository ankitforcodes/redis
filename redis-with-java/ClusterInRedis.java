import java.util.HashSet;
import java.util.Set;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class ClusterInRedis {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//final Logger log = LoggerFactory.getLogger(ClusterInRedis.class.getSimpleName());
	    //log.info("Program started");
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("167.71.238.208", 7004));	//We are adding only replica
		jedisClusterNodes.add(new HostAndPort("167.71.238.208", 7005)); // but we can still send write command and replica will route to the master
		JedisCluster jedis = new JedisCluster(jedisClusterNodes);
		
		jedis.set("javaprogram2", "cluster2");
		// log.info("Program Complete");
		System.out.println("Complete");
	}

}
