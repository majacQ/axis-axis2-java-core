/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.axis2.rest;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Call;
import org.apache.axis2.engine.util.TestConstants;
import org.apache.axis2.om.OMAbstractFactory;
import org.apache.axis2.om.OMElement;
import org.apache.axis2.om.OMFactory;
import org.apache.axis2.om.OMNamespace;
import org.apache.axis2.om.impl.llom.builder.StAXOMBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import junit.framework.TestCase;

/**
 * Sample for synchronous single channel blocking service invocation.
 * Message Exchage Pattern IN-OUT
 */
public class PostTest extends TestCase implements TestConstants{
    //private static EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/MyService");
	//private static EndpointReference targetEPR = new EndpointReference("http://127.0.0.1:80/axis2/services/MyService");
    private static EndpointReference targetEPR = new EndpointReference("http://127.0.0.1:8070/onca/xml");
    
    public void testRESTPost() throws Exception{
        try {
           // OMElement payload = ClientUtil.getEchoOMElement();
        	/*OMFactory fac = OMAbstractFactory.getOMFactory();
            OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "example1");
            OMElement payload = fac.createOMElement("echo", omNs);
            OMElement value = fac.createOMElement("Text", omNs);
            value.addChild(fac.createText(value, "Hello"));
            payload.addChild(value);*/

        	String  xml = 
        		"<websearch>"+
        		"<Service>AWSECommerceService</Service>"+
        		"<SubscriptionId>03WM83XFMP0X52C7A9R2</SubscriptionId>"+
        		"<Operation>ItemSearch</Operation>"+
        		"<SearchIndex>Books</SearchIndex>"+
        		"<Keywords>Sanjiva,Web,Services</Keywords>"+
        		"<ResponseGroup>Request,Small</ResponseGroup>"+
        		"</websearch>";
        	
        	byte arr[] = xml.getBytes();
        	ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        	
        	XMLStreamReader reader = null;
        	try {
        		XMLInputFactory xif= XMLInputFactory.newInstance();
        		reader= xif.createXMLStreamReader(bais);
        	} catch (XMLStreamException e) {
        		e.printStackTrace();
        	}
        	StAXOMBuilder builder= new StAXOMBuilder(reader);
        	OMElement websearch = builder.getDocumentElement();
        	
        	Call call = new Call();
            call.setTo(targetEPR);
            call.setTransportInfo(Constants.TRANSPORT_HTTP,Constants.TRANSPORT_HTTP,false);
            call.set(Constants.Configuration.ENABLE_REST,Constants.VALUE_TRUE);
            //call.set(Constants.Configuration.ENABLE_REST_THROUGH_GET,Constants.VALUE_TRUE);
            call.set("content Type","application/x-www-form-urlencoded");

            //Blocking invocation
            //OMElement result = call.invokeBlocking("echo",payload);
            OMElement result = call.invokeBlocking("echo",websearch);

            StringWriter writer = new StringWriter();
            result.serialize(XMLOutputFactory.newInstance()
                    .createXMLStreamWriter(writer));
            writer.flush();

            System.out.println(writer.toString());

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    }

