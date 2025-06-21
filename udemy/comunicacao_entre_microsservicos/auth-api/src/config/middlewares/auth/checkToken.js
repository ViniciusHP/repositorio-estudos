import jwt from "jsonwebtoken";
import { promisify } from "util";
import { API_CONFIG } from "../../constants/Constants.js";
import * as HttpStatus from "../../constants/HttpStatus.js";
import AuthException from "./AuthException.js";

const bearer = "bearer ";

export default async (req, res, next) => {
  try {
    const { authorization } = req.headers;

    if (!authorization) {
      throw new AuthException(
        HttpStatus.UNAUTHORIZED,
        "Access token was not informed."
      );
    }

    let accessToken = null;

    if (authorization.toLowerCase().includes(bearer)) {
      accessToken = authorization.split(" ")[1];
    } else {
      accessToken = authorization;
    }

    const decoded = await promisify(jwt.verify)(
      accessToken,
      API_CONFIG.API_SECRET
    );

    req.authUser = decoded.authUser;
    return next();
  } catch (err) {
    const status = err.status ? err.status : HttpStatus.INTERNAL_SERVER_ERROR;
    return res.status(status).json({
      status: status,
      message: err.message,
    });
  }
};
