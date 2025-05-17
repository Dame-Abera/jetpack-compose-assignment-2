# Todo List App

A modern Android application that fetches TODO items from the JSONPlaceholder API, displays them in a scrollable Jetpack Compose UI, and caches them locally using Room for offline access. The app uses MVVM architecture with Hilt for dependency injection and Material 3 components for a polished look.

## Features

- **Remote Data Fetching**: Uses Retrofit to retrieve todos from `https://jsonplaceholder.typicode.com/todos`.  
- **Local Caching**: Stores and observes data in a Room database so that todos are available offline and load instantly on app start.  
- **Data Synchronization**: On launch, displays cached data immediately and then refreshes in the background, updating both UI and database.  
- **Compose UI**: Implements a `LazyColumn` for efficient scrolling and displays loading/error states.  
- **Navigation**: Uses Jetpack Compose Navigation to move between the list and detail screens, passing the selected todo’s ID.  
- **Detail View**: Shows full information (title, user ID, completed status) for a selected todo item, with back navigation.  

## Tech Stack

- **Kotlin**  
- **Jetpack Compose** (UI layer with Material 3)  
- **Retrofit + Gson** (networking)  
- **Room** (local persistence)  
- **Hilt** (dependency injection)  
- **Coroutines & Flow** (asynchronous and reactive streams)  
- **Navigation Compose** (in-app navigation)  

## Installation

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Dame-Abera/jetpack-compose-assignment-2.git
   cd jetpack-compose-assignment-2
