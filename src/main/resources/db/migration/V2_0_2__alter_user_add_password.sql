ALTER TABLE users ADD COLUMN password VARCHAR(MAX) NOT NULL DEFAULT 'TMP';

UPDATE users SET password = 'pass1__app_key' WHERE username = 'user1';
UPDATE users SET password = 'pass2__app_key' WHERE username = 'user2';
UPDATE users SET password = 'pass3__app_key' WHERE username = 'user3';