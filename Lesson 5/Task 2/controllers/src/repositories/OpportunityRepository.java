package repositories;

import api.IRepository;
import com.danco.training.TextFileWorker;
import entities.Entity;
import entities.Opportunity;
import handlers.TextHandler;

import java.util.ArrayList;

public class OpportunityRepository implements IRepository {
    private ArrayList<Opportunity> opportunities;

    public static int lastIdOpportunities = 0;

    private String path = "D:\\inputOpportunities.txt";

    public OpportunityRepository() {
        opportunities = new TextHandler().getOpportunities(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Opportunity> getOpportunities() {
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
    public ArrayList<Opportunity> findAll() {
        return opportunities;
    }

    @Override
    public void save(Entity entity) {
        this.opportunities.add((Opportunity) entity);
    }

    @Override
    public long count() {
        return opportunities.size();
    }
}
