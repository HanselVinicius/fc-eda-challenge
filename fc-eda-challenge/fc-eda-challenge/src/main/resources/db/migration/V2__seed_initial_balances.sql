INSERT INTO balance (account_id, balance)
VALUES ('acc1', 1000.0),
       ('acc2', 2000.0) ON CONFLICT (account_id) DO NOTHING;