# Explicacion solucion

---

## 1. Creacion proyecto

En la url "https://start.spring.io/" podemos crear proyectos de spring boot facilemente y luego exportarlos

En la misma pagina ponemos el nombre y dependencias que ocupemos en este caso ocupamos sobre todo postgres driver

Con el proyecto creado procedemos a crear el JPA para interactuar con la base de datos, el repositorio para la comunicacion con la base de datos y el controler para levantar los servicios

## 2. Construir proyecto

Ya con el proyecto de java terminado procedemos con el build de la aplicacion con el siguiente comando:

```bash
./gradlew clean build
```

Esto nos creara un .jar en build/libs


## 3. Docker y compose

Construimos la imagen en local y construimos con docker compose para comprobar 

```bash
docker build -t evaluacion-app:latest .
docker compose up --build
```

Ademas subimos nuestro contenedor a docker hub para luego poder usarlo en los archivos de configuracion de kubernetes

```bash
docker push mbarzallob/evaluacion-app:latest
```

## 4. Despliegue en kubernetes
Primero creamos en una carpeta, los despliegues y los servicios para la base de datos y para los microservicios
```bash
kubectl apply -f database-deployment.yaml
kubectl apply -f database-service.yaml
kubectl apply -f microservice-deployment.yaml
kubectl apply -f microservice-service.yaml
```

Y verificamos su funcionamiento
```bash
kubectl get pods
```

## 5: Exponer y probar el servicio

Obtenemos la url del microservicio con el siguiente comando y comprobamos que todo funcione bien
```bash
minikube service microservice --url
```
