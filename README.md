# Domain Driven Design
<img src="images/ddd_archi.png">

## Rest Web Service
https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/CarRentalController.java

## DDD service
https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/RentalServiceImpl.java

## DDD repository
https://github.com/charroux/eventsourcig/blob/main/eventsourcing/src/main/java/com/charroux/eventsourcing/EntityRepositoryImpl.java

## DDD entities, aggregates
<img src="images/entity_aggregate.png">

### RentalAgreement
https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/RentalAgreement.java
### Aggregate
https://github.com/charroux/eventsourcig/blob/main/eventsourcing/src/main/java/com/charroux/eventsourcing/Aggregate.java
### Entity
https://github.com/charroux/eventsourcig/blob/main/eventsourcing/src/main/java/com/charroux/eventsourcing/Entity.java
### Car
https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/Car.java


# eventsourcig



docker run --name mongodb -d -p 27017:27017 mongodb/mongodb-community-server:6.0-ubi8

docker stop mongodb && docker rm mongodb

