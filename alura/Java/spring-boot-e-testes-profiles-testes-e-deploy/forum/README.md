# Comando para fazer build da aplicação

```bash
$ ./mvnw clean package 
```

# Comando para executar o jar

```bash
$ java -jar -Dspring.profiles.active=dev ./target/forum.jar
```

# Exportando variáveis de ambiente

```bash
$ export FORUM_DATABASE_URL=jdbc:h2:mem:alura-forum
$ export FORUM_DATABASE_USERNAME=sa
$ export FORUM_DATABASE_PASSWORD=
$ export FORUM_JWT_SECRET=123456
```

# Definindo e passando variáveis de ambiente ao executar jar

```bash
$ java -jar -Dspring.profiles.active=prod -DFORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 ./target/forum.jar
```
