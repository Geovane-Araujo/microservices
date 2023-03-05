import express from "express";

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;


app.get('/api/status', (req, res) => {
  return res.json({
    service: 'SALES',
    status: "up",
    httpStatus: 200
  })
})

app.listen(PORT, () => {
  console.info("starter");
});
