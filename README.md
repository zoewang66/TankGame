# Java Tank Project

A simple yet engaging tank battle game written in Java, showcasing the use of Java threads and object-oriented programming principles. This project demonstrates proficiency in **multithreaded programming** and **object-oriented design**, providing a fun way to learn and practice core Java concepts.

---

## Project Overview

- **Multithreaded Programming:** Multiple tanks and game elements run concurrently using Java's threading mechanisms.  
- **Object-Oriented Design:** Different elements of the game (tanks, bullets, bombs, etc.) are modeled as objects, resulting in a clear, maintainable, and extensible code structure.  
- **Game Logic:** Includes tank movement, shooting, collision detection, scoring, and the ability to load/save game progress.  

---

## Screenshot

Below is a snapshot of the running game interface:

![Tank Game Screenshot](tankgame_screenshot.png)

*(Replace `tankgame_screenshot.png` with the actual path to your screenshot file. You can store the image in the same folder as this README or in a dedicated images folder, adjusting the path accordingly.)*

---

## How to Compile & Run

1. **Clone or download** this repository, and navigate into the project directory.

2. **Compile all source files**:
   ```bash
   find src -name "*.java" > sources.txt
   javac -d bin @sources.txt
