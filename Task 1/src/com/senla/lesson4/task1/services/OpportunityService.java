package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.comparators.OpportunityComparators;
import com.senla.lesson4.task1.interfaces.IOpportunityService;
import com.senla.lesson4.task1.repositories.OpportunityRepository;

import java.text.ParseException;
import java.util.Arrays;

public class OpportunityService implements IOpportunityService {
    private OpportunityRepository opportunityRepository = new OpportunityRepository();

    public OpportunityService() throws ParseException {
    }

    public OpportunityRepository getOpportunityRepository() {
        return opportunityRepository;
    }

    @Override
    public void sortOpportunitiesByPrice() {
        Arrays.sort(opportunityRepository.getOpportunities(), new OpportunityComparators().getOpportunityByPriceComparator());
    }

    @Override
    public void changeOpportunitiesPrice(int oppotunityId, Integer price) {
        opportunityRepository.findById(oppotunityId).setPrice(price);
    }
}
