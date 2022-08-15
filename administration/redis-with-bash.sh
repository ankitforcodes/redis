#!/bin/bash

redis-cli -h 127.0.0.1 -p 6379 --scan > all-redis-keys.txt

while read -r key
do
	value=$(redis-cli  -h 127.0.0.1 -p 6379 get "$key")
	echo $key '=>' $value
done < all-redis-keys.txt

