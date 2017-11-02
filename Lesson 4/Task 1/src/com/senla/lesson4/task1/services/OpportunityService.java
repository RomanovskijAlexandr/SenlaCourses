package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.interfaces.IOpportunityService;
import com.senla.lesson4.task1.repositories.OpportunityRepository;

import java.text.ParseException;

public class OpportunityService implements IOpportunityService {
    private OpportunityRepository opportunityRepository = new OpportunityRepository();

    public OpportunityService() throws ParseException {
    }

    public OpportunityRepository getOpportunityRepository() {
        return opportunityRepository;
    }

    @Override
    public void changeOpportunitiesPrice(int oppotunityId, Integer price) {
        opportunityRepository.findById(oppotunityId).setPrice(price);
    }
}
