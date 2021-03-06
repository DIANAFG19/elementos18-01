package org.unitec.elementos1801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1801Application implements CommandLineRunner {

    @Autowired RepositorioMensajito repoMensa;
    @Autowired RepositorioUsuario repoUsu;
    @Autowired RepositorioDireccion repoDir;


    public static void main(String[] args) {
        SpringApplication.run(Elementos1801Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        /*repoMensa.save(new Mensajito("Primero", "Mi primera vez con hibernate"));
        //repoMensa.save(new Mensajito(3, "17-10-2017", "Noo temblo"));
        System.out.println("si se guardo");

        //consulta busca uno por id
        Mensajito m = repoMensa.findOne(1);
        System.out.println(m.getTitulo());

        //buscar todos  (select)
        System.out.println("vamos a buscar todos");
        for (Mensajito mensa : repoMensa.findAll()) { //ciclo for mejorado 2.0 xD
            System.out.println(mensa.getTitulo());
        }

        System.out.println("vamos a buscar todos");
        for (Mensajito mensa : repoMensa.findAll()) { //ciclo for mejorado 2.0 xD
            System.out.println(mensa);
        }

        //otra forma de buscar por id
        System.err.println("buscar por id");
        System.out.println(repoMensa.findOne(1));

        //actualizar
        repoMensa.save(new Mensajito(2, "Master", "Actualizado"));
        System.out.println(repoMensa.findOne(1));
        
        //eliminar
        //repoMensa.delete(5);

        //personalizado buscar por titulo
        for (Mensajito mensa : repoMensa.findByTitulo("Master")) {
            System.out.println(mensa);
        }*/

        //vamos a generar un usuario
        Usuario u = new Usuario(33868L, "Diana Laura", "diana_1310fg@hotmail.com");
        //lo guardamos
        repoUsu.save(u);
        
        //generamos la direccion 
        Direccion d = new Direccion(new Usuario(33868L), "Calle 13", 55130, "Ecatepec");
        repoDir.save(d);
        
        //Aqui haremos el join
        Direccion d2 = repoDir.findOne(1L);
        System.out.println("Correo :" + d2.getU().getEmail() + "municipio " + d2.getMunicipio());
    }
}
