### 1. Tại sao bắt buộc gọi registerOutParameter()?
- Đặt chỗ trước: Java cần biết tham số trả về là kiểu gì (Số, Chữ, Ngày tháng...) để chuẩn bị sẵn "vùng nhớ" phù hợp.

- Phiên dịch: Giúp JDBC Driver biết cách chuyển đổi dữ liệu từ "tiếng Database" sang "tiếng Java" một cách chính xác khi câu lệnh chạy xong.

- Nguyên tắc: Nếu không đăng ký, Java sẽ không biết cách "hứng" kết quả trả về từ Store Procedure.

### 2. Tham số DECIMAL trong SQL dùng hằng số nào?
- Trong lớp `java.sql.Types`,  dùng hằng số: `Types.DECIMAL`