# ShopSphere — Advanced Java E-Commerce Project

This is the first working phase of the RTU Advanced Java project guide: a Maven WAR web application using Java 21, Jakarta Servlet/JSP, JSTL, JDBC, MySQL, and Tomcat 11.

## Implemented in this starter
- Customer registration and login (BCrypt password hashing)
- Product listing, search, and product details
- Persistent cart additions
- Checkout with a **simulated/mock payment** and stock deduction
- Customer order history
- Admin product add/deactivate screens and role-based admin filter
- Prepared statements, service/DAO separation, session-based login, MVC-style servlet controllers
- Responsive storefront styling
- Database tables for addresses, wishlist, reviews, coupons, and payments to support later stages

## Requirements
- JDK 21
- Maven 3.9+
- MySQL 8+
- Apache Tomcat 11

## Setup
1. Create the database by running `database/shopsphere.sql` in MySQL Workbench.
2. Set database environment variables, or edit `src/main/java/com/shopsphere/util/DB.java`:
   - `SHOPSPHERE_DB_URL` (default `jdbc:mysql://localhost:3306/shopsphere?useSSL=false&serverTimezone=UTC`)
   - `SHOPSPHERE_DB_USER` (default `root`)
   - `SHOPSPHERE_DB_PASSWORD` (default `change_me`)
3. Build from this folder:
   ```bash
   mvn clean package
   ```
4. Copy `target/ShopSphere.war` to Tomcat 11's `webapps` folder and start Tomcat.
5. Open `http://localhost:8080/ShopSphere/`.
6. Register a customer account.
7. To make your account an admin, run (replace the email):
   ```sql
   USE shopsphere;
   UPDATE users SET role='ADMIN' WHERE email='your-email@example.com';
   ```
8. Sign out and sign in again, then visit `/ShopSphere/admin/products`.

## Important notes
- Payment is simulated only. No real payment provider is connected.
- Set a real database password in your environment. Do not commit credentials.
- Product images use remote image URLs; an internet connection is needed for those images.
- This is a student project starter, not a production-ready commerce system.
- The guide's remaining syllabus modules (Swing desktop admin, Socket/ServerSocket, RMI Registry, serialization demo, JNDI/URLConnection, locale bundles, extra JSTL demonstrations, full diagrams/report/test pack) are planned as subsequent phases and are not yet included in this first archive.
- Tomcat 11 uses `jakarta.servlet.*`, not `javax.servlet.*`.
