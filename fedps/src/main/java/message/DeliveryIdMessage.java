package message;

import javax.xml.bind.annotation.*;

@XmlType(name="DeliveryIdMessage")
public class DeliveryIdMessage {

	@XmlElement(required=true, name="delivery_id")
	public String delivery_id;
}
