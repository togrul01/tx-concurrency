Requirements
Java 17
MysQL
DB
docker run --name hibernate -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=hibernate  mysql:8

Benchmark
echo "{
  "uuid": "7464d45c-3d31-4d4f-ba8d-3c71c8e2c426",
  "amount": 123
}" > invoice.json
ab -p a.json -T application/json -n 100000 -c 100 http://localhost:8081/invoices
