CREATE TABLE login (
    id INTEGER,
    password VARCHAR(20),
    isActive BIT
);

CREATE TABLE user_details (
    id INTEGER,
    loginId INTEGER,
    name VARCHAR(20),
    address JSON,
    contactNo VARCHAR(10),
    type VARCHAR(5)
);

CREATE TABLE permissions (
    userId INTEGER,
    permissionLevel INTEGER
);

INSERT INTO user_details (id, loginId, name, address, contactNo, type) VALUES (1, 10, 'Aditya', '123456', '071266133', 'admin');
INSERT INTO user_details (id, loginId, name, address, contactNo, type) VALUES (2, 20, 'Beth', '654321', '081354344', 'admin');
INSERT INTO user_details (id, loginId, name, address, contactNo, type) VALUES (3, 30, 'Cameron', 'AB1CD3', '091289441', 'user');

INSERT INTO login (id, password, isActive) VALUES (30, 'snake', 1);
INSERT INTO login (id, password, isActive) VALUES (20, 'dog', 1);
INSERT INTO login (id, password, isActive) VALUES (10, 'cat', 0);

INSERT INTO permissions (userId, permissionLevel) VALUES (2, 3);
INSERT INTO permissions (userId, permissionLevel) VALUES (1, 5);
INSERT INTO permissions (userId, permissionLevel) VALUES (3, 1);

