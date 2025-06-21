import { Sequelize } from "sequelize";
import { API_CONFIG } from "../constants/Constants.js";

const sequelize = new Sequelize(
  API_CONFIG.DB_NAME,
  API_CONFIG.DB_USERNAME,
  API_CONFIG.DB_PASSWORD,
  {
    host: API_CONFIG.DB_HOST,
    port: API_CONFIG.DB_PORT,
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
      syncOnAssociation: true,
      timestamps: false,
      underscored: true,
      underscoredAll: true,
      freezeTableName: true,
    },
  }
);

sequelize
  .authenticate()
  .then(() => {
    console.info("Connection has been stablished!");
  })
  .catch((err) => {
    console.error("Unable to connect to the database.");
    console.error(err.message);
  });

export default sequelize;
