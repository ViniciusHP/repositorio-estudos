import bcrypt from "bcrypt";
import User from "../../modules/user/model/User.js";

async function getEncryptedPassword(password) {
  return await bcrypt.hash(password, 10);
}

export async function createInitialData() {
  try {
    await User.sync({ force: true });

    await User.create({
      name: "User test",
      email: "testuser@gmail.com",
      password: await getEncryptedPassword("123456"),
    });

    await User.create({
      name: "User",
      email: "user@email.com",
      password: await getEncryptedPassword("123456"),
    });
  } catch (err) {
    console.error(err);
  }
}
