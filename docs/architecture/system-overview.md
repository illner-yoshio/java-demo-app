# Java Demo Webアプリケーション システム概要

## 1. システム概要

Java / Spring Bootを使用したToDo管理Webアプリケーション。

ブラウザからログインし、認証されたユーザーが自身のToDoを管理できるWebアプリケーションを構築する。

## 2. システム構成

### 現在の構成

```text
[Browser]
    |
    | HTTP
    ↓
[Spring Boot]
    |
    ├─ Controller
    │
    ├─ Service
    │
    ├─ Repository
    │
    └─ Entity
    |
    ↓
[MySQL]
```

## 3. 使用技術

| 分類         | 技術              |
| ---------- | --------------- |
| 言語         | Java            |
| Webフレームワーク | Spring Boot     |
| ORM        | Spring Data JPA |
| データベース     | MySQL           |
| パスワードハッシュ  | BCrypt          |
| 開発環境       | VS Code         |
| ソース管理      | Git / GitHub    |
| クラウド       | AWS             |

## 4. 機能一覧

| No | 機能      | 状態  |
| -- | ------- | --- |
| 1  | ログイン画面  | 完了  |
| 2  | ユーザー認証  | 完了  |
| 3  | セッション管理 | 完了  |
| 4  | メイン画面   | 完了  |
| 5  | ログアウト   | 完了  |
| 6  | ToDo一覧  | 未実装 |
| 7  | ToDo登録  | 未実装 |
| 8  | ToDo更新  | 未実装 |
| 9  | ToDo削除  | 未実装 |

## 5. ログイン処理

```text
Browser
  ↓
POST /login
  ↓
LoginController
  ↓
AuthenticationService
  ↓
UserRepository
  ↓
MySQL users
  ↓
UserEntity
  ↓
BCryptPasswordEncoder.matches()
  ↓
認証結果
  ↓
Sessionへログイン情報を保存
  ↓
/main
```

## 6. 認証方式

ユーザーのパスワードは平文では保存せず、BCryptによるハッシュ値をMySQLに保存する。

ログイン時は入力されたパスワードと、DBに保存されたBCryptハッシュを照合する。

## 7. Javaのレイヤー構成

```text
com.example.demo
│
├── LoginController
│
├── service
│   └── AuthenticationService
│
├── repository
│   └── UserRepository
│
└── entity
    └── UserEntity
```

### Controller

HTTPリクエストを受け取り、画面遷移を制御する。

### Service

認証などの業務ロジックを担当する。

### Repository

データベースへのアクセスを担当する。

### Entity

MySQLのテーブルをJavaオブジェクトとして扱う。

## 8. 今後の拡張

```text
ログイン
   ↓
メイン画面
   ↓
ToDo一覧
   ↓
ToDo登録・更新・削除
   ↓
ログアウト
```

今後、AWSへのデプロイやデータベース構成、セキュリティ対策についても設計を追加する。
