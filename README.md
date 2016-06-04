# Trang web Movie Review

Mã nguồn của trang web Movie Review.

# Yêu cầu công cụ
1. JDK 1.7
2. Eclipse IDE
3. MYSQL
4. Hibernate Tools
5. Git

# Công nghệ sử dụng
1. Servlet - JSP
2. Hibernate
3. Apache Tiles

# Yêu cầu chức năng

Mọi người clone git về và tạo branch riêng để làm việc trước nhé. Commit sẽ có message ghi đầy đủ chức năng thực hiện ở lần commit đó.

## Hiện thực chức năng Login trong LoginController.

Hiện tại đã có View Login, sử dụng Apache Tiles để hiện thực rồi và các bạn sẽ sử dụng View này để gọi tới Controller. Các bạn sẽ phải implement các Service để phục vụ cho các chức năng tương ứng dựa theo cái interface đã có sẵn.

Về công tác xử lý, thì khi người dùng nhập username và password rồi Login, thì ở LoginController sẽ thực hiện kiểm tra để Login và lưu username vào Session, tiếp đó là forward tới Trang Chủ.

## Hiện thực chức năng Register trong RegisterController.

Từ View Login đã có, các bạn tạo một View Register với các thông tin tương ứng với Model User, sử dụng các stylesheets đã có như bên form Login và tạo một form Register tương ứng, và ghép vào Tiles, để khi vào trang `/register` thì vào Controller và trả về trang form Register.

Xong phần View, đến phần backend thì sẽ sử dụng các Service đã implement để thực hiện đăng ký tài khoản, sau khi đăng ký cũng gắn username vào Session và forward tới Trang Chủ.

## Chức năng kiểm tra tài khoản đã đăng nhập

Ở phần Navigation(trong header), sử dụng JSTL, kiểm tra nếu session chưa có biến username (`${sessionScope.username}`, kiểm tra bằng thẻ `<c:if>`) thì là chưa login, và ở header chỉ là Sign In và Sign Up, còn trường hợp ngược lại, thì đã login và sẽ hiện Username và Sign Out.
..1. Chức năng Sign Out được thực hiện bằng cách loại đi biến username trong Session với Controller Logout, LogoutController các bạn sẽ phải tự tạo và tự map url là `/logout`, vậy thôi là đủ rồi :v..

Hồ Quốc Toản