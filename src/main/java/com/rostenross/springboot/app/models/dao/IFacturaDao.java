package com.rostenross.springboot.app.models.dao;

import com.rostenross.springboot.app.models.entity.Factura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository <Factura, Long>{

    //Se implementa esta busqueda por ser mas optimizada.
    @Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id =?1")
    public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
    
}