import redis
import time

r = redis.Redis(host='127.0.0.1', port=6379, db=0)
c = 0
while True:
	r.lpush("transaction_list", c)
	time.sleep(1)
	c = c + 1
	print(c)

