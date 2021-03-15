# Roulette Services

REST services to manage the roulette information.

## Technologies

#### 1. Spring Boot & Java
Official documentation: https://spring.io/projects/spring-boot


#### 2. Docker
For this exercise we use a mongo db container, please run the follow command:
```
docker run -it -v mongodata:/data/db -p 27017:27017 --name mongodb -d mongo
```

## Endpoints

1. Endpoint to Get all Roulettes
```
curl http://localhost:8090/api/v1/Roulette
```

2. Endpoint to Create a Roulette
```
curl --location --request POST 'http://localhost:8090/api/v1/Roulette'
```

3. Endpoint to Open Roulette
```
curl --location --request PUT 'http://localhost:8090/api/v1/Roulette/59ab8542-0070-4f65-8558-22c6b0699c26/activate'
```

4. Endpoint to create a Bet
```
curl --location --request POST 'http://localhost:8090/api/v1/Bet' \
--header 'Content-Type: application/json' \
--data-raw '{
"number": 12,
"dollars": 800,
"idRoulette": "3d7b065e-f704-4b7e-af7f-926ae51c9a06"
}'
```

5. Close the roulette
```
curl --location --request POST 'http://localhost:8090/api/v1/Roulette/3d7b065e-f704-4b7e-af7f-926ae51c9a06/close'
```
