package repository;

import entities.Entity;
import entities.Opportunity;
import handlers.serialize.Reader;
import storage.PropertiesStorage;

import java.util.List;

public class OpportunityRepository implements IRepository {
    private List<Opportunity> opportunities;

    public static int lastIdOpportunities = 0;

    private PropertiesStorage propertiesStorage;

    private static OpportunityRepository opportunityRepository;

    public static OpportunityRepository getInstance() {
        if (opportunityRepository == null) {
            opportunityRepository = new OpportunityRepository();
        }
        return opportunityRepository;
    }

    private OpportunityRepository() {
        propertiesStorage = PropertiesStorage.getInstance();
        opportunities = (List<Opportunity>) new Reader().readEntitiesFromFile(propertiesStorage.getProperties().getProperty("inputOpportunities"));
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    @Override
    public Opportunity findById(int id) {
        Opportunity opportunity = null;
        for (Opportunity opportunityFind : opportunities) {
            if (opportunityFind.getId() == id) {
                opportunity = opportunityFind;
                break;
            }
        }
        return opportunity;
    }

    @Override
    public List<Opportunity> findAll() {
        return opportunities;
    }

    @Override
    public void save(Entity entity) {
        entity.setId(entity.generateId(lastIdOpportunities));
        lastIdOpportunities++;
        this.opportunities.add((Opportunity) entity);
    }

    @Override
    public long count() {
        return opportunities.size();
    }
}
