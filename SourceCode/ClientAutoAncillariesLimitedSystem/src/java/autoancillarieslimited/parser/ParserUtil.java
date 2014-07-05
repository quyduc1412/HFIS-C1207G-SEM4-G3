/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.parser;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.TypeItem;
import autoancillarieslimited.hiberate.entities.WareHouses;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Duc
 */
public class ParserUtil {

    public static Item parserItem(String dataJson) {
        try {
            Item i = new Item();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataJson);
            JSONObject jsonObject = (JSONObject) obj;
            int id = Integer.parseInt((String) jsonObject.get("P0"));
            String name = (String) jsonObject.get("P1");
            String description = (String) jsonObject.get("P3");
            int category = Integer.parseInt((String) jsonObject.get("P2"));
            double price = Double.parseDouble((String) jsonObject.get("P4"));
            String images = (String) jsonObject.get("P6");
            //     String imagesData
            i.setId(id);
            i.setName(name);
            i.setDescription(description);
            i.setPrice(price);
            i.setDate_Created(new Date());
            TypeItem typeItemByID = ProductDAO.getInstance().getTypeItemByID(category);
            i.setTypeItem(typeItemByID);
            i.setType_ID(category);
            i.setImages(images);
            return i;
        } catch (Exception ex) {
            return null;
        }
    }

    public static Employee parserEmployeeFromJSON(String dataJson) {
        try {
            Employee i = new Employee();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataJson);
            JSONObject jsonObject = (JSONObject) obj;
            int id = Integer.parseInt((String) jsonObject.get("P0"));
            int warehouse_id = Integer.parseInt((String) jsonObject.get("P1"));
            String email = (String) jsonObject.get("P2");
            String password = (String) jsonObject.get("P3");
            String name = (String) jsonObject.get("P4");
            String address = (String) jsonObject.get("P5");
            String phone = (String) jsonObject.get("P6");
            i.setId(id);
            i.setEmail(email);
            i.setPassword(password);
            i.setName(name);
            i.setAddress(address);
            i.setPhone(phone);
            WareHouses houses = WareHousesDAO.getInstance().getByID(warehouse_id, WareHouses.class);
            i.setWareHouses(houses);
            return i;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String parserItemJSon(Item item) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("P0", item.getId());
        jSONObject.put("P1", item.getName());
        jSONObject.put("P3", item.getDescription());
        jSONObject.put("P2", item.getTypeItem().getId());
        jSONObject.put("P4", item.getPrice());
        jSONObject.put("P6", item.getImages());
        return jSONObject.toString();
    }

    public static WareHouses parserWarehouses(String dataJson) {
        try {
            WareHouses i = new WareHouses();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataJson);
            JSONObject jsonObject = (JSONObject) obj;
            int id = Integer.parseInt((String) jsonObject.get("P0"));
            String name = (String) jsonObject.get("P1");
            String address = (String) jsonObject.get("P2");
            String phone = (String) jsonObject.get("P3");
            String email = (String) jsonObject.get("P4");
            int region_ID = Integer.parseInt((String) jsonObject.get("P5"));
            i.setId(id);
            i.setName(name);
            i.setAddress(address);
            i.setPhone(phone);
            i.setEmail(email);
            i.setRegion_ID(region_ID);
            return i;
        } catch (Exception ex) {
            return null;
        }
    }
}
