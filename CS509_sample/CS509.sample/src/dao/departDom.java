package dao;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import airport.Airport;
import airport.Airports;
import schedule.Depart;

public class departDom {
	
	public static ArrayList<Depart> addAll (String xmlAirports) throws NullPointerException {
		//Airports airports = new Airports();
		
		// Load the XML string into a DOM tree for ease of processing
		// then iterate over all nodes adding each airport to our collection
		ArrayList<Depart> departLists = new ArrayList<>();
		Document docAirports = buildDomDoc (xmlAirports);
		
		NodeList nodesFlight = docAirports.getElementsByTagName("Flights");
		Element depart = (Element) nodesFlight.item(0);
		NodeList flight = (NodeList) depart.getElementsByTagName("Flight");
	    System.out.println(flight.getLength());
		
		for (int i = 0; i < flight.getLength(); i++) {
			Element elementAirport = (Element) flight.item(i);
			//Element flight;
			//System.out.println(elementAirport);
		//	flight = (Element) elementAirport.getElementsByTagName("Flight");
			 departLists.add(buildAirport (elementAirport));
			
			//if (airport.isValid()) {
				//airports.add(airport);
		//	}
		}
		
		return departLists;
	}
	static private Document buildDomDoc (String xmlString) {
		/**
		 * load the xml string into a DOM document and return the Document
		 */
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xmlString));
			
			return docBuilder.parse(inputSource);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
	}
	static private Depart buildAirport (Node nodeAirport) {
		/**
		 * Instantiate an empty Airport object
		 */
		Depart depart = new Depart();
        String dLocation;
        String dtime, idtime;
        String aLocation;
        String atime;
		String airplane;
		String flightTime;
		String number;
		//double longitude;
		String dcode;
		String acode;
	    String fClass, fPrice;
	    String cClass, cPrice;
		// The airport element has attributes of Name and 3 character airport code
		Element elementAirplane = (Element) nodeAirport;	
		Element departure, arrival, seating, firstClass, coachClass;
		airplane = elementAirplane.getAttributeNode("Airplane").getValue();
		flightTime = elementAirplane.getAttributeNode("FlightTime").getValue();
		number = elementAirplane.getAttributeNode("Number").getValue();
        depart.setAirplane(airplane);
        depart.setFtime(flightTime);
        depart.setNumber(number);
        departure = (Element)elementAirplane.getElementsByTagName("Departure").item(0);
        dcode = departure.getTextContent();
        dLocation = dcode.substring(0, 3);
        dtime = dcode.substring(3);
        idtime = dtime.substring(0, 11);
       // System.out.println(idtime);
        depart.setItime(idtime);
        depart.setdLocation(dLocation);
        depart.setDtime(dtime);
        
        arrival = (Element)elementAirplane.getElementsByTagName("Arrival").item(0);
        acode = arrival.getTextContent();
        aLocation = acode.substring(0, 3);
        atime = acode.substring(3);
        depart.setaLocation(aLocation);
        depart.setAtime(atime);
        
        seating = (Element)elementAirplane.getElementsByTagName("Seating").item(0);
        firstClass = (Element)seating.getElementsByTagName("FirstClass").item(0);
        fClass = firstClass.getTextContent();
        fPrice = firstClass.getAttributeNode("Price").getValue();
        depart.setfClass(fClass);
        depart.setfPrice(fPrice);
        
        coachClass = (Element)seating.getElementsByTagName("Coach").item(0);
        cClass = coachClass.getTextContent();
        cPrice = coachClass.getAttributeNode("Price").getValue();
        depart.setCclass(cClass);
        depart.setcPrice(cPrice);
		//code = getCharacterDataFromElement(departure);
	
		// The latitude and longitude are child elements
		
		
		//elementLatLng = (Element)elementAirplane.getElementsByTagName("Longitude").item(0);
	//	longitude = Double.parseDouble(getCharacterDataFromElement(elementLatLng));

		/**
		 * Update the Airport object with values from XML node
		 */
		//airport.name(name);
		//airport.code(code);
		//airport.latitude(latitude);
		//airport.longitude(longitude);	
		return depart;
	}
	private static String getCharacterDataFromElement (Element e) {
		Node child = e.getFirstChild();
		Node ftime = e.getLastChild();
		String time;
		time = ftime.getNodeValue();
		System.out.println(time);
	    if (child instanceof CharacterData) {
	        CharacterData cd = (CharacterData) child;
	        return cd.getData();
	      }
	      return "";
	}
}
