import express from "express";
import * as db from "./src/config/db/inicialData.js";
import userRoutes from './src/modules/routes/UserRoutes.js'
import checkToken from "./src/config/auth/checkToken.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8080;

db.createInitialData();
app.use(express.json());
app.use(userRoutes);


app.get('/api/status', (req, res) => {
  return res.json({
    service: 'AUTH',
    status: "up",
    httpStatus: 200
  })
});

app.listen(PORT, () => {
  console.info("starter");
});
