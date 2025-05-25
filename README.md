
# Melodex Application 🎶

Melodex is a Spring Boot application that manages music-related data, including artists, albums, and tracks. It provides functionality for fetching, storing, and managing music data with JPA repositories and an interactive menu-driven interface. It uses the TheAudioDB API as the data source.
## Features

- Manage artists, albums, and tracks using JPA entities and repositories.
- Convert JSON data into Java objects using Jackson.
- Fetches artist, album, and track data using TheAudioDB API.
- Stores data in a local database using Spring Data JPA.
- Interactive command line interface to navigate the application.

## Technologies

- Java 17+
- Spring Boot
- Spring Data JPA
- Jackson for JSON parsing
- Jakarta Persistence (JPA)
- Postgres or any other relational database
- TheAudioDB API

## Project Structure

- `com.melodex.modules.artists`: Artist entity, DTOs, and data wrappers.
- `com.melodex.modules.albums`: Album entity, DTOs, and data wrappers.
- `com.melodex.modules.tracks`: Track entity, DTOs, and data wrappers.
- `com.melodex.repository`: JPA repositories for artists, albums, and tracks.
- `com.melodex.services`: Services for HTTP requests and JSON conversion.
- `com.melodex`: Main application entry point.

## Running the Application

1. Clone the repository.
2. Build the project using Maven or Gradle.
3. Run the application with:
   ```
   mvn spring-boot:run
   ```
   or from your IDE.
4. The application starts and displays a menu for interaction.

## Usage

Use the console menu to interact with the application. Options include managing artists, albums, and tracks.

## Notes

- Ensure your database is configured in `application.properties` or `application.yml`.
- The application uses JPA entities and repositories to persist data.

