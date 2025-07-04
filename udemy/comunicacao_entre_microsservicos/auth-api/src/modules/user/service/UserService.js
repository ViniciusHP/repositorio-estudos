import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";
import { API_CONFIG } from "../../../config/constants/Constants.js";
import * as HttpStatus from "../../../config/constants/HttpStatus.js";
import UserException from "../exception/UserException.js";
import UserRepository from "../repository/UserRepository.js";

class UserService {
  async findByEmail(req) {
    try {
      const { email } = req.params;
      const { authUser } = req;
      this.validateRequestData(email);
      let user = await UserRepository.findByEmail(email);
      this.validateUserNotFound(user);
      this.validateAuthenticatedUser(user, authUser);

      return {
        status: HttpStatus.SUCCESS,
        user: {
          id: user.id,
          name: user.name,
          email: user.email,
        },
      };
    } catch (err) {
      return this.getErrorResponse(err);
    }
  }

  async getAccessToken(req) {
    try {
      const { email, password } = req.body;
      this.validateAccessTokenData(email, password);

      let user = await UserRepository.findByEmail(email);

      this.validateUserNotFound(user);
      await this.validatePassword(password, user.password);

      const authUser = { id: user.id, name: user.name, email: user.email };
      const accessToken = jwt.sign(
        {
          authUser,
        },
        API_CONFIG.API_SECRET,
        {
          expiresIn: "1d",
        }
      );

      return {
        status: HttpStatus.SUCCESS,
        accessToken,
      };
    } catch (err) {
      return this.getErrorResponse(err);
    }
  }

  validateRequestData(email) {
    if (!email) {
      throw new UserException(
        HttpStatus.BAD_REQUEST,
        "User email was not informed."
      );
    }
  }

  validateUserNotFound(user) {
    if (!user) {
      throw new UserException(HttpStatus.BAD_REQUEST, "User was not found.");
    }
  }

  validateAuthenticatedUser(user, authUser) {
    if (!authUser || user.id !== authUser.id) {
      throw new UserException(
        HttpStatus.FORBIDDEN,
        "You cannot see this user data."
      );
    }
  }

  validateAccessTokenData(email, password) {
    if (!email || !password) {
      throw new UserException(
        HttpStatus.BAD_REQUEST,
        "Email and password must be informed."
      );
    }
  }

  async validatePassword(password, hashPassword) {
    if (!(await bcrypt.compare(password, hashPassword))) {
      throw new UserException(
        HttpStatus.UNAUTHORIZED,
        "Password does't match."
      );
    }
  }

  getErrorResponse(err) {
    return {
      status: err.status ? err.status : HttpStatus.INTERNAL_SERVER_ERROR,
      message: err.message,
    };
  }
}

export default new UserService();
