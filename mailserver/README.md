# Spring Boot Mail Server REST API with PostgreSQL

## Prosjektbeskrivelse
Dette er et Spring Boot-basert Mail Server API som bruker PostgreSQL som database. API-et håndterer funksjonaliteter som å opprette brukere, sende e-poster, hente e-posthistorikk og mer.

## Teknologier brukt
- **Java 20 eller høyere**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven** (for bygging og administrasjon av prosjektet)
- **Lombok** (valgfritt, for å redusere boilerplate kode)

## Forutsetninger
For å komme i gang med prosjektet, trenger du følgende:

- **PostgreSQL**: Installer PostgreSQL på systemet ditt.
- **Java 20 eller høyere**: Sørg for at du har installert Java 20 eller en nyere versjon.
- **Maven**: Maven må være installert, eller du kan bruke Maven Wrapper (som er inkludert i prosjektet).

## Komme i gang

### Steg 1: Sett opp PostgreSQL-database
1. Installer PostgreSQL hvis det ikke allerede er installert på systemet ditt.
2. Opprett en ny database med navnet `mailserverdb` (eller et annet navn du ønsker å bruke).
3. Opprett en ny bruker i PostgreSQL med nødvendige privilegier for å aksessere og administrere databasen (f.eks. `Admin_mailserver`).

### Steg 2: Konfigurer `application.properties`
I `src/main/resources/application.properties`, oppdater følgende konfigurasjon med din databasebruker og passord:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mailserverdb
spring.datasource.username=din_brukernavn
spring.datasource.password=din_passord
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

Steg 3: Bygg og kjør applikasjonen
Bygg prosjektet med Maven:
mvn clean install
Start applikasjonen med Maven:
mvn spring-boot:run
Når applikasjonen er startet, skal den være tilgjengelig på http://localhost:8080.

Prosjektstruktur
Modeller: Jeg har laget to hovedmodeller: User og Email. Disse modellene representerer tabellene i databasen.
User-modellen inneholder feltene id, username, email, password.
Email-modellen inneholder feltene id, fromEmail, toEmail, subject, body, timestamp.

Repository: Repositories er laget for å håndtere CRUD-operasjoner på User og Email.
Service: Serviceklasser håndterer forretningslogikken for bruker- og e-postoperasjoner.

Controller: REST-kontrollere er laget for å eksponere API-endepunktene for å opprette, hente og håndtere brukere og e-poster.

API Endepunkter
POST /users: Opprett en ny bruker. (Sender brukerdata som JSON).

Eksempel:
{
  "username": "john_doe",
  "email": "john.doe@example.com",
  "password": "securepassword"
}

GET /users/{id}: Hent informasjon om en spesifikk bruker ved å bruke brukerens ID.

GET /emails: Hent alle e-poster fra databasen.

POST /emails: Send en ny e-post ved å sende e-postdata som JSON.

Eksempel:
{
  "fromEmail": "john.doe@example.com",
  "toEmail": "jane.smith@example.com",
  "subject": "Hello",
  "body": "This is a test email",
  "timestamp": "2025-03-01T12:00:00"
}

Testing med Postman:
Jeg har testet API-et ved hjelp av Postman. Alle endepunktene fungerer som forventet, og dataene kan opprettes, hentes og manipuleres som definert i prosjektet.

Hvordan laste opp prosjektet:
GitHub: Prosjektet kan lastes opp til GitHub som en zip-fil eller ved hjelp av et Git-lager.
Dokumentasjon: Dokumentasjonen for API-et er beskrevet her, og Swagger eller Spring Rest Docs kan brukes til videre dokumentasjon av API-ene.

Feilsøking:
Hvis du støter på problemer med å koble til PostgreSQL-databasen, sjekk at:
PostgreSQL-serveren kjører.

Databasens navn og brukeropplysninger er korrekt konfigurert i application.properties.
Bidragsytere

Alan Jan Urban - Hovedutvikler og implementering av modellen, service, controller, og repository.

Lisens:
Dette prosjektet er lisensiert under Apache License 2.0 - se LICENSE for detaljer.