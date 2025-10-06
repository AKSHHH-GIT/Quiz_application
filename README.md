# Quiz_application
This is a backend API for a simple quiz application
# Online Quiz Application API

Backend API for a simple online quiz application built using Spring Boot, JPA, and H2/MySQL.

---

##  Features

### Quiz Management
- Create a quiz with a title and optional question IDs.
- Add questions to a quiz.
- Retrieve all quizzes or a specific quiz by ID.

### Question Management
- Create, read, update, and delete questions.
- Questions include text, subject, type, choices, and correct answers.
- Fetch questions by subject or get random questions for quiz-taking.

### Quiz Taking
- Fetch questions of a quiz **without exposing correct answers**.
- Submit answers and calculate the score.
- Score calculation supports multiple-choice questions (order-independent).

### Bonus Features
- Fetch all available subjects.
- Randomized question selection for quizzes.

---

##  Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 / MySQL
- Lombok
- Jakarta Validation

---

##  API Endpoints

### Quiz Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST   | `/api/quizzes/create` | Create a new quiz with title + questions |
| GET    | `/api/quizzes` | Get all quizzes |
| GET    | `/api/quizzes/{id}` | Get a specific quiz by ID |
| GET    | `/api/quizzes/{quizId}/questions` | Get all questions of a quiz (hide correct answers) |
| POST   | `/api/quizzes/{quizId}/submit` | Submit answers and get score |

### Question Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST   | `/api/quizzes/create-new-question` | Create a new question |
| GET    | `/api/quizzes/all-questions` | Fetch all questions |
| GET    | `/api/quizzes/questions/{id}` | Fetch question by ID |
| PUT    | `/api/quizzes/question/{id}/update` | Update a question by ID |
| DELETE | `/api/quizzes/question/{id}/delete` | Delete a question by ID |
| GET    | `/api/quizzes/subjects` | Get list of all subjects |
| GET    | `/api/quizzes/quiz/fetch-questions-for-user` | Fetch randomized questions for a user (`numOfQuestions`, `subject`) |


##  Sample Request / Response

**Create Question**
```json
POST /api/quizzes/create-new-question
{
  "question": "What is the size of int in Java?",
  "subject": "Java",
  "questionType": "MCQ",
  "choices": ["16 bits", "32 bits", "64 bits", "Depends on OS"],
  "correctAnswers": ["32 bits"]
}
