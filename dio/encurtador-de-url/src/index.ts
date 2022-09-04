import MongoConnections from './database/MongoConnections';
import express, { NextFunction, Request, Response } from 'express';
import shortenRoute from './routes/shorten.routes';

const api = express();

const database = new MongoConnections();
database.connect();

api.use(express.json());
api.use(express.urlencoded({ extended: true }));

api.use(shortenRoute);

api.use('/test', (req: Request, res: Response, next: NextFunction) => {
  res.json({ success: true });
});

api.listen(5000, () => console.log("API iniciada na porta 5000"));