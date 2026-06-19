# SeatMap 🗺️

SeatMap è un'applicazione per la gestione e la prenotazione delle postazioni (scrivanie/desk) all'interno degli uffici. Il progetto include un back-end in Java e un front-end reattivo sviluppato in Angular.

## 🚀 Tecnologie Utilizzate

### Back-End
- Java con framework Spring Boot
- JPA per la persistenza dei dati
- PostgreSQL (Database relazionale)

### Front-End
- **Angular**
- **TypeScript**
- **HTML5 & CSS3**

### DevOps & Strumenti
- **Docker & Docker Compose** (per la containerizzazione)
- **Git & GitHub** (controllo di versione)

## 📁 Struttura del Repository

- `BackEnd/`: Contiene l'applicazione back-end Java.
- `FrontEnd/`: Contiene l'applicazione front-end Angular.
- `docker-compose.yml`: File di configurazione per avviare i servizi (es. database).
- `dbbackup.sql`: Backup iniziale o dump del database per il test.

## 🛠️ Come Avviare il Progetto Localmente

### 1. Prerequisiti
Assicurati di avere installato sul tuo computer:
- Java JDK (versione 17 o superiore consigliata)
- Node.js e npm
- Angular CLI
- Docker e Docker Compose

### 2. Configurazione del Database
Se usi Docker, puoi avviare l'ambiente del database posizionandoti nella root del progetto ed eseguendo:
```bash
docker compose up -d
```
*Nota: se necessario, importa il file `dbbackup.sql` nel tuo client di database.*

### 3. Avviare il Back-End (Java)
1. Entra nella cartella del back-end:
   ```bash
   cd seatmap/seatmap
   ```
2. Avvia l'applicazione con il tuo IDE (IntelliJ, Eclipse, VS Code) oppure tramite riga di comando Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

### 4. Avviare il Front-End (Angular)
1. Apri un nuovo terminale ed entra nella cartella del front-end:
   ```bash
   cd FrontEnd
   ```
2. Installa le dipendenze:
   ```bash
   npm install
   ```
3. Avvia il server di sviluppo:
   ```bash
   ng serve
   ```
4. Apri il browser all'indirizzo `http://localhost:4200/`.

## 🧑‍💻 Autore
- **Vincenzo Barreca** - [vincys21](https://github.com)
