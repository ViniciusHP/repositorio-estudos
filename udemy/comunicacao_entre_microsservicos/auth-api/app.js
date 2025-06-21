import express from "express";
import { CONFIG } from "./src/config/constants/Constants.js";
import * as db from "./src/config/db/initialData.js";

const app = express();

db.createInitialData();

app.get("/api/status", (req, res) => {
  return res.status(200).json({
    service: "Auth-API",
    status: "up",
    httpStatus: 200,
  });
});

app.listen(CONFIG.PORT, () => {
  console.info(`Server started successfully at port ${CONFIG.PORT}`);
});
