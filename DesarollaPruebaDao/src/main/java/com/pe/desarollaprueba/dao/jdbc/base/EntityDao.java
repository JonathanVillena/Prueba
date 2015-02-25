/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.dao.jdbc.base;

import java.util.List;
import com.pe.desarollaprueba.util.SystemException;

/**
 *
 * @author JonathaN
 */
public interface EntityDao<E,J> {
    
    void insertar(E e) throws SystemException;
    void actualizar(E e) throws SystemException;
    void eliminar(J id) throws SystemException;
    E obtener(J id) throws SystemException;
    List<E> listar() throws SystemException;
    
}
