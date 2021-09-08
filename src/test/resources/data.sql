-- -- call next value for hibernate_sequence;
-- insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'martin', 'martin@fastcampus.com', now(), now());
--
-- -- call next value for hibernate_sequence;
-- insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@fastcampus.com', now(), now());
--
-- -- call next value for hibernate_sequence;
-- insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@slowcampus.com', now(), now());
--
-- -- call next value for hibernate_sequence;
-- insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@slowcampus.com', now(), now());
--
-- -- call next value for hibernate_sequence;
-- insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'martin', 'martin@another.com', now(), now());

-- insert into user (`id`, `name`, `email`) values (1, 'martin', 'martin@fastcampus.com');
-- insert into user (`id`, `name`, `email`) values (2, 'dennis', 'dennis@fastcampus.com');
-- insert into user (`id`, `name`, `email`) values (3, 'sophia', 'sophia@slowcampus.com');
-- insert into user (`id`, `name`, `email`) values (4, 'james', 'james@slowcampus.com');
-- insert into user (`id`, `name`, `email`) values (5, 'martin', 'martin@another.com');

insert into user (`name`, `email`) values ('martin', 'martin@fastcampus.com');
insert into book ( `name`, `deleted`) values ('book-test-name', false);
