USE java_demo_app;

CREATE TABLE task_list (
    task_id INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    task VARCHAR(100) NOT NULL,
    due_date DATE,
    priority INT NOT NULL,
    complete_flg CHAR(1) NOT NULL,
    del_flg CHAR(1) NOT NULL,
    create_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL,
    PRIMARY KEY (task_id)
);