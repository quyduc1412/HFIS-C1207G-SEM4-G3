/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.parser;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.TypeItem;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

/**
 *
 * @author Duc
 */
public class ParserUtil {

    public static Item parserItem(String dataJson) {
        Item i = new Item();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataJson);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject itemObject = (JSONObject) jsonObject.get("__data");
            String name = (String) itemObject.get("name");
            String description = (String) itemObject.get("description");
            int category = Integer.parseInt((String) itemObject.get("category"));
            double price = Double.parseDouble((String) itemObject.get("price"));
            i.setName(name);
            i.setDescription(description);
            i.setPrice(price);
            i.setDate_Created(new Date());
            TypeItem typeItemByID = ProductDAO.getInstance().getTypeItemByID(category);
            System.out.println(typeItemByID.getItems());
            i.setTypeItem(typeItemByID);
        } catch (ParseException ex) {
            Logger.getLogger(ParserUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public static void main(String[] args) {
        Item parserItem = parserItem("{\"__data\":{\"name\":\"sfasfasf\",\"description\":\"\",\"category\":\"0\",\"price\":\"123\"}}");
        ProductDAO.getInstance().saveItem(parserItem);
    }
}
