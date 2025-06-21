import { Router } from "express";
import checkToken from "../../../config/middlewares/auth/checkToken.js";
import UserController from "../controller/UserController.js";

const router = new Router();

// Público
router.post("/api/user/auth", UserController.getAccessToken);

// Apenas autenticados
router.use(checkToken);
router.get("/api/user/email/:email", UserController.findByEmail);

export default router;
