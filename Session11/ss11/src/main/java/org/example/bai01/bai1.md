### Tại sao việc khởi tạo kết nối liên tục mà không có cơ chế đóng (Close) hoặc quản lý tập trung lại gây nguy hiểm cho hệ thống y tế (vốn cần hoạt động 24/7)?

1. **Gây cạn kiệt tài nguyên**: Hệ quản trị csdl có giới hạn số lượng kết nốt tối đa. Khi đạt đến giới hạn, csdl sẽ từ chối mọi yêu cầu kết nối mới gây "Communications link failure".
2. **Lãng phí bộ nhớ**: Mỗi kết nối mở chiếm một lượng bộ nhớ nhất định trên cả Server ứng dụng và Server CSDL. Việc tích tụ hàng nghìn kết nối "treo" sẽ làm hệ thống chậm dần và cuối cùng là sụp đổ.
3. **Gián đoạn nghiệp vụ khẩn cấp**: Trong môi trường y tế, việc không thể truy xuất hồ sơ bệnh nhân do lỗi hệ thống có thể gây ra hậu quả nghiêm trọng về tính mạng và quy trình khám chữa bệnh.