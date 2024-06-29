# KotlinToDoAPI

KotlinToDoAPI é uma API REST simples para gerenciar listas de tarefas, construída com Kotlin e Spring Boot. ✅

Este projeto foi feito após a conclusão do curso "API REST com Kotlin e Spring Boot: Camada Web" da Alura, com o
objetivo de colocar em prática os conceitos que aprendi. 💪

![Skills Usadas](https://skillicons.dev/icons?i=kotlin,spring,postman)

## Funcionalidades

- [X] Criar Tarefa
- [X] Listar Tarefas
- [X] Buscar Tarefa por ID
- [X] Atualizar Tarefa
- [X] Excluir Tarefa

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
| PUT         | /tarefa        | Cria uma nova tarefa                 |
| PUT         | /tarefa/status | Atualiza o status de uma tarefa      |
| DELETE      | /tarefa/{id}   | Delete uma tarefa específica por ID  |
| DELETE      | /usuario/{id}  | Delete um usuário específico por ID  |
