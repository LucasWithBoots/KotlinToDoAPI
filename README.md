# KotlinToDoAPI

KotlinToDoAPI é uma API REST simples para gerenciar listas de tarefas, construída com Kotlin e Spring Boot. ✅

Este projeto foi feito após a conclusão do curso "API REST com Kotlin e Spring Boot: Camada Web" da Alura, para colocar
em prática os conceitos que aprendi. 💪

![Skills Usadas](https://skillicons.dev/icons?i=kotlin,spring,postman,idea)

## Funcionalidades

- Criar tarefa e usuário
- Listar tarefas e usuários
- Buscar tarefa e usuário por ID
- Atualizar conteúdo e status da tarefa
- Atualizar dados do usuário
- Excluir tarefa e usuário

## Dependências

- Spring Web
- Spring Boot DevTools
- Validation

## Endpoints

> Todos os métodos já estão implementados no Postman. Importe essa API 🌐
> https://bit.ly/3xDdiMN

| Método HTTP | Endpoint       | Função                               |
|-------------|----------------|--------------------------------------|
| GET         | /tarefa        | Retorna todas as tarefas             |
| GET         | /tarefa/{id}   | Retorna uma tarefa específica por ID |
| GET         | /usuario       | Retorna todos os usuários            |
| GET         | /usuario/{id}  | Retorna um usuário específico por ID |
| POST        | /tarefa/       | Cria uma nova tarefa                 |
| POST        | /usuario/      | Cria um novo usuário                 |
| PUT         | /tarefa        | Atualiza uma tarefa                  |
| PUT         | /tarefa/status | Atualiza o status de uma tarefa      |
| PUT         | /usuario       | Cria uma nova tarefa                 |
| DELETE      | /tarefa/{id}   | Delete uma tarefa específica por ID  |
| DELETE      | /usuario/{id}  | Delete um usuário específico por ID  |
