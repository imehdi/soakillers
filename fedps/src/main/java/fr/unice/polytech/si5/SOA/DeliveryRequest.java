package fr.unice.polytech.si5.SOA;

import javax.xml.bind.annotation.*;


@XmlType(name="DeliveryRequest")
public class DeliveryRequest {

	@XmlElement(required=true, name="pickup")
	public String pickup;	
	
	@XmlElement(required=true, name="delivery")
	public String delivery;
	
	@XmlElement(required=true, name="dimension_length")
	public String dimension_long;	
	
	@XmlElement(required=true, name="dimension_width")
	public String dimension_width;
	
	@XmlElement(required=true, name="dimension_height")
	public String dimension_height;
	
	@XmlElement(required=true, name="weight")
	public String weight;
	
}
