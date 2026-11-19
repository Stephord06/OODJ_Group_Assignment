# APU Automotive Service Centre (APU ASC) System

![Java](https://img.shields.io/badge/Java-JDK%208%2B%20(NetBeans%20JDK%2025)-ED8B00?style=flat&logo=openjdk&logoColor=white)
![UI](https://img.shields.io/badge/GUI-Java%20Swing%20%26%20AWT-007396?style=flat)
![Storage](https://img.shields.io/badge/Persistence-Flat--File%20(.txt%20%2F%20Properties)-4A5568?style=flat)
![Dependencies](https://img.shields.io/badge/External%20Dependencies-None%20(Pure%20Java%20SE)-2E7D32?style=flat)

A multi-role Java Swing desktop management system built for the **Object-Oriented Development with Java (OODJ)** group assignment at Asia Pacific University (APU). The **APU Automotive Service Centre (APU ASC) System** digitizes day-to-day service centre operations — from customer registration and appointment scheduling to technician task updates, payment collection, receipt issuance, customer feedback, pricing management, and business reporting.

---

## Table of Contents

- [Features by User Role](#features-by-user-role)
- [Service Tiers & Appointment Workflow](#service-tiers--appointment-workflow)
- [Tech Stack & OOP Architecture](#tech-stack--oop-architecture)
- [Data Persistence Format](#data-persistence-format)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Demo Accounts](#demo-accounts)
- [Contributors](#contributors)

---

## Features by User Role

All users sign in through a single unified login portal (`GeneralTools.Login`), which supports case-insensitive authentication by **User ID** or **Full Name** and automatically routes users to their respective dashboard.

### Manager (`manager`)
- **User & Role Management (`ModifyRoles`)** — Full CRUD across all four user roles (`Manager`, `CounterStaff`, `Technician`, `Customer`) with live search by ID/name and automatic role-prefixed ID generation (`M###`, `S###`, `T###`, `C###`).
- **Service Pricing Configuration (`SetPrices`)** — View and update base service rates (in RM) for 1-hour Normal Service and 3-hour Major Service, stored via Java `Properties`.
- **Business Analytics Report (`AnalyzedReport`)** — Displays KPI summary cards for **Total Revenue**, **Total Appointments**, **Total Paid Appointments**, and **Total Comments**, with service-type filtering (`All`, `Normal Service`, `Major Service`).
- **Comments & Feedback Oversight (`ViewComment`)** — Scrollable review feed of all appointments showing both customer comments and technician feedback, with real-time search by Appointment ID.

### Counter Staff (`counterstaff`)
- **Operations Dashboard (`StaffDashboard`)** — Displays live KPI metrics (Total Appointments, Pending Payment count, Total Revenue & Receipt count, Total Customers) alongside quick-action cards.
- **Customer Management (`ManageCustomer`, `AddCustomer`, `EditCustomer`)** — Searchable customer directory with add (auto-generated `C###` ID and default password), edit (preserving existing password), and delete with confirmation.
- **Appointment Scheduling (`CreateAppointment`)** — Guided booking workflow with live customer search, service tier selection, date picker, cascading time-slot selection with automatic end-time calculation, and technician assignment (`A###` ID).
- **Payment Collection & Receipt Generation (`CollectPayment`, `Receipt`)** — Lists completed appointments ready for settlement, fetches current service pricing from `setPrices.txt`, supports **Cash** or **Card** payment, generates a sequential receipt (`R###`), marks the appointment `Paid`, and displays a formatted payment receipt.
- **Profile Management (`EditProfile`)** — Update personal contact number, email, and password (with current password verification).

### Technician (`technician`)
- **Personal Profile (`Profile`, `ProfileEdit`)** — View profile details and update contact number, email, and password with regex/length validation (10–11 digit contact number, valid email format, minimum 6-character password).
- **Assigned Appointment Details & Feedback (`Appointments`, `AppointmentDetails`)** — Inspect full booking details and customer comments for assigned jobs, and submit or edit technician service feedback.
- **Appointment Status Tracking (`AppointmentTable`)** — Tabular view of all assigned appointments with live reload and status updates between `Pending` and `Completed`.

### Customer (`customer`)
- **Profile Management (`EditProfile`)** — Edit contact details and password with save confirmation, revert option, and automatic re-login prompt upon password change.
- **Service & Payment History (`ViewHistory`)** — Tabbed view separating full **Service History** (with color-coded status badges, duration, assigned staff/technician, and amount paid) and **Payment History** (itemized receipt cards).
- **Technician Feedback Viewer (`ViewFeedback`)** — Card-based view of each appointment alongside the technician's service feedback and the customer's own comment.
- **Service Comments (`ProvideComment`)** — Two-pane interface to select an appointment and submit or update comments for counter staff and technicians.

---

## Service Tiers & Appointment Workflow

| Service Tier | Duration | Available Start Slots | Default Rate (`setPrices.txt`) |
| --- | --- | --- | --- |
| **Normal Service** | 1 hour (`1hour`) | `09:00 AM` – `04:00 PM` | RM 200 |
| **Major Service** | 3 hours (`3hour`) | `09:00 AM` – `02:00 PM` | RM 500 |

**Lifecycle:**
1. **`Pending`** — Counter Staff books an appointment and assigns a Technician.
2. **`Completed`** — Technician completes the job, updates the status in `AppointmentTable`, and records technical feedback.
3. **`Paid`** — Counter Staff collects Cash/Card payment in `CollectPayment`, issues a receipt in `receipts.txt`, and updates status to `Paid`. Customers can review history/feedback and post comments; Managers monitor comments and revenue reports.

---

## Tech Stack & OOP Architecture

- **Language:** Java (Pure Java SE — zero third-party dependencies)
- **GUI Framework:** Java Swing & AWT (`javax.swing`, `java.awt`)
- **IDE / Build System:** Apache NetBeans (Ant project)
- **OOP Design:**
  - **Inheritance:** `GeneralTools.User` serves as the base class (`userID`, `userName`, `contactNum`, `email`, `password`, `role`, file-loading helpers) extended by `Manager`, `CounterStaff`, `Technician`, and `Customer`.
  - **Abstraction & Interfaces:** Role contracts defined via `ManagerStandard_Method`, `CounterStaffStandardMethod`, and `CustomerStandard_Method`.
  - **Encapsulation:** Private UI state and domain fields exposed through getters/setters (`User`, `ReadAppointment`).
  - **Separation by Package:** Dedicated packages per user role plus shared utilities and a reusable `FileManager` persistence layer.

---

## Data Persistence Format

All application data is persisted in plain-text files inside `JAVAGROUPWORK/` (referenced via relative paths from that directory):

| File | Delimiter / Format | Schema |
| --- | --- | --- |
| `managers.txt` | Pipe (`\|`) | `UserID\|Name\|ContactNumber\|Email\|Password` (`M###`) |
| `counterStaffs.txt` | Pipe (`\|`) | `UserID\|Name\|ContactNumber\|Email\|Password` (`S###`) |
| `technicians.txt` | Pipe (`\|`) | `UserID\|Name\|ContactNumber\|Email\|Password` (`T###`) |
| `customers.txt` | Pipe (`\|`) | `UserID\|Name\|ContactNumber\|Email\|Password` (`C###`) |
| `appointments.txt` | Pipe (`\|`) | `AppointID\|CustomerID\|TechnicianID\|StaffID\|ServiceType\|Date\|TimeStart\|TimeEnd\|TechnicianFeedback\|CustomerComment\|Status` (`A###`) |
| `receipts.txt` | Pipe (`\|`) | `ReceiptID\|AppointmentID\|CustomerName\|ServiceType\|TechID - TechName\|Date\|TimeSlot\|PaymentMethod\|Amount` (`R###`) |
| `setPrices.txt` | Java `Properties` | `1hour=<price>`, `3hour=<price>` |

---

## Project Structure

```text
OODJ_Group_Assignment/
├── README.md
└── JAVAGROUPWORK/
    ├── build.xml
    ├── manifest.mf
    ├── appointments.txt
    ├── counterStaffs.txt
    ├── customers.txt
    ├── managers.txt
    ├── receipts.txt
    ├── setPrices.txt
    ├── technicians.txt
    ├── nbproject/
    │   ├── build-impl.xml
    │   ├── genfiles.properties
    │   ├── project.properties
    │   └── project.xml
    └── src/
        ├── GeneralTools/        # Login, User base class, ReadAppointment
        ├── counterstaff/        # StaffDashboard, Customer CRUD, CreateAppointment, CollectPayment, Receipt, FileManager
        ├── customer/            # CustomerDashBoard, EditProfile, ViewHistory, ViewFeedback, ProvideComment
        ├── manager/             # ManagerDashBoard, ModifyRoles, SetPrices, AnalyzedReport, ViewComment
        └── technician/          # TechnicianDashBoard, Profile/ProfileEdit, Appointments, AppointmentDetails, AppointmentTable
```

---

## Getting Started

### Prerequisites
- **JDK 8 or higher** for command-line compilation (or **JDK 25** to match the default NetBeans `nbproject/project.properties` target without modifying project settings).
- *(Optional)* **Apache NetBeans IDE** or **Apache Ant**.

> **Important:**
> 1. **Working Directory:** Always run the application from inside the `JAVAGROUPWORK/` directory so relative paths to the `.txt` data files resolve properly.
> 2. **Entry Point:** Launch **`GeneralTools.Login`** as the main class. *(Note: `nbproject/project.properties` currently points `main.class` to `counterstaff.StaffDashboard`, which has an empty `main` method.)*

### Option 1: Run from the Command Line

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Stephord06/OODJ_Group_Assignment.git
   cd OODJ_Group_Assignment/JAVAGROUPWORK
   ```

2. **Compile all sources:**
   - **Windows (PowerShell):**
     ```powershell
     New-Item -ItemType Directory -Force -Path build\classes | Out-Null
     javac -encoding UTF-8 -d build\classes (Get-ChildItem -Recurse -Filter *.java src).FullName
     ```
   - **macOS / Linux:**
     ```bash
     mkdir -p build/classes
     javac -encoding UTF-8 -d build/classes $(find src -name "*.java")
     ```

3. **Run the application:**
   ```bash
   java -cp build/classes GeneralTools.Login
   ```

### Option 2: Run in Apache NetBeans IDE

1. Open Apache NetBeans and go to **File → Open Project...**
2. Select the `JAVAGROUPWORK` folder.
3. If using a JDK version earlier than JDK 25, update **Project Properties → Sources → Source/Binary Format** to match your installed JDK.
4. Right-click `src/GeneralTools/Login.java` and choose **Run File** (or set **Project Properties → Run → Main Class** to `GeneralTools.Login` and click **Run Project**).

---

## Demo Accounts

Sample credentials pre-populated in the repository's `.txt` files for testing each role:

| Role | User ID | Password | Notes |
| --- | --- | --- | --- |
| **Manager** | `M001` | `password123` | Full role, pricing, analytics, and comment access |
| **Counter Staff** | `S001` | `abc123456` | Manage customers, book appointments, collect payments |
| **Technician** | `T001` | `password123` | Assigned sample appointments (`A001`, etc.) |
| **Customer** | `C003` | `password789` | Includes existing paid appointment (`A001`) and receipt (`R001`) |

---

## Contributors

- [@Stephord06](https://github.com/Stephord06)
- [@chownm](https://github.com/chownm)
- [@LHM2006](https://github.com/LHM2006)
