package fr.unice.polytech.si5.SOA;

import javax.xml.bind.annotation.*;

@XmlType(name="DeliveryResponse")
public class DeliveryResponse {

	@XmlElement(required=true, name="delivery_id")
	public String delivery_id;
}
