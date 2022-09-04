<h1 align="center">
  Encurtador de URL
</h1>

<h4 align="center">Status: ✔ Concluído</h4>

---

<p align="center">
 <a href="#user-content-sobre-o-projeto">Sobre o projeto</a> |
 <a href="#user-content-executando-o-projeto">Executando o projeto</a> |
 <a href="#user-content-endpoint">Endpoint</a> |
 <a href="#user-content-tecnologias">Tecnologias</a>
</p>

---

## **Sobre o projeto**

Encurtador de url feito em NodeJS no bootcamp [Eduzz Fullstack Developer](https://digitalinnovation.one/bootcamps/eduzz-fullstack-developer) com a [Digital Innovation One](https://digitalinnovation.one/) e a [Alexia Pereira](https://www.linkedin.com/in/alexiapereira/).

## **Executando o projeto**

### Pré-requisitos
Antes de começar, é necessário você já tenha as ferramentas [Node.js](https://nodejs.org/en/) e [Git](https://git-scm.com/) instaladas.

### Instruções de execução do projeto
```bash
# Clone este repositório
$ git clone https://github.com/ViniciusHP/encurtador-de-url.git

# Acesse a pasta deste projeto por meio do terminal
$ cd encurtador-de-url

# Instale as dependências deste projeto
$ npm install

# Inicie o compilador do Typescript
$ npm run build:watch

# Inicie o servidor de desenvolvimento
$ npm run dev

# O servidor de desenvolvimento será iniciado na porta 5000
# Para acessar o projeto, navegue para http://localhost:5000
```

## **Endpoint**

Para encurtar uma url faça a requisição `POST` em `localhost:5000/shorten` passando o seguinte corpo:
```json
{
    "originURL": "<url-para-encurtar>"
}
```

Exemplo: 

Requisição:
```
POST localhost:5000/shorten

{
    "originURL": "https://www.google.com/"
}
```

Resposta:
```json
{
    "_id": "61a0364071fc2c9821d6bd76",
    "hash": "hIUEIdq0k",
    "originURL": "https://www.google.com/",
    "shortURL": "http://localhost:5000/hIUEIdq0k",
    "__v": 0
}
```

Para acessar o site, utilize o link do `shortURL`;

## **Tecnologias**

Este projeto foi construído com as seguintes ferramentas:

- **[Express](https://expressjs.com/pt-br/)**
- **[Mongoose](https://mongoosejs.com/)**
- **[TypeScript](https://www.typescriptlang.org/)**