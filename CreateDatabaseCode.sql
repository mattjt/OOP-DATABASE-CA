DROP DATABASE IF EXISTS `OOPCADB`;
CREATE DATABASE `OOPCADB`;

USE `OOPCADB`;
DROP TABLE IF EXISTS `expenses`;
CREATE TABLE expenses (
                          expenseID INT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          category VARCHAR(100) NOT NULL,
                          amount DOUBLE NOT NULL,
                          dateIncurred DATE NOT NULL
);

DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
                          incomeID INT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          amount DOUBLE NOT NULL,
                          dateEarned DATE NOT NULL
);

INSERT INTO expenses (title, category, amount, dateIncurred)
VALUES
    ('Weekly shop', 'shopping', 47.50, '2025-01-02'),
    ('Gym membership', 'Fitness', 25.40, '2025-01-09'),
    ('Car Insurance', 'Car', 1025.40, '2024-05-16'),
    ('Car Tires', 'Car', 160.00, '2025-01-01'),
    ('Weekly shop', 'Shopping', 30.30, '2025-01-15');

INSERT INTO income (title, amount, dateEarned)
VALUES
    ('McDonalds work', 400.00, '2025-01-04'),
    ('Pub work', 115.00, '2025-01-07'),
    ('Sold stolen bike', 90.00, '2025-01-25'),
    ('McDonalds work', 425.00, '2025-01-16'),
    ('Found a 20 on the ground', 20.00, '2025-01-19'),
    ('McDonalds work', 485.00, '2025-01-25');