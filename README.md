# JoinQuitMessagePlus
このプラグインはプレイヤーの参加・退出メッセージを変更したり、参加した時に音を鳴らしたり、タイトルを表示させたりできるプラグインです。
全ての機能はコンフィグで無効化することができます。メッセージ等も変更が可能です。
## 動作するソフトウェア
 - Nukkit
## ライセンス
 - General Public Lisence v3.0
## config.yml
| 項目 | 内容 | 説明 |
| ---- | ---- | ---- |
| EnableJoinMessage | true/false | 参加時にプレイヤーにメッセージを送信するかしないか |
| EnableJoinTitle | true/false | 参加時にプレイヤーにタイトルを表示するかしないか |
| EnableJoinSound | true/false | 参加時にレベルアップした時の音を鳴らすかどうか |
| EnableCustomJoinMessage | true/false | プレイヤーの参加メッセージをアレンジするかどうか |
| EnableCustomQuitMessage | true/false | プレイヤーが退室した時のメッセージをアレンジするかどうか |
| JoinMessage | メッセージ(配列で1行ごと) | 送信するメッセージの内容を設定 |
| JoinTitle | タイトルの内容 | 送信するタイトルの内容 |
| JoinSubTitle | サブタイトルの内容 | 送信するタイトルのサブタイトルの内容 |
| CustomJoinMessage | 参加メッセージの内容 | {username}はユーザーの名前が入ります |
| CustomQuitMessage | 退出メッセージの内容 | {username}はユーザーの名前が入ります |
