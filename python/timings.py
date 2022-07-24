import redis
import time
r = redis.Redis(host='localhost', port=6379)


startTime = time.time()
r.set('name', 'Ankit')
endTime = time.time()

print("SET time taken: ", endTime - startTime)



startTime = time.time()
r.get('name')
endTime = time.time()

print("GET time taken: ", endTime - startTime)

