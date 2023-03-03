package com.charroux.eventsourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AggregateController {

    AggregateDAL aggregateDAL;

    @Autowired
    public AggregateController(AggregateDAL aggregateDAL) {
        this.aggregateDAL = aggregateDAL;
    }

    @PostMapping("/")
    public Aggregate addNewAggregate(@RequestBody Aggregate aggregate){
        return aggregateDAL.addNewAggregate(aggregate);
    }

    @GetMapping("/")
    public List<Aggregate> litsAggregates(){
        return aggregateDAL.getAllAggregates();
    }

}
