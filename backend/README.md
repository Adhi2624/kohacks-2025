# Payir Backend - Run Instructions

## 🚀 Quick Start

### Method 1: Use IntelliJ IDEA (EASIEST - Recommended)
IntelliJ IDEA handles SSL/certificate issues automatically.

1. Open **IntelliJ IDEA**
2. **File** → **Open** → Select the `backend` folder
3. Wait for Gradle sync to complete (it will download dependencies automatically)
4. Navigate to `src/main/kotlin/index.kt`
5. Right-click on the file → **Run 'IndexKt'**

✅ **Server will start on http://localhost:3000**

---

### Method 2: Run Directly with Installed Gradle
If you have Gradle installed (check with `gradle --version`):

```bash
cd backend

# Skip wrapper creation, run directly
gradle run
```

---

### Method 3: Build and Run JAR
```bash
cd backend

# Build
gradle build

# Run
java -jar build\libs\payir-backend-1.0.0.jar
```

---

## ⚠️ SSL Certificate Issues?

If you're seeing SSL errors when running `gradle wrapper`, the issue is network-related, not code-related.

**Solutions:**
1. **Use IntelliJ IDEA** (handles SSL automatically) ← **RECOMMENDED**
2. **Check network/proxy settings**
3. **Try different network** (mobile hotspot)
4. **Download Gradle manually** from https://gradle.org/releases/ and use directly

---

## 📋 Prerequisites

Before running:
- ✅ **Java 17+** installed
- ✅ **PostgreSQL** database running
- ✅ Database created: `payir` (or set `DATABASE_URL` env variable)

### Database Setup
```sql
CREATE DATABASE payir;
```

### Environment Variables (Optional)
```bash
# Windows
set DATABASE_URL=jdbc:postgresql://localhost:5432/payir
set DATABASE_USER=postgres
set DATABASE_PASSWORD=postgres
```

---

## 🌐 Server Information

- **Port**: 3000
- **URL**: http://localhost:3000
- **Host**: 0.0.0.0 (accessible from network)

---

## 🛑 Stop Server

Press `Ctrl + C` in terminal

---

## 📁 Project Structure

```
backend/
├── src/main/kotlin/
│   ├── index.kt              # Main entry point
│   ├── models/               # Database models
│   ├── controllers/          # Business logic
│   ├── routes/               # API routes
│   ├── helpers/              # Utility functions
│   └── plugins/              # Ktor plugins
└── build.gradle.kts          # Build configuration
```

