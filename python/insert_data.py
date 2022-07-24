import redis

r = redis.Redis(host='localhost', port=6379)

r.set('mykey', 'thevalueofmykey')
value = r.get('mykey')

value_as_string = value.decode('utf-8')

print(value)
print(value_as_string)
