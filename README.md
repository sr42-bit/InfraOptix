# 🚀 InfraOptix

**InfraOptix** is a cloud resource management backend built using **Spring Boot** and **Clean Architecture**. It provides a REST API to manage cloud resources while demonstrating modern backend development practices, including layered architecture, validation, exception handling, and API documentation.

> 📚 This project is being developed as a portfolio project to learn Backend Development, Cloud, and DevOps.

---

## ✨ Features

- ✅ Cloud Resource CRUD Operations
- ✅ Clean Architecture (Ports & Adapters)
- ✅ Domain-Driven Design (DDD) principles
- ✅ Bean Validation
- ✅ Global Exception Handling
- ✅ RESTful APIs
- ✅ Swagger / OpenAPI Documentation
- ✅ Maven Build
- 🔄 Unit Testing (In Progress)
- 🔄 Docker Support (Planned)
- 🔄 JWT Authentication (Planned)
- 🔄 CI/CD Pipeline (Planned)
- 🔄 AWS Deployment (Planned)

---

# 🏗️ Architecture

```
                Client
                   │
            REST Controller
                   │
          Application Layer
              (Use Cases)
                   │
            Domain Layer
          (Business Logic)
                   │
          Repository Ports
                   │
     Infrastructure Layer
     (JPA, Database, Web)
```

This project follows:

- Clean Architecture
- Hexagonal Architecture
- SOLID Principles
- Dependency Inversion Principle

---

# 🛠️ Tech Stack

| Category | Technology |
|-----------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| Build Tool | Maven |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Validation | Jakarta Bean Validation |
| API Docs | Swagger (OpenAPI) |
| Testing | JUnit 5, Mockito *(Planned)* |
| Version Control | Git & GitHub |

---

# 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.infraoptix
│   │       ├── application
│   │       ├── domain
│   │       ├── infrastructure
│   │       └── InfraoptixApplication.java
│   └── resources
└── test
```

---

# 📌 REST API

## Cloud Resources

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/resources` | Get all resources |
| GET | `/api/resources/{id}` | Get resource by ID |
| POST | `/api/resources` | Create resource |
| PUT | `/api/resources/{id}` | Update resource |
| DELETE | `/api/resources/{id}` | Delete resource |

---

## Health

| Method | Endpoint |
|---------|----------|
| GET | `/api/health` |

---

# 📖 Swagger

After running the application:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides interactive API documentation where endpoints can be tested directly from the browser.

---

# ▶️ Getting Started

## Clone Repository

```bash
git clone https://github.com/sr42-bit/InfraOptix.git
```

```bash
cd InfraOptix
```

---

## Configure Database

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/infraoptix
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## Run

```bash
mvn clean spring-boot:run
```

---

## Run Tests

```bash
mvn test
```

---

# 📁 Git Workflow

```
main
│
├── feature/resource-crud
├── feature/service-tests
├── feature/controller-tests
├── feature/jwt-auth
├── feature/docker
├── feature/aws-deployment
└── feature/ci-cd
```

---

# 🛣️ Roadmap

- [x] Project Setup
- [x] Clean Architecture
- [x] CRUD APIs
- [x] Bean Validation
- [x] Global Exception Handling
- [x] Swagger Documentation
- [ ] Unit Testing (JUnit + Mockito)
- [ ] Controller Testing (MockMvc)
- [ ] Docker
- [ ] JWT Authentication
- [ ] Pagination & Filtering
- [ ] GitHub Actions CI/CD
- [ ] AWS Deployment
- [ ] Monitoring & Logging

---

# 🤝 Contributing

Contributions, suggestions, and feedback are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a Pull Request

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Somesh Rathour**

- GitHub: https://github.com/sr42-bit
- LinkedIn: https://www.linkedin.com/in/someshrathour42

---

⭐ If you find this project helpful, consider giving it a star.