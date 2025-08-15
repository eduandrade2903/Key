# Sistema de Empréstimo de Chaves

Este projeto é um sistema de gerenciamento de empréstimos de chaves, desenvolvido com **Java**, **Spring Boot**, **MySQL** e **Docker**.

## Funcionalidades

- Cadastro de funcionários, setores, chaves e autorizações.
- Gerenciamento de empréstimos de chaves.
- Devolução de chaves.
- Interface web responsiva com **Bootstrap**.

## Tecnologias Utilizadas

- **Java 23**
- **Spring Boot**
- **MySQL**
- **Docker**
- **Maven**
- **Bootstrap**

## Pré-requisitos

- **Docker** e **Docker Compose** instalados.
- **Maven** para build da aplicação.

## Configuração

### 1. Build da aplicação

Antes de rodar o Docker, é necessário gerar o arquivo JAR da aplicação:

```bash
mvn clean package
