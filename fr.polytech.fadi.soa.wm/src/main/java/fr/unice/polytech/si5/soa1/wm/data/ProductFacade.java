package fr.unice.polytech.si5.soa1.wm.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import fr.unice.polytech.si5.soa1.wm.model.Product;

public class ProductFacade extends AbstractFacade<Product> {

	public ProductFacade(ObjectContainer oc) {
		super(Product.class);
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
		for (Product p : this.findAll()) {
			if (p.getId() > maxId) {
				maxId = p.getId();
			}
		}
		return ++maxId;
	}
	
	@Override
	public void create(Product p) {
		p.setId(this.autoIncreId());
		getObjectContainer().store(p);	
	}

	@Override
	public Product find(Long id) {
		ObjectSet resultDepartment = oc.queryByExample(new Product(id));
		return (Product) resultDepartment.next();
	}
}