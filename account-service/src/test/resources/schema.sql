drop
  table if exists movimientos cascade;
drop
   table if exists clientes cascade;
drop
  table if exists cuentas cascade;

create table clientes (
  cliente_id bigint NOT NULL AUTO_INCREMENT,
  edad integer NOT NULL,
  status boolean NOT NULL,
  direccion varchar(255) NOT NULL,
  genero varchar(255),
  identificacion varchar(255) NOT NULL,
  nombre varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  telefono varchar(255) NOT NULL,
  primary key (cliente_id)
);

create table cuentas (
  numero_de_cuenta bigint NOT NULL unique,
  saldo numeric(38, 2) NOT NULL,
  status boolean NOT NULL,
  cliente_id bigint NOT NULL,
  account_type varchar(255) NOT NULL,
  foreign key (cliente_id) references clientes(cliente_id),
  primary key (numero_de_cuenta)
);

create table movimientos (
  movimiento_id bigint NOT NULL AUTO_INCREMENT,
  fecha date NOT NULL,
  saldo_inicial numeric(38, 2) NOT NULL,
  valor numeric(38, 2) NOT NULL,
  numero_de_cuenta bigint NOT NULL,
  tipo_de_movimiento varchar(255) NOT NULL,
  foreign key (numero_de_cuenta) references cuentas(numero_de_cuenta),
  primary key (movimiento_id)
);
