package Interfaces;

import java.util.List;
public interface GenericDao<Entity, PK> {
    List<Entity> findAll();
    Entity findById(PK id);
    Entity save(Entity entity);
    Entity update(Entity entity);
    boolean remove(PK id);
}