# Quick Commands - Payir Backend

## ✅ Run Without Creating Wrapper (Gradle Already Installed)

Since Gradle 8.13 is installed, you can run directly:

```bash
# Navigate to backend folder
cd "E:\New folder\kohacks-2025\backend"

# Run the application
gradle run
```

**That's it!** The server will start on **http://localhost:3000**

---

## 🚀 Alternative Commands

### Build Only
```bash
cd "E:\New folder\kohacks-2025\backend"
gradle build
```

### Run JAR After Build
```bash
java -jar "E:\New folder\kohacks-2025\backend\build\libs\payir-backend-1.0.0.jar"
```

### Clean Build
```bash
cd "E:\New folder\kohacks-2025\backend"
gradle clean build
```

---

## ⚠️ Important Notes

1. **Java Version**: You have Java 11, but project requires Java 17+
   - Option 1: Install Java 17+ and set JAVA_HOME
   - Option 2: Update build.gradle.kts to support Java 11 (temporary)

2. **PostgreSQL**: Make sure database is running before starting server

3. **Skip Wrapper**: You don't need `gradle wrapper` - just use `gradle run` directly

---

## 🛑 Stop Server

Press `Ctrl + C` in terminal

---

## 📍 Server Address

Once running:
- **Local**: http://localhost:3000
- **Network**: http://0.0.0.0:3000

