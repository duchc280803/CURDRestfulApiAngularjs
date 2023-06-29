# Thiết kế RESTful API
# RESTful API là gì?
RESTful API là một tiêu chuẩn dùng trong việc thiết kế API cho các ứng dụng web (thiết kế Web services) để tiện cho việc quản lý các resource.
# Các thành phần của nó
- API (Application Programming Interface) là một tập các quy tắc và cơ chế mà theo đó, một ứng dụng hay một thành phần sẽ tương tác với một ứng dụng hay thành phần khác. API có thể trả về dữ liệu mà bạn cần cho ứng dụng của mình ở những kiểu dữ liệu phổ biến như JSON hay XML.
- REST (REpresentational State** T**ransfer) là một dạng chuyển đổi cấu trúc dữ liệu, một kiểu kiến trúc để viết API. Nó sử dụng phương thức HTTP đơn giản để tạo cho giao tiếp giữa các máy. Vì vậy, thay vì sử dụng một URL cho việc xử lý một số thông tin người dùng, REST gửi một yêu cầu HTTP như GET, POST, DELETE, vv đến một URL để xử lý dữ liệu.
- RESTful API là một tiêu chuẩn dùng trong việc thiết kế các API cho các ứng dụng web để quản lý các resource. RESTful là một trong những kiểu thiết kế API được sử dụng phổ biến ngày nay để cho các ứng dụng (web, mobile…) khác nhau giao tiếp với nhau.
  Chức năng quan trọng nhất của REST là quy định cách sử dụng các HTTP method (như GET, POST, PUT, DELETE…) và cách định dạng các URL cho ứng dụng web để quản các resource. RESTful không quy định logic code ứng dụng và không giới hạn bởi ngôn ngữ lập trình ứng dụng, bất kỳ ngôn ngữ hoặc framework nào cũng có thể sử dụng để thiết kế một RESTful API.
# Những hành động CRUD sử dụng những phương thức HTTP
- GET (SELECT) : Trả về một Resource hoặc một danh sách Resource.
- POST (CREATE): Tạo mới một Resource
- PUT (UPDATE): Cập nhập thông tin cho Resource
- PATCH (UPDATE): Cập nhập một thành phần, thuộc tính của Resource.
- DELETE (DELETE): Xóa một Resource.
- HEAD - Trả về thông tin chung của một hoặc danh sách Resource
# Dữ liệu trả về JSON only?
Hầu hết những người viết RESTful API giờ đây đều chọn JSON là format chính thức nhưng rất nhiều người vẫn phân vân với câu hỏi “chỉ JSON hay hỗ trợ thêm XML?”. Tất nhiên, có hàng tá lý do để chúng ta hỗ trợ thêm những format khác, đặc biệt là XML. Tuy nhiên, hỗ trợ nhiều định dạng chỉ làm cho việc kiểm thử API thêm phức tạp.
# Status code
- 200 OK – Trả về thành công cho những phương thức GET, PUT, PATCH hoặc DELETE.
- 201 Created – Trả về khi một Resouce vừa được tạo thành công.
- 204 No Content – Trả về khi Resource xoá thành công.
- 304 Not Modified – Client có thể sử dụng dữ liệu cache.
- 400 Bad Request – Request không hợp lệ
- 401 Unauthorized – Request cần có sự authentication.
- 403 Forbidden – Server hiểu request nhưng bị từ chối không cho phép.
- 404 Not Found – Không tìm thấy rource từ URI
- 405 Method Not Allowed – Phương thức không cho phép với user hiện tại.
- 410 Gone – Resource không còn tồn tại, Version cũ đã không còn hỗ trợ.
- 415 Unsupported Media Type
- 422 Unprocessable Entity – Dữ liệu không được kiểm chứng
- 429 Too Many Requests – Request bị từ chối do bị giới hạn
