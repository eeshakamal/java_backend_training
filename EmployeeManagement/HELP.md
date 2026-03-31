# Employee Management API Help

## Base URL

- `http://localhost:9090`

## Authentication (Spring Security)

- All `/api/**` endpoints require HTTP Basic Auth.
- Username: `eesha`
- Password: `root`

PowerShell example:

```powershell
$auth = "eesha:root"
```

## Main Endpoints

- `POST /api/employees/create` -> Create employee
- `GET /api/employees` -> Display all employees
- `GET /api/employees/last` -> Display last created employee
- `PUT /api/employees/raise-salary/{id}` -> Raise salary

There is no backend "exit" endpoint; exit is handled by the client/UI.

## Request Validation Rules

- `name`: letters only, max 2 spaces (up to 3 words)
- `age`: between `19` and `60`
- `designation`: only `M25`, `P20`, `T15`
- `percentage` (raise salary): between `1` and `10`

## cURL Examples

Create employee:

```powershell
curl.exe -u eesha:root -H "Content-Type: application/json" -d "{\"name\":\"John Doe\",\"age\":25,\"designation\":\"P20\"}" http://localhost:9090/api/employees/create
```

Get all employees (full display endpoint):

```powershell
curl.exe -u eesha:root http://localhost:9090/api/employees
```

Raise salary by 5% for employee id `1`:

```powershell
curl.exe -u eesha:root -X PUT -H "Content-Type: application/json" -d "{\"percentage\":5}" http://localhost:9090/api/employees/raise-salary/1
```

## Common Error Responses

- `401 Unauthorized`: Basic Auth missing or wrong credentials
- `400 Bad Request`: Validation failed (invalid name/age/designation/percentage)
- `404 Not Found`: No employees found for endpoints that require existing data

