# apiHealth

En liten Java/Spring Boot-tjänst för att öva GitHub-flödet: feature-brancher, pull requests, CI och containerpublicering.

## Starta lokalt

Kräver Java 21 och Maven.

```powershell
mvn spring-boot:run
```

API:t kör på `http://localhost:8080`.

```powershell
Invoke-RestMethod http://localhost:8080/api/health
Invoke-RestMethod -Method Post http://localhost:8080/api/projects -ContentType 'application/json' -Body '{"name":"Min första feature","description":"Öva en pull request"}'
```

## Docker

```powershell
docker build -t api-health .
docker run --rm -p 8080:8080 api-health
```

## GitHub-flöde

1. Skapa ett tomt GitHub-repository och pusha projektet till `main`.
2. Skapa en branch, till exempel `feature/tasks`.
3. Öppna en pull request till `main`. Workflowen **CI** kör tester, paketering och en Docker-build utan publicering.
4. Efter merge till `main` publicerar workflowen **Publish container image** till `ghcr.io/<ditt-github-namn>/<repository>:latest`.

Aktivera branch protection för `main` och kräv att kontrollen **Build and test** passerar före merge.

## Bra nästa feature-brancher

- `feature/tasks` – uppgifter under ett projekt
- `feature/project-delete` – ta bort projekt
- `feature/labels` – etiketter och filtrering
- `feature/error-handling` – konsekventa API-felsvar
- `feature/postgres` – PostgreSQL med Docker Compose
