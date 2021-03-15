-1. Endpoint to Get all Roulettes
```
curl http://localhost:8090/api/v1/Rulette
```

-2. Endpoint to Create a Roulette
```
curl --location --request POST 'http://localhost:8090/api/v1/Rulette'
```

-3. Endpoint to Open Roulette
```
curl --location --request PUT 'http://localhost:8090/api/v1/Rulette/59ab8542-0070-4f65-8558-22c6b0699c26/activate'
```

-4 Endpoint to create a Bet
```
curl --location --request POST 'http://localhost:8090/api/v1/Bet' \
--header 'Content-Type: application/json' \
--data-raw '{
"number": 12,
"dollars": 800,
"idRoulette": "3d7b065e-f704-4b7e-af7f-926ae51c9a06"
}'
```
