package DAOs.TravelGateXDAOs;

import Beans.TravelGateXBeans.ResponseAPIJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by George on 04/07/2018.
 */
public class StaticContentDAOs {

    public static ResponseAPIJSON destinations() {

        String request="   {  \"query\":  \" { hotelX { destinations(criteria: {access: \\\"490\\\"},relay: {}) {   edges {node {code destinationData {code available parent  type texts {  text } } error { code type description     } } } } } } \"     }";
        String response=CurlRequest.request(request);
        //System.out.print("1111111  "+response+"  22222222");

        ResponseAPIJSON destinationsAPIJSON=new ResponseAPIJSON();
        ObjectMapper mapper = new ObjectMapper();
        try {
            destinationsAPIJSON = mapper.readValue(response, ResponseAPIJSON.class);
        }catch(IOException e){

            e.printStackTrace();
        }
        return destinationsAPIJSON;
    }


    public static Beans.TravelGateXBeans.ResponseAPIJSON roomtypes() {

        String request="   {  \"query\":  \"  { hotelX { rooms ( criteria:  {access:  \\\"490\\\"}, relay: {}) { edges { node {  roomData { roomCode texts { text language } } error { code type description } } } } } }  \"     }";
        String response=CurlRequest.request(request);
       // System.out.print("1111111  "+response+"  22222222");

        ResponseAPIJSON roomTypesAPIJSON=new ResponseAPIJSON();
        ObjectMapper mapper = new ObjectMapper();
        try {
            roomTypesAPIJSON = mapper.readValue(response, ResponseAPIJSON.class);
        }catch(IOException e){

            e.printStackTrace();
        }
        return roomTypesAPIJSON;
    }


    public static Beans.TravelGateXBeans.ResponseAPIJSON boards() {

        String request="   {  \"query\":  \"  { hotelX { boards(criteria: { access: \\\"490\\\" }, relay: {}) { edges { node { boardData { boardCode texts { text language  } } error {  description  code } } } } } }  \"     }";
        String response=CurlRequest.request(request);
        // System.out.print("1111111  "+response+"  22222222");

        ResponseAPIJSON  boardsAPIJSON=new ResponseAPIJSON();
        ObjectMapper mapper = new ObjectMapper();
        try {
            boardsAPIJSON = mapper.readValue(response, ResponseAPIJSON.class);
        }catch(IOException e){

            e.printStackTrace();
        }
        return boardsAPIJSON;
    }

    public static ResponseAPIJSON hotels(String destinationCode) {

        String request="   {  \"query\":  \"  { hotelX { hotels(criteria: { access: \\\"490\\\", destinationCodes:[\\\""+destinationCode+"\\\"] }, token: \\\"\\\", relay: {}) {  edges { node { error { code type description } hotelData {  hotelCode hotelCodeSupplier hotelName   categoryCode chainCode property { name code } exclusiveDeal  location {  address city country  coordinates { latitude longitude }  closestDestination { code available texts(languages: \\\"en\\\") { text  language }  } } contact { email telephone fax  web } rank  cardTypes  amenities { code type  texts(languages: \\\"en\\\") {  text language }  } medias {  code  order  type updatedAt  url  texts(languages: \\\"en\\\") { text  language }  } descriptions(types: GENERAL,languages:\\\"en\\\") { type  texts {  text language }  }  }  } } } } }  \"     }";
        String response=CurlRequest.request(request);
        // System.out.print("1111111  "+response+"  22222222");

        ResponseAPIJSON  hotelsAPIJSON=new ResponseAPIJSON();
        ObjectMapper mapper = new ObjectMapper();
        try {
            hotelsAPIJSON = mapper.readValue(response, ResponseAPIJSON.class);
        }catch(IOException e){

            e.printStackTrace();
        }
        return hotelsAPIJSON;
    }

    public static ResponseAPIJSON search(String checkIn, String checkOut,String hotelsIds,String nationality,String paxes,String currency) {

        String request="   {  \"query\":  \" {hotelX { search (criteria: { checkIn: \\\""+checkIn+"\\\", checkOut: \\\""+checkOut+"\\\", hotels: [ "+hotelsIds+" ], occupancies: [ { paxes: [ "+paxes+" ] } ], language: \\\"en\\\", nationality: \\\""+nationality+"\\\", currency: \\\""+currency+"\\\", market: \\\""+nationality+"\\\" }, settings: { suppliers: null, businessRules: null, timeout: 24700, context: \\\"HOTELTEST\\\", client: \\\"atbholidays\\\", auditTransactions: true, testMode: true }, filter: { access: { includes: [ \\\"490\\\" ] } }) {  options {   market hotelCode  hotelName  boardCode  status  rooms {  code description refundable units roomPrice { price { currency binding net gross   } } beds { type description count shared } ratePlans { code name effectiveDate  expireDate }  }     cancelPolicy { refundable cancelPenalties { hoursBefore  penaltyType currency value } } remarks token id } errors { code  type description } warnings { code type description } } } }\"     }";
        String response=CurlRequest.request(request);
        //System.out.print("1111111  "+response+"  22222222");

        ResponseAPIJSON  searchAPIJSON=new ResponseAPIJSON();
        ObjectMapper mapper = new ObjectMapper();
        try {
            searchAPIJSON = mapper.readValue(response, ResponseAPIJSON.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return searchAPIJSON;
    }

    }
