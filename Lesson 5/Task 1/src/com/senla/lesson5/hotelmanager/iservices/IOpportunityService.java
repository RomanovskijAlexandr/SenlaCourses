package com.senla.lesson5.hotelmanager.iservices;

import com.senla.lesson5.hotelmanager.entities.Opportunity;

import java.util.ArrayList;

public interface IOpportunityService {
    public void changeOpportunitiesPrice(int oppotunityId, Integer price);

    public void printOpportunities(ArrayList<Opportunity> opportunities);
}
