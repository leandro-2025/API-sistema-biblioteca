# 📚 Sistema de Biblioteca - API REST

## 📖 Sobre o projeto

O **Sistema de Biblioteca** é uma API REST desenvolvida em **Java** utilizando **Spring Boot**, com o objetivo de gerenciar o empréstimo de livros de uma biblioteca.

O projeto permite cadastrar usuários e livros, realizar empréstimos, registrar devoluções e controlar automaticamente a disponibilidade dos livros.

Além das operações básicas de CRUD, foram implementadas regras de negócio para garantir a integridade dos dados e impedir operações inválidas, como emprestar um livro que já está emprestado ou devolver um livro duas vezes.

---

## 👨‍💻 Autor

**Leandro**

Desenvolvedor Java em formação.

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven
* Hibernate
* Jackson
* Insomnia

---

## 📂 Estrutura do projeto

O projeto foi organizado seguindo uma arquitetura em camadas:

* **Model** → Entidades do sistema
* **Repository** → Comunicação com o banco de dados
* **Service** → Regras de negócio
* **Controller** → Endpoints da API
* **DTO** → Entrada de dados
* **ResponseDTO** → Saída personalizada da API

---

## 📚 Funcionalidades

### Usuários

* Cadastrar usuário
* Listar usuários
* Buscar usuário por ID
* Atualizar usuário
* Remover usuário

### Livros

* Cadastrar livro
* Listar livros
* Buscar livro por ID
* Atualizar livro
* Remover livro

### Empréstimos

* Realizar empréstimo de um livro
* Listar empréstimos
* Buscar empréstimo por ID
* Registrar devolução de um livro

---

## ✅ Regras de negócio

Durante o desenvolvimento foram implementadas as seguintes validações:

* O usuário deve existir para realizar um empréstimo.
* O livro deve existir.
* Um livro só pode ser emprestado se estiver disponível.
* Ao realizar um empréstimo:

  * a data do empréstimo é registrada automaticamente;
  * a data prevista para devolução é definida automaticamente para 7 dias após o empréstimo;
  * o livro passa para **indisponível**.
* Um livro devolvido volta automaticamente para **disponível**.
* Um empréstimo não pode ser devolvido duas vezes.

---

## 📌 Principais Endpoints

### Usuários

| Método | Endpoint       | Descrição         |
| ------ | -------------- | ----------------- |
| POST   | /usuarios      | Cadastrar usuário |
| GET    | /usuarios      | Listar usuários   |
| GET    | /usuarios/{id} | Buscar usuário    |
| PUT    | /usuarios/{id} | Atualizar usuário |
| DELETE | /usuarios/{id} | Remover usuário   |

---

### Livros

| Método | Endpoint     | Descrição       |
| ------ | ------------ | --------------- |
| POST   | /livros      | Cadastrar livro |
| GET    | /livros      | Listar livros   |
| GET    | /livros/{id} | Buscar livro    |
| PUT    | /livros/{id} | Atualizar livro |
| DELETE | /livros/{id} | Remover livro   |

---

### Empréstimos

| Método | Endpoint                   | Descrição           |
| ------ | -------------------------- | ------------------- |
| POST   | /emprestimos               | Criar empréstimo    |
| GET    | /emprestimos               | Listar empréstimos  |
| GET    | /emprestimos/{id}          | Buscar empréstimo   |
| PUT    | /emprestimos/{id}/devolver | Registrar devolução |

---

## 🧠 Conceitos praticados

Durante este projeto foram praticados conceitos importantes do desenvolvimento de APIs REST:

* Programação Orientada a Objetos (POO)
* Relacionamentos JPA (`@OneToMany` e `@ManyToOne`)
* Spring Data JPA
* Criação de APIs REST
* Organização em camadas
* DTO e ResponseDTO
* Conversão entre Entidades e DTOs
* Regras de negócio no Service
* Manipulação de datas com `LocalDateTime`
* Tratamento de exceções
* Controle de disponibilidade de livros
* Versionamento com Git e GitHub

---

## ▶️ Como executar o projeto

1. Clone este repositório.

2. Configure um banco de dados MySQL.

3. Atualize o arquivo `application.properties` com suas credenciais.

4. Execute o projeto utilizando sua IDE (IntelliJ IDEA ou Eclipse).

5. Utilize o Insomnia ou Postman para testar os endpoints da API.

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido como parte dos estudos em **Java** e **Spring Boot**, com foco na prática de construção de APIs REST, modelagem de banco de dados, regras de negócio e boas práticas de organização de código.

---


