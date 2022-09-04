import express from "express";
import errorHandler from "./middlewares/error-handler.middleware";
import jwtAuthenticationMiddleware from "./middlewares/jwt-authentication.middleware";
import authorizationRoute from "./routes/authorization.route";
import statusRoute from "./routes/status.route";
import usersRoute from "./routes/users.route";

const app = express();

// Configura middleware para que o express possa receber JSON
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Configura Rotas
app.use(authorizationRoute);
app.use(statusRoute);

// Configura as rotas abaixo dela para usar o jwtAuthenticationMiddleware
app.use(jwtAuthenticationMiddleware);
app.use(usersRoute);

// Configuração dos Handlers de Erro
app.use(errorHandler);

app.listen(3000, () => {
  console.log("Aplicação executando na porta 3000");
});
