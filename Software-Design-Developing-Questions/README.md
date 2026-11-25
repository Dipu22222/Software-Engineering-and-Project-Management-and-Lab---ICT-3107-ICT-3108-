# Software Design: Developing Questions

**Reference Book:** *Software Engineering* (10th Edition, Global Edition) by Ian Sommerville

| | |
|---|---|
| **Name** | `[Dipu Mondol]` |
| **Student ID** | `[IT24040]` |

---

## Introduction

This assignment is an Outcome-Based Education (OBE) question set for the Software Engineering course. It was developed from Ian Sommerville's *Software Engineering* (10th Edition). Five important topics were chosen from the book. For each topic there is one question, written using **Bloom's Taxonomy** at the **Knowledge** and **Understanding** levels in the **Cognitive** domain, in line with the **BNQF** standard. 

Every answer is based only on the content of the book. The answers are written in simple language so that they are easy to revise and understand.

---

## Assessment Overview

| Item | Details |
|---|---|
| Total Marks | 40 |
| Duration | 1 Hour |
| Number of Questions | 5 (8 marks each) |
| Approach | Outcome-Based Education (OBE) |
| Taxonomy | Bloom's Taxonomy |
| Domain | Cognitive (BNQF standard) |
| Levels Used | Knowledge (Remember), Understanding |

Each question has two parts:

- **Part (a):** Knowledge level, 3 marks
- **Part (b):** Understanding level, 5 marks

---

## Course Outcomes (CO)

<!-- If your course outline has official CO statements, replace the wording below with them. -->

| CO | Course Outcome |
|---|---|
| **CO1** | Explain software processes and compare the generic software process models. |
| **CO2** | Describe agile development principles and Scrum-based project management. |
| **CO3** | Explain how software requirements are classified, elicited, validated and managed. |
| **CO4** | Describe architectural design decisions, views and common architectural patterns. |
| **CO5** | Explain software testing concepts, testing stages and test-driven development. |

## Question to CO Mapping

| Question | Topic | Book Chapter | CO | Bloom's Level | Marks |
|---|---|---|---|---|---|
| Q1 | Software Processes | Chapter 2 | CO1 | Knowledge, Understanding | 3 + 5 = 8 |
| Q2 | Agile Software Development | Chapter 3 | CO2 | Knowledge, Understanding | 3 + 5 = 8 |
| Q3 | Requirements Engineering | Chapter 4 | CO3 | Knowledge, Understanding | 3 + 5 = 8 |
| Q4 | Architectural Design | Chapter 6 | CO4 | Knowledge, Understanding | 3 + 5 = 8 |
| Q5 | Software Testing | Chapter 8 | CO5 | Knowledge, Understanding | 3 + 5 = 8 |
| | | | | **Total** | **40** |

---

## Table of Contents

