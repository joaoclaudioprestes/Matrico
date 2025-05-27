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
📁 controller
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

- [ ] Cadastro, edição e exclusão de **Cursos**
- [ ] Cadastro, edição e exclusão de **Alunos**
- [ ] Realização de **Matrícula** entre aluno e curso
- [ ] Consulta de cursos com seus respectivos alunos
- [ ] Consulta de alunos matriculados em um curso
- [ ] Consulta de cursos em que um aluno está matriculado
- [ ] Filtro de cursos por nome ou status
- [ ] Relatórios simples via JSON

---

## 📡 Rotas Exemplares (Spring REST)

| Método | Rota                      | Descrição                          |
|--------|---------------------------|-------------------------------------|
| GET    | `/cursos`                 | Listar todos os cursos              |
| POST   | `/cursos`                 | Cadastrar novo curso                |
| GET    | `/alunos`                 | Listar todos os alunos              |
| POST   | `/alunos`                 | Cadastrar novo aluno                |
| POST   | `/matriculas`            | Realizar matrícula                  |
| GET    | `/cursos/{id}/alunos`    | Alunos matriculados no curso       |
| GET    | `/alunos/{id}/cursos`    | Cursos que o aluno está matriculado|

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