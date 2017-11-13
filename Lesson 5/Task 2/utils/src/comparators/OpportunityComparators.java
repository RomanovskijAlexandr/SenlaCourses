package comparators;

import entities.Opportunity;

import java.util.Comparator;

public class OpportunityComparators {
    private Comparator<Opportunity> opportunityByPriceComparator = new Comparator<Opportunity>() {
        @Override
        public int compare(Opportunity opportunity1, Opportunity opportunity2) {
            if (opportunity1 != null && opportunity2 != null)
                return opportunity1.getPrice().compareTo(opportunity2.getPrice());
            else if (opportunity1 != null && opportunity2 == null) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public Comparator<Opportunity> getOpportunityByPriceComparator() {
        return opportunityByPriceComparator;
    }
}
