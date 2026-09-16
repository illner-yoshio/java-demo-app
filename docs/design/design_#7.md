# 設計書　タスク一覧の画面表示

## 1. 概要

本ドキュメントにおける設計の対象は下記

- Amazon RDS (MySQL)の設計（新規テーブル追加）
- タスク表示機能（新規機能）
- メイン画面の画面設計（仕様変更）

## 2. 処理概要（処理フロー）

本件では、処理フローの変更は発生しない

## 3. テーブル設計

|No. | Column name | type | 桁 | description|
| --- | --- | --- | --- | --- | 
|1 | task_id | int |  | レコードを一意に特定するID |
|2 | user_id | varchar | 255 |　このタスクのユーザーのID |
|3 | task | varchar | 5000 | 全角文字で100文字まで|
|4 | due_date | date |  | 期限 |
|5 | priority | int | 1 | 1:高、2: 中、3：低|
|6 | complete_flg | char | 1 |　1:完了、0:未完了 |
|7 | create_date | date |  | システム日付|
|8 | update_date | date |  | システム日付|
|9 | del_flg | varchar | 1 | 1:削除済、0: 削除未実施 |

