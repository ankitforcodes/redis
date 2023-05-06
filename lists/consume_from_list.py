import redis
import time

r = redis.Redis(host='127.0.0.1', port=6379, db=0)
c = 0
while True:
	fetched = r.rpop("transaction_list")
	if fetched is not None:
		print(fetched.decode())


