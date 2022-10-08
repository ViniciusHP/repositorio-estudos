# Escopos
 - Compile: A dependência é necessária em tempo de compilação
 - Provided: A dependência é necessária para compilar o código, mas no build, ela não será necessária, pois ela será provida pelo servidor de aplicação
 - Runtime: A dependência será provida apenas em tempo de execução
 - Test: A dependência é apenas usada durante a fase de testes

# Comandos Maven
Compila o projeto:
```bash
$ mvn compile
```

Limpa o diretório onde será colocado os dados compilados:
```bash
$ mvn clean
```

Roda os testes:
```bash
$ mvn test
```

Empacota o projeto:
```bash
$ mvn package
```

Limpa o diretório, roda os testes, empacota o projeto e move o .jar para o repositório local 
```bash
$ mvn install
```

Limpa o diretório, roda os testes, empacota o projeto e move o .jar para um repositório remoto
```bash
$ mvn deploy
```
