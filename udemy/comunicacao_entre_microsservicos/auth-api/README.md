# Rodando o projeto

Para executar o projeto, rode o comando:

```bash
yarn startDev
```

# Endpoints

## Autenticação

Exemplo de requisição:

`POST http://localhost:8080/api/user/auth`
Corpo da requisição:

```json
{
  "email": "testuser@gmail.com",
  "password": "123456"
}
```

Exeplo de retorno

```json
{
  "status": 200,
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVXNlciI6eyJpZCI6MSwibmFtZSI6IlVzZXIgdGVzdCIsImVtYWlsIjoidGVzdHVzZXJAZ21haWwuY29tIn0sImlhdCI6MTc1MDUyMDEzNywiZXhwIjoxNzUwNjA2NTM3fQ.16602rC6sIJFFEQr2DsQpQB11OEy-DOv9iJMy0dFEzk"
}
```

## Busca usuário com email informado

Exemplo de requisição:

`GET http://localhost:8080/api/user/email/testuser@gmail.com`
Cabeçalhos:

```
Authorization=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVXNlciI6eyJpZCI6MSwibmFtZSI6IlVzZXIgdGVzdCIsImVtYWlsIjoidGVzdHVzZXJAZ21haWwuY29tIn0sImlhdCI6MTc1MDUyMDEzNywiZXhwIjoxNzUwNjA2NTM3fQ.16602rC6sIJFFEQr2DsQpQB11OEy-DOv9iJMy0dFEzk
```

Exeplo de retorno

```json
{
  "status": 200,
  "user": {
    "id": 1,
    "name": "User test",
    "email": "testuser@gmail.com"
  }
}
```

## Busca do status da aplicação

Exemplo de requisição:

`GET http://localhost:8080/api/status`

Exeplo de retorno

```json
{
  "service": "Auth-API",
  "status": "up",
  "httpStatus": 200
}
```
