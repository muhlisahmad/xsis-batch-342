select * from master.categories;
select * from master.products;
select * from master.variants;

select * from master.categories where deleted_at IS NULL;
select * from master.products where deleted_at IS NULL;