CREATE TABLE Roles (
                       RoleID INT PRIMARY KEY AUTO_INCREMENT,
                       RoleName VARCHAR(255) NOT NULL
);

CREATE TABLE Store (
                       StoreID INT PRIMARY KEY AUTO_INCREMENT,
                       Name VARCHAR(255) NOT NULL,
                       Address VARCHAR(255) NOT NULL,
                       Phone VARCHAR(20),
                       ManagerID INT,
                       FOREIGN KEY (ManagerID) REFERENCES Employees(EmployeeID)
);

CREATE TABLE Employees (
                           EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
                           Name VARCHAR(255) NOT NULL,
                           Address VARCHAR(255),
                           Phone VARCHAR(20),
                           Email VARCHAR(255),
                           DateOfBirth DATE,
                           Position VARCHAR(255),
                           StoreID INT,
                           RoleID INT,
                           FOREIGN KEY (StoreID) REFERENCES Store(StoreID),
                           FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

CREATE TABLE User (
                      UserID INT PRIMARY KEY AUTO_INCREMENT,
                      Username VARCHAR(255) NOT NULL UNIQUE,
                      Password VARCHAR(255) NOT NULL,
                      Status VARCHAR(50),
                      EmployeeID INT UNIQUE,
                      FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

CREATE TABLE Suppliers (
                           SupplierID INT PRIMARY KEY AUTO_INCREMENT,
                           Name VARCHAR(255) NOT NULL,
                           Address VARCHAR(255),
                           Phone VARCHAR(20),
                           Email VARCHAR(255)
);

CREATE TABLE Categories (
                            CategoryID INT PRIMARY KEY AUTO_INCREMENT,
                            Name VARCHAR(255) NOT NULL,
                            Description TEXT,
                            SupplierID INT,
                            Price DECIMAL(10, 2),
                            Stock INT,
                            FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);

CREATE TABLE Customers (
                           CustomerID INT PRIMARY KEY AUTO_INCREMENT,
                           Name VARCHAR(255) NOT NULL,
                           Address VARCHAR(255),
                           Phone VARCHAR(20),
                           Email VARCHAR(255)
);

CREATE TABLE Orders (
                        OrderID INT PRIMARY KEY AUTO_INCREMENT,
                        CustomerID INT,
                        OrderDate DATE,
                        TotalAmount DECIMAL(10, 2),
                        Status VARCHAR(50),
                        FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE OrderDetails (
                              OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
                              OrderID INT,
                              ProductID INT,
                              Quantity INT,
                              Price DECIMAL(10, 2),
                              FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
                              FOREIGN KEY (ProductID) REFERENCES Categories(CategoryID)
);

CREATE TABLE Import (
                        ImportID INT PRIMARY KEY AUTO_INCREMENT,
                        SupplierID INT,
                        ImportDate DATE,
                        TotalCost DECIMAL(10, 2),
                        FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);


INSERT INTO manerger_wine.`role`
(role_id, role_name)
VALUES(1, 'ADMIN');
INSERT INTO manerger_wine.`role`
(role_id, role_name)
VALUES(2, 'MANAGE');
INSERT INTO manerger_wine.`role`
(role_id, role_name)
VALUES(3, 'EMPLOYEE');