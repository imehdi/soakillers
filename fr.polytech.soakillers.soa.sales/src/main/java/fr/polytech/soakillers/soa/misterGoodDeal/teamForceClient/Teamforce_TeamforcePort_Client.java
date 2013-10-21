
package fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2013-10-20T13:39:53.114+02:00
 * Generated source version: 2.5.1
 * 
 */
public final class Teamforce_TeamforcePort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.teamforce.soa.mehdi.polytech.fr/", "ITeamForceService");

    private Teamforce_TeamforcePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ITeamForceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ITeamForceService ss = new ITeamForceService(wsdlURL, SERVICE_NAME);
        Teamforce port = ss.getTeamforcePort();  
        
        {
        System.out.println("Invoking addCustomer...");
        fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient.CustomerRequest _addCustomer_customer = null;
        fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient.CustomerResponse _addCustomer__return = port.addCustomer(_addCustomer_customer);
        System.out.println("addCustomer.result=" + _addCustomer__return);


        }
        {
        System.out.println("Invoking addOrder...");
        fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient.OrderRequest _addOrder_newOrder = null;
        fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient.OrderResponse _addOrder__return = port.addOrder(_addOrder_newOrder);
        System.out.println("addOrder.result=" + _addOrder__return);


        }

        System.exit(0);
    }

}