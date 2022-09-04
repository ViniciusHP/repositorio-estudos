import { NextFunction, Request, Response } from "express";
import JWT from 'jsonwebtoken';
import ForbiddenError from "../models/errors/forbbiden.error.model";

async function jwtAuthenticationMiddleware(req: Request, res: Response, next: NextFunction) {
  try{
    const authorizationHeader = req.headers['authorization'];

    if (!authorizationHeader) {
      throw new ForbiddenError("Credenciais não informadas!");
    }

    const [ authenticationType, token ] = authorizationHeader.split(' ');

    if(authenticationType != "Bearer" || !token) {
      throw new ForbiddenError("Tipo de autenticação inválido!");
    }
    
    try{
      const secretKey = "my_secret_key";
      const tokenPayload = JWT.verify(token, secretKey);
      
      if(typeof tokenPayload !== 'object' || !tokenPayload.sub) {
        throw new ForbiddenError("Token inválido");
      }
  
      const user = {
        uuid: tokenPayload.sub,
        username: tokenPayload.username
      };
  
      req.user = user;
      next();
    }catch(error) {
      throw new ForbiddenError("Token inválido", error);
    }
  } catch (error) {
    next(error);
  }
}

export default jwtAuthenticationMiddleware;
