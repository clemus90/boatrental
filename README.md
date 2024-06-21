# Pet-Friendly Boat Rental Service API

## Requirements
- Docker
- Gradle v8.8
- Java v17

## How to locally run
1. from the root of the project run `docker compose up`, this will start the postgres db instance
2. in a different terminal from the root of the project run `gradle bootRun`

## Play with the API
This project has graphiql enabled so one you run the spring boot project you can head to [localhost:8080](http://localhost:8080)

#`# Graphql definitions
You can find the schema of the API here: [boatrental.graphqls](./src/main/resources/graphql/boatrental.graphqls)
