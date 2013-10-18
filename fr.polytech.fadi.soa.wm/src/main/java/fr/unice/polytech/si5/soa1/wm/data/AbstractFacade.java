package fr.unice.polytech.si5.soa1.wm.data;

import java.util.List;

import com.db4o.ObjectContainer;

public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    protected abstract ObjectContainer getObjectContainer();
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
	public abstract long autoIncreId();
	
    public abstract void create(T entity);

    public abstract T find(Long id);

    public List<T> findAll() {
        return (List<T>)getObjectContainer().queryByExample(entityClass);
    }
}