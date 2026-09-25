INSERT INTO task_list (
    task_id,
    user_id,
    task,
    due_date,
    priority,
    complete_flg,
    del_flg,
    create_date,
    update_date
) VALUES (
    1,
    'admin',
    'AWS SAAの勉強をする',
    '2026-10-01',
    1,
    '0',
    '0',
    NOW(),
    NOW()
);