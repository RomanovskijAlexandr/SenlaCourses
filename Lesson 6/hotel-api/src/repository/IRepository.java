package repository;

import entities.Entity;

import java.util.List;

public interface IRepository {
    public void setPath(String path);

    public Entity findById(int id);

    public List<? extends Entity> findAll();

    public void save(Entity entity);

    public long count();
}
