------------------------------====chuc nang sys====-----------------------------

---------------------------chuc nang killsession -------------------------------
---------------------------- kiem tra cac sesion -------------------------------
create or REPLACE function fct_kt_ktkillsession
(a in v$session.sid%type,
b v$session.serial#%type)
return number is
sl number(2):=0;

begin
 select count(*) into sl from v$session 
 where type !='BACKGROUND' and sid=a and serial#=b;
 return sl;
end;

select fct_kt_ktkillsession('138','64265') as soluong from dual;
select * from view_insession;

-----------------------------=====ktkhoa=========-------------------------------
select count(*) from sys.dba_users where username='TEST123';

create or REPLACE function kt_taouser
(a in sys.dba_users.username%type)
return number is
sl number(2):=0;

begin
 select count(*) into sl from sys.dba_users where username=a;
 return sl;
end;

select kt_taouser('TEST123') as soluong from dual;

----------------------------- kt khoa co bi lock chua --------------------------
create or REPLACE function kt_lockuser
(a in sys.dba_users.username%type)
return number is
sl number(2):=0;

begin
 select count(*) into sl from sys.dba_users where username=a and account_status='LOCKED';
 return sl;
end;

select kt_lockuser('HR') as soluong from dual;

------------------------ kiem tra trung ma sach --------------------------------
create or REPLACE function fct_kt_trungmasach
(a in sys.SACH.masach%type)
return number is
sl number(2):=0;

begin
 select count(*) into sl from sys.SACH where masach=a;
 return sl;
end;

select fct_kt_trungmasach('S001') as soluong from dual;

--- kt tên tabletable ----------------------------------------------------------
select tablespace_name from dba_tablespaces;

create or replace function kttentablespace(a in varchar)
return number is
sl number(2):=0;
begin
    select count(*) into sl from sys.dba_tablespaces where tablespace_name=a;
    return sl;
end;

select kttentablespace('BAITAP') as soluong from dual;

--kt ten policy-----------------------------------------------------------------
select * from dba_audit_policies;

create or replace function kttenpolicy(a in varchar)
return number is
sl number(2):=0;
begin
     select count(*) into sl from sys.dba_audit_policies where policy_name=a;
     return sl;
end;

select kttenpolicy('HR') as soluong from dual;

--kt bat tat policy-------------------------------------------------------------
create or replace function ktbattatpolicy(a in varchar)
return number is
sl number(2):=0;
begin
     select count(*) into sl from sys.dba_audit_policies where policy_name=a and enabled='NO'; -- bi tat
     return sl;
end;

select ktbattatpolicy('HIHI') as soluong from dual;

--hien tu bang theo user
SELECT table_name FROM sys.dba_tables where owner='HR';

--kiem tra trung ten nhom-------------------------------------------------------
create or replace function kttrungtenhomq(a in varchar)
return number is
sl number(2):=0;
begin
     select count(*) into sl from sys.dba_roles where oracle_maintained='N' and role=a;
     return sl;
end;

select kttrungtenhomq('NHOMQ12') from dual;