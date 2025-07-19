# 📦 Apache Kafka - Local Setup & Spring Boot Integration

Apache Kafka is a **distributed streaming platform** used for building real-time data pipelines and streaming applications. It is highly scalable, fault-tolerant, and fast.

---

## 📌 Key Concepts

- **Distributed** and **Horizontally Scalable**
- **Fault Tolerant**: Works across multiple nodes (brokers)
- **Three Main Capabilities**:
    1. **Publish and Subscribe** to streams of records
    2. **Store** streams in a fault-tolerant way
    3. **Process** streams as they occur

---

## 🏗️ Kafka Architecture

- A **Kafka Cluster** consists of multiple **brokers** (Kafka servers)
- Each **broker** manages multiple **topics**
- Topics are divided into **partitions** (enable parallel processing)
- **ZooKeeper** (Kafka < 4.0) manages the cluster metadata
- Kafka **preserves message order** within a partition

> 🧠 Unlike JMS, Kafka guarantees ordering within partitions.

---

## 📂 Message Retention

Kafka stores messages for a **configured period**, regardless of whether they've been consumed.

---

## ⚙️ Kafka Setup (on Windows)

### ✅ Prerequisites

- **Java 8+** (Kafka runs on the JVM)

---

### 🛠️ Installation & Setup

#### 1. Download Kafka

- Go to [Kafka Downloads](https://kafka.apache.org/downloads)
- Choose a **binary download with Scala 2.13**
- Extract the folder and **rename it to `kafka`**

---

#### 2. Start Kafka Services

Open PowerShell or Command Prompt:

**Start ZooKeeper**
```powershell
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

**Start Kafka Broker**
```powershell
$env:KAFKA_HEAP_OPTS="-Xmx512M -Xms256M"
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

> 📝 `KAFKA_HEAP_OPTS` is used to avoid errors related to deprecated `wmic` command in newer Windows versions.

---

### ✅ 3. Testing Kafka CLI

**Create a Topic**
```powershell
.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

**List Topics**
```powershell
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```

**Produce Messages**
```powershell
.\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092
```

Type messages in the console and hit Enter.

**Consume Messages**
```powershell
.\bin\windows\kafka-console-consumer.bat --topic test-topic --from-beginning --bootstrap-server localhost:9092
```

---

## 🚀 Spring Boot Kafka Integration

Once Kafka is running, you can run your **Spring Boot application** to publish messages to Kafka topics.

> Use the Postman collection to send test messages to the Spring Boot publisher endpoint:

📁 **Import this collection** into Postman:
```
collections/postman/service-learn-kafka-publisher.postman_collection.json
```

---

## ✅ Summary

| Component       | Purpose                        |
|----------------|--------------------------------|
| Kafka Broker    | Handles message streaming      |
| ZooKeeper       | Manages brokers (Kafka < 4.0)  |
| Spring Boot App | Publishes messages to Kafka    |
| Postman         | Tests message publishing       |

---

## 🙌 Happy Streaming!
