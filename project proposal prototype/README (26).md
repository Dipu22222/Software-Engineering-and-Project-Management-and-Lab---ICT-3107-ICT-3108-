# Smart Academic MBSTU Calendar

> **Capstone Project – Part I: Proposal and Prototyping**
> **Student:** Dipu Mondol | **ID:** IT24040 | **University:** Mawlana Bhashani Science and Technology University (MBSTU)

**Smart Academic MBSTU Calendar** is a desktop application written in **Java** that helps MBSTU students, faculty and administrators plan the academic year: semesters, class schedules, exams, assignment deadlines, holidays and reminders, all in one calendar.

---

## Table of Contents
1. [Project Idea and Problem Statement](#1-project-idea-and-problem-statement)
2. [Objectives and Scope](#2-objectives-and-scope)
3. [Requirements](#3-requirements)
4. [Software Process Model](#4-software-process-model)
5. [Schedule, Milestones and Deliverables](#5-schedule-milestones-and-deliverables)
6. [Risk Analysis](#6-risk-analysis)
7. [UML and Design Diagrams](#7-uml-and-design-diagrams)
8. [Prototype (Simple Interface)](#8-prototype-simple-interface)
9. [Repository Structure](#9-repository-structure)
10. [How to Build and Run](#10-how-to-build-and-run)
11. [Testing Plan](#11-testing-plan)
12. [Future Work](#12-future-work)
13. [References](#13-references)

---

## 1. Project Idea and Problem Statement

Students at MBSTU often track semester dates, exam schedules, holidays and assignment deadlines across notice boards, PDFs and chat groups. Important dates get missed and schedules conflict.

**Smart Academic MBSTU Calendar** provides one place where:
- An **Admin** publishes the official academic calendar (semesters, holidays, exam weeks).
- **Faculty** add class sessions, assignments and exams for their courses.
- **Students** see a personalised calendar for the courses they are enrolled in and receive reminders before deadlines.

## 2. Objectives and Scope

**Objectives**
- Build a user-friendly Java desktop application for managing academic events.
- Detect schedule conflicts automatically (for example two exams at the same time).
- Provide reminders and a search and filter function.
- Store data persistently (files or database in `data/`, settings in `config/`).

**In scope:** login and roles, semester and course management, event CRUD, enrolment, reminders, conflict detection, calendar (month, week and list) views, import and export (CSV).

**Out of scope (first version):** mobile app, cloud sync, online payments, integration with an external LMS.

## 3. Requirements

### 3.1 Functional Requirements
| ID | Requirement |
|----|-------------|
| FR1 | Users can register and log in; roles are Admin, Faculty and Student. |
| FR2 | Admin can create, update and delete semesters and holidays. |
| FR3 | Faculty can create, update and delete course events (class, assignment, exam). |
| FR4 | Students can enrol in or drop courses. |
| FR5 | The system shows a monthly, weekly and list view of events. |
| FR6 | The system warns about conflicting events. |
| FR7 | The system sends reminders before deadlines. |
| FR8 | Users can search and filter events by course, type or date. |
| FR9 | Calendar data can be exported to and imported from CSV. |

### 3.2 Non-Functional Requirements
- **Usability:** a new user can add an event in under one minute.
- **Performance:** calendar view loads in under 2 seconds for 1,000 events.
- **Reliability:** data is saved after every change; no data loss on a normal exit.
- **Security:** passwords are stored hashed, never as plain text.
- **Portability:** runs on any OS with JDK 17 or later.
- **Maintainability:** layered architecture (UI, service, data) and JavaDoc comments.

### 3.3 Technology Stack
Java 17+, Swing (or JavaFX) for the GUI, JDBC with SQLite (or file storage), JUnit 5 for tests, Maven or Gradle for the build, Git and GitHub for version control, LaTeX for the report.

## 4. Software Process Model

**Chosen model: Agile (Scrum-style iterative and incremental development).**

*Why:* requirements (views, reminders, roles) are expected to evolve with feedback; each sprint produces a working increment; risks are found early; it suits a small team (one student) with a fixed deadline.

| Sprint | Focus | Output |
|--------|-------|--------|
| Sprint 0 | Planning and requirements | Proposal, backlog |
| Sprint 1 | Design | UML diagrams, DB schema |
| Sprint 2 | Core classes and data layer | Model classes, DAO |
| Sprint 3 | GUI prototype | Login and calendar screens |
| Sprint 4 | Features | Reminders, conflict check |
| Sprint 5 | Testing and polish | Test report, final demo |

## 5. Schedule, Milestones and Deliverables

### 5.1 Gantt Chart
> Adjust the dates to your real semester. GitHub renders this chart automatically.

```mermaid
gantt
    title Smart Academic MBSTU Calendar - Project Schedule
    dateFormat  YYYY-MM-DD
    axisFormat  %d %b
    section Planning
    Idea and proposal            :done,    p1, 2026-10-01, 7d
    Requirements analysis        :done,    p2, after p1, 5d
    section Design
    UML diagrams                 :active,  d1, after p2, 8d
    Database and UI design       :         d2, after d1, 5d
    section Implementation
    Model and data layer         :         i1, after d2, 10d
    GUI prototype (5+ classes)   :         i2, after i1, 10d
    Reminders and conflict check :         i3, after i2, 8d
    section Testing
    Unit and integration tests   :         t1, after i3, 7d
    User acceptance testing      :         t2, after t1, 4d
    section Delivery
    Documentation and report     :         r1, after t1, 7d
    Final demo and submission    :milestone, m5, after r1, 1d
```

### 5.2 Milestones
| # | Milestone | Target |
|---|-----------|--------|
| M1 | Proposal approved | End of Week 1 |
| M2 | Requirements and UML complete | End of Week 3 |
| M3 | Working GUI prototype | End of Week 6 |
| M4 | All features implemented | End of Week 8 |
| M5 | Testing complete, final submission | End of Week 10 |

### 5.3 Deliverables
| Deliverable | Description |
|-------------|-------------|
| D1 | Project proposal (this README and LaTeX report) |
| D2 | Gantt chart and schedule |
| D3 | UML diagrams (DFD, Use Case, Activity, ERD, Class, Object) |
| D4 | Prototype source code in `src/` |
| D5 | Test plan and results |
| D6 | User manual and final report |

## 6. Risk Analysis
| Risk | Probability | Impact | Mitigation |
|------|-------------|--------|------------|
| Underestimated schedule | Medium | High | Sprint reviews and buffer time |
| GUI complexity | Medium | Medium | Start with simple Swing layouts |
| Data loss or corruption | Low | High | Regular backups, transactions |
| Scope creep | High | Medium | Fixed backlog, "future work" list |

## 7. UML and Design Diagrams

### 7.1 Data Flow Diagram (Level 0, context)
```mermaid
flowchart LR
    Admin([Admin]) -->|Semester, holidays| S((Smart Academic MBSTU Calendar))
    Faculty([Faculty]) -->|Course events, exams| S
    Student([Student]) -->|Enrol, search| S
    S -->|Calendar views, reminders| Student
    S -->|Conflict reports| Faculty
    S <-->|Read / write| DB[(Data Store)]
```

### 7.2 Data Flow Diagram (Level 1)
```mermaid
flowchart LR
    U([User]) --> P1((1.0 Authenticate))
    P1 --> D1[(Users)]
    P1 --> P2((2.0 Manage Events))
    P2 --> D2[(Events)]
    P2 --> P3((3.0 Check Conflicts))
    P3 --> D2
    P2 --> P4((4.0 Send Reminders))
    P4 --> U
    U --> P5((5.0 View Calendar))
    D2 --> P5
    D3[(Enrolments)] --> P5
```

### 7.3 Use Case Diagram
```mermaid
flowchart LR
    Admin([Admin])
    Faculty([Faculty])
    Student([Student])
    subgraph System[Smart Academic MBSTU Calendar]
        UC1(Login)
        UC2(Manage Semesters and Holidays)
        UC3(Manage Course Events)
        UC4(Enrol in Course)
        UC5(View Calendar)
        UC6(Receive Reminders)
        UC7(Search and Filter Events)
        UC8(Export / Import CSV)
    end
    Admin --- UC1 & UC2 & UC5 & UC8
    Faculty --- UC1 & UC3 & UC5 & UC7
    Student --- UC1 & UC4 & UC5 & UC6 & UC7
```

### 7.4 Activity Diagram (Add an Event)
```mermaid
flowchart TD
    A([Start]) --> B[Login]
    B --> C{Valid credentials?}
    C -- No --> B
    C -- Yes --> D[Open Add Event form]
    D --> E[Enter title, date, time, course]
    E --> F{Input valid?}
    F -- No --> E
    F -- Yes --> G{Conflict found?}
    G -- Yes --> H[Show warning] --> I{Continue anyway?}
    I -- No --> E
    I -- Yes --> J[Save event]
    G -- No --> J
    J --> K[Schedule reminder]
    K --> L[Refresh calendar]
    L --> M([End])
```

### 7.5 Entity Relationship Diagram
```mermaid
erDiagram
    USER ||--o{ ENROLMENT : makes
    COURSE ||--o{ ENROLMENT : has
    SEMESTER ||--o{ COURSE : contains
    COURSE ||--o{ EVENT : schedules
    USER ||--o{ EVENT : creates
    EVENT ||--o{ REMINDER : triggers
    USER {
        int user_id PK
        string name
        string email
        string password_hash
        string role
    }
    SEMESTER {
        int semester_id PK
        string name
        date start_date
        date end_date
    }
    COURSE {
        int course_id PK
        string code
        string title
        int semester_id FK
        int faculty_id FK
    }
    ENROLMENT {
        int enrolment_id PK
        int user_id FK
        int course_id FK
    }
    EVENT {
        int event_id PK
        string title
        string type
        datetime start_time
        datetime end_time
        int course_id FK
        int created_by FK
    }
    REMINDER {
        int reminder_id PK
        int event_id FK
        int minutes_before
    }
```

### 7.6 Class Diagram
```mermaid
classDiagram
    class User {
        -int id
        -String name
        -String email
        -String passwordHash
        +login(email, password) boolean
        +logout()
    }
    class Student { +enroll(Course) +viewSchedule() List~Event~ }
    class Faculty { +addEvent(Event) +updateEvent(Event) +deleteEvent(int) }
    class Admin { +createSemester(Semester) +addHoliday(Event) }
    class Semester {
        -int id
        -String name
        -LocalDate startDate
        -LocalDate endDate
    }
    class Course {
        -int id
        -String code
        -String title
        +addStudent(Student)
    }
    class Event {
        -int id
        -String title
        -LocalDateTime start
        -LocalDateTime end
        +overlaps(Event) boolean
    }
    class Exam { -String room }
    class Assignment { -LocalDateTime dueDate }
    class Reminder {
        -int minutesBefore
        +trigger()
    }
    class CalendarService {
        +addEvent(Event)
        +findConflicts(Event) List~Event~
        +getEvents(LocalDate, LocalDate) List~Event~
    }
    class DataStore {
        +save(Object)
        +load(Class) List
    }
    User <|-- Student
    User <|-- Faculty
    User <|-- Admin
    Event <|-- Exam
    Event <|-- Assignment
    Semester "1" o-- "*" Course
    Course "1" o-- "*" Event
    Course "*" -- "*" Student
    Event "1" -- "*" Reminder
    CalendarService --> DataStore
    CalendarService --> Event
```

### 7.7 Object Diagram
```mermaid
classDiagram
    class s1["s1 : Student"] { name = "Rahim" email = "rahim@mbstu.ac.bd" }
    class f1["f1 : Faculty"] { name = "Dr. Karim" }
    class c1["c1 : Course"] { code = "CSE201" title = "Data Structures" }
    class e1["e1 : Exam"] { title = "Midterm" start = "2026-11-10 10:00" room = "B-204" }
    class r1["r1 : Reminder"] { minutesBefore = 1440 }
    f1 --> c1 : teaches
    s1 --> c1 : enrolled in
    c1 --> e1 : schedules
    e1 --> r1 : triggers
```

## 8. Prototype (Simple Interface)

The prototype is a Java Swing GUI that uses **at least 5 classes from the class diagram**:

| Class used | Role in the prototype |
|------------|-----------------------|
| `User` / `Student` | Login screen and role-based menu |
| `Course` | Course list and enrolment panel |
| `Event` (`Exam`, `Assignment`) | Add / edit event form and table |
| `Reminder` | Reminder setting on the event form |
| `CalendarService` | Month view and conflict warning |
| `DataStore` | Saves and loads data from `data/` |

**Planned screens:** Login → Dashboard (month calendar) → Add / Edit Event → Course List → Settings.

*(Add screenshots here: `docs/screenshots/login.png`, `docs/screenshots/calendar.png`)*

## 9. Repository Structure
```
java-academic-calender/
├── config/        # Application settings (e.g. app.properties)
├── data/          # Stored data (database file / CSV)
├── src/           # Java source code
│   ├── model/     # User, Student, Faculty, Admin, Course, Event, Exam, Assignment, Reminder, Semester
│   ├── service/   # CalendarService, ReminderService, AuthService
│   ├── data/      # DataStore, DAO classes
│   └── ui/        # Swing frames and panels, Main.java
├── docs/          # Diagrams, screenshots, LaTeX report
└── README.md
```

## 10. How to Build and Run
```bash
# Requirements: JDK 17+
git clone https://github.com/Dipu22222/java-academic-calender.git
cd java-academic-calender

# compile
mkdir -p out
javac -d out $(find src -name "*.java")

# run (replace with your main class)
java -cp out ui.Main
```

## 11. Testing Plan
| Type | Tool | What is tested |
|------|------|----------------|
| Unit | JUnit 5 | `Event.overlaps()`, `CalendarService.findConflicts()` |
| Integration | JUnit 5 | Data layer reads and writes |
| UI / manual | Test cases | Login, add event, enrol, reminders |
| Acceptance | Peer users | Usability against the requirements |

## 12. Future Work
Cloud sync, mobile companion app, email and push notifications, Google Calendar and iCal export, and a dark mode theme.

## 13. References
- I. Sommerville, *Software Engineering*, Pearson.
- R. Pressman, *Software Engineering: A Practitioner's Approach*, McGraw-Hill.
- Oracle, *Java Platform Documentation*: https://docs.oracle.com/en/java/
- OMG, *Unified Modeling Language Specification*.

---
*Course project submitted for academic purposes.*
