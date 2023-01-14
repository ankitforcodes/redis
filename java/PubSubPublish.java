import redis.clients.jedis.Jedis;
 
public class PubSubPublish {
 
  public static void main(String[] args) {
         
    Jedis jedis = null;
         
    try {           
        jedis = new Jedis("127.0.0.1", 6379);
             
        jedis.publish("C1", "First message to channel C1");
        jedis.publish("C2", "First message to channel C2");
        jedis.publish("C1", "Second message to channel C1");
        jedis.publish("C2", "Second message to channel C2");
         
    } catch(Exception ex) {         
             
        System.out.println("Exception : " + ex.getMessage());
    } finally {
             
        if(jedis != null) {
          jedis.close();
        }       
    }
  }
}
