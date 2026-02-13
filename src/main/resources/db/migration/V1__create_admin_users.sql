
CREATE TABLE admin_users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL UNIQUE,
    version INT DEFAULT 1,
    full_name VARCHAR(200) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    country VARCHAR(100) NOT NULL,
    gender ENUM('male','female','other') DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL UNIQUE,
    version INT DEFAULT 1,
    full_name VARCHAR(200) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    country VARCHAR(100) NOT NULL,
    qualification VARCHAR(100) NOT NULL,
    gender ENUM('male','female','other') DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

INSERT INTO admin_users
(uuid, version, full_name, email, password, mobile, country, gender)
VALUES
(
UUID(),
1,
'Admin',
'admin@lms.com',
'$2a$12$EUgyknD53rvHAKlM769xY.Zl6P0SUTic7VqJ7BdVCD5RwQjkl55FS',
'9999999999',
'India',
'female'
);