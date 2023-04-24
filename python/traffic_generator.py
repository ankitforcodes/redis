import redis
import time
r = redis.Redis(host='127.0.0.1', port=6379, db=0)
c = 0
while True:
	time.sleep(0.5)
	if c%4 == 0:
		r.get("mykey")
	else:
		r.set("mykey:"+str(c), "myvalue:"+str(c))
	c = c + 1
	print(c)
