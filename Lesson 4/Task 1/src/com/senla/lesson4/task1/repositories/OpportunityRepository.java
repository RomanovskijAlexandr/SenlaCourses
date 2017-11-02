package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.handlers.ArrayHandler;
import com.senla.lesson4.task1.handlers.TextHandler;
import com.senla.lesson4.task1.entities.Opportunity;

import java.text.ParseException;

public class OpportunityRepository {
    private Opportunity[] opportunities;

    public OpportunityRepository() throws ParseException {
        opportunities = new TextHandler().getOpportunities(new TextFileWorker("D:\\inputOpportunities.txt").readFromFile());
    }

    public Opportunity[] getOpportunities() {
        return opportunities;
    }

    public Opportunity findById(int id) {
        Opportunity opportunity = null;
        for (Opportunity opportunityFind : opportunities) {
            if (opportunityFind.getId() == id) {
                opportunity = opportunityFind;
                break;
            }
        }
        return opportunity;
    }

    public Opportunity[] findAll() {
        return opportunities;
    }

    public void save(Opportunity opportunity) {
        if (!new ArrayHandler().checkArrayForNewElement(opportunities)) {
            opportunities = (Opportunity[]) new ArrayHandler().resizeArray(opportunities);
        }
        opportunities[new ArrayHandler().getPosition(opportunities)] = opportunity;
    }

    public long count() {
        return opportunities.length;
    }
}
