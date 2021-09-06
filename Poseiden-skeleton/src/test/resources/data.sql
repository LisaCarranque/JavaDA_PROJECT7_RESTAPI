

use test;

insert ignore  into users(id, username,password,fullname, role) values ('200', 'jeanneDupont', '$2a$10$pi/L5GQiL/Yf2BvKKSOJR.krx4UWi5najPzQdgg4VzBCRHFDVLpPi', 'JeanneDupont', 'ADMIN');
insert ignore  into trade(trade_id, account,buy_quantity,type) values ('200', 'account', 10.00, 'type');
insert ignore  into bid_list(bid_list_id, account) values ('200', 'account');
insert ignore  into bid_list(bid_list_id, account) values ('201', 'account');
insert ignore  into curve_point(id, curve_id, term) values ('200', 7, 'term');
insert ignore  into rating(id, fitch_rating, moodys_rating, order_number, sand_p_rating) values ('200', 'fitch rating', 'moodys rating', 'order number', 'sand p rating');
commit;
