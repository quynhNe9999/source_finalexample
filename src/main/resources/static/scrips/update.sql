INSERT INTO manerger_wine.`role`
(id, name)
VALUES(1, 'ROLE_ADMIN');
INSERT INTO manerger_wine.`role`
(id, name)
VALUES(2, 'ROLE_MANAGE');
INSERT INTO manerger_wine.`role`
(id, name)
VALUES(3, 'ROLE_EMPLOYEE');

INSERT INTO manerger_wine.user_roles
(user_id, role_id)
VALUES(1, 1);
INSERT INTO manerger_wine.user_roles
(user_id, role_id)
VALUES(2, 2);
INSERT INTO manerger_wine.user_roles
(user_id, role_id)
VALUES(3, 3);
INSERT INTO manerger_wine.user_roles
(user_id, role_id)
VALUES(4, 3);

INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(1, 'nhập mỹ', 'Vang Trắng Mỹ', 123000.0, 20, 1, 1, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(2, 'Vang trắng Terre di Chieti Pinot Grigio, dòng vang Organic, được làm từ 100% nho Pinot Grigio, vùng Abruzzo, Ý. Nho được thu hoạch thủ công cho sản xuất, sau khi lên men, rượu được ủ 6 tháng trong thùng thép không gỉ. ', 'Terre di Chieti Pinot Grigio', 660000.0, 5, 1, 1, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(3, '
Rượu vang trắng Vigneti Radica Tullum Pecorino, được làm từ 100% nho Pecorino, vùng Abruzzo, Ý. Nho được thu hoạch thủ công từ những cây nho 15 năm tuổi cho sản xuất, sau khi lên men, rượu được ủ trên lee ít nhất 15 tháng và thêm 6 tháng trong chai.', 'Vigneti Radica Tullum Pecorino', 1080000.0, 9, 1, 1, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(4, 'Devil''s Carnaval là bộ sưu tập vang mới nhất đến từ thương hiệu nổi tiếng trên toàn thế giới: Casillero del Diablo. Được lấy cảm hứng từ các bữa tiệc giàu cảm xúc và mùa lễ hội sôi động.', 'Casillero del Diablo Devils Carnaval Fabulous Red Blend', 500000.0, 10, 3, 2, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(7, 'Rượu vang trắng Vigneti Radica Tullum Pecorino, được làm từ 100% nho Pecorino, vùng Abruzzo, Ý. Nho được thu hoạch thủ công từ những cây nho 15 năm tuổi cho sản xuất, sau khi lên men, rượu được ủ trên lee ít nhất 15 tháng và thêm 6 tháng trong chai. ', 'Vigneti Radica Tullum Pecorino', 1080.0, 20, 1, 1, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(8, 'Vang đỏ Vigneti Radica Tullum Rosso được làm từ 100% nho Montepulciano, vùng Abruzzo, Ý. Nho được thu hoạch thủ công từ những cây nho có tuổi thọ trung bình 21 năm tuổi, sau khi lên men, rượu được ủ thời gian trong thùng gỗ sồi Pháp. ', 'Vigneti Radica Tullum Rosso', 1450000.0, 3, 3, 2, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(9, 'Vang trắng Terre di Chieti Pinot Grigio, dòng vang Organic, được làm từ 100% nho Pinot Grigio, vùng Abruzzo, Ý. Nho được thu hoạch thủ công cho sản xuất, sau khi lên men, rượu được ủ 6 tháng trong thùng thép không gỉ. ', 'Terre di Chieti Pinot Grigio', 660000.0, 13, 1, 1, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(10, 'Rượu vang Pháp La Fiole Du Pape (rượu vang bụi, vang vẹo) được phối trộn từ 13 giống nho (Grenache, Syrah, Mourvèdre, Cinsault,...), ủ các năm khác nhau nên trên chai không để vintage.
Nguồn gốc: Được khám phá bởi Charles Brotte năm 1952', 'Rượu Vang La Fiole Du Pape - Vang vẹo 1.5L', 2250000.0, 2, 3, 2, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(11, 'Rượu vang đỏ La Fiole Reserve Pere Anselme, có hình dạng xoắn nhằm để gợi nhớ đến vườn nho ở Mistral. Với hình dạng đặc biệt của nó, La Fiole đã trở thành một biểu tượng hiện được tìm thấy ở hơn 120 quốc gia trên thế giới.', 'La Fiole Reserve Pere Anselme', 2230000.0, 2, 3, 2, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(12, 'Rượu Four Roses Small Batch - Kentucky Straight Bourbon Whiskey, rượu được phối trộn từ các thùng rượu được ủ 6 - 7 năm.
', 'Four Roses Small Batch Bourbon', 1040000.0, 4, 6, 5, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(13, 'Rượu Buffalo Trace Kentucky Straight Bourbon Whiskey - Buffalo Trace đã sản xuất ra whiskey Bourbon huyền thoại trong hơn 220 năm qua.
', 'Buffalo Trace Bourbon', 750000.0, 5, 6, 5, NULL);
INSERT INTO manerger_wine.products
(id, description, name, price, stock, category_id, supplier_id, image)
VALUES(14, 'Rượu whiskey Blanton''s Original Single Barrel Bourbon bắt đầu với Blanton’s vào năm 1984. Sắp nghỉ hưu, Master Distiller Elmer T. Lee được giao nhiệm vụ tạo ra một loại bourbon có chất lượng đặc biệt cao.', 'Blanton''s Original', 1000000.0, 10, 1, 5, NULL);

INSERT INTO manerger_wine.`user`
(id, date_tao, email, password, status, username)
VALUES(1, '2024-09-20 00:00:00', 'tdquynh09@gmail.com', '$2a$10$v.fPEHTsv7XBjp/96NNrK.G4OaFI7IULL58HbeSXCoenWjKYHb3rO', 'A', 'quynh');
INSERT INTO manerger_wine.`user`
(id, date_tao, email, password, status, username)
VALUES(2, '2024-09-20 00:00:00', 'dbadmin@gmail.com', '$2a$10$yVBK.1DLLr4jOIyUg/vVuedWCW8bxMa/z1FiLxOGACYoOQ2wohlf2', 'A', 'employee01');
INSERT INTO manerger_wine.`user`
(id, date_tao, email, password, status, username)
VALUES(3, '2024-09-20 00:00:00', 'manage111@gmail.com', '$2a$10$7aSxKhlj8RpVXZwkx/ySz.F0qTPKwXTz7qylciS/5DniLpXMLh7pK', 'A', 'manager01');
INSERT INTO manerger_wine.`user`
(id, date_tao, email, password, status, username)
VALUES(4, '2026-02-01 00:00:00', 'hungvloger12@gmail.com', '$2a$10$wgaXdETay6hRFIFiaErftemezTvk8AOkJF7pmwpJCLtVKGICQeoPK', 'A', 'hungvlog');

INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(1, '2024-09-20 00:00:00', 'Rượu vang trắng hay còn gọi là vang trắng, rượu nho trắng là một thể loại của rượu vang theo đó khác với rượu vang đỏ, rượu vang trắng có màu lạt hơn nó được gọi là màu trắng nhưng không hoàn toà...', 'Vang Trắng');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(3, '2024-09-20 00:00:00', 'Sành rượu luôn nổ lực lựa chọn những chai vang đỏ ngon trong tầm giá để quý vị an tâm mua được chai rượu vang đỏ phù hợp cho ăn uống hàng ngày, tiệc tùng cùng đồng nghiệp, tiếp khách thân mật hoặc đại tiệc với giá thân thiện nhất', 'Vang Đỏ');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(4, '2024-09-20 00:00:00', 'Champagne là một loại vang nổ/vang sủi/sparkling đặc biệt, xuất xứ từ chỉ dẫn địa lý từ vùng Champagne của Pháp với tiêu chuẩn và quy định khắc khe mới được gọi là Champagne và là sản phẩm được bảo...', 'Champagne');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(5, '2024-09-20 00:00:00', 'Rượu Whiskey Mỹ được sản xuất từ lúa mạch đen, bắp, lúa mạch hay hiếm hơn là lúa mì, thành phần của các loại ngũ cốc khác nhau tùy theo vùng. Bourbon là loại Whiskey phải được sản xuất từ ít nhất...', 'American');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(6, '2024-09-15 00:00:00', 'Rượu Whiskey Mỹ được sản xuất từ lúa mạch đen, bắp, lúa mạch hay hiếm hơn là lúa mì, thành phần của các loại ngũ cốc khác nhau tùy theo vùng. Bourbon là loại Whiskey phải được sản xuất từ ít nhất...', 'WHISKY Mỹ');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(7, '2024-09-15 00:00:00', 'Hiện nay, Nhật Bản được xem như quốc gia sản xuất rượu Whisky tăng trưởng nhanh nhất và gia nhập vào bảng đồ rượu whisky thế giới bên cạnh Scotland, Mỹ, Ai Len, Canada,... Nhật bản là nước duy nhât...', 'WHISKY Nhật');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(8, '2024-09-15 00:00:00', 'Cognac là dòng rượu mạnh xuất xứ từ Pháp, đây là chỉ dẫn địa lý đã được đăng ký. Rượu sản xuất tại vùng Cognac, Pháp từ 6 khu vực: Grande Champagne, Petite Champagne, Borderies, Fins Bois, Bons Boi...', 'Rượu Cognac Pháp');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(9, '2024-09-15 00:00:00', 'Armagnac là loại rượu mạnh lâu đời nhất của Pháp. Loại rượu này được sản xuất tại vùng Armagnac và được chưng cất từ việc phối trộn nhiều giống nho với nhau Ugni Blanc, Baco, Colombard và Folle Bla...', 'Armagnac');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(10, '2023-09-15 00:00:00', 'Soju là dòng rượu trắng chưng cất từ gạo, lúa mì hoặc lúa mạch trên bán đảo Triều Tiên.', 'Rượu Soju Hàn Quốc');
INSERT INTO manerger_wine.category
(id, date_tao, description, name)
VALUES(11, '2024-09-15 00:00:00', 'Rượu Vang Chile được gọi là rượu vang Tân thế giới (Vang thế giới mới: Úc, Chile, Mỹ, Argentina, Nam Phi,… Vang thế giới cũ: Pháp, Ý, Tây Ban Nha và Bồ Đào Nha). Các vùng trồng nho của Chile có...', 'Vang Chile');

INSERT INTO manerger_wine.import
(id, import_date, nhap_xuat, total_cost, product_id, supplier_id)
VALUES(1, '2002-03-09 00:00:00', 'Nhập', 10.0, 1, 1);
INSERT INTO manerger_wine.import
(id, import_date, nhap_xuat, total_cost, product_id, supplier_id)
VALUES(2, '2332-12-31 00:00:00', 'Xuất', 20.0, 2, 1);
INSERT INTO manerger_wine.import
(id, import_date, nhap_xuat, total_cost, product_id, supplier_id)
VALUES(3, '2332-12-31 00:00:00', 'Xuất', 5.0, 2, 1);
INSERT INTO manerger_wine.import
(id, import_date, nhap_xuat, total_cost, product_id, supplier_id)
VALUES(4, '2332-12-31 00:00:00', 'Xuất', 30.0, 2, 1);
INSERT INTO manerger_wine.import
(id, import_date, nhap_xuat, total_cost, product_id, supplier_id)
VALUES(5, '2024-01-09 00:00:00', 'Nhập', 15.0, 3, 3);

INSERT INTO manerger_wine.suppliers
(id, address, email, name, phone, status)
VALUES(1, 'THANH OAI, HÀ NỘI', 'tdquynh09@gmail.com', 'Vang Trắng', '0984368800', 'A');
INSERT INTO manerger_wine.suppliers
(id, address, email, name, phone, status)
VALUES(2, 'Trung Hòa,Cầu Giấy', 'vangdo@gmail.com', 'Vang đỏ', '0912316241', 'A');
INSERT INTO manerger_wine.suppliers
(id, address, email, name, phone, status)
VALUES(3, 'Indonesia', 'vignetiradica@gmail.com', 'Vigneti Radica', '+628462746324', 'A');
INSERT INTO manerger_wine.suppliers
(id, address, email, name, phone, status)
VALUES(4, 'Chile', 'chile123@gmail.com', 'Vang Chile', '0387206363', 'A');
INSERT INTO manerger_wine.suppliers
(id, address, email, name, phone, status)
VALUES(5, 'số 1 Khúc Thừa Dụ, Đống Đa, Hà Nội', 'whisky9302@gmail.com', 'WHISKY', '02488988932', 'A');

INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(1, 'Thanh Oai,Hà Nội', '2024-12-31 00:00:00', 'ituse9302@gmail.com', 'Quynh Ta Dinh', '0984368800', 'Quản lý', 1, 1, 1);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(2, 'Thạch Thất, Quốc Oai, Hà Nội', '2002-03-09 00:00:00', 'hungvloger12@gmail.com', 'Nguyễn Văn Hưng', '0973746382', 'Nhân viên', 3, 2, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(3, 'Hà Đông, Hà Nội', '1992-10-14 00:00:00', 'lananhtran1992@gmail.com', 'Trần Lan Anh', '0979906868', 'Nhân viên', 3, 2, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(4, 'Hà Đông, Hà Nội', '1989-03-09 00:00:00', 'tuannq120990@gmail.com', 'Nguyễn Quang Tuấn', '0781478423', 'Nhân viên', 3, 1, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(5, 'Hà Đông, Hà Nội', '1996-06-16 00:00:00', 'khaitq9920@gmail.com', 'Trần Quang Khải', '0923472344', 'Nhân viên', 3, 2, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(6, 'Hà Đông, Hà Nội', '1979-06-04 00:00:00', 'tuannv23421@gmail.com', 'Ngô Văn Tuấn', '0864732644', 'Nhân viên', 3, 3, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(7, 'Hà Đông, Hà Nội', '1997-03-24 00:00:00', 'anhnt88982@gmail.com', 'Nguyễn Tuấn Anh', '0823465234', 'Nhân viên', 3, 1, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(8, 'Hà Đông, Hà Nội', '1988-03-14 00:00:00', 'lienntk213@gmail.com', 'Nguyễn Thị Kim Liên', '0978236423', 'Nhân viên', 3, 3, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(9, 'Hà Đông, Hà Nội', '1997-03-25 00:00:00', 'cuonghv8@gmail.com', 'Hoàng Văn Cường', '0923784234', 'Quản lý', 2, 3, 3);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(10, 'Hà Đông, Hà Nội', '1999-09-06 00:00:00', 'tramem1209@gmail.com', 'Hoàng Thị Thùy Trâm', '0978563445', 'Quản lý', 2, 2, 3);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(11, 'Lục Ngạn, Bắc Giang', '2000-09-28 00:00:00', 'dungtt09@gmail.com', 'Trần Tiến Dũng', '0853574567', 'Nhân viên', 1, 1, 3);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(12, 'Cầu Giấy, Hà Nội', '2000-09-20 00:00:00', 'dunquydant09@gmail.com', 'Lê Văn Lợi', '0945837485', 'Nhân viên', 3, 3, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(13, 'Lương Sơn, Hòa Bình', '2000-06-28 00:00:00', 'dungtt09@gmail.com', 'Vũ Bich Diệp', '0923427364', 'Nhân viên', 3, 2, 2);
INSERT INTO manerger_wine.employees
(id, address, date_of_birth, email, name, phone, `position`, role_id, store_id, user_id)
VALUES(14, 'Thanh Xuân, Hà Nội', '2000-10-28 00:00:00', 'duoudan@gmail.com', 'Phạm Thị Kiều Trang', '0935774353', 'Nhân viên', 3, 1, 2);

INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(1, 'Thanh Oai,Hà Nội', 'tdquynh09@gmail.com', 'Quynh Ta Dinh', '0984368800');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(2, 'Nguyễn Văn Trỗi ,Hà Đông ,Hà Nội', 'hnstun11@gmail.com', 'Tun Pham', '08162371232');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(3, 'Trung Hoa,Cầu Giấy,Hà Nội', 'huongnguyen33@gmail.com', 'Hương Nguyên', '09812365232');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(4, 'Trung Hoa,Cầu Giấy,Hà Nội', 'thanhthanhthuy9@gmail.com', 'Lâm Thanh Thuy', '09664523234');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(5, 'Trung Hoa,Cầu Giấy,Hà Nội', 'huongvanle12@gmail.com', 'Trần Đức Nam', '09812637444');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(6, 'CT01 Ngô Thì Nhậm, Hà Đông,Hà Nội', 'linadhas123@gmail.com', 'Linh Phi', '09472834623');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(7, '123 Nguyễn khuyễn, Văn Quán,Hà Nội', 'namth098435@gmail.com', 'Nam Thanh Trần', '09123712733');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(8, '44 Lê Lai, Hà Đông, Hà Nội', 'thuynt66544@gmail.com', 'Nguyễn Thị Thủy', '08532342344');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(9, 'Số 18 ngõ 168 Triều Khúc,Thanh Xuân, Hà Nội', 'tuantung94542@gmail.com', 'Kiều Tuấn Tùng', '09743264732');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(10, '232 Phạm Văn Đồng, Cầu Giấy, Hà Nội', 'quanquanNguyen12@gmail.com', 'Nguyễn Ngọc Quân', '03654353645');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(11, '222 Hoàng Quốc Việt, Cầu Giấy, Hà Nội', 'phupbcs@gmail.com', 'Tòng Minh Phú', '09564734345');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(12, 'Số 36 Thụy Khuệ, Tây Hồ, Hà Nội', 'huongnguyen33@gmail.com', 'Lương Hạnh Chinh', '09888126412');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(13, 'Số 35 Đường Trần Hưn Đạo, Hoàn Kiếm, Hà Nội', 'trangdajs21@gmail.com', 'Dinh Như Cường', '09436273445');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(14, 'CT7b Khu ĐT Văn Phú, Hà Đông, Hà Nội', 'loivanas23@gmail.com', 'Lê Văn Lợi', '03887273644');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(15, '77 Phố Xốm, Hà Đông, Hà Nội', 'diepbich9989@gmail.com', 'Vũ Bich Diệp', '03781231254');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(16, '234 Trích Sài, Tây Hồ, Hà Nội', 'vupm2134@gmail.com', 'Pham Minh Vũ', '03765362421');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(17, '124 Trần Duy Hưng, Hà Nội', 'hieutrang09748@gmail.com', 'Phạm Thị Kiều Trang', '09123771238');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(18, '44 Tố Hữu, Nam Từ Liêm,Hà Nội', 'hoangkna@gmail.com', 'Nguyễn Văn Hoàng', '09174642546');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(19, '132 Nguyễn Xiển, Thanh Xuân, Hà Nội', 'tralfmg@gmail.com', 'Nguyễn Thị Thùy Trâm', '09123764735');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(20, 'UBND quận Thanh Xuân Nam, Thanh Xuân, Hà Nội', 'tram9043242@gmail.com', 'Thiều Bảo Trâm', '09865476543');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(21, 'Số 767 Tạ Quang bửu, ,Hà Nội', 'trangthieubao2@gmail.com', 'Thiều Bảo Trang', '09536123145');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(22, '334 Tô Hiến Thành,Hà Nội', 'thuyanh89234@gmail.com', 'Nguyễn Thùy Anh', '09642763422');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(23, '87 Nguyễn Thái Học, Quốc Tử Giảm, Hà Nội', 'lamanh8989@gmail.com', 'Trần Thị Lâm Anh', '09127317245');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(24, '77 Trần Đăng Ninh, Cầu Giấy, Hà nội', 'cuongtv879@gmail.com', 'Trần Văn Cường', '09127642714');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(25, 'Hoàng văn thụ, Hà Đông, Hà Nội', 'huonghuyad@gmail.com', 'Phan Sĩ Huy', '09472635232');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(26, 'Số 676 Nguyễn Phong Sắc,Hà Nội', 'quanghmda67@gmail.com', 'Hoàng Minh Quang', '09763234256');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(27, 'Số 332 Trằn Xuân Thủy, Cầu Giấy, Hà Nội', 'Ngocnadhas@gmail.com', 'Nguyễn Như Ngọc', '09123674541');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(28, '234 Võ Chí Công, Tây Hồ, Hà Nội', 'sonpxasd@gmail.com', 'Phung Xuan Son', '09438753467');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(29, '222 Phạm Văn Đồng,Hà Nội', 'huongthang3@gmail.com', 'Pham Van Thắng', '09936748565');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(30, '22 Nguyễn Văn Hoàng, Cầu Giấy, Hà Nội', 'huadatne23@gmail.com', 'Hứa Minh Đạt', '09534758366');
INSERT INTO manerger_wine.customer
(id, address, email, name, phone)
VALUES(31, '343 Trinh Minh Triết, ,Hà Nội', 'vuemdaea3@gmail.com', 'Trần Tuấn Vũ', '09436836427');

INSERT INTO manerger_wine.store
(id, address, name, phone, status, manager_id)
VALUES(1, '368 Bình Đà, Thanh Oai,Hà Nội', 'Wine cơ sở 2', '02433888667', 'A', NULL);
INSERT INTO manerger_wine.store
(id, address, name, phone, status, manager_id)
VALUES(2, '132 Nguyễn Xiển, Thanh Xuân, Hà Nội', 'Wine cở sở 3', '0984368800', 'A', NULL);
INSERT INTO manerger_wine.store
(id, address, name, phone, status, manager_id)
VALUES(3, '469 Nguyễn Trãi, Thanh Xuân, Hà Nội', 'Wine cơ sở 1', '02433868686', 'A', NULL);
INSERT INTO manerger_wine.store
(id, address, name, phone, status, manager_id)
VALUES(4, 'Số 1 Nguyễn Thị Duệ, Trung Hòa, Cầu Giấy', 'Wine cơ sở 4', '02435635663', 'A', NULL);