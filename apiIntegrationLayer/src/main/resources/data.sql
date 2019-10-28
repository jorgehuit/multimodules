INSERT INTO CONDICION (id, ID_GENERADO,tipo,titulo,descripcion, texto, estatus)
VALUES (10001, 'COBE00010000', 'COBERTURA', 'SEGURO AUTO', 'SEGURO DE AUTO AMPLIO', 'TEXTO EN NEGRITAS', 1);

INSERT INTO CONDICION  (id, ID_GENERADO,tipo,titulo,descripcion, texto, estatus)
VALUES (10002, 'SERV00010000', 'SERVICIO', 'SEGURO MOTOCICLETA', 'SEGURO DE MOTOCICLETA AMPLIO', 'TEXTO EN NEGRITAS MOTOCICLETA', 1);

--Insert de usuarios
insert into usuarios (OID,CVEUSUARIO, CVEUSUARIO_LDAP, NOMCOMPLETO,EMAIL1, ESACTIVO )
  VALUES (1,'lreyesve', 'lreyesve-ldap', 'Luis Reyes Velasco', 'lreyesve@capgemini.com', 1);
insert into usuarios (OID,CVEUSUARIO, CVEUSUARIO_LDAP, NOMCOMPLETO,EMAIL1, ESACTIVO )
  VALUES (2,'jgomez', 'jgomez-ldap', 'Jorge Gomez', 'jgomez@capgemini.com', 1);

--insert de roles modulo
insert into ROLESMODULO (OID,CVEROL,NOMROL,DESCROL)
  VALUES (2,'ADMIN', 'ADMINISTRADOR', 'ADMINISTRADOR DEL SISTEMA');
insert into ROLESMODULO (OID,CVEROL,NOMROL,DESCROL)
VALUES (3,'USER', 'USUARIO', 'USUARIO DEL SISTEMA');

--INSERT INTERMEDIO
INSERT INTO usuariosroles (OID,USUARIOS_OID, ROLESMODULO_OID)
VALUES (2,SELECT OID FROM USUARIOS WHERE CVEUSUARIO = 'lreyesve', SELECT OID FROM ROLESMODULO WHERE CVEROL = 'ADMIN' );
INSERT INTO usuariosroles (OID, USUARIOS_OID, ROLESMODULO_OID)
VALUES (3,SELECT OID FROM USUARIOS WHERE CVEUSUARIO = 'jgomez', SELECT OID FROM ROLESMODULO WHERE CVEROL = 'ADMIN' );

INSERT INTO modulos (oid, cvemodulo, nommodulo) VALUES (1, 'mod1', 'modulo 1');
INSERT INTO modulos (oid, cvemodulo, nommodulo) VALUES (2, 'mod2', 'modulo de operacion');

INSERT INTO componentes (oid, cvecomp, desccomp, nomcomp, modulos_oid) VALUES (1, 'clave componente 1', 'el primer componente', 'Componente 1', 1);
INSERT INTO permisoscomp (oid, componentes_oid, rolesmodulo_oid) VALUES (1, 1, 2);

INSERT INTO operaciones (oid, esadmin, cveoper, descoper, nomoper, componentes_oid, modulos_oid) VALUES (1, 1, 'clave op1', 'la operacion primera', 'primer operacion', 1, 2);
INSERT INTO permisosoper (oid, acciones_oid, rolesmodulo_oid) VALUES (1, 1, 3);

INSERT INTO eventos (oid, datosevt, fechaevt, operaciones_oid, usuarios_oid) VALUES (2, 'datos del evento', '2019-10-28', 1, 1);
