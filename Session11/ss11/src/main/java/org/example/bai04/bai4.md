1. Phân tích việc nối chuỗi
- Khi bác sĩ nhập tên bệnh nhân, hệ thống thực hiện phép cộng chuỗi. Giả sử hacker nhập: ' OR '1'='1.

- Câu lệnh SQL gốc:
SELECT * FROM Patients WHERE full_name = ' + patientName + '

- Sau khi nối chuỗi, câu lệnh gửi đến Database sẽ trở thành:
SELECT * FROM Patients WHERE full_name = '' OR '1'='1'

2. Tại sao mệnh đề WHERE luôn đúng?
- Trong logic của SQL, mệnh đề WHERE sẽ kiểm tra từng dòng trong bảng:

- Vế 1: full_name = '' (Có thể sai nếu không có bệnh nhân nào tên rỗng).

- Vế 2: '1'='1' (Đây là một biểu thức toán học luôn luôn đúng).

- Kết nối bằng OR: Trong logic, (Sai) OR (Đúng) kết quả sẽ là Đúng.

- Vì điều kiện WHERE trả về True cho mọi dòng trong bảng Patients, hệ thống sẽ trả về tất cả hồ sơ bệnh án của mọi bệnh nhân cho hacker, thay vì chỉ 1 người.