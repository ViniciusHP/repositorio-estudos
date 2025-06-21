const env = process.env;

export const API_CONFIG = {
  PORT: env.PORT || 8080,
  DB_NAME: env.DB_NAME || "auth-db",
  DB_USERNAME: env.DB_USERNAME || "admin",
  DB_PASSWORD: env.DB_PASSWORD || "123456",
  DB_HOST: env.DB_HOST || "localhost",
  DB_PORT: env.DB_PORT || "5432",
  API_SECRET: env.API_SECRET || "YXV0aC1hcGktc2VjcmV0LWRldi0xMjM0NTY=",
};
