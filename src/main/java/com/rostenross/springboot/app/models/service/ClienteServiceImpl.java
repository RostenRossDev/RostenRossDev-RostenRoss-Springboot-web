package com.rostenross.springboot.app.models.service;

import java.util.List;

import com.rostenross.springboot.app.models.dao.IClienteDao;
import com.rostenross.springboot.app.models.dao.IFacturaDao;
import com.rostenross.springboot.app.models.dao.IProductoDao;
import com.rostenross.springboot.app.models.entity.Cliente;
import com.rostenross.springboot.app.models.entity.Factura;
import com.rostenross.springboot.app.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IFacturaDao facturaDdao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente fetchByIdWithFacturas(Long id) {

        return clienteDao.fetchByIdWithFacturas(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {

        return clienteDao.findAll(pageable);
    }

    @Override
    public List<Producto> findByNombre(String term) {

        return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
    }

    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        facturaDdao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoById(Long id) {

        return productoDao.findById(id).orElse(null);
    }

	@Override
	public Factura findFacturaById(Long id) {
		return facturaDdao.findById(id).orElse(null);
	}

    @Override
    @Transactional
    public void deleteFactura(Long id) {
        facturaDdao.deleteById(id);
    }

    @Override
    @Transactional (readOnly= true)
	public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id) {
		return facturaDdao.fetchByIdWithClienteWithItemFacturaWithProducto(id);
	}

   

}