
use dev;

insert ignore  into users(id, username,password,fullname, role) values ('200', 'jeanneDupont', '$2a$10$pi/L5GQiL/Yf2BvKKSOJR.krx4UWi5najPzQdgg4VzBCRHFDVLpPi', 'JeanneDupont', 'USER');
insert ignore  into users(id, username,password,fullname, role) values ('201', 'jeanneMartin', '$2a$10$pi/L5GQiL/Yf2BvKKSOJR.krx4UWi5najPzQdgg4VzBCRHFDVLpPi', 'JeanneMartin', 'ADMIN');

commit;
