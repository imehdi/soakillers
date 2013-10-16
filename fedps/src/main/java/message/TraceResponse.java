package message;


import java.util.Date;

import javax.xml.bind.annotation.*;


@XmlType(name="response")
public class TraceResponse {

	@XmlElement(required=true, name="E2D")
	public Date E2D;	
	
	@XmlElement(required=true, name="location")
	public String location;
	
}
