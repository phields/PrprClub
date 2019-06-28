# 前后端接口规范 - RESTful 部分

维护者: CJ

约定：若无特别注明，所有 API 均接受 `application/json` 并返回 `application/json` 格式，采用 `UTF-8` 编码。

## 通用返回格式

参照 `backend/src/main/kotlin/com.prprclub.frontmodel/Result.kt`

通用返回结构如下所示：

```json
{
    code: 0,
    msg: "ok",
    data: {
        ......
    }
}
```

其中：

- `code` ：状态码
- `msg`：状态信息
- `data`：返回 Payload

## 返回状态码

参照 `backend/src/main/kotlin/com.prprclub.frontmodel/Result.kt`

### 通用

1. `0`：成功；
2. `-1`：通用失败/服务器内部错误，详见返回的状态信息；

### 用户与权限相关

2. `-102`：无效状态 Token（此时前端应删除本地存储中的 JWT Token）
2. `-130`：无权访问
3. `-131`：当前帐户已被封禁
4. `-100`：未登录

## 用户与权限相关 API

### POST `/api/login`

登录

Request Body:

```json
{ "phone": "130xxxxxxxx", "captcha": "xxxxxx" }
```

- `phone`：手机号
- `captcha`：（暂时忽略）验证码或 reCAPTCHA 验证信息

Response Payload: 

```json
{ "token": "xxxxxxxxxxxxxxxxxxxx" }
```

- `token`：JWT Token，请将其保存并用于随后的所有请求

额外的错误码：

- `-101`：用户名或密码错误
- `-103`：无效的验证码

### POST `/api/send_verify`

发送手机验证码（用于注册/重新绑定手机）

Request Body:

```json
{ "phone": "130xxxxxxxx", "captcha": "xxxxxx" }
```

- `phone`：手机号
- `captcha`：（暂时忽略）验证码或 reCAPTCHA 验证信息

Response Payload: `null`

额外的错误码：

- `-103`：无效的验证码
- `-111`：请求被拒绝，手机号为黑号等，或验证平台端出错

## POST `/api/register`

注册新用户。

Request Body:

```json
{ 
    "username": "xxxxxxxx",
    "password": "xxxxxxxx",
    "phone": "130xxxxxxxx",
    "verifyCode": "xxxxxx"
}
```

- `username`： 用户名
- `password`：密码（明文）
- `phone`：手机号
- `verifyCode`：手机验证码（测试期间请发送“123456”）

Response Payload: 

```json
{ "token": "xxxxxxxxxxxxxxxxxxxx" }
```

- `token`：JWT Token，请将其保存并用于随后的所有请求

额外的错误码：

- `-110`：无效的手机验证码
- `-111`：请求被拒绝，IP 被封禁等
- `-112`：已使用的用户名/手机号
- `-113`：弱密码或密码不符合规则

Charlie牛逼！
