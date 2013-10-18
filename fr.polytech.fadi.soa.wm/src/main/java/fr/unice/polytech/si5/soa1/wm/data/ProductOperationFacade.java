package fr.unice.polytech.si5.soa1.wm.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import fr.unice.polytech.si5.soa1.wm.model.ProductOperation;

public class ProductOperationFacade extends AbstractFacade<ProductOperation> {

	public ProductOperationFacade(ObjectContainer oc) {
		super(ProductOperation.class);
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
		for (ProductOperation pO : this.findAll()) {
			if (pO.getId() > maxId) {
				maxId = pO.getId();
			}
		}
		return ++maxId;
	}

	@Override
	public void create(ProductOperation oP) {
		oP.setId(this.autoIncreId());
		getObjectContainer().store(oP);
	}

	@Override
	public ProductOperation find(Long id) {
		ObjectSet resultDepartment = oc
				.queryByExample(new ProductOperation(id));
		return (ProductOperation) resultDepartment.next();
	}
}