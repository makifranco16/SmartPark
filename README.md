# SmartPark – In-Memory Parking Management System

## Project Overview

SmartPark is a Java Spring Boot application that manages parking lots and vehicles. The system allows:

- Registering parking lots
- Registering vehicles
- Checking vehicles in/out of parking lots
- Viewing parking lot occupancy
- Viewing all vehicles parked in a lot  

This project uses **in-memory storage** (HashMaps) instead of a database, so all data resets on application restart.

---

## Technology Stack

- Java 1.8+  Specifically Java 17 (Recommended for Spring Framework)
- Spring Boot  
- Spring Web (REST API)  
- Maven (build tool)  

---

## Models

### ParkingLot
| Field           | Type     | Description                         |
|-----------------|---------|-------------------------------------|
| lotId           | String  | Unique identifier for the lot        |
| location        | String  | Location of the parking lot          |
| capacity        | int     | Total number of parking spaces       |
| occupiedSpaces  | int     | Number of currently occupied spaces |

### Vehicle
| Field         | Type     | Description                                 |
|---------------|---------|---------------------------------------------|
| licensePlate  | String  | Unique identifier of the vehicle            |
| type          | String  | Vehicle type (Car, Motorcycle, Truck)      |
| ownerName     | String  | Name of the vehicle owner                   |
| parkedLotId   | String  | ID of the lot where the vehicle is parked (null if not parked) |

---

## API Endpoints
**Parking Lot Endpoints**
Register Parking Lot
Method: POST
URL: http://localhost:8080/api/parking/lot

Body:

{
  "lotId": "LOT-001",
  "location": "Downtown",
  "capacity": 5
}

Get Parking Lot Info
Method: GET
URL: http://localhost:8080/api/parking/lot/{lotId}
Example: http://localhost:8080/api/parking/lot/LOT-001
Get All Vehicles in Lot
Method: GET
URL: http://localhost:8080/api/parking/lot/{lotId}/vehicles
Example: http://localhost:8080/api/parking/lot/LOT-001/vehicles

**Vehicle Endpoints**
Register Vehicle
Method: POST
URL: http://localhost:8080/api/parking/vehicle
Body:
{
  "licensePlate": "CAR-001",
  "type": "Car",
  "ownerName": "John Doe"
}

**Get All Vehicles**
Method: GET
URL: http://localhost:8080/api/parking/vehicles

**Parking Operations**
Check In Vehicle
Method: POST
URL: http://localhost:8080/api/parking/checkin
Query Parameters:
lotId (e.g., LOT-001)
licensePlate (e.g., CAR-001)
Example: http://localhost:8080/api/parking/checkin?lotId=LOT-001&licensePlate=CAR-001

Check Out Vehicle
Method: POST
URL: http://localhost:8080/api/parking/checkout
Query Parameters:
licensePlate (e.g., CAR-001)
Example: http://localhost:8080/api/parking/checkout?licensePlate=CAR-001

