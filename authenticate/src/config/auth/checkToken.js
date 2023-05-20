/**
 * Middleware
 */

import jwt from 'jsonwebtoken'
import {promisify} from 'util'
import * as secrets from '../conts/secrets.js'
import * as HttpStatus from '../conts/HttpStatus.js'
import UserException from '../../modules/user/exception/UserException.js';
const bearer = "Bearer ";

export default async (req, res, next) => {
  try{
    const { authorization } = req.headers;
    if(!authorization){
      throw new UserException(HttpStatus.UNAUTHORIZED, "Acesso não autorizado");
  
    }
    let accessToken = authorization;
    if(accessToken.indexOf(bearer) > -1){
      accessToken = accessToken.replace(bearer, '');
    }
    const decoded = await promisify(jwt.verify)(accessToken, secrets.API_SECRET);
    req.authUser = decoded.authUser;
    return next();
  }catch(err){
    const status = err.status ? err.status : HttpStatus.INTERNAL_SERVER_ERROR;
    return res.status(status).json({
      msg: err.message
    })
  }

};