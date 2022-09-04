-- Extensão para habilitar uuid_generate_v4()
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Extensão para habilitar o crypt();
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS application_user (
  uuid uuid DEFAULT uuid_generate_v4(),
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  PRIMARY KEY (uuid)
);

-- crypt(valorASerCriptografado, chavePrivada)
INSERT INTO application_user (username, password) VALUES ('vinicius', crypt('admin', 'my_salt'));
