create table procatsup(
xid varchar(10),
pid varchar(10),
catid varchar(10),
supid varchar(10),
Stock int not null,
price int not null,
status varchar(20) not null,
primary key (xid),
foreign key (pid) references Products(pid),
foreign key (catid) references Category(catid),
foreign key (supid) references Supplier(supid)
)

create view userdata as
select xid,psize,products.pid,pname,catname,supplier.supid,supname,stock,price from procatsup 
join products on procatsup.pid=products.pid 
join supplier on procatsup.supid=supplier.supid
join category on procatsup.catid=category.catid;


create table cart(
ciid int ,
xid varchar(10) ,
mid varchar(20) ,
size varchar(10) not null,
price int not null,
primary key (ciid),
foreign key (xid) references procatsup(xid),
foreign key (mid) references userdetails(mid)

);


create table orders(
oid varchar(10),
mid varchar(20),
shipno bigint not null,
shipaddress varchar(100) not null,
orderdate timestamp,
orderstatus varchar(15) not null,
primary key (oid),
foreign key (mid) references cart(mid)
)




create view usercart as
 select  cart.ciid,cart.xid,cart.quantity,userdata.psize,cart.mid,userdata.pname,userdata.supname,userdata.price from Userdata
join cart on userdata.xid=cart.xid 


create table review(
sno int,
mid varchar(20) not null,
rating int,
comment varchar(255) not null,
xid varchar(10),
primary key (sno),
foreign key (mid) references Userdetails(mid)
)
