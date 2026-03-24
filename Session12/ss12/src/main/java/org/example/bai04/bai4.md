### Phân tích sự lãng phí tài nguyên của Database Server khi phải phân tích (Parse) và lập kế hoạch thực thi (Execution Plan) 1.000 lần cho cùng một cấu trúc câu lệnh.

- Khi chạy 1000 câu lệnh `Statement` ó cấu trúc giống hệt nhau (chỉ khác giá trị), Database Server sẽ rơi vào trạng thái "khổ sai" vì phải lặp lại quy trình Hard Parse:
1. Cú pháp: Kiểm tra xem câu lệnh có viết sai chính tả SQL không.

2. Ngữ nghĩa: Kiểm tra bảng Surgery có tồn tại không, cột base_cost có đúng kiểu dữ liệu không.

3. Cấp quyền: Kiểm tra user hiện tại có quyền INSERT vào bảng đó không.

4. Lập kế hoạch thực thi: Đây là bước tốn kém nhất. Database phải tính toán xem nên dùng Index nào, quét bảng theo cách nào để nhanh nhất.

- **Hậu quả**: 
  - CPU Overhead: CPU của Database liên tục nhảy vọt để tính toán các kế hoạch thực thi giống hệt nhau.

  - Shared Pool Pollution: Bộ nhớ đệm của Database bị lấp đầy bởi 1.000 câu lệnh khác nhau (về mặt ký tự), đẩy các kế hoạch thực thi hữu ích khác ra ngoài.

  - Latancy: Tổng thời gian thực hiện tăng vọt do mất thời gian "nghĩ" (Parse) nhiều hơn thời gian "làm" (Execute).