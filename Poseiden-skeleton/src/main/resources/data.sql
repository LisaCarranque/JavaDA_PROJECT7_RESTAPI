

use dev;

insert ignore  into users(id, username,password,fullname, role) values ('200', 'jeanneDupont', '$2a$10$MiAcjZQu0fAjWtoCc6NpSO.4.1yteMsb6mhmJloqoAcM0d7Z5tAB2', 'JeanneDupont', 'USER');
insert ignore  into users(id, username,password,fullname, role) values ('201', 'jeanneMartin', '$2a$10$MiAcjZQu0fAjWtoCc6NpSO.4.1yteMsb6mhmJloqoAcM0d7Z5tAB2', 'JeanneMartin', 'ADMIN');

commit;
