package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Opportunity;

import java.util.Comparator;

public class OpportunityComparators {
    private Comparator<Opportunity> opportunityByPriceComparator = new Comparator<Opportunity>() {
        @Override
        public int compare(Opportunity opportunity1, Opportunity opportunity2) {
            return opportunity1.getPrice().compareTo(opportunity2.getPrice());
        }
    };

    public Comparator<Opportunity> getOpportunityByPriceComparator() {
        return opportunityByPriceComparator;
    }
}
