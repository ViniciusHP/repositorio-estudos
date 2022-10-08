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

# Configurando Proxy no Maven
Para configurar um proxy para o maven, devemos criar um o arquivo `settings.xml` no diretório `.m2`:

````xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <proxies>
        <proxy>
            <id>meu-proxy</id>
            <active>true</active>
            <protocol>http</protocol>
            <host>http://ip</host>
            <port>3128</port>
            <username>username</username>
            <password>password</password>
        </proxy>
    </proxies>
</settings>
````
