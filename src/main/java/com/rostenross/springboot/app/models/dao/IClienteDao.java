package com.rostenross.springboot.app.models.dao;

import java.util.List;

import com.rostenross.springboot.app.models.entity.Cliente;

public interface IClienteDao {

    public List<Cliente> findAll();
}