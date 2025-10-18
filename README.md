# 🧠 Quiz Application

A full-stack Quiz Application built using **Java Spring Boot** for the backend.
It allows admins to create and manage quizzes, and users to attempt quizzes based on subjects.
Designed for learning and testing knowledge interactively.

---

## 🚀 Features

* Create, update, delete quiz questions
* Fetch quizzes by subject
* Randomized question selection for users
* RESTful API structure
* Clean service and repository layer design
* Easy setup and run using Maven

---

## 🧰 Tech Stack

* **Backend:** Spring Boot (Java 17)
* **Database:** MySQL / H2 (configurable)
* **Build Tool:** Maven 3.9+
* **Version Control:** Git & GitHub
* **IDE:** IntelliJ IDEA / Eclipse

---

## ⚙️ Setup Instructions

To set up the project locally, follow the steps below 👇

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/AKSHHH-GIT/Quiz_application.git
cd Quiz_application
```

### 2️⃣ Build the Project

```bash
mvn clean install
```

### 3️⃣ Configure Database

Edit the file `src/main/resources/application.properties` and update your database configuration (example for MySQL):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Run the Application

**Option 1 – Using Maven:**

```bash
mvn spring-boot:run
```

**Option 2 – Using the built JAR:**

```bash
java -jar target/quiz-app-0.0.1-SNAPSHOT.jar
```

The application will start on:
👉 **[http://localhost:8080/](http://localhost:8080/)**

---

## 🔍 Testing the Setup

You can test whether the application is running by visiting:
**[http://localhost:8080/api/questions](http://localhost:8080/api/questions)**

Or use curl:

```bash
curl http://localhost:8080/api/questions
```

---

## 📁 Project Structure

```
src/
 ├── main/
 │   ├── java/com/verto/demo/
 │   │   ├── controller/     → REST Controllers
 │   │   ├── model/          → Entity classes
 │   │   ├── repository/     → JPA Repositories
 │   │   ├── service/        → Service layer
 │   │   └── DemoApplication.java → Main entry point
 │   └── resources/
 │       └── application.properties
 └── test/                   → Unit tests (if any)
```

---

## 🧑‍💻 Example API Endpoints

| Method | Endpoint                         | Description              |
| ------ | -------------------------------- | ------------------------ |
| GET    | /api/questions                   | Get all questions        |
| GET    | /api/questions/{id}              | Get question by ID       |
| POST   | /api/questions                   | Create new question      |
| PUT    | /api/questions/{id}              | Update question          |
| DELETE | /api/questions/{id}              | Delete question          |
| GET    | /api/questions/subject/{subject} | Get questions by subject |

---

## 🧾 License

This project is open-source and available under the **MIT License**.

---

## 🤝 Contributing

Contributions are welcome!
If you’d like to add new features or improve the documentation:

1. Fork the repository
2. Create a new branch (`feature/your-feature-name`)
3. Commit your changes
4. Push the branch and create a Pull Request

---

## 💡 Author

**Akshada Gajanan Ghangale**
📍 Pune, India
🔗 [LinkedIn](#) | [GitHub](#)

⭐ *If you found this project helpful, please give it a star!*

---

✅ **Next Step:**

```bash
git checkout -b add-readme
```

Create a file named `README.md` in the root of your project.
Paste the above content, then:

```bash
git add README.md
git commit -m "Add project README documentation"
git push origin add-readme
```

Then go to GitHub → **Open a Pull Request** just like you did for `SETUP.md`. 💪
