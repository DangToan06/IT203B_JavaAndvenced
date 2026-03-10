### 1. Kiểm tra xem một User có phải là Admin hay không (trả về true/false).
- **Functional Interface**: *Predicate* 
- **Lý do**: FI trên kiểm tra đk đúng với yêu cầu chức năng

### 2. Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin username.
- **Functional Interface**: *Function*
- **Lý do**: Vì đây là FI dùng để chuyển đổi

### 3. In thông tin chi tiết của User ra màn hình Console.
- **Functional Interface**: *Consumer*
- **Lý do**: FI trên khi nhận tên user sẽ không trả về giá trị gì phù hợp với việc in ra thông tin chi tiết

### 4. Khởi tạo một đối tượng User mới với các giá trị mặc định.
- **Functional Interface**: *Supplier*
- **Lý do**: FI sẽ cung cấp dữ liệu mặc định chúng ta mong muốn khi tạo