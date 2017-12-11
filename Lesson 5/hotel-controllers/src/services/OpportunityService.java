package services;

import entities.Entity;
import entities.Opportunity;
import repository.IRepository;
import repository.OpportunityRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OpportunityService implements IOpportunityService {
    private IRepository opportunityRepository = OpportunityRepository.getInstance();

    public OpportunityService() {
    }

    public OpportunityRepository getOpportunityRepository() {
        return (OpportunityRepository) opportunityRepository;
    }

    @Override
    public void changeOpportunitiesPrice(int oppotunityId, Integer price) {
        Opportunity opportunity = (Opportunity) opportunityRepository.findById(oppotunityId);
        opportunity.setPrice(price);
    }

    @Override
    public void sortOpportunities(Comparator<Opportunity> comparator) {
        OpportunityRepository opportunityRepository = (OpportunityRepository) this.opportunityRepository;
        Collections.sort(opportunityRepository.getOpportunities(), comparator);
    }

    //OpportunityRepository

    public Opportunity findById(int id) {
        return (Opportunity) opportunityRepository.findById(id);
    }

    public List<Opportunity> findAll() {
        return (List<Opportunity>) opportunityRepository.findAll();
    }

    public void save(Entity entity) {
        opportunityRepository.save(entity);
    }

    public long count() {
        return opportunityRepository.count();
    }

    public void setPath(String path) {
        opportunityRepository.setPath(path);
    }

    public String getPath() {
        return opportunityRepository.getPath();
    }
}
