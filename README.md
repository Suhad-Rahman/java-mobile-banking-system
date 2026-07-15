# Java Mobile Wallet System

A simple console-based Mobile Wallet System developed in Java. This project simulates the basic operations of a mobile financial service such as Cash In, Cash Out, Send Money, and Balance Inquiry.

## Features

- User Registration
- Mobile Number Validation
- PIN Authentication
- Cash In
- Cash Out
- Send Money
- Check Balance
- Menu-driven Console Interface

## Technologies Used

- Java
- Scanner Class
- Object-Oriented Programming Fundamentals
- Console Application

## Project Structure

```
src/
└── Main.java
```

## How to Run

1. Clone the repository.

```bash
git clone https://github.com/<your-username>/java-mobile-wallet-system.git
```

2. Navigate to the project directory.

```bash
cd java-mobile-wallet-system
```

3. Compile the program.

```bash
javac src/Main.java
```

4. Run the program.

```bash
java -cp src Main
```

## Sample Functionalities

- Register a new user
- Validate mobile number format
- Deposit money (Cash In)
- Withdraw money (Cash Out)
- Transfer money
- Check available balance

## Known Limitations

- Data is not stored permanently.
- Transaction history is not available.
- PIN length is not validated during registration.
- Account numbers are not validated.
- Three incorrect PIN attempts do not terminate the transaction.

## Future Improvements

- Apply full Object-Oriented Programming (User, Account, Transaction classes)
- Persistent storage using files or a database
- Transaction history
- Change PIN feature
- Multiple user accounts
- Better exception handling
- Unit testing
- Graphical User Interface (JavaFX or Swing)

## Author

Suhad Rahman Turan
