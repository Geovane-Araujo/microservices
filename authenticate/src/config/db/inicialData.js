import User from "../../modules/user/model/User.js";
import bcrypt from "bcrypt";


export async function createInitialData(){
  try {
    await User.sync({force: true});

    let password = await bcrypt.hash("123456",10);
  
    await User.create({
      name: "test",
      email: "test@test.com",
      password: password
    });
  } catch(err){
    console.log(err);
  }
}