/*==============================================================*/
/* Tables: levels(+)                                            */
/* Tables: parts_level(+)                                       */
/* Tables: theory(+)                                            */
/* Tables: tests(+)                                             */
/* Tables: fill_gaps(+)                                         */
/*                                                              */
/* Tables: write_code                                           */
/*==============================================================*/




/*==============================================================*/
/* Table: levels                                                */
/*==============================================================*/

CREATE TABLE "levels" (
	"uid"	        INTEGER,
	"name_level"	TEXT,
	"prog_level_id"	INTEGER,
	"description"	TEXT,
	"done"	        INTEGER DEFAULT 0,
	PRIMARY KEY("uid" AUTOINCREMENT)
);

/*==============================================================*/
/* Table: parts_levels                                          */
/*==============================================================*/

CREATE TABLE "parts_levels" (
	"uid"	         INTEGER,
	"levels_id"	     INTEGER,
	"type_level_id"	 INTEGER,
	"done"	         INTEGER DEFAULT 0,
	"type_level"	 INTEGER,
	PRIMARY KEY("uid" AUTOINCREMENT),
	FOREIGN KEY("levels_id") REFERENCES "levels"("uid")
);

/*==============================================================*/
/* Table: theory                                                */
/*==============================================================*/

CREATE TABLE "theory" (
	"uid"	        INTEGER,
	"text"	        TEXT,
	"type_view"	    INTEGER,
	"type_level"	INTEGER DEFAULT 1,
	"type_level_id"	INTEGER,
	FOREIGN KEY("type_level_id") REFERENCES "parts_levels"("type_level_id"),
	PRIMARY KEY("uid" AUTOINCREMENT)
);

/*==============================================================*/
/* Table: tests                                                 */
/*==============================================================*/

CREATE TABLE "tests" (
	"uid"	        INTEGER,
	"question"	    TEXT,
	"answer"	    TEXT,
	"right_answer"	INTEGER,
	"num_question"	INTEGER,
	"type_level"	INTEGER DEFAULT 2,
	"type_level_id"	INTEGER,
	FOREIGN KEY("type_level_id") REFERENCES "parts_levels"("type_level_id"),
	PRIMARY KEY("uid" AUTOINCREMENT)
);

/*==============================================================*/
/* Table: fill_gaps                                             */
/*==============================================================*/

CREATE TABLE "fill_gaps" (
	"uid"	        INTEGER,
	"text"	        TEXT,
	"right_answer"	TEXT,
	"type_level"	INTEGER DEFAULT 3,
	"type_level_id"	INTEGER,
	FOREIGN KEY("type_level_id") REFERENCES "parts_levels"("type_level_id"),
	PRIMARY KEY("uid" AUTOINCREMENT)
);