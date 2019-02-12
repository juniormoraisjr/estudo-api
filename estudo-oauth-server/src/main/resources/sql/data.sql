DELETE FROM oauth_client_details;

INSERT INTO usuario (username, email, password, activated)
SELECT * FROM (SELECT 'admin', 'admin@admin.com', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM usuario WHERE username = 'admin'
) LIMIT 1;

INSERT INTO perfil (name)
SELECT * FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM perfil WHERE name = 'ROLE_USER'
) LIMIT 1;

INSERT INTO perfil (name)
SELECT * FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM perfil WHERE name = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO USUARIO_PERFIL (username, perfil)
SELECT * FROM (SELECT 'admin', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, perfil FROM usuario_perfil WHERE username = 'admin' and perfil = 'ROLE_USER'
) LIMIT 1;

INSERT INTO USUARIO_PERFIL (username, perfil)
SELECT * FROM (SELECT 'admin', 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT username, perfil FROM USUARIO_PERFIL WHERE username = 'admin' and perfil = 'ROLE_ADMIN'
) LIMIT 1;