import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
 
public class PubSubSubscribe {
 
  public static void main(String[] args) {
 
    try {
    jedis = new Jedis("127.0.0.1", 6379);
         
    JedisPubSub jedisPubSub = new JedisPubSub() {
                 
        @Override
        public void onMessage(String channel, String message) {
            System.out.println("Channel " + channel + " has sent a message : " + message );
            if(message.equals("last")) {
                unsubscribe(channel);
            }
        }
                 
        @Override
        public void onSubscribe(String channel, int subscribedChannels) {
            System.out.println("Subscribed to channel : "+ channel);
            System.out.println("Subscribed to "+ subscribedChannels + " no. of channels");
        }
             
        @Override
        public void onUnsubscribe(String channel, int subscribedChannels) {
            System.out.println("Unsubscribed from channel : "+ channel);
            System.out.println("Subscribed to "+ subscribedChannels + " no. of channels");
        }
             
    };
             
    jedis.subscribe(jedisPubSub, "C1");
             
    } catch(Exception ex) {         
             
        System.out.println("Exception : " + ex.getMessage());   
             
    } finally {
             
        if(jedis != null) {
            jedis.close();
        }
    }       
  }
}
