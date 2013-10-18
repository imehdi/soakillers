package fr.unice.polytech.si5.soa1.wm.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import fr.unice.polytech.si5.soa1.wm.model.Aisle;

public class AisleFacade extends AbstractFacade<Aisle> {

	public AisleFacade(ObjectContainer oc) {
		super(Aisle.class);
		this.oc = oc;
	}

	private ObjectContainer oc;

	@Override
	protected ObjectContainer getObjectContainer() {
		return oc;
	}
	
	@Override
	public long autoIncreId() {
		long maxId = 0;
		for (Aisle ai : this.findAll()) {
			if (ai.getId() > maxId) {
				maxId = ai.getId();
			}
		}
		return ++maxId;
	}
	
	@Override
	public void create(Aisle ai) {
		ai.setId(this.autoIncreId());
		getObjectContainer().store(ai);	
	}
	
	@Override
	public Aisle find(Long id) {
		ObjectSet resultDepartment = oc.queryByExample(new Aisle(id));
		return (Aisle) resultDepartment.next();
	}
}