# Desafio Backend Itaú - API de Transações  

Este projeto é uma API REST desenvolvida como parte de um desafio de backend do Itaú. A API tem como objetivo processar transações e calcular estatísticas com base nas operações realizadas nos últimos 60 segundos. O desenvolvimento foi feito utilizando [Java](https://www.java.com/) e [Spring Boot](https://spring.io/projects/spring-boot).  

## 📌 Pré-requisitos  

Para executar a aplicação, é necessário ter instalado:  

- **Java**: [JDK 21](https://jdk.java.net/) ou superior  
- **Maven**: Versão 3.8.1 ou superior  
- **Git**: Para clonar o repositório  
- **Docker** (opcional): Caso queira executar a aplicação em um container  

## 🚀 Como configurar e executar o projeto  

### 1️⃣ Clonar o repositório  
```bash
git clone git@github.com:jardeylsonJacinto/transacao-api.git
```

### 2️⃣ Compilar o projeto  
```bash
mvn clean install
```

### 3️⃣ Executar a aplicação  
```bash
mvn spring-boot:run
```

## 🐳 Executando com Docker (Opcional)  

### 1️⃣ Criar a imagem Docker  
Certifique-se de que o Docker está instalado e execute:  
```bash
docker build -t api-transacoes .
```

### 2️⃣ Rodar o container  
```bash
docker run -p 8080:8080 api-transacoes
```

## 📖 Endpoints da API  

### ➤ Criar uma Transação  
```http
POST /transacao
```
#### 📌 Parâmetros:  
| Parâmetro  | Tipo            | Obrigatório | Descrição                        |
|------------|----------------|------------|--------------------------------|
| `valor`    | BigDecimal     | ✅ Sim      | Valor da transação             |
| `dataHora` | OffsetDateTime | ✅ Sim      | Data e hora da transação       |

---

### ➤ Remover todas as transações  
```http
DELETE /transacao
```

---

### ➤ Obter estatísticas das transações  
```http
GET /estatistica
```
#### 📌 Parâmetros:  
| Parâmetro          | Tipo    | Obrigatório | Descrição                                      |
|--------------------|--------|------------|------------------------------------------------|
| `intervaloSegundos` | Integer | ❌ Não      | Tempo de análise das estatísticas (padrão: 60s) |
