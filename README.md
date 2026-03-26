# 💬 Chat Application

A real-time chat application built with Spring Boot and WebSocket/STOMP protocol.

## 🛠️ Tech Stack
- Java 17
- Spring Boot 4.0
- Spring WebSocket + STOMP
- Spring Data JPA
- H2 In-Memory Database
- Lombok

## 🚀 Features
- Real-time group messaging via WebSocket
- Private messaging between users
- Chat room management (create, join, leave)
- Online/offline user status
- Message read receipts
- User profile with profile picture

## 📌 API Endpoints

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /User | Create user |
| GET | /User/{username} | Get user by username |
| GET | /User/AllOnline | Get all online users |
| PUT | /User/{id} | Update online status |

### Chat Rooms
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /chatrooms | Create chat room |
| GET | /chatrooms | Get all chat rooms |
| GET | /chatrooms/{id} | Get chat room by ID |
| POST | /chatrooms/{id}/add | Add member |
| DELETE | /chatrooms/{id}/leave | Leave group |

### WebSocket Endpoints
| Endpoint | Description |
|----------|-------------|
| /app/chat/{id} | Send group message |
| /app/private/{receiverId} | Send private message |
| /topic/chatroom/{id} | Subscribe to chat room |
| /topic/private | Subscribe to private messages |

## 🔧 Setup
1. Clone the repo
2. Open in IntelliJ
3. Run `Application.java`
4. API at `http://localhost:8080`
5. Chat UI at `http://localhost:8080/index.html`
