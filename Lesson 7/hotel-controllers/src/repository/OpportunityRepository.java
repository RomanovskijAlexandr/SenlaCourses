package repository;

import entities.Entity;
import entities.Opportunity;
import handlers.serialize.Reader;
import storages.IRepository;
import storage.PropertiesStorage;

import java.io.IOException;
import java.util.List;

public class OpportunityRepository implements IRepository {
    private List<Opportunity> opportunities;

    public static int lastIdOpportunities = 0;

    private PropertiesStorage propertiesStorage;

    private String path = null;

    private static OpportunityRepository opportunityRepository;

    public static OpportunityRepository getInstance() throws IOException {
        if (opportunityRepository == null) {
            opportunityRepository = new OpportunityRepository();
        }
        return opportunityRepository;
    }

    private OpportunityRepository() throws IOException {
        propertiesStorage = PropertiesStorage.getInstance();
        if(path==null)
            path = propertiesStorage.getProperties().getProperty("inputOpportunities");
        opportunities = (List<Opportunity>) new Reader().readEntitiesFromFile(path);
    }

    @Override
    public void setPath(String path) {
        this.path = path;
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
