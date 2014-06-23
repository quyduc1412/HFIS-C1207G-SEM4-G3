/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.hiberate.dao;

/**
 *
 * @author Duc
 */
public interface IDao<T> {
    public boolean insert(T object) ;
    public boolean deleteByID(int id,Class clazz) ;
    public T getByID(int id,Class clazz) ;
}
