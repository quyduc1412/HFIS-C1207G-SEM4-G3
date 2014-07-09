/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc
 */
public class CartBussiness {

    private List<CartItem> list;

    public CartBussiness() {
        list = new ArrayList<>();
    }

    public List<CartItem> getList() {
        return list;
    }

    public void addItem(Item item) {
        for (CartItem cartItem : list) {
            if (item.getId() == cartItem.getItem().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return;
            }
        }
        Item byID = ProductDAO.getInstance().getByID(item.getId(), Item.class);
        list.add(new CartItem(byID, 1));
    }

    public void removeItem(int id) {
        for (CartItem cartItem : list) {
            if (id == cartItem.getItem().getId()) {
                list.remove(cartItem);
                return;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem cartItem : list) {
            total += cartItem.getItem().getPrice() * cartItem.getQuantity();
        }
        return total;
    }

    public int getTotalQuantity() {
        int total = 0;
        for (CartItem cartItem : list) {
            total += cartItem.getQuantity();
        }
        return total;
    }

    public int getCount() {
        return list.size();
    }

}