1. [Question 1: Software Processes](#question-1-software-processes)
2. [Question 2: Agile Software Development](#question-2-agile-software-development)
3. [Question 3: Requirements Engineering](#question-3-requirements-engineering)
4. [Question 4: Architectural Design](#question-4-architectural-design)
5. [Question 5: Software Testing](#question-5-software-testing)
6. [References](#references)

---

## Question 1: Software Processes

**Mapped CO:** CO1  |  **Bloom's Level:** Knowledge, Understanding  |  **Marks:** 8  |  **Source:** Chapter 2

### Question

**(a)** *(Knowledge, 3 marks)* What is a software process? Name the four fundamental process activities and the three generic software process models.

**(b)** *(Understanding, 5 marks)* Explain the waterfall model, incremental development, and integration and configuration. Compare their strengths and weaknesses and say when each one is suitable.

### Answer

#### (a) Software process and its activities

A **software process** is a set of related activities that leads to the production of a software system. There is no single process that suits every kind of software. The process a company uses depends on the type of software, the customer's requirements, and the skills of the developers.

Every software process includes, in some form, these **four fundamental activities**:

1. **Software specification:** defining the functionality of the software and the constraints on its operation.
2. **Software development:** producing the software that meets the specification.
3. **Software validation:** checking that the software does what the customer wants.
4. **Software evolution:** changing the software to meet changing customer needs.

The book describes three **generic process models**: the **waterfall model**, **incremental development**, and **integration and configuration**.

#### (b) Comparing the three process models

**1. Waterfall model**

The waterfall model is a *plan-driven* process. It shows the fundamental activities as separate phases that follow one another:

1. Requirements analysis and definition
2. System and software design
3. Implementation and unit testing
4. Integration and system testing
5. Operation and maintenance

Each phase normally ends with approved ("signed off") documents, and the next phase should not begin until the previous one is finished.

- **Strengths:** It works well when extensive analysis and documentation are needed before implementation starts.
- **Weaknesses:** In real projects the phases overlap and feed information back to each other. Changing earlier documents needs customer approval and delays the project. As a result, requirements may be frozen too early, so the system may not do what users want, or it may end up badly structured.
- **Suitable for:** embedded systems that interface with hardware, critical systems that need detailed safety and security analysis, and large systems developed by several partner companies.
- **Not suitable when:** requirements change quickly and the team can communicate informally.

**2. Incremental development**

In this model, specification, development and validation are *interleaved*. An initial version is built, users give feedback, and the system is evolved through several versions. Each increment adds some functionality, and the most important functions are usually delivered first.

- **Strengths:**
  1. The cost of implementing requirement changes is lower, because less analysis and documentation has to be redone.
  2. It is easier to get customer feedback, because customers can see working demonstrations.
  3. Useful software can be delivered and used early, even if not all functions are ready.
- **Weaknesses:**
  1. The process is not very visible to managers, because it is not cost-effective to document every version.
  2. The system structure tends to degrade as new increments are added, so regular *refactoring* is needed.
- **Suitable for:** most business systems and software products, where requirements are likely to change. It is harder to use for large, complex, long-lifetime systems, which need a stable architecture planned in advance.

**3. Integration and configuration**

This approach is based on *reuse*. The system is built by configuring and integrating existing components or systems. Three kinds of components are commonly reused: stand-alone application systems that are configured for a specific environment, collections of objects built as a package for a component framework, and web services.

The main stages are: requirements specification, software discovery and evaluation, requirements refinement, application system configuration, and component adaptation and integration.

- **Strengths:** There is less software to develop, so cost and risk are reduced, and delivery is usually faster.
- **Weaknesses:** Compromises on requirements are unavoidable, so the system may not fully meet users' real needs. The organization also loses some control over how the reused components evolve, because new versions are not under its control.
- **Suitable for:** business systems built by configuring and integrating existing systems.

**Summary table**

| Model | Main Idea | Best Suited For | Main Limitation |
|---|---|---|---|
| Waterfall | Separate, sequential phases | Embedded, critical and large multi-company systems | Hard to handle change |
| Incremental | Build and refine in versions | Business systems and products with changing requirements | Structure may degrade; low visibility |
| Integration and configuration | Reuse existing components | Systems where suitable components exist | Requirement compromises; less control |

**Conclusion:** No process model is right for every project. Most real processes are based on one general model but borrow features from the others. For large systems it makes sense to combine them. The architecture needs the essential requirements first, so it cannot be developed incrementally. Well-understood parts can use a waterfall-style process, and parts that are hard to specify in advance should be developed incrementally.

---

## Question 2: Agile Software Development

**Mapped CO:** CO2  |  **Bloom's Level:** Knowledge, Understanding  |  **Marks:** 8  |  **Source:** Chapter 3

### Question

**(a)** *(Knowledge, 3 marks)* Why did agile methods emerge? State the common characteristics of agile methods and list the principles of agile development.

**(b)** *(Understanding, 5 marks)* Explain how Scrum organizes an agile project. Describe its main roles and terms, the sprint cycle, and the benefits of using Scrum.

### Answer

#### (a) Agile methods: need, characteristics and principles

Modern businesses work in a fast-changing environment, so rapid software development and delivery is often the most important requirement. In such an environment it is almost impossible to produce a complete, stable set of requirements up front. Plan-driven processes that fully specify the system first are slow, and by the time the software is ready, the original need may have changed. Agile methods (for example Extreme Programming, Scrum and DSDM) became popular from the late 1990s to deliver useful software quickly.

**Common characteristics of agile methods:**

1. Specification, design and implementation are *interleaved*. There is no detailed specification, and design documentation is kept to a minimum.
2. The system is developed in a series of small increments, and users and other stakeholders take part in specifying and evaluating each one. New releases are typically produced every two or three weeks.
3. Extensive tool support is used, such as automated testing tools, configuration management tools and tools for building user interfaces.

**Principles of agile methods:**

| Principle | Meaning |
|---|---|
| Customer involvement | Customers are closely involved throughout. They provide and prioritize requirements and evaluate each iteration. |
| Embrace change | Expect requirements to change and design the system to accommodate this. |
| Incremental delivery | The software is built in increments, and the customer decides which requirements go into each one. |
| Maintain simplicity | Keep both the software and the development process as simple as possible. |
| People, not process | Recognize and use the skills of the team and let them choose their own ways of working. |

The agile manifesto expresses the same thinking. It values individuals and interactions over processes and tools, working software over comprehensive documentation, customer collaboration over contract negotiation, and responding to change over following a plan.

**Where agile works best:** Agile methods have been especially successful for (1) product development, where a company builds a small or medium-sized product for sale, and (2) custom systems developed inside an organization, where the customer is committed to being involved and few outside stakeholders or regulations apply.

**Extreme Programming (XP)** is one of the best-known agile approaches. Requirements are written as *user stories*. Developers work in pairs, write tests before the code (test-first development), refactor continuously, integrate code often, and make small, frequent releases.

#### (b) Scrum

**Scrum** is an agile method that provides a framework for organizing agile projects and gives managers some visibility of progress. It does not require specific programming practices, so it fits easily with a company's existing practices. It has become the most widely used agile method.

**Main Scrum terms and roles:**

| Term | Meaning |
|---|---|
| **Product backlog** | The list of "to do" items for the team, such as features, requirements, user stories or supporting tasks. |
| **Product Owner** | The person who identifies and prioritizes backlog items and keeps checking that the project meets business needs. |
| **ScrumMaster** | The person who makes sure the Scrum process is followed, guides the team, and protects it from outside interference. |
| **Development team** | A self-organizing group of no more than seven developers. |
| **Sprint** | One development iteration, usually 2 to 4 weeks long. |
| **Sprint backlog** | The work chosen for one particular sprint. |
| **Daily Scrum** | A short daily meeting to review progress and re-prioritize work. |
| **Velocity** | An estimate of how much backlog work a team can complete in one sprint. |
| **Potentially shippable increment** | The finished software produced by a sprint. |

**The sprint cycle:**

1. The Product Owner prioritizes the product backlog at the start of each cycle.
2. The whole team selects the highest-priority items it believes it can finish and estimates the effort, using the velocity from earlier sprints. This creates the **sprint backlog**.
3. The sprint begins. The team organizes itself and decides who works on what.
4. During the sprint, the team holds short daily Scrums where everyone shares progress, raises problems and states plans for the next day. A Scrum board helps everyone see the status of the work.
5. Sprints are never extended. Unfinished items go back to the product backlog.
6. At the end of the sprint, a review meeting is held. The team reflects on how to improve its way of working, and gives input for the next backlog review.

**Benefits of Scrum:**

1. The product is split into small pieces that stakeholders can understand.
2. Unstable requirements do not hold up progress.
3. The whole team can see everything, which improves communication and morale.
4. Customers receive increments on time and give feedback, so there are no last-minute surprises.
5. Trust grows between customers and developers, creating a positive culture where everyone expects the project to succeed.

---

## Question 3: Requirements Engineering

**Mapped CO:** CO3  |  **Bloom's Level:** Knowledge, Understanding  |  **Marks:** 8  |  **Source:** Chapter 4

### Question

**(a)** *(Knowledge, 3 marks)* Define *requirements* and *requirements engineering*. Distinguish between user requirements and system requirements, and between functional and non-functional requirements.

**(b)** *(Understanding, 5 marks)* Explain the main activities of the requirements engineering process (elicitation and analysis, specification, and validation) and explain why requirements change.

### Answer

#### (a) Key concepts

The **requirements** for a system describe the services the system should provide and the constraints on its operation. **Requirements engineering (RE)** is the process of finding out, analyzing, documenting and checking these services and constraints.

**User requirements vs. system requirements**

| | User Requirements | System Requirements |
|---|---|---|
| Description | Statements, in natural language plus diagrams, of the services the system should provide and the constraints it must follow | More detailed descriptions of the system's functions, services and operational constraints |
| Level of detail | High-level and abstract | Detailed; they define exactly what is to be implemented |
| Typical readers | Client managers, end-users | End-users, client engineers, system architects, software developers |

*Example from the Mentcare system:* The user requirement "generate monthly management reports showing the cost of drugs prescribed by each clinic" is expanded into several system requirements. These cover when the report is generated, what it contains for each clinic, and who is allowed to access it.

**Functional vs. non-functional requirements**

- **Functional requirements** describe the services the system should provide, how it should react to particular inputs, and how it should behave in particular situations. Sometimes they also state what the system should *not* do.
- **Non-functional requirements** are constraints on the services or functions of the system, such as timing constraints, constraints on the development process, and constraints from standards. They often apply to the system as a whole.

Non-functional requirements are often more critical than individual functional requirements. Users can work around a missing function, but if a non-functional requirement is not met, the whole system may become unusable. They fall into three groups:

| Type | Meaning | Example (Mentcare) |
|---|---|---|
| **Product requirements** | Constrain the runtime behavior of the software (performance, reliability, security, usability) | The system must be available during working hours, with limited downtime per day. |
| **Organizational requirements** | Come from the policies and procedures of the customer's and developer's organizations | Users must identify themselves using their health authority identity card. |
| **External requirements** | Come from factors outside the system and its development process (regulatory, legislative, ethical) | The system must follow a national patient privacy standard. |

Non-functional requirements should be written so that they can be tested. For example, a vague goal such as "the system should be easy to use" can be rewritten as a measurable requirement, such as staff being able to use all functions after two hours of training and a limit on the average number of errors they make.

#### (b) The requirements engineering process

RE has three key activities: discovering requirements by interacting with stakeholders (**elicitation and analysis**), converting them into a standard form (**specification**), and checking that they define the system the customer really wants (**validation**). In practice these activities are *interleaved* and repeated in an iterative way, not carried out strictly one after another.

**1. Requirements elicitation and analysis**

The aim is to understand the work stakeholders do and how a new system can support it. This is difficult because stakeholders often do not know exactly what they want, express needs in their own terms, have conflicting requirements, may be influenced by organizational politics, and work in a changing business environment. The process has four activities:

1. **Discovery and understanding:** interacting with stakeholders to find their requirements.
2. **Classification and organization:** grouping related requirements into coherent clusters.
3. **Prioritization and negotiation:** resolving conflicts between stakeholders through negotiation and compromise.
4. **Documentation:** recording the requirements for the next round of the process.

**2. Requirements specification**

The gathered requirements are written down in a standard form. They are written at two levels of detail: user requirements for customers and managers, and more detailed system requirements for the people who will build the system. The result of the RE process is a requirements document.

**3. Requirements validation**

Validation checks that the requirements describe what the customer really wants. It is very important because fixing a requirements error later costs far more than fixing a design or coding error. The main checks are:

- **Validity:** do the requirements reflect the real needs of users?
- **Consistency:** do any requirements conflict with each other?
- **Completeness:** are all functions and constraints included?
- **Realism:** can the requirements be implemented within the budget and schedule?
- **Verifiability:** can tests be written to show that each requirement is met?

Useful validation techniques are **requirements reviews**, **prototyping**, and **test-case generation**.

**Why do requirements change?**

The requirements of large systems keep changing for several reasons:

1. These systems often address "wicked" problems that cannot be fully defined, so stakeholders' understanding grows during development.
2. The business and technical environment changes after installation. New hardware or systems appear, business priorities shift, and new laws or regulations are introduced.
3. The people who pay for the system are rarely the same people who use it, so their needs can conflict.
4. Large systems have many stakeholders with different, sometimes contradictory, priorities, so requirements may need to be re-prioritized later.

Because of this, requirements must be managed carefully, which means keeping track of individual requirements and the links between dependent ones.

---

## Question 4: Architectural Design

**Mapped CO:** CO4  |  **Bloom's Level:** Knowledge, Understanding  |  **Marks:** 8  |  **Source:** Chapter 6

### Question

**(a)** *(Knowledge, 3 marks)* What is software architecture and why is it important? List the architectural views used to describe a system.

**(b)** *(Understanding, 5 marks)* Explain how non-functional requirements influence architectural design. Describe four architectural patterns (MVC, Layered, Repository and Client–Server) with their advantages and disadvantages.

### Answer

#### (a) Software architecture, its importance and views

A **software architecture** is a description of how a software system is organized. **Architectural design** is concerned with understanding how a system should be organized and designing its overall structure. The book notes that architectural design overlaps significantly with requirements engineering, because the main architectural components reflect the high-level features of the system.

**Why it matters:** Architecture strongly affects the performance, robustness, distributability and maintainability of a system. Individual components implement the functional requirements, but the architecture has the dominant effect on non-functional characteristics. Explicitly designing and documenting the architecture has three advantages:

1. **Stakeholder communication:** it is a high-level view of the system that different stakeholders can discuss.
2. **System analysis:** making the architecture explicit early forces analysis of whether the system can meet requirements such as performance, reliability and maintainability.
3. **Large-scale reuse:** the same architecture can often be reused in systems with similar requirements, for example in product lines.

**Architectural views:** One diagram can show only one perspective of a system, so several views are normally used. In the well-known 4+1 view model they are:

| View | What it Shows |
|---|---|
| **Logical view** | The key abstractions of the system as objects or object classes |
| **Process view** | How the system is made up of interacting processes at runtime |
| **Development view** | How the software is broken down into components for development |
| **Physical view** | The system hardware and how software components are distributed across processors |

These are linked through common use cases or scenarios. Another suggestion adds a **conceptual view**, an abstract view that is almost always developed during design to explain the architecture to stakeholders.

#### (b) Non-functional requirements and architectural patterns

**How non-functional requirements shape the architecture**

The choice of architectural style and structure should depend on the system's non-functional requirements:

| Requirement | Architectural Approach |
|---|---|
| **Performance** | Keep critical operations in a small number of relatively large components on the same computer, to reduce communication. |
| **Security** | Use a layered structure, with the most critical assets in the innermost layers and strong validation applied there. |
| **Safety** | Place safety-related operations in one component or a few components, to reduce the cost of safety validation. |
| **Availability** | Include redundant components so parts can be replaced or updated without stopping the system. |
| **Maintainability** | Use fine-grain, self-contained components that are easy to change, and separate data producers from consumers. |

Some of these demands conflict. For example, large components help performance but small components help maintainability, so a compromise must be found when both are important.

**Architectural patterns**

An **architectural pattern** is a stylized, abstract description of good practice that has been tried and tested in different systems. It describes a system organization that worked before, and when it is and is not appropriate to use.

| Pattern | Description | When Used | Advantages | Disadvantages |
|---|---|---|---|---|
| **MVC (Model-View-Controller)** | Separates presentation and interaction from the system data. The *Model* manages data, the *View* manages how data is shown, and the *Controller* manages user interaction. | When there are many ways to view and interact with the data, or future presentation needs are unknown. | Data and its presentation can change independently. The same data can be shown in different ways. | Can add extra code and complexity when the data model and interactions are simple. |
| **Layered architecture** | Organizes the system into layers. Each layer provides services to the layer above and relies only on the layer below. | When building new features on top of existing systems, when several teams each handle a layer, or when multilevel security is needed. | A whole layer can be replaced if its interface stays the same. Supports incremental development. | A clean separation between layers is hard to achieve. Performance can suffer because each request passes through several layers. |
| **Repository** | All data is kept in a central repository, and components interact only through it. | When large amounts of data must be stored for a long time, or in data-driven systems. | Components are independent. Data is managed consistently in one place. | The repository is a single point of failure. Routing all communication through it can be inefficient. |
| **Client-server** | The system is a set of services, each provided by a server, and clients use those services. | When shared data must be accessed from many locations, or when the load varies. | Servers can be distributed across a network. Common services are available to all clients. | Each server is a single point of failure. Performance depends on the network and can be unpredictable. |

---

## Question 5: Software Testing

**Mapped CO:** CO5  |  **Bloom's Level:** Knowledge, Understanding  |  **Marks:** 8  |  **Source:** Chapter 8

### Question

**(a)** *(Knowledge, 3 marks)* What are the goals of software testing? Distinguish between validation testing and defect testing, and between verification and validation.

**(b)** *(Understanding, 5 marks)* Explain the three stages of testing for a commercial software system. Then describe test-driven development (TDD) and its benefits.

### Answer

#### (a) Goals of testing and V&V

**Testing** is meant to show that a program does what it is intended to do and to discover defects before the program is put into use. When testing, the program is executed with artificial data and the results are checked for errors or anomalies. Testing has two goals:

1. To show the developer and customer that the software **meets its requirements**. This is called **validation testing**. The test cases reflect how the system is expected to be used.
2. To **find inputs where the software behaves incorrectly** or not according to its specification. This is called **defect testing**. The test cases can be deliberately unusual and do not have to reflect normal use.

An important limit of testing is that it can only show that errors are present. It cannot show that there are none.

Testing is part of the broader process of **verification and validation (V&V)**:

- **Verification:** "Are we building the product right?" It checks that the software meets its stated functional and non-functional requirements.
- **Validation:** "Are we building the right product?" It is a more general check that the software meets the customer's real expectations.

The goal of V&V is to build confidence that the system is "fit for purpose". The confidence needed depends on how critical the software is, what users expect, and the current marketing environment.

#### (b) Stages of testing and test-driven development

**Three stages of testing**

| Stage | Who Tests | Purpose | Details |
|---|---|---|---|
| **1. Development testing** | The development team (programmers and designers) | Discover bugs and defects during development | Done in three levels: **unit testing** (individual methods or classes), **component testing** (several units combined, focusing on component interfaces), and **system testing** (components integrated, focusing on their interactions). |
| **2. Release testing** | A separate testing team, not the developers | Check that a complete release meets requirements and is good enough for use | Usually *black-box* (functional) testing, where tests are derived from the specification. It is a validation check. |
| **3. User testing** | Users or customers in their own environment | Check suitability in real working conditions, which developers cannot fully reproduce | Includes **alpha testing** (selected users work with the developers on early releases), **beta testing** (a larger group of users tries a release and reports problems) and **acceptance testing** (the customer decides whether to accept the system). |

Testing usually mixes manual and automated methods. Automated tests are especially useful for *regression testing*, which means re-running earlier tests to check that new changes have not introduced new bugs.

**Test-driven development (TDD)**

TDD is an approach in which testing and code development are interleaved. Code is developed in small increments along with its tests, and the next increment is not started until the current code passes all its tests. It began as part of Extreme Programming but can now be used in both agile and plan-based processes.

**The TDD process:**

1. Identify a small piece of new functionality.
2. Write an automated test for it.
3. Run the test (with all other tests). It should fail at first, because the feature is not yet implemented. This shows the test adds something new.
4. Implement the functionality, refactoring existing code if needed, and run the tests again.
5. When all tests pass, move on to the next piece of functionality.

**Benefits of TDD:**

- **Code coverage:** every piece of code has at least one test, so defects are found early.
- **Regression testing:** the test suite grows with the program and can be re-run at any time.
- **Simpler debugging:** when a test fails, the problem is most likely in the newly written code.
- **System documentation:** the tests describe what the code is supposed to do.

**Limitations:** TDD works best for new development. It is hard to use when large existing components or legacy systems are reused, and it can be ineffective for multithreaded systems. A separate system testing process is still needed to check that the system meets all stakeholder requirements.

---

## References

1. Sommerville, I. (2016). *Software Engineering* (10th ed., Global Edition). Pearson Education Limited. ISBN 978-1-292-09613-1.

**Chapters used from the book:**

| Question | Chapter |
|---|---|
| Q1 | Chapter 2: Software Processes |
| Q2 | Chapter 3: Agile Software Development |
| Q3 | Chapter 4: Requirements Engineering |
| Q4 | Chapter 6: Architectural Design |
| Q5 | Chapter 8: Software Testing |