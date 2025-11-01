# Quick Start Guide

## If Gradle Wrapper Fails Due to SSL Issues

The SSL certificate errors you're seeing are network-related. Here are alternative approaches:

### Option 1: Use IntelliJ IDEA (Easiest)
1. Open IntelliJ IDEA
2. Open the `backend` folder as a project
3. IntelliJ will detect the Gradle project and download dependencies
4. Run the `index.kt` file directly from IDEA

### Option 2: Manual Dependency Download
If you have Maven available:
```bash
cd backend
mvn dependency:resolve  # This might work if Gradle doesn't
```

### Option 3: Use Docker (Recommended for Development)
Create a `Dockerfile` in the backend folder to build and run in a container.

### Option 4: Check Network Settings
1. Verify you're not behind a corporate proxy
2. Check if firewall is blocking HTTPS connections
3. Try connecting from a different network
4. Update Java certificates: `keytool -importcert` (if needed)

### Option 5: Download Gradle Wrapper Manually
1. Download Gradle 8.5 from: https://gradle.org/releases/
2. Extract it
3. Use it directly:
   ```bash
   C:\path\to\gradle\bin\gradle.bat wrapper
   C:\path\to\gradle\bin\gradle.bat run
   ```

## Alternative: Skip Gradle Wrapper
If wrapper creation fails, you can run directly with installed Gradle:

```bash
# Make sure Gradle is installed
gradle --version

# Run directly
gradle run
```

## Note
The SSL error "No PSK available. Unable to resume" typically indicates:
- Network connectivity issues
- Corporate proxy blocking
- Java keystore certificate issues
- Firewall interference

Try running from a different network or use IntelliJ IDEA which often handles these issues better.

