const env = process.env;

export const CONFIG = {
  PORT: env.PORT || 8080,
  DB_NAME: env.DB_NAME || "auth-db",
  DB_USERNAME: env.DB_USERNAME || "admin",
  DB_PASSWORD: env.DB_PASSWORD || "123456",
  DB_HOST: env.DB_HOST || "localhost",
  DB_PORT: env.DB_PORT || "5432",
};
