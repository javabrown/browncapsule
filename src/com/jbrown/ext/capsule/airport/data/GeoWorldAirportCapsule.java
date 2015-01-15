package com.jbrown.ext.capsule.airport.data;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

 
public class GeoWorldAirportCapsule  implements AirportCapsuleI, Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Map<String, String>> _worldAirportData;
  
	public List<Map<String, String>> getAirportsList(){
        return new ArrayList<Map<String, String>>(_worldAirportData);
	}
	
	public List<Map<String, String>> getAirportByIATACode(String lookupIataCode) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (Map<String, String> map : _worldAirportData) {
			String name = map.get(IATA_CODE);

			if (name != null && name.equalsIgnoreCase(lookupIataCode)) {
				list.add(new HashMap(map));
				break;
			}
		}

		return list;
	}
	
	public List<Map<String, String>> getAirportByName(String lookupAirportName) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (Map<String, String> map : _worldAirportData) {
			String name = map.get(NAME);

			if (name != null && name.equalsIgnoreCase(lookupAirportName)) {
				list.add(new HashMap(map));
			}
		}

		return list;
	}
 
	
	public GeoWorldAirportCapsule() throws Exception {
		String airportData = "<airports><airport><id>6523</id><ident>00A</ident><type>heliport</type><name>Total Rf Heliport</name><latitude_deg>40.07080078</latitude_deg><longitude_deg>-74.93360138</longitude_deg><elevation_ft>11</elevation_ft><continent>NA</continent><iso_country>US</iso_country><iso_region>US-PA</iso_region><municipality>Bensalem</municipality><scheduled_service>no</scheduled_service><gps_code>00A</gps_code><iata_code></iata_code><local_code>00A</local_code></airport></airports>";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document airportDocument = 
		   db.parse(new ByteArrayInputStream(airportData.getBytes("UTF-8")));
		
		_worldAirportData = getWorldAirportData(airportDocument);
	}

	private List<Map<String, String>> getWorldAirportData(Document doc) {
		NodeList nList = doc.getElementsByTagName("airport");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
		 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Map<String, String> map = new HashMap<String, String>();
				Element eElement = (Element) nNode;
				map.put(ID, eElement.getElementsByTagName(ID)
						.item(0).getTextContent());
				map.put(IDENT, eElement.getElementsByTagName(IDENT)
						.item(0).getTextContent());
				map.put(TYPE, eElement.getElementsByTagName(TYPE)
						.item(0).getTextContent());
				map.put(NAME, eElement.getElementsByTagName(NAME)
						.item(0).getTextContent());
				map.put(LATITUDE, eElement.getElementsByTagName(LATITUDE)
						.item(0).getTextContent());
				map.put(LONGITUDE, eElement.getElementsByTagName(LONGITUDE)
						.item(0).getTextContent());
				map.put(ELEVATION_FT, eElement.getElementsByTagName(ELEVATION_FT)
						.item(0).getTextContent());
				map.put(CONTINENT, eElement.getElementsByTagName(CONTINENT)
						.item(0).getTextContent());
				map.put(ISO_COUNTRY, eElement.getElementsByTagName(ISO_COUNTRY)
						.item(0).getTextContent());				
				map.put(ISO_REGION, eElement.getElementsByTagName(ISO_REGION)
						.item(0).getTextContent());	
				map.put(MUNICIPALITY, eElement.getElementsByTagName(MUNICIPALITY)
						.item(0).getTextContent());	
				map.put(SCHEDULED_SERVICE, eElement.getElementsByTagName(SCHEDULED_SERVICE)
						.item(0).getTextContent());	
				map.put(GPS_CODE, eElement.getElementsByTagName(GPS_CODE)
						.item(0).getTextContent());	
				map.put(IATA_CODE, eElement.getElementsByTagName(IATA_CODE)
						.item(0).getTextContent());	
				map.put(LOCAL_CODE, eElement.getElementsByTagName(LOCAL_CODE)
						.item(0).getTextContent());
				
				list.add(map);
			}
		}

		return list;
	}
	
	private final String ID = "id";
	private final String IDENT = "ident";
	private final String TYPE = "type";
	private final String NAME = "name";
	private final String LATITUDE= "latitude_deg";
	private final String LONGITUDE= "longitude_deg";
	private final String ELEVATION_FT = "elevation_ft";
	private final String CONTINENT = "continent";
	private final String ISO_COUNTRY = "iso_country";
	private final String ISO_REGION = "iso_region";
	private final String MUNICIPALITY = "municipality";
	private final String SCHEDULED_SERVICE = "scheduled_service";
	private final String GPS_CODE = "gps_code";
	private final String IATA_CODE = "iata_code";
	private final String LOCAL_CODE = "local_code";
	
	public static void main(String[] xx) throws Exception{
		GeoWorldAirportCapsule capsule = new GeoWorldAirportCapsule();
		System.out.println(capsule.getAirportsList());
		System.out.println(capsule.getAirportByName("Total Rf Heliport"));
		
	}
}

