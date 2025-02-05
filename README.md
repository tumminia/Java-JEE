# Progetto Full-Stack: Back-end Java JEE e Front-end AngularJS

## Descrizione

Questo progetto è una web application full-stack che utilizza **Java JEE** per il lato back-end e **AngularJS**, **Bootstrap**, **jQuery** e **JSON** per il front-end.

Che ha come obiettivo la gestione di un ristorante, e l'applicazione web è suddivisa:
- **index.jsp**: permette di visualizzate la specialità del giorno, con i relativi ingredienti e quantità;
- **page.jsp**: ti permette di ordinare dal tavolo, inserendo le i piatti nel carrello (massimo 10 ordinazioni alla volta);
- **stock.jsp**: ti permette di visualizzare la giacenza dei prodotti alimentari presenti in frigorifero;
- **table.jsp**: ti permette di visualizzare la disponibilità di un tavolo per giorno e orario;
- In tutte pagine è possibile prenotare un tavolo da remoto, da menù a scomparsa.

## Sicurezza
Contromisure contro la vulnerabilità **SQL injection**.

## Struttura del progetto

Il progetto è suddiviso in due macro-componenti principali:

1. **Back-end** (Java JEE)
2. **Front-end** (AngularJS, Bootstrap, jQuery, JSON)

### 1. Back-end (Java JEE)

Il lato server è implementato utilizzando **Java JEE** con le seguenti funzionalità principali:

- **JSP (Java Server Pages)**: pagine web dinamiche, che consente inserimento del codice Java, Javascript, Html e css;
- **RESTful**: per gestione di richieste http e creazione di file *.json.
- **Interrogazione ai Database**: sia MySQL (Classe MySQL.java) e PostgreSQL (Classe Pg.java), con contromisure SQL injection.

#### Dipendenze principali:

- **Java EE 8**
- **WildFly 10.x** (application server)

### 2. Front-end (AngularJS, Bootstrap, jQuery, JSON)

Il lato client dell'applicazione è implementato utilizzando un approccio **SPA (Single Page Application)** con **AngularJS**. **Bootstrap** e **jQuery** sono utilizzati per migliorare l'esperienza utente e semplificare l'interfaccia.

- **AngularJS**
- **Bootstrap**
- **jQuery**
- **JSON**
#### Dipendenze principali:

- **AngularJS 1.x**
- **Bootstrap 5.x**
- **jQuery 3.x**

## Configurazione del progetto

### Requisiti

Assicurati di avere installato i seguenti strumenti:

- **JDK 8**
- **Application Server** (WildFly. 10.x)
### Installazione

1. **Clonare il repository:**

```bash
git clone https://github.com/tumminia/Java-JEE
