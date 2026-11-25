# 🧩 CampusBoot

A tiny Spring-Boot-style framework built from scratch with **Java Reflection** and **custom annotations**.
No external libraries, just plain Java 11+.

> Spring Boot's `@Component`, `@Value` and `@GetMapping` are not magic. They are annotations plus reflection.
> CampusBoot shows how.

## ✨ Features

| Annotation | Applies to | Purpose |
|------------|-----------|---------|
| `@Component` | Class | Marks a class to be created and managed by the container |
| `@Value("key")` | Field | Injects a configuration value (`String` or `int`) |
| `@Range(min, max, message)` | Field | Validates that an `int` field is within bounds |
| `@Route("/path")` | Method | Maps a URL path to a method |

All four use `@Retention(RetentionPolicy.RUNTIME)` so reflection can read them while the program runs.

## 🏗️ How it works

```
Container.scan(...)          -> finds @Component classes, creates beans (IoC)
Container.injectValues(cfg)  -> sets @Value fields via reflection (setAccessible(true))
Validator.validate(obj)      -> reads @Range fields, returns violation messages
Router.dispatch(c, path)     -> finds the @Route method for a path and invokes it
```

## 📁 Project structure

```
CampusBoot/
├── Component.java        # annotation
├── Value.java            # annotation
├── Range.java            # annotation
├── Route.java            # annotation
├── Container.java        # IoC container + value injection
├── Validator.java        # @Range validator
├── Router.java           # @Route dispatcher
├── GradeController.java  # sample bean
├── ReportPrinter.java    # sample class with NO annotation (gets skipped)
├── Student.java          # sample model with @Range fields
├── Main.java             # demo
└── answers.txt           # reflection questions
```

## 🚀 Getting started

**Requirements:** JDK 11 or newer.

### IntelliJ IDEA
1. Open the folder as a project (or create a new Java project and copy in the `.java` files).
2. Open `Main.java` and click the green ▶ next to `main`.

### Command line
```bash
mkdir out
javac -d out *.java
java -cp out Main
```

## 🖥️ Expected output

```
[Container] Registered: gradeController (GradeController)
[Container] Skipped: ReportPrinter (no @Component)
[Container] Injected: app.name -> GradeController.appName
[Container] Injected: app.passMark -> GradeController.passMark
--- Validation ---
VIOLATION: score - Score must be between 0 and 100 (actual: 120)
OK
VIOLATION: semester - Value out of range (actual: 15)
--- Routing ---
[Router] /hello -> Welcome to CampusBoot
[Router] /status -> Pass mark is 40
[Router] /unknown -> 404 Not Found: /unknown
```

## 💡 Example

```java
@Component("gradeController")
public class GradeController {
    @Value("app.name") private String appName;

    @Route("/hello")
    public String hello() { return "Welcome to " + appName; }
}
```

## 🔍 CampusBoot vs. Spring Boot

| CampusBoot | Spring Boot |
|-----------|-------------|
| `@Component` | `@Component` / `@Service` / `@Controller` |
| `@Value` | `@Value("${...}")` |
| `@Range` | Bean Validation (`@Min`, `@Max`, `@Valid`) |
| `@Route` | `@GetMapping` / `@RequestMapping` |

**What real Spring adds:** dependency injection between beans (`@Autowired`), automatic package scanning,
bean scopes, and a full web server with HTTP methods, parameters and JSON.

## 📝 Design note

`@Route` declares both `path()` and `value()` (each defaulting to `""`). The spec calls for `path()`,
while the shorthand `@Route("/hello")` only compiles if an element is named `value`. The Router
accepts either form.

## 🎓 Learning outcomes

- Declaring custom annotations with `@Target`, `@Retention` and defaults
- Using `Class`, `Field` and `Method` reflection to read annotations at runtime
- Building a mini IoC container, value injector, validator and router

## 📄 License

Educational project. Use it however you like.
