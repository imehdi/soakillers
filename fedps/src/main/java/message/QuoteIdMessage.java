package message;

import javax.xml.bind.annotation.*;

@XmlType(name="QuoteIdMessage")
public class QuoteIdMessage {

	@XmlElement(required=true, name="quote_id")
	public String quote_id;
}
