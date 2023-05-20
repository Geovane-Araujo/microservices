import UserService from "../service/UserService.js";

class UserController{

  async getAccessToken(req, res){
    let user = await UserService.getAccesToken(req);
    return res.status(user.status).json(user);
  }

  async findbyEmail(req, res){
    let user = await UserService.findByEmail(req);
    return res.status(user.status).json(user);
  }
}

export default new UserController();