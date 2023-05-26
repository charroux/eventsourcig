# Domain Driven Design and Event Sourcing

<div id="user-content-toc">
  <ul>
    <li><a href="#domain-driven-design">1. Domain Driven Design</a>

    </li>
  </ul>
</div>

## Domain Driven Design

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

# Message Oriented Middleware with RabbitMQ stream
<img src="images/rabbitmq_stream.png">

https://www.rabbitmq.com/streams.html

## Publisher
https://github.com/charroux/eventsourcig/blob/main/stream/src/main/java/com/charroux/stream/EventPublisher.java
## Consumer
https://github.com/charroux/eventsourcig/blob/main/stream/src/main/java/com/charroux/stream/EventConsumer.java

# Event sourcig
## Event sourcing

## The event sourcing pattern
<img src="images/eventsourcing_pattern.png">

https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/RentalServiceImpl.java

## Apply vs Process
<img src="images/apply_vs_process.png">

https://github.com/charroux/eventsourcig/blob/main/carservice/src/main/java/com/charroux/carservice/RentalAgreement.java

# How to?

docker run --name mongodb -d -p 27017:27017 mongodb/mongodb-community-server:6.0-ubi8

docker stop mongodb && docker rm mongodb

