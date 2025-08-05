# 🎓 Matrico

**Matrico** é um sistema modular de **gestão de cursos**, desenvolvido com foco em **boas práticas de programação orientada a objetos (POO)**, princípios **SOLID** e **arquitetura em camadas**.

> 📌 Projeto construído com **Java 17+, Spring Boot** e **PostgreSQL**, utilizando **Swagger** para documentação da API REST.

---

## 🧩 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring MVC
* Spring Data JPA
* Lombok
* PostgreSQL
* Swagger/OpenAPI (springdoc)

---

## 📐 Estrutura do Projeto

Organizado em múltiplas camadas, visando legibilidade, manutenção e separação de responsabilidades:

```
📁 advice         # Manipulação global de exceções
📁 controller     # Endpoints REST
├── course
├── student
└── registration
📁 exception      # Exceções customizadas
📁 service        # Regras de negócio
📁 repository     # Interface com o banco de dados
📁 domain
├── entity        # Entidades JPA
└── dto           # Objetos de transferência de dados
```

---

## 📚 Entidades

* **Curso**
* **Aluno**
* **Matrícula**

### 🔗 Relacionamentos

* Um **Curso** possui vários **Alunos** (`@OneToMany`)
* Um **Aluno** pode estar matriculado em vários **Cursos** (`@ManyToMany`)
* A **Matrícula** representa o vínculo entre aluno e curso, com data e status

---

## 🚀 Funcionalidades

* [x] CRUD completo para cursos
* [x] CRUD completo para alunos
* [x] Matrícula entre aluno e curso
* [x] Consulta de cursos com seus respectivos alunos
* [x] Consulta de alunos com seus cursos matriculados

---

## 📡 API REST

| Método | Endpoint                | Descrição                 |
| ------ | ----------------------- | ------------------------- |
| POST   | `/cursos`               | Cadastrar novo curso      |
| PUT    | `/cursos/{id}`          | Editar curso              |
| DELETE | `/cursos/{id}`          | Excluir curso             |
| GET    | `/cursos`               | Listar todos os cursos    |
| GET    | `/cursos?nome=&status=` | Filtrar cursos            |
| GET    | `/cursos/{id}/alunos`   | Listar alunos do curso    |
| POST   | `/alunos`               | Cadastrar novo aluno      |
| PUT    | `/alunos/{id}`          | Editar aluno              |
| DELETE | `/alunos/{id}`          | Excluir aluno             |
| GET    | `/alunos`               | Listar todos os alunos    |
| GET    | `/alunos/{id}/cursos`   | Listar cursos de um aluno |
| POST   | `/matriculas`           | Realizar matrícula        |
| DELETE | `/matriculas/{id}`      | Cancelar matrícula        |

---

## 📘 Documentação da API

A documentação interativa da API REST é gerada automaticamente com o **Swagger (springdoc-openapi)**.

Após iniciar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧠 Conceitos Aplicados

* ✅ Princípios **SOLID**
* ✅ Boas práticas de **POO**
* ✅ Camada **Service** para regras de negócio
* ✅ Padrão **Repository** com Spring Data JPA
* ✅ Uso de **DTOs** para segurança e encapsulamento
* ✅ Injeção de dependência com Spring
* ✅ Arquitetura em camadas
* ✅ Integração com banco de dados relacional (PostgreSQL)
* ✅ Documentação automática com Swagger

---

## 🛠️ Como Executar o Projeto

```bash
# Clone o repositório
git clone https://github.com/joaoclaudioprestes/matrico.git

# Acesse o diretório do projeto
cd matrico

# Configure o PostgreSQL com o schema fornecido (application.properties)

# Execute o projeto via sua IDE ou terminal:
./mvnw spring-boot:run
```
