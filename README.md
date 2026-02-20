# Sentinel: Financial Fraud Detection Engine (v5.0)

Sentinel is a high-performance Java-based security gateway designed to analyze financial transactions in real-time. It utilizes weighted heuristic scoring to detect and mitigate fraudulent activities before they impact the ledger.

## 🛡️ Key Features
* **Weighted Risk Engine:** Implements a cumulative scoring algorithm to assess risk levels across multiple vectors (Identity & Volume).
* **Real-time Observability:** Features standardized, timestamped logging for security auditing and incident response.
* **Automated Rate Limiting:** Built-in protection against brute-force credential stuffing.
* **Tiered Response System:** Automatically categorizes transactions into `AUTHORIZED`, `PENDING` (Human-in-the-loop), or `REJECTED`.

## 🏗️ Architecture
The system operates as a middleware security layer, intercepting incoming transaction requests and applying heuristic filters.



## 🚀 Getting Started

### Prerequisites
* Java JDK 17 or higher
* Apache Maven 3.8+

### Execution
To initialize the security engine, navigate to the project root and execute:
```bash
mvn compile exec:java -Dexec.mainClass="com.security.Main"