CREATE TABLE balance
(
    id         BIGSERIAL PRIMARY KEY,
    account_id VARCHAR(255) NOT NULL,
    balance    FLOAT8       NOT NULL,
    CONSTRAINT uk_account_id UNIQUE (account_id)
);