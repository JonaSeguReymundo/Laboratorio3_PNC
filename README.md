Todas las pruebas operan bajo la ruta base local de la API: `http://localhost:8080/api/specimens`. 
A continuación se detallan los payloads de entrada y los resultados reales obtenidos tras la ejecución de la suite:

---

1. Operaciones de Creación (POST)

A. Create Specimen (Éxito)
Endpoint: `POST http://localhost:8080/api/specimens/create`
Request Body (JSON):
```JSON
{
  "name": "Lynel",
  "region": "Gerudo Highlands",
  "dangerLevel": 5,
  "isFriendly": false
} 
```
#### Resultado Obtenido (201 Created):

```JSON
{
  "uri": "/api/specimens/create",
  "message": "Specimen registered successfully in Sheikah Slate",
  "status": 201,
  "time": "2026-05-19T04:50:12.115Z",
  "data": {
    "id": "ea07cec6-e666-4def-bae9-04d0515f98e8",
    "name": "Lynel",
    "region": "Gerudo Highlands",
    "dangerLevel": 5,
    "isFriendly": false
  }
}
```

B. Create Specimen / Same (Error por Nombre Duplicado)
Endpoint: POST http://localhost:8080/api/specimens/create

Request Body (JSON):

```JSON
{
  "name": "Lynel",
  "region": "Gerudo Highlands",
  "dangerLevel": 5,
  "isFriendly": false
}
```
Resultado Obtenido (400 Bad Request):

```JSON
{
  "uri": "/api/specimens/create",
  "status": 400,
  "time": "2026-05-19T04:51:05.320Z",
  "message": [
    "Specimen name must be unique in Hyrule records."
  ]
}
```

C. Create Specimen / Empty (Error de Formato / Atributos Nulos)
Endpoint: POST http://localhost:8080/api/specimens/create

Request Body (JSON):

```JSON

{
  "name": "",
  "region": " ",
  "dangerLevel": null,
  "isFriendly": null
}
```
Resultado Obtenido (400 Bad Request):

```JSON
{
  "uri": "/api/specimens/create",
  "status": 400,
  "time": "2026-05-19T04:52:14.012Z",
  "message": [
    "The specimen name cannot be empty.",
    "The region of Hyrule must be specified.",
    "Danger level is required.",
    "You must specify if the specimen is friendly."
  ]
}
```

2. Operaciones de Consulta (GET)
A. Get All Specimen (Paginación y Catálogo)
Endpoint: GET http://localhost:8080/api/specimens/getAll?page=0&size=10&sortBy=name&sortOrder=asc

Resultado Obtenido (200 OK):

```JSON
{
  "uri": "/api/specimens/getAll",
  "message": "Specimens catalog retrieved successfully",
  "status": 200,
  "time": "2026-05-19T04:53:22.441Z",
  "data": {
    "content": [
      {
        "id": "ea07cec6-e666-4def-bae9-04d0515f98e8",
        "name": "Lynel",
        "region": "Gerudo Highlands",
        "dangerLevel": 5,
        "isFriendly": false
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 1,
    "totalPages": 1,
    "last": true
  }
}
```


B. Get Specimen By ID (Búsqueda por Clave Primaria)
Endpoint: GET http://localhost:8080/api/specimens/getBy/ea07cec6-e666-4def-bae9-04d0515f98e8

Resultado Obtenido (200 OK):

```JSON

{
  "uri": "/api/specimens/getBy/ea07cec6-e666-4def-bae9-04d0515f98e8",
  "message": "Specimen record localized",
  "status": 200,
  "time": "2026-05-19T04:54:02.195Z",
  "data": {
    "id": "ea07cec6-e666-4def-bae9-04d0515f98e8",
    "name": "Lynel",
    "region": "Gerudo Highlands",
    "dangerLevel": 5,
    "isFriendly": false
  }
}
```

C. Get Specimen By ID / NOT FOUND (Control de Excepciones)
Endpoint: GET http://localhost:8080/api/specimens/getBy/00000000-0000-0000-0000-000000000000

Resultado Obtenido (404 Not Found):

```JSON
{
  "uri": "/api/specimens/getBy/00000000-0000-0000-0000-000000000000",
  "status": 404,
  "time": "2026-05-19T04:55:01.882Z",
  "message": "Specimen not found in Sheikah Slate records"
}
```


3. Operaciones de Modificación y Eliminación
A. Update Specimen By ID (PUT)
Endpoint: PUT http://localhost:8080/api/specimens/update/ea07cec6-e666-4def-bae9-04d0515f98e8

Request Body (JSON):

```JSON
{
  "name": "White-Maned Lynel",
  "region": "Hebra Mountains",
  "dangerLevel": 5,
  "isFriendly": false
}
```

Resultado Obtenido (200 OK):

```JSON
{
  "uri": "/api/specimens/update/ea07cec6-e666-4def-bae9-04d0515f98e8",
  "message": "Specimen updated successfully in Sheikah Slate",
  "status": 200,
  "time": "2026-05-19T04:56:40.002Z",
  "data": {
    "id": "ea07cec6-e666-4def-bae9-04d0515f98e8",
    "name": "White-Maned Lynel",
    "region": "Hebra Mountains",
    "dangerLevel": 5,
    "isFriendly": false
  }
}
```

B. Delete Specimen By ID (DELETE)
Endpoint: DELETE http://localhost:8080/api/specimens/delete/ea07cec6-e666-4def-bae9-04d0515f98e8

Resultado Obtenido (200 OK):

```JSON
{
  "uri": "/api/specimens/delete/ea07cec6-e666-4def-bae9-04d0515f98e8",
  "message": "Specimen completely purged from records",
  "status": 200,
  "time": "2026-05-19T04:58:11.554Z",
  "data": {
    "id": "ea07cec6-e666-4def-bae9-04d0515f98e8",
    "name": "White-Maned Lynel",
    "region": "Hebra Mountains",
    "dangerLevel": 5,
    "isFriendly": false
  }
}
```
