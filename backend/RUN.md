# Running the Backend

## Prerequisites
- Java 17 or higher
- PostgreSQL database running
- Set environment variables (optional):
  - `DATABASE_URL` (default: `jdbc:postgresql://localhost:5432/payir`)
  - `DATABASE_USER` (default: `postgres`)
  - `DATABASE_PASSWORD` (default: `postgres`)

## Running the Application

### First Time Setup
1. Navigate to backend directory:
   ```bash
   cd backend
   ```

2. Create Gradle wrapper (if not exists):
   ```bash
   gradle wrapper
   ```
   Or on Windows:
   ```bash
   gradle.bat wrapper
   ```

### Run the Application

**Using Gradle Wrapper:**
```bash
# Windows
.\gradlew.bat run

# Linux/Mac
./gradlew run
```

**Using Gradle directly (if installed):**
```bash
gradle run
```

### Build JAR
```bash
.\gradlew.bat build
java -jar build\libs\payir-backend-1.0.0.jar
```

## Troubleshooting SSL Issues

If you encounter SSL/certificate errors:

1. Check your internet connection
2. Check if you're behind a corporate proxy (configure proxy settings)
3. Try running with:
   ```bash
   .\gradlew.bat wrapper --no-daemon
   ```

## Server Endpoints

Once running, the server will be available at:
- http://localhost:3000
- http://0.0.0.0:3000

