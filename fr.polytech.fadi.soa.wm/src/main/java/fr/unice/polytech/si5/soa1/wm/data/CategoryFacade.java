package fr.unice.polytech.si5.soa1.wm.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import fr.unice.polytech.si5.soa1.wm.model.Category;

public class CategoryFacade extends AbstractFacade<Category> {

	public CategoryFacade(ObjectContainer oc) {
		super(Category.class);
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
		for (Category ca : this.findAll()) {
			if (ca.getId() > maxId) {
				maxId = ca.getId();
			}
		}
		return ++maxId;
	}
	
	@Override
	public void create(Category ca) {
		ca.setId(this.autoIncreId());
		getObjectContainer().store(ca);	
	}
	
	@Override
	public Category find(Long id) {
		ObjectSet resultDepartment = oc.queryByExample(new Category(id));
		return (Category) resultDepartment.next();
	}
}