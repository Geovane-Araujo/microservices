import UserRepository from "../repository/UserRepository.js";
import * as HttpStatus from "../../config/conts/HttpStatus.js"
import UserException from "../user/exception/UserException.js";
import bcrypt from 'bcrypt';
import jwt from 'jsonwebtoken'
import * as secrets from "../../config/conts/secrets.js"

class UserService{
  async findByEmail(req) {
    try{
      const { email } = req.params;
      this.validateRequestData(email);
      let user = await UserRepository.findByEmail(email);
      
      this.validateUserNotFount(user);
      console.log(user)
      return {
        status: HttpStatus.SUCCESS,
        user: {
          id: user.id,
          name: user.name,
          email: user.email
        }
       };
    } catch(err){
      console.log(err)
      return {
        status: err.status ? err.status : HttpStatus.INTERNAL_SERVER_ERROR,
        msg: err.message
      }
    }
  }

  async getAccesToken(req){

    try{
      const {email, password } = req.body;
      let user = await UserRepository.findByEmail(email);
      this.validateUserNotFount(user);
      await this.validatePassword(password, user.password);
      let authUser = { id: user.id,user: user.name, email: user.email };
      console.log('cha')
      const accessToken = jwt.sign({authUser}, secrets.API_SECRET, {expiresIn: '1d'})
      return {
        status: HttpStatus.SUCCESS,
        accessToken
      }
    } catch(err){
      console.log(err)
      return {
        status: err.status ? err.status : HttpStatus.INTERNAL_SERVER_ERROR,
        msg: err.message
      }
    }

  }

  validateAuthenticatedUser(user, authUser) {
    if(!authUser || user.id !== authUser.id){
      throw new UserException(HttpStatus.UNAUTHORIZED, "")
    }
  }

  async validatePassword(password, hashPass){
    
    if(!await bcrypt.compare(password,''+ hashPass)){
      throw new UserException(HttpStatus.UNAUTHORIZED, "Email ou senha inválido")
    }
  }

  validateAccessTokenData(email, password){
    if(!email || !password ){
      throw new UserException(HttpStatus.UNAUTHORIZED, "Email ou senha inválido")
    }
  }

  validateRequestData(email){
    if(!email) {
      throw new UserException(HttpStatus.UNAUTHORIZED,"Email ou senha inválidos");
    }
  }

  validateUserNotFount(user){
    if(!user){
      throw new UserException(HttpStatus.OBJECT_NOT_FOUND,"Usuário não encontrado");
    }
  }
}

export default new UserService();