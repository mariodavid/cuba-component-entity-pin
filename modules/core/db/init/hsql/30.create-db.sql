insert into SEC_GROUP
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, PARENT_ID)
values ('5d4601d6-9894-b0af-64b8-83de6d7396ec', 1, '2017-03-09 09:37:32', 'admin', '2017-03-09 09:37:32', null, null, null, 'PinDefinitions', '0fa2b1a5-1d68-4d69-9fbd-dff348347f93');


insert into SEC_GROUP
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, PARENT_ID)
values ('cde8e540-8f74-4c95-7bf4-f6b14e927eb0', 3, '2017-03-09 09:37:44', 'admin', '2017-03-09 09:57:59', 'admin', null, null, 'entitypin$Customer', '5d4601d6-9894-b0af-64b8-83de6d7396ec');

insert into SEC_CONSTRAINT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, CHECK_TYPE, OPERATION_TYPE, CODE, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROOVY_SCRIPT, FILTER_XML, IS_ACTIVE, GROUP_ID)
values ('a122a042-c314-bfb8-affa-d0d31aab2596', 1, '2017-03-09 09:38:17', 'admin', '2017-03-09 09:38:17', null, null, null, 'db', 'read', null, 'entitypin$Order', null, '{E}.customer.id = :session$pinEntity', null, null, true, 'cde8e540-8f74-4c95-7bf4-f6b14e927eb0');


insert into SEC_CONSTRAINT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, CHECK_TYPE, OPERATION_TYPE, CODE, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROOVY_SCRIPT, FILTER_XML, IS_ACTIVE, GROUP_ID)
values ('0711a719-29c3-5fcd-aa36-e1a100c01cbc', 1, '2017-03-09 09:45:41', 'admin', '2017-03-09 09:45:41', null, null, null, 'db', 'read', null, 'entitypin$Customer', null, '{E}.id = :session$pinEntity', null, null, true, 'cde8e540-8f74-4c95-7bf4-f6b14e927eb0');




insert into SEC_GROUP
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, PARENT_ID)
values ('b89b6b8a-8f18-34b0-10a6-b6f1de53b826', 2, '2017-03-09 09:38:31', 'admin', '2017-03-09 09:57:53', 'admin', null, null, 'entitypin$Order', '5d4601d6-9894-b0af-64b8-83de6d7396ec');

insert into SEC_CONSTRAINT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, CHECK_TYPE, OPERATION_TYPE, CODE, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROOVY_SCRIPT, FILTER_XML, IS_ACTIVE, GROUP_ID)
values ('251db3f0-2eff-f499-387d-30e7ec749533', 1, '2017-03-09 09:39:59', 'admin', '2017-03-09 09:39:59', null, null, null, 'db', 'read', null, 'entitypin$Customer', 'join {E}.orders s', 's.id = :session$pinEntity', null, null, true, 'b89b6b8a-8f18-34b0-10a6-b6f1de53b826');

insert into SEC_CONSTRAINT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, CHECK_TYPE, OPERATION_TYPE, CODE, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROOVY_SCRIPT, FILTER_XML, IS_ACTIVE, GROUP_ID)
values ('ad7bcb20-1be1-67dd-897c-92f8833716a2', 2, '2017-03-09 10:28:15', 'admin', '2017-03-09 10:28:23', 'admin', null, null, 'db', 'read', null, 'entitypin$Order', null, '{E}.id = :session$pinEntity', null, null, true, 'b89b6b8a-8f18-34b0-10a6-b6f1de53b826');