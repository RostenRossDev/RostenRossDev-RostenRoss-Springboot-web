/*populate table clientes*/

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Jhon', 'Doe', 'jhon.dow@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Linus', 'Torvalds', 'linus.torvals@gmail.com', '2017-08-01','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Jane', 'Doe', 'jaine.dow@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Erich', 'Helm', 'erich.helm@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Bruno', 'Díaz', 'bruno.diaz@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Jhon', 'Roe', 'jhon.roe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Phillip', 'Webb', 'phillip.doe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Stephane', 'Nicoll', 'stephane.nocill@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juergen', 'Hoeller', 'jurgen.hoeller@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('John', 'Smith', 'john.smith@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Richard', 'Roe', 'richard.roe@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Bruce', 'Wayne', 'bruce.wayne@gmail.com', '2017-08-01', '');

/* Populate tabla productos*/
INSERT INTO productos (nombre, precio, create_at) VALUES ('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas*/
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina',null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2,1,4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura Bicicleta','Alguna nota importante', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3,2,6);

/*populate table users*/

INSERT INTO `users`(username, password, enabled) VALUES('andres','$2a$10$OJyrU2PvsoZQlIW/QTQjY.gxSWQ.D1fU3OK7RkbUpFjq9lKAlDpI.',1);
INSERT INTO `users`(username, password, enabled) VALUES('admin','$2a$10$z5T3.yyZ20aKFJAoeX3efeixy6HxQYSWPm1Qzvw75mWfjpHMQbMoK',1);

/*populate table authorities*/

INSERT INTO `authorities` (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2, 'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2, 'ROLE_ADMIN');
