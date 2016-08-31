/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     30/08/2016 20:18:18                          */
/*==============================================================*/


drop table if exists ACCESO;

drop table if exists DEPORTISTA;

drop table if exists EJERCICIO;

drop table if exists METAS;

drop table if exists MUSCULO;

drop table if exists M_ANTROPOMETRICAS;

drop table if exists PAGO;

drop table if exists PERFIL;

drop table if exists PLANIFICACION;

drop table if exists RUTINA;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ACCESO                                                */
/*==============================================================*/
create table ACCESO
(
   ID_ACCESO            int not null auto_increment,
   ID_USUARIO           int,
   ID_RUTINA            int,
   NUMERO_ACCESO        int not null,
   NUM_DIAS_RETRASO     int not null,
   FECHA_ULTIMO_ACCESO  date not null,
   primary key (ID_ACCESO)
);

/*==============================================================*/
/* Table: DEPORTISTA                                            */
/*==============================================================*/
create table DEPORTISTA
(
   ID_DEPORTISTA        int not null auto_increment,
   PRIMER_NOMBRE        char(40) not null,
   SEGUNDO_NOMBRE       char(40) not null,
   APELLIDO_PATERNO     char(40) not null,
   APELLIDO_MATERNO     char(40) not null,
   SEXO                 char(2) not null,
   CEDULA               char(10) not null,
   CORREO               char(50),
   FECHA_NACIMIENTO     date not null,
   EDAD                 int not null,
   FACEBOOK             char(40),
   CELULAR              char(10) not null,
   TELEFONO_FIJO        char(10) not null,
   primary key (ID_DEPORTISTA)
);

/*==============================================================*/
/* Table: EJERCICIO                                             */
/*==============================================================*/
create table EJERCICIO
(
   ID_EJERCICIO         int not null auto_increment,
   ID_MUSCULO           int,
   DESCRIPCION_EJERCICIO char(70) not null,
   IMAGEN_MAQUINA       char(1000) not null,
   NUMERO_SERIES        int not null,
   NUMERO_REPETICIONES  int not null,
   primary key (ID_EJERCICIO)
);

/*==============================================================*/
/* Table: METAS                                                 */
/*==============================================================*/
create table METAS
(
   ID_META              int not null auto_increment,
   ID_DEPORTISTA        int,
   DESCRIPCION          char(70) not null,
   primary key (ID_META)
);

/*==============================================================*/
/* Table: MUSCULO                                               */
/*==============================================================*/
create table MUSCULO
(
   ID_MUSCULO           int not null auto_increment,
   ID_RUTINA            int,
   NOMBRE_MUSCULO       char(40) not null,
   primary key (ID_MUSCULO)
);

/*==============================================================*/
/* Table: M_ANTROPOMETRICAS                                     */
/*==============================================================*/
create table M_ANTROPOMETRICAS
(
   ID_M_ANTROPOMRTRICAS int not null auto_increment,
   ID_DEPORTISTA        int,
   PESO                 decimal(6,2) not null,
   TALLA                decimal(6,2) not null,
   BRAZO                decimal(6,2) not null,
   PECHO                decimal(6,2) not null,
   CINTURA              decimal(6,2) not null,
   CADERA               decimal(6,2),
   MUSLO                decimal(6,2) not null,
   PANTORRILLAS         decimal(6,2) not null,
   IRM                  decimal(6,2),
   primary key (ID_M_ANTROPOMRTRICAS)
);

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
create table PAGO
(
   ID_PAGO              int not null auto_increment,
   ID_DEPORTISTA        int,
   FECHA_PAGO           date not null,
   FECHA_VENCIMIENTO_PAGO date not null,
   TIPO_PAGO            char(20) not null,
   primary key (ID_PAGO)
);

/*==============================================================*/
/* Table: PERFIL                                                */
/*==============================================================*/
create table PERFIL
(
   ID_PERFIL            int not null auto_increment,
   ID_USUARIO           int,
   DESC_PERFIL          char(40) not null,
   primary key (ID_PERFIL)
);

/*==============================================================*/
/* Table: PLANIFICACION                                         */
/*==============================================================*/
create table PLANIFICACION
(
   ID_PLANIFICACION     int not null auto_increment,
   ID_M_ANTROPOMRTRICAS int,
   ID_META              int,
   INTENSIDAD           int not null,
   OBJETIVO             char(70) not null,
   NUM_MAX_DIAS         int not null,
   primary key (ID_PLANIFICACION)
);

/*==============================================================*/
/* Table: RUTINA                                                */
/*==============================================================*/
create table RUTINA
(
   ID_RUTINA            int not null auto_increment,
   ID_PLANIFICACION     int,
   ID_ACCESO            int,
   NUMERO_DIA           int not null,
   primary key (ID_RUTINA)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USUARIO           int not null auto_increment,
   ID_PERFIL            int,
   USUARIO              char(40) not null,
   CONTRASENA           char(50) not null,
   primary key (ID_USUARIO)
);

alter table ACCESO add constraint FK_RUTINA_ACCESO foreign key (ID_RUTINA)
      references RUTINA (ID_RUTINA) on delete restrict on update restrict;

alter table ACCESO add constraint FK_USUARIO_ACCESO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table EJERCICIO add constraint FK_MUSCULO_EJERCICIO foreign key (ID_MUSCULO)
      references MUSCULO (ID_MUSCULO) on delete restrict on update restrict;

alter table METAS add constraint FK_DEPORTISTA_METAS foreign key (ID_DEPORTISTA)
      references DEPORTISTA (ID_DEPORTISTA) on delete restrict on update restrict;

alter table MUSCULO add constraint FK_RUTINA_MUSCULO foreign key (ID_RUTINA)
      references RUTINA (ID_RUTINA) on delete restrict on update restrict;

alter table M_ANTROPOMETRICAS add constraint FK_DEPORTISTA_MEDIDAS foreign key (ID_DEPORTISTA)
      references DEPORTISTA (ID_DEPORTISTA) on delete restrict on update restrict;

alter table PAGO add constraint FK_DEPORTITA_PAGOS foreign key (ID_DEPORTISTA)
      references DEPORTISTA (ID_DEPORTISTA) on delete restrict on update restrict;

alter table PERFIL add constraint FK_PERFIL_USUARIO2 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table PLANIFICACION add constraint FK_MEDIDAS_PLAN foreign key (ID_M_ANTROPOMRTRICAS)
      references M_ANTROPOMETRICAS (ID_M_ANTROPOMRTRICAS) on delete restrict on update restrict;

alter table PLANIFICACION add constraint FK_METAS_PLAN foreign key (ID_META)
      references METAS (ID_META) on delete restrict on update restrict;

alter table RUTINA add constraint FK_PLAN_RUTINA foreign key (ID_PLANIFICACION)
      references PLANIFICACION (ID_PLANIFICACION) on delete restrict on update restrict;

alter table RUTINA add constraint FK_RUTINA_ACCESO2 foreign key (ID_ACCESO)
      references ACCESO (ID_ACCESO) on delete restrict on update restrict;

alter table USUARIO add constraint FK_PERFIL_USUARIO foreign key (ID_PERFIL)
      references PERFIL (ID_PERFIL) on delete restrict on update restrict;

