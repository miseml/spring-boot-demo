# spring-boot-demo

## build instructions

```
cd microservice
mvn clean package -Dmaven.test.skip=true 
docker-compose build
docker-compose up
```

## endpoints

```
/cities
/countries
/continents
/swagger-ui.html
```

## sample queries

Full rest api documentation available at: http://localhost:8080/swagger-ui.html
See more: [Swagger UI](https://swagger.io/swagger-ui/)

### curl
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
   "country" : {
    "name": "Country",
    "continent": {
      "name": "Continent"
    }
  },
  "name": "string"
}' 'http://localhost:8080/cities'

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
"name": "Continent"
}' 'http://localhost:8080/continents'

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "continent": {
  "name": "Continent"
},

  "name": "Country"
}' 'http://localhost:8080/countries'
```
## integration test

Test requires running redis-server on localhost:6379, host and port may be changed in "test.properties" file.


