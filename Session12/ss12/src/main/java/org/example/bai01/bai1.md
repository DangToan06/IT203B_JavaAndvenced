### Tại sao PreparedStatement lại được coi là "tấm khiên" chống lại SQL Injection? Cơ chế "Pre-compiled" (biên dịch trước) giúp ích gì trong việc bảo vệ tham số đầu vào?

- **PreparedStatement là "Tấm khiên"**:
  - Statement thông thường: Trộn lẫn lệnh và dữ liệu thành một chuỗi. Kẻ tấn công có thể chèn thêm lệnh vào chuỗi đó để phá hoại.
  - PreparedStatement: Gửi khung lệnh đi trước, dữ liệu đi sau. Dữ liệu dù "độc hại" đến đâu cũng chỉ được xem là một chuỗi văn bản vô hại, không bao giờ có quyền trở thành lệnh thực thi.

- **Cơ chế "Pre-compiled"**:
  - Biên dịch trước: Database nhận câu lệnh SQL có các dấu hỏi chấm ? và xây dựng sẵn "kế hoạch tác chiến". Cấu trúc này bị khóa chặt, không thể thay đổi.
  - Truyền tham số: Khi bạn đưa dữ liệu vào, Database chỉ việc lắp nó vào các vị trí ? đã định sẵn.