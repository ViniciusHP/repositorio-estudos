import express from "express";
import { API_CONFIG } from "./src/config/constants/Constants.js";
import * as db from "./src/config/db/initialData.js";
import userRoutes from "./src/modules/user/routes/UserRoutes.js";

const app = express();

db.createInitialData();

app.use(express.json());

app.get("/api/status", (req, res) => {
  return res.status(200).json({
    service: "Auth-API",
    status: "up",
    httpStatus: 200,
  });
});

app.use(userRoutes);

app.listen(API_CONFIG.PORT, () => {
  console.info(`Server started successfully at port ${API_CONFIG.PORT}`);
});
