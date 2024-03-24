Avaliacao 1 da materia de PRINCÍPIOS DO DESENVOLVIMENTO WEB E MOBILE.

Versao do Java = 17
Spring boot 3.2.3

Feita  a persistencia em BD postgres.
Alterar configuracao/conexao com o Banco de dados no arquivo application.properties  ./pdwm/src/main/resources/application.properties 

a principio é para a aplicacao criar a tabela no banco automaticamente.

Link da aplicao enquanto estiver executando -
http://localhost:8080/users
http://localhost:8080/cadastro
http://localhost:8080//users/iduser

Versao do Java = 17
Spring boot 3.2.3


Usuarios e senha para login podem ser alterados no WebSecurityConfig
src/main/java/pos/pdwm/security/WebSecurityConfig.java

Ideia era fazer login por banco com criptografia de senha, deixarei para projetos futuros