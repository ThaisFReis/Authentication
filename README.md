# Authentication
Authentication é uma API Restful construída em JAX-RS que fornece serviços de autenticação, cadastro de usuários, login, listagem de usuários, atualização de cadastro e exclusão de usuários.
Instalação
Para rodar esta aplicação, você precisa ter o JDK (Java Development Kit) e o banco de dados de sua preferência. 
Banco de Dados
A aplicação utiliza o PostgreSQL como banco de dados e na pasta "database" é possível encontrar um arquivo "dump.sql" para a criação das tabelas necessárias. É importante configurar a conexão no arquivo "db.java" atualizando as informações de URL, usuário e senha.

## Uso
A API pode ser utilizada por meio de chamadas HTTP nos seguintes endpoints:
POST /user/register - para cadastro de usuários
POST /user/login - para efetuar o login de um usuário
GET /user/{id} - para buscar um usuário pelo ID
GET /user/all - para buscar todos os usuários
PUT /user/{id} - para atualizar um usuário pelo ID
DELETE /user/{id} - para excluir um usuário pelo ID
É necessário enviar as requisições com o formato JSON.

###  Cadastro de Usuários
Para cadastrar um usuário, envie uma requisição POST para o endpoint /user/register, com os seguintes campos:
email: e-mail do usuário
name: nome do usuário
password: senha do usuário

###  Login
Para efetuar o login de um usuário, envie uma requisição POST para o endpoint /user/login, com os seguintes campos:
email: e-mail do usuário
password: senha do usuário
O endpoint irá retornar um token de acesso que deve ser utilizado para as chamadas que exigem autenticação. O token deve ser enviado no header Authorization da requisição, precedido da palavra Bearer.

###  Buscar um Usuário pelo ID
Para buscar um usuário pelo ID, envie uma requisição GET para o endpoint /user/{id}, substituindo {id} pelo ID do usuário desejado.
Buscar Todos os Usuários
Para buscar todos os usuários cadastrados, envie uma requisição GET para o endpoint /user/all.

###  Atualizar um Usuário pelo ID
Para atualizar um usuário pelo ID, envie uma requisição PUT para o endpoint /user/{id}, substituindo {id} pelo ID do usuário desejado. Os campos que podem ser atualizados são:
email: e-mail do usuário
name: nome do usuário
password: senha do usuário

###  Excluir um Usuário pelo ID
Para excluir um usuário pelo ID, envie uma requisição DELETE para o endpoint /user/{id}, substituindo {id} pelo ID do usuário desejado.

###  Autenticação
####  Middleware de autenticação
Este middleware é aplicado nas rotas que requerem autenticação. Ele verifica se o usuário enviou um token válido no header de autenticação. Se o token for válido, ele adiciona o ID do usuário na requisição. Caso contrário, retorna uma resposta de erro 401 (Não Autorizado).
Para aplicar este middleware em uma rota, basta adicionar a anotação @Secured na classe de controller correspondente.

##### Considerações Finais
A API Authentication é uma solução simples e eficiente para autenticação e gerenciamento de usuários em aplicações web.
