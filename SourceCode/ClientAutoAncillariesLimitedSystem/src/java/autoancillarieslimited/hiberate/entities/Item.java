package autoancillarieslimited.hiberate.entities;
// Generated Jul 1, 2014 11:22:27 AM by Hibernate Tools 3.6.0

import java.io.Serializable;
import java.util.Date;

/**
 * Item generated by hbm2java
 */
public class Item implements java.io.Serializable {

    private int id;
    private TypeItem typeItem;
    private String name;
    private String description;
    private Double price;
    private Date date_Created;
    private int type_ID;
    private String images;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, TypeItem typeItem, String name, String description, Double price, Date date_Created, int type_ID, String images) {
        this.id = id;
        this.typeItem = typeItem;
        this.name = name;
        this.description = description;
        this.price = price;
        this.date_Created = date_Created;
        this.type_ID = type_ID;
        this.images = images;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeItem getTypeItem() {
        return this.typeItem;
    }

    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getDate_Created() {
        return date_Created;
    }

    public void setDate_Created(Date date_Created) {
        this.date_Created = date_Created;
    }

    public int getType_ID() {
        return type_ID;
    }

    public void setType_ID(int type_ID) {
        this.type_ID = type_ID;
    }

}
