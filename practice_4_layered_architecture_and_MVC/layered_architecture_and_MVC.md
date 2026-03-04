**Authors:** Henry Fernando Mulato Llanten - Leider Ceron - Juan Jose Hurtado

**Prototypes:** [Prototype Figma](https://www.figma.com/design/xuDc5jfUPLjyiSoS8VALcY/piedra-Azul?node-id=0-1&t=d9vzoc5Hh4b6WqfK-1)

# Laboratory Workshop: Layered Architecture and MVC

## University Information

**University:** Universidad del Cauca
**Department:** Departamento de Sistemas
**Course:** Software Engineering II Laboratory
**Semester:** 2026.1
**Workshop:** Layered Architecture and MVC

---

## Objective

Apply the **Three-Layer Architecture** and the **Model-View-Controller (MVC)** pattern in the design and implementation of flexible, maintainable, and modifiable software systems.

---

## Workshop Description

This workshop focuses on applying architectural principles and design patterns to a course project. The goal is to move from validated functional requirements to a structured implementation using layered architecture and MVC.

The application must:

* Be implemented in **Java**.
* Follow a **three-layer architecture**.
* Apply **SOLID principles**.
* Use selected **GoF design patterns**.
* Implement **MVC using the Observer pattern**.
* Be developed as a **desktop monolithic application**.

---

## Development Phases

### 1. User Interface Prototyping

Based on the validated functional requirements for the first academic period, user interface prototypes were designed.

Tools suggested:

* Balsamiq
* WireframeSketcher

The objective of this phase was to:

* Visualize system interactions.
* Validate usability before implementation.
* Identify improvements early in the design process.

---

### 2. Usability Testing – Thinking Aloud

A **Thinking Aloud usability test** was applied to the prototypes.

In this technique, users interact with the prototype while verbally expressing their thoughts. This allows identification of:

* Usability issues
* Confusing navigation flows
* Interface inconsistencies
* Improvement opportunities

This phase ensured that the system design is user-centered before implementation.

---

## Architectural Design

The system architecture was based on the previously developed **C4 Model diagrams**.

The final implementation follows a **Three-Layer Architecture**:

### 1. Presentation Layer

* Implements the **View** component of MVC.
* Handles user interaction.
* Displays system data.
* Observes changes in the Model using the **Observer pattern**.

### 2. Business Logic Layer

* Implements application use cases.
* Contains domain logic.
* Applies SOLID principles.
* Coordinates communication between presentation and data layers.

### 3. Data Access Layer

* Manages data persistence.
* Encapsulates database or storage operations.
* Reduces coupling with business logic.

This separation ensures:

* High cohesion
* Low coupling
* Improved maintainability
* Better scalability

---

## MVC Implementation

The **Model-View-Controller (MVC)** pattern was implemented as follows:

### Model

* Represents domain entities and business state.
* Notifies observers when its state changes.

### View

* Displays information to the user.
* Subscribes to model updates using the **Observer pattern**.

### Controller

* Handles user input.
* Coordinates actions between View and Model.

The use of the **Observer pattern** ensures that when the model state changes, all subscribed views are automatically notified and updated.

This design promotes:

* Loose coupling
* Separation of concerns
* Extensibility

---

## SOLID Principles Applied

The following principles were considered during implementation:

* **Single Responsibility Principle (SRP):** Each class has a single well-defined responsibility.
* **Open/Closed Principle (OCP):** System components are open for extension but closed for modification.
* **Liskov Substitution Principle (LSP):** Subclasses can replace their base classes without altering system correctness.
* **Interface Segregation Principle (ISP):** Interfaces are specific and focused.
* **Dependency Inversion Principle (DIP):** High-level modules depend on abstractions, not concrete implementations.

---

## Design Patterns Used

* **Observer Pattern** (for MVC interaction between Model and View)
* Additional GoF patterns where necessary to improve flexibility and maintainability

These patterns enhance:

* Modifiability
* Reusability
* Architectural clarity

---

## Functional Testing

Functional tests were implemented to verify that:

* Validated functional requirements are correctly implemented.
* Use cases behave as expected.
* Architectural separation does not introduce inconsistencies.

Testing ensures reliability and validates architectural decisions.

---

## Deployment

The application was implemented as a:

* Desktop application
* Monolithic deployment

This approach simplifies development and evaluation while preserving architectural separation internally.

---

## Deliverables

The workshop requires:

1. Implemented system using three-layer architecture and MVC.
2. Usability-tested UI prototypes.
3. Functional tests.
4. Project advances presented before the first partial evaluation.

---

## Conclusions

This workshop reinforces the importance of structured software architecture in building maintainable systems. By applying layered architecture and MVC, the system achieves clear separation of concerns and improved flexibility.

The integration of usability testing, SOLID principles, and design patterns demonstrates how theoretical concepts directly impact practical software development.

The exercise also highlights how architecture decisions influence system quality attributes such as maintainability, extensibility, and testability.
