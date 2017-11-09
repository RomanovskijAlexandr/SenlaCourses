package com.senla.lesson5.hotelmanager.services;

import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.iservices.IOpportunityService;
import com.senla.lesson5.hotelmanager.repositories.OpportunityRepository;

import java.util.ArrayList;

public class OpportunityService implements IOpportunityService {
    private OpportunityRepository opportunityRepository = new OpportunityRepository();

    public OpportunityService() {
    }

    public OpportunityRepository getOpportunityRepository() {
        return opportunityRepository;
    }

    @Override
    public void changeOpportunitiesPrice(int oppotunityId, Integer price) {
        opportunityRepository.findById(oppotunityId).setPrice(price);
    }

    @Override
    public void printOpportunities(ArrayList<Opportunity> opportunities) {
        StringBuilder[] sb = new StringBuilder[opportunities.size()];
        for (int i = 0; i < opportunities.size(); i++) {
            if (opportunities.get(i) != null)
                sb[i] = new StringBuilder(opportunities.get(i).toString());
        }
        for (int i = 0; i < opportunities.size(); i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }
}
