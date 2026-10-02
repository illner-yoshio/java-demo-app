# GitHubのコマンドまとめ

- ブランチを新しく切りたいとき
```
git switch -c [新しいブランチ名]
git switch -c feature/issue-#7
```
- branchを切り替える
```
# branch を切り替える
git switch ブランチ名

# リモートブランチへ初めて切り替える：
git switch -c develop origin/develop

# ブランチ一覧を確認
git branch -a
