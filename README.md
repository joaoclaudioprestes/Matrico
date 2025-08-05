# 🎓 Matrico

**Matrico** é um sistema modular de **gestão de cursos**, desenvolvido com foco em **boas práticas de POO**, princípios **SOLID** e **arquitetura em camadas**.

> 📌 Projeto ideal para demonstrar domínio técnico com **Java 17+, Spring Boot** e **PostgreSQL**.

---

## 🧩 Tecnologias

* Java 17+
* Spring Boot
* Spring MVC
* Spring Data JPA
* Lombok
* PostgreSQL

---

## 📐 Estrutura do Projeto

Organização em camadas, garantindo clareza, separação de responsabilidades e fácil manutenção:

```
📁 advice
📁 controller
├── course
├── student
└── registration
📁 exception
📁 service
📁 repository
📁 domain
├── entity
└── dto
```

---

## 📚 Entidades

* **Curso**
* **Aluno**
* **Matrícula**

### 🔗 Relacionamentos

* Um **Curso** possui vários **Alunos** (`@OneToMany`)
* Um **Aluno** pode se matricular em vários **Cursos** (`@ManyToMany`)
* A **Matrícula** representa o vínculo entre Aluno e Curso, com data e status

---

## 🚀 Funcionalidades

* [x] Cadastro, edição e exclusão de cursos
* [x] Cadastro, edição e exclusão de alunos
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

## 🧠 Conceitos Aplicados

* ✅ Princípios **SOLID**
* ✅ Boas práticas de **POO**
* ✅ Uso de **DTOs** para segurança e desacoplamento
* ✅ Injeção de dependência com Spring
* ✅ Padrão **Repository**
* ✅ Camada **Service** para regras de negócio
* ✅ CRUD completo
* ✅ Banco relacional com PostgreSQL

---

## 🛠️ Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/matrico.git

# Acesse a pasta do projeto
cd matrico

# Configure o PostgreSQL com o schema fornecido

# Execute o projeto via sua IDE ou terminal:
./mvnw spring-boot:run
```