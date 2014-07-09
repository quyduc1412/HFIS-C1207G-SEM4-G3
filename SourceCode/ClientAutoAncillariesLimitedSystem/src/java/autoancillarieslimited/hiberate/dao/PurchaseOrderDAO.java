/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.PurchaseOrder;

/**
 *
 * @author Duc
 */
public class PurchaseOrderDAO extends AbstractDao<PurchaseOrder>{
    private static PurchaseOrderDAO INSTANCE;
    

    public static PurchaseOrderDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PurchaseOrderDAO();
        }
        return INSTANCE;
    }
}
