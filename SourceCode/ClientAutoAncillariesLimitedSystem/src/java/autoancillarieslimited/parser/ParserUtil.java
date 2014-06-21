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
            String name = (String) jsonObject.get("P0");
            String description = (String) jsonObject.get("P2");
            int category = Integer.parseInt((String) jsonObject.get("P1"));
            double price = Double.parseDouble((String) jsonObject.get("P3"));
            i.setName(name);
            i.setDescription(description);
            i.setPrice(price);
            i.setDate_Created(new Date());
            TypeItem typeItemByID = ProductDAO.getInstance().getTypeItemByID(category);
            i.setTypeItem(typeItemByID);
        } catch (ParseException ex) {
            Logger.getLogger(ParserUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
