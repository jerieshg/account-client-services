insert into clientes(
      NOMBRE, GENERO, EDAD, IDENTIFICACION,
      DIRECCION, TELEFONO, PASSWORD, STATUS
    )
values(
        'Jose Lema', 'Masculino', 33, '0000-1111-22222',
        'San Pedro Sula', '3133-0501', '12345',
        true
      );

insert into cuentas(
      NUMERO_DE_CUENTA, ACCOUNT_TYPE, SALDO,
      STATUS, CLIENTE_ID
)
values  (102301230, 'Savings', '1100', true, 1 );
