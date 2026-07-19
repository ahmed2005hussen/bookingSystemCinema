# 🎬 Cinema Ticket Booking System

A simple console-based Java application that simulates a cinema ticket booking system, built using core Java fundamentals: arrays, loops, conditionals, and functions.

> Assignment project — Route Academy

---

## 📋 Overview

The system manages seat bookings for a cinema hall with **5 rows** and **6 seats per row**. Users can view seat availability, book seats, cancel bookings, view the list of movies showing, and check occupancy statistics — all through a simple text menu.

## ✨ Features

- **Display Seats** — View the current seating layout (`O` = Available, `X` = Booked)
- **Book Seat** — Reserve a seat by entering its number (e.g. `12` → row 1, seat 2)
- **Cancel Booking** — Free up a previously booked seat
- **Show All Movies** — List all movies currently showing
- **Show Seat Stats** — Display the count of available and booked seats
- **Almost Full Alert** — Automatically warns when occupancy exceeds 80%
- **Input Validation** — Rejects invalid row/seat numbers with a clear error message

## 🧱 Data Structures

```java
char[][] seats = new char[5][6];
String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};
```

| Symbol | Meaning     |
|--------|-------------|
| `O`    | Available   |
| `X`    | Booked      |

## 🎟️ Seat Numbering Format

Seats are entered as a two-digit number `RC`, where:
- `R` = Row number (1–5)
- `C` = Seat/column number (1–6)

**Example:** Entering `12` books **row 1, seat 2**.

## 🖥️ Main Menu

```
1. Display Seats
2. Book Seat
3. Cancel Booking
4. Show all movies
5. Show number of available and booked seats
0. Exit
```

## ▶️ How to Run

1. Make sure you have **Java (JDK 17+)** installed.
2. Compile the program:
   ```bash
   javac Main.java
   ```
3. Run it:
   ```bash
   java Main
   ```

## 🧪 Example Session

```
1. Display Seats
2. Book Seat
3. Cancel Booking
4. Show all movies.
5. Show number of available and booked seats
0. Exit
Enter your choice: 2
Enter the number of seat: 12
book done successfully
-------------------
1. Display Seats
2. Book Seat
...
Enter your choice: 1
Current Seats:
   O   X   O   O   O   O
   O   O   O   O   O   O
   O   O   O   O   O   O
   O   O   O   O   O   O
   O   O   O   O   O   O
-------------------------
```

## ✅ Validation Rules

- Row numbers must be between **1 and 5**.
- Seat numbers must be between **1 and 6**.
- Attempting to book an already booked seat, or cancel an unbooked seat, shows a clear message instead of crashing.
- Invalid seat numbers display: `Invalid Seat.`

## 🛠️ Tech Stack

- **Language:** Java
- **Concepts used:** 2D arrays, loops (`for`), conditionals (`if`/`switch`), methods/functions, `Scanner` for input
