package com.senla.lesson5.hotelmanager.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.handlers.TextHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class OpportunityRepository {
    private ArrayList<Opportunity> opportunities;

    public static int lastIdOpportunities = 0;

    private String path = "D:\\inputOpportunities.txt";

    private static final Logger log = Logger.getLogger(OpportunityRepository.class.getName());

    public OpportunityRepository() {
        opportunities = new TextHandler().getOpportunities(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Opportunity> getOpportunities() {
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

    public ArrayList<Opportunity> findAll() {
        return opportunities;
    }

    public void save(Opportunity opportunity) {
        this.opportunities.add(opportunity);
    }

    public long count() {
        return opportunities.size();
    }
}
