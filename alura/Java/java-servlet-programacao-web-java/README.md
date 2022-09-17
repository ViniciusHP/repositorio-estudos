# Endpoints

Servlets:
```
/gerenciador/alteraEmpresa
/gerenciador/listaEmpresas
/gerenciador/mostraEmpresa
/gerenciador/novaEmpresa
/gerenciador/oi
/gerenciador/ola
/gerenciador/removeEmpresa
```

JSP/HTML:
```
/gerenciador/bem-vindo.html
/gerenciador/formAlteraEmpresa.jsp
/gerenciador/formNovaEmpresa.jsp
/gerenciador/listaEmpresas.jsp
/gerenciador/novaEmpresaCriada.jsp
```
# JSTL

Para habilitar este recurso, é necessário copiar o jar do JSTL para a pasta `WebContent/WEB-INF/lib`

# Tomcat

Pasta `/webapps`: é onde colocamos nosso arquivo WAR para deploy.

Pasta `/bin`: é onde contém os scripts `startup.sh` e `startup.bat` que inicializam o Tomcat.

Pasta `/conf`: é onde contém as configurações do Tomcat, como por exemplo, o arquivo `server.xml` que possui o número da porta que o Tomcat irá usar.