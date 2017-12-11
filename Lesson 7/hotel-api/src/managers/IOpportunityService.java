package managers;

import entities.Opportunity;

import java.util.Comparator;

public interface IOpportunityService {
    public void changeOpportunitiesPrice(int oppotunityId, Integer price);

    public void sortOpportunities(Comparator<Opportunity> comparator);
}
