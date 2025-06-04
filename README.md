# 🎓 Matrico

**Matrico** é um sistema simples e modular de **gestão de cursos**, desenvolvido com foco em boas práticas de programação orientada a objetos (POO), princípios SOLID e arquitetura em camadas.

> 📌 Ideal para demonstrar domínio técnico em projetos reais com **Java 17+, Spring Boot** e **PostgreSQL**.

---

## 🧩 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Lombok
- PostgreSQL

---

## 🧱 Arquitetura do Projeto

O projeto é organizado em camadas para garantir separação de responsabilidades e fácil manutenção:
```bash
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

## 🧑‍🏫 Entidades Principais

- **Curso**
- **Aluno**
- **Matrícula**

### 🔗 Relacionamentos
- Um **Curso** possui vários **Alunos** (OneToMany).
- Um **Aluno** pode estar matriculado em vários **Cursos** (ManyToMany).
- A **Matrícula** representa o vínculo entre **Aluno** e **Curso**, com data e status.

---

## 🚀 Funcionalidades

- [X] Cadastro, edição e exclusão de **Cursos**
- [ ] Cadastro, edição e exclusão de **Alunos**
- [ ] Realização de **Matrícula** entre aluno e curso
- [ ] Consulta de cursos com seus respectivos alunos
- [ ] Consulta de alunos matriculados em um curso
- [ ] Consulta de cursos em que um aluno está matriculado
- [ ] Filtro de cursos por nome ou status
- [ ] Relatórios simples via JSON

---

## 📡 Rotas (Spring REST)

| Método | Rota                     | Descrição                                     |
| ------ | ------------------------ | --------------------------------------------- |
| POST   | `/cursos`                | Cadastrar novo curso                          |
| PUT    | `/cursos/{id}`           | Editar curso                                  |
| DELETE | `/cursos/{id}`           | Excluir curso                                 |
| GET    | `/cursos`                | Listar todos os cursos                        |
| GET    | `/cursos?nome=&status=`  | Filtrar cursos por nome ou status             |
| GET    | `/cursos/{id}/alunos`    | Listar alunos matriculados no curso           |
| GET    | `/cursos/{id}/relatorio` | Relatório simples do curso (JSON)             |
| POST   | `/alunos`                | Cadastrar novo aluno                          |
| PUT    | `/alunos/{id}`           | Editar aluno                                  |
| DELETE | `/alunos/{id}`           | Excluir aluno                                 |
| GET    | `/alunos`                | Listar todos os alunos                        |
| GET    | `/alunos/{id}/cursos`    | Listar cursos em que o aluno está matriculado |
| GET    | `/alunos/{id}/relatorio` | Relatório simples do aluno (JSON)             |
| POST   | `/matriculas`            | Realizar matrícula (vincular aluno e curso)   |
| DELETE | `/matriculas/{id}`       | Cancelar matrícula                            |

---

## 🧠 Conceitos Demonstrados

- [ ] Princípios **SOLID** aplicados
- [ ] Boas práticas de **POO**
- [ ] Uso de **DTOs** para segurança e desacoplamento
- [ ] Injeção de dependência com **Spring**
- [ ] **Repository pattern** com Spring Data JPA
- [ ] Camada **Service** para regras de negócio
- [ ] **CRUD** completo e funcional
- [ ] Uso de banco relacional com **PostgreSQL**

---

## 🛠️ Como rodar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/matrico.git

# Acesse o diretório
cd matrico

# Configure o banco PostgreSQL com o schema fornecido

# Rode o projeto com sua IDE ou:
./mvnw spring-boot:run
```