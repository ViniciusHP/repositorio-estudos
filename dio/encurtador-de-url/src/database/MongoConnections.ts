import { config } from '../config/Constants';
import mongoose from 'mongoose';

export default class MongoConnections {
  public async connect(): Promise<void> {
    try{
      await mongoose.connect(config.MONGO_CONNECTION);
      console.log('Conectado ao banco do MongoDB');
    } catch(err: any) {
      console.error(err.message);
      process.exit(1);
    }
  }
}
