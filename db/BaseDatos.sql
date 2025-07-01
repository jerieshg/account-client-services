drop
  table if exists devsu_api.movimientos cascade;
drop
   table if exists devsu_api.clientes cascade;
drop
  table if exists devsu_api.cuentas cascade;

create table devsu_api.clientes (
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

create table devsu_api.cuentas (
  numero_de_cuenta bigint NOT NULL unique,
  saldo_inicial numeric(38, 2) NOT NULL,
  status boolean NOT NULL,
  cliente_id bigint NOT NULL,
  account_type varchar(255) NOT NULL,
  foreign key (cliente_id) references clientes(cliente_id),
  primary key (numero_de_cuenta)
);

create table devsu_api.movimientos (
  movimiento_id bigint NOT NULL AUTO_INCREMENT,
  fecha date NOT NULL,
  valor numeric(38, 2) NOT NULL,
  numero_de_cuenta bigint NOT NULL,
  tipo_de_movimiento varchar(255) NOT NULL,
  foreign key (numero_de_cuenta) references cuentas(numero_de_cuenta),
  primary key (movimiento_id)
);

insert into devsu_api.clientes(
  NOMBRE, GENERO, EDAD, IDENTIFICACION,
  DIRECCION, TELEFONO, PASSWORD, STATUS
)
values
  (
    'Jose Lema', 'Masculino', 33, '0000-1111-22222',
    'San Pedro Sula', '3133-0501', '12345',
    true
  );

insert into devsu_api.cuentas(
  NUMERO_DE_CUENTA, ACCOUNT_TYPE, SALDO_INICIAL,
  STATUS, CLIENTE_ID
)
values
  (
    102301230, 'Savings', '600', true,
    1
  );

insert into devsu_api.movimientos(
    FECHA, VALOR, NUMERO_DE_CUENTA, tipo_de_movimiento
)
values
  (
  '2025-06-30', 500, 102301230, 'Deposito de 500'
  )
