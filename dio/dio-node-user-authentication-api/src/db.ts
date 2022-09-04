import { Pool } from "pg";

const connectionString = 'postgresql://postgres:root@localhost:5432/user-authentication'

const db = new Pool({ connectionString });

export default db;
