package com.senla.lesson5.task1.services;

import com.senla.lesson5.task1.interfaces.IOpportunityService;
import com.senla.lesson5.task1.repositories.OpportunityRepository;

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
}
