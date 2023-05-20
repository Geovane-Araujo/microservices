import Sequelize from "sequelize";


const sequelize = new Sequelize("auth-db", "postgres", "553322@@##", {
  host: "localhost",
  dialect: "postgres",
  port: "5434",
  quotIdentifiers: false,
  define: {
    sincOnAssociation: true,
    timestamps: false,
    undersocored: true,
    undersocoredAll: true,
    freezeTableName: true
  }
});

sequelize.authenticate().then(() => {
  console.info("conectado a base de dados")
}).catch(err => {
  console.error(err.message)
});

export default sequelize;