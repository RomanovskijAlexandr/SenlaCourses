package com.senla.lesson4.task1.interfaces;

import com.senla.lesson4.task1.repositories.OpportunityRepository;

public interface IOpportunityService {
    public void sortOpportunitiesByPrice();

    public void changeOpportunitiesPrice(int oppotunityId, Integer price);
}
