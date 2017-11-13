package services;

import api.IOpportunityService;
import entities.Entity;
import entities.Opportunity;
import repositories.OpportunityRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public void sortOpportunities(Comparator<Opportunity> comparator){
        Collections.sort(opportunityRepository.getOpportunities(), comparator);
    }

    //OpportunityRepository

    public Opportunity findById(int id){
        return opportunityRepository.findById(id);
    }

    public List<Opportunity> findAll(){
        return opportunityRepository.findAll();
    }

    public void save(Entity entity){
        opportunityRepository.save(entity);
    }

    public long count(){
        return opportunityRepository.count();
    }
}
