CREATE TABLE login_log (
    id VARCHAR(40) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    login_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    access_token TEXT NOT NULL,
    refresh_token TEXT NOT NULL
);