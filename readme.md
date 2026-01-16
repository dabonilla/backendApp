# Prueba Técnica

Este repositorio contiene el componente backend en Spring boot y el componente de base de datos en PostgreSQL de la prueba técnica realizada.

## Despliegue
Clonar este repositorio y ejecutar el siguiente comando en la misma carpeta:

```docker-compose up -d```

Cuando los contenedores este creados ejecutar los siguientes comando para restaurar la base de datos:
```docker cp db/test_data.dump pruebat-db-1:/test_data.dump```

```docker exec -it pruebat-db-1 pg_restore -U admin_user -d mi_db /test_data.dump```