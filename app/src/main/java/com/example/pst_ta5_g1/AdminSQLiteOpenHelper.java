package com.example.pst_ta5_g1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table libros(IDLibro int primary key ,titulo text,autor text,editorial text,IDCategoria int,sipnosis text)");

        //INSERTAR DATOS
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(1,'Fuimos canciones','Elisabet Benavent','Suma de letras',1,'Macarena vive en Madrid y es asistente de una influencer de moda.\n" +
                "Macarena disfruta la vida a sorbos e intenta ser feliz.\n" +
                "Macarena tiene dos amigas: Adriana y Jimena.\n" +
                "Macarena guarda un secreto que deletrea a escondidas.\n" +
                "Ese secreto tiene tres letras: L-E-O.\n" +
                "Macarena no sabe que Leo está en Madrid.\n" +
                "Macarena teme, Macarena sueña, Macarena ama, Macarena vuela…\n" +
                "\n" +
                "Y en este juego del destino intenta aceptar que lo que fuimos no puede ser lo que seremos…\n" +
                "\n" +
                "¿O quizás sí?')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(2,'El mundo secreto de los dragones','Nikola Kucharska','EDICIONES SM',3,'El mundo secreto de los dragones.\n" +
                "\n" +
                "¿Qué misterio encierra la anatomía del dragón ancestral?\n" +
                "¿Qué se estudia en el cole de dragones?\n" +
                "¿Cuáles de estas criaturas han pasado a la historia?\n" +
                "Y lo más importante: ¿por qué se rompió su amistad con los seres humanos?\n" +
                "\n" +
                "Atrévete a descubrir toda la verdad sobre estas fascinantes criaturas.')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(3,'La Sombra de la Muerte','Antonio Lagares','Pelicano',2,'¿Estás dispuesto a combatir contra tus propios miedos? " +
                "¿A iniciar esta arriesgada lectura? Él lo hizo, y ahora está muerto… Da rienda suelta a tu curiosidad, " +
                "sé valiente, pasa y, Póstrate ante un nuevo género literario. Lector: ante ti se alzará el «PSICOTERROR». Tú y tus pasos, la agonía, una sombra… la noche. Buscas algo a lo que aferrar tus miedos; un remedio que cure ese pánico que te anquilosa, ralentiza hasta convertir en una víctima sumisa. Entre la oscuridad, una figura te acecha. «¿Voy a morir?», te preguntas.')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(4,'El Cuento de la Criada','Margaret Atwood','EDICIONES SALAMANDRA',4,'Amparándose en la coartada del terrorismo islámico, unos políticos teócratas se hacen con el poder y, como primera medida, suprimen la libertad de prensa y los derechos de las mujeres. Esta trama" +
                ", inquietante y oscura, que bien podría encontrarse en cualquier obra actual, pertenece en realidad a esta novela escrita por " +
                "Margaret Atwood a principios de los ochenta, en la que la afamada autora canadiense anticipó con llamativa premonición una amenaza latente en el mundo de hoy')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(5,'El día que el cielo se caiga','Megan Maxwell','Esencia',1,'La sangre te hace pariente, pero solo la lealtad y el amor te convierten en familia.\n" +
                "\n" +
                "Alba y Nacho se conocen desde que eran niños. La conexión entre ellos es muy especial y aumenta con el paso de los años," +
                " hasta que ella se casa y, obligada por su marido, se distancia de él. \n')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(6,'Dragonalia','Carlos Reviejo','EDICIONES SM',3,'Dragonalia es el país donde viven los dragones, pero no unos dragones cualquiera: " +
                "allí encontraréis dragones de colores, corsarios, astronautas, poetas, dragones que se casan.')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(7,'Cómo Explicar Física Cuántica Con Un Gato Zombi','Elena Gonzalez','Penguin Infantil',4,'Si eres de los que piensa que saber que el tiempo y el espacio son en realidad lo mismo no sirve para nada, o que lo único que le " +
                "puede decir un protón a un electrón es que deje de ser tan negativo..., ¡has dado con la lectura que necesitabas!')");
        db.execSQL("INSERT INTO libros (IDLibro,titulo,autor,editorial,IDCategoria,sipnosis) VALUES(8,'Cabal','Clive Barker','Plaza & Janés',2,'Aaron Boone lleva un tiempo sufriendo espantosas pesadillas, en las que se ve cometiendo los crímenes más atroces. Su psicólogo, el doctor Decker, termina de convencerlo de que esos asesinatos han ocurrido realmente." +
                " Ahora Boone sabe que en el mundo no hay lugar para él, y deja que el infierno lo llame, quiere que la Muerte lo " +
                "lleve hasta allí. Pero hasta la mismísima Muerte parece retroceder ante él. Parece que el único refugio para Boone es " +
                "Midian, aquel terrible y legendario lugar que estrecha entre sus monstruosos brazos a los medio muertos, las razas de noche…')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}

