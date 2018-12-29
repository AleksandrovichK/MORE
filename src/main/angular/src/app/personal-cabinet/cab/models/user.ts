export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  registrationDate: Date;
  balance: number;
  userTypeId: number;
  isDeleted: boolean;

  constructor(id: number, username: string, password: string, email: string, registrationDate: Date, balance: number, userTypeId: number, isDeleted: boolean) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.registrationDate = registrationDate;
    this.balance = balance;
    this.userTypeId = userTypeId;
    this.isDeleted = isDeleted;
  }
}
