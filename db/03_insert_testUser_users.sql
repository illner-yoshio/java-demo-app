USE java_demo_app;

INSERT INTO users (user_id, password_hash)
VALUES ('admin', 'BCryptで生成したハッシュ値');
