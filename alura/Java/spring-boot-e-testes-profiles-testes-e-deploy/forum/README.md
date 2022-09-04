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

# Gerando arquivo WAR

É necessário modificar o arquivo `pom.xml`, adicionando a tag:

```xml

<packaging>war</packaging>
```

e depois adicionar a dependência que indica ao maven que o tomcat será provido, e que não deve ser empacotado junto:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope>
</dependency>
```

Por fim, precisamos alterar nossa classe main, fazendo ela estender a classe SpringBootServletInitializer e registrar
nossa classe no método configure

```java

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class ForumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ForumApplication.class);
    }
}
```
