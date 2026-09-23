# Smart Pantry Manager

An Android app (Java) that helps reduce food waste by tracking pantry ingredients
and suggesting recipes you can cook using **strict matching** — only recipes
whose ingredients are ALL currently in your pantry are shown.

## Database
Room (SQLite). Chosen because:
- On-device persistence, no internet required
- Type-safe queries at compile time
- Ideal for personal, offline-first data

## Setup
1. Clone this repo
2. Open in Android Studio
3. Sync Gradle, then Run on emulator or device (API 24+)

## Modules
- Pantry CRUD (add / edit / delete ingredients)
- Recipe suggestions (strict matching)
- Recipe detail, Settings