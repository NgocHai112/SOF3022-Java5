# 🧩 SOF3022 – LẬP TRÌNH JAVA 5 (Spring Boot MVC)
> **Sinh viên thực hiện:** [Ngọc Hải]  
---

## 🎯 MỤC TIÊU MÔN HỌC
Sinh viên có thể:
- Hiểu và vận dụng được **Spring Boot MVC** vào phát triển ứng dụng web.  
- Sử dụng được **Thymeleaf** cho view layer.  
- Thao tác dữ liệu với **JpaRepository, JPQL, DSL Query**.  
- Áp dụng các kỹ thuật nâng cao như **Spring Beans, DI, IoC, Interceptor, Scheduled Tasks**.  
- Xây dựng website bán hàng hoàn chỉnh với bảo mật, giỏ hàng, đặt hàng, gửi mail,...

---
## 🧠 NỘI DUNG TỪNG PHẦN

### 🧾 **Slides (Lý thuyết)**
| STT | Chủ đề | Nội dung chính |
|:---:|:--------|:---------------|
| 1 | Spring Boot MVC Introduction | Cấu trúc project, HttpRequest/Response |
| 2 | Spring Boot Controller | Mapping, Model, Redirect |
| 3 | Thymeleaf 1 | Biểu thức, chỉ thị, vòng lặp |
| 4 | Thymeleaf 2 | Form binding, Validation, Layout, i18n |
| 5 | Spring Beans | IoC, DI, Scopes, Bean Injection, Cookie/Session/File Services |
| 6 | JpaRepository 1 | CRUD, Sort, Page |
| 7 | JpaRepository 2 | @Query, JPQL, DSL |
| 8 | Scheduled Task & Interceptor | Gửi mail, AuthInterceptor, Logging |

---

### 🧪 **Labs (Thực hành)**

| Lab | Chủ đề | Nội dung chính |
|:---:|:--------|:---------------|
| 1 | Spring Introduction | Cấu hình, HelloController, Login Form |
| 2 | Building Controller | Mapping nâng cao, Model, RedirectAttributes |
| 3 | Thymeleaf 1 | Hiển thị dữ liệu từ Bean và List |
| 4 | Thymeleaf 2 | Data binding, Validation, Layout, Đa ngôn ngữ |
| 5 | Spring Beans | Xây dựng ParamService, CookieService, SessionService, ShoppingCart |
| 6 | JpaRepository 1 | CRUD, Sort, Paging |
| 7 | JpaRepository 2 | JPQL, DSL, Aggregation Report |
| 8 | Scheduled Tasks & Interceptor | MailService, Schedule Queue, AuthInterceptor, LogInterceptor |

---
## ⚙️ CÔNG NGHỆ SỬ DỤNG
- **Java 17+ / Spring Boot 3.x**
- **Thymeleaf / Bootstrap 5**
- **JPA / Hibernate / SQL Server**
- **Lombok / DevTools**
- **JavaMailSender / Interceptor / Scheduling**

---

## 🧰 HƯỚNG DẪN CHẠY PROJECT
1. Mở project trong **IntelliJ IDEA** hoặc **STS4**  
2. Cấu hình `application.properties` với database của bạn  
3. Chạy ứng dụng bằng:
   ```bash
   mvn spring-boot:run
