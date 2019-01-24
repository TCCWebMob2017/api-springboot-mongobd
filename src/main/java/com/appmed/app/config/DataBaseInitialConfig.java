package com.appmed.app.config;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.appmed.app.domain.*;
import com.appmed.app.domain.Institucional.Area;
import com.appmed.app.domain.Perfil.*;
import com.appmed.app.domain.perfil.*;
import com.appmed.app.domain.perfil.pessoal.Dependente;
import com.appmed.app.domain.perfil.pessoal.Dependente.Parentesco;
import com.appmed.app.repository.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DataBaseInitialConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoalRepository pessoalRepository;

    @Autowired
    private InstitucionalRepository institucionalRepository;

    @Autowired
    private DoencaRepository doencaRepository;

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private CondicaoEspecialRepository condicaoEspecialRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent argument) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //insert cid
        condicaoEspecialRepository.deleteAll();
        List<CondicaoEspecial> condicoesEspeciais = condicaoEspecialRepository.findAll();
        if (condicoesEspeciais.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/com/appmed/app/data/demo/condicoes-especiais");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    //String linha[] = content.toString().split(";");
                    CondicaoEspecial e = new CondicaoEspecial(content.toString());
                    System.out.println(e.getNome());// print the line
                    this.condicaoEspecialRepository.save(e);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            condicoesEspeciais = condicaoEspecialRepository.findAll();
        }
        drogaRepository.deleteAll();
        List<Droga> drogas = drogaRepository.findAll();
        if (drogas.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/com/appmed/app/data/demo/drogas");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha = content.toString();
                    Droga e = new Droga(linha);
                    System.out.println(e.getNome());// print the line
                    this.drogaRepository.save(e);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            drogas = drogaRepository.findAll();
        }

        alergiaRepository.deleteAll();
        List<Alergia> alergias = alergiaRepository.findAll();
        if (alergias.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/com/appmed/app/data/demo/alergias");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(";");
                    Alergia alergia = new Alergia(linha[0], linha[1]);
                    System.out.println(alergia.getNome());// print the line
                    this.alergiaRepository.save(alergia);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            alergias = alergiaRepository.findAll();
        }
        doencaRepository.deleteAll();
        List<Doenca> doencas = doencaRepository.findAll();
        if (doencas.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/com/appmed/app/data/cid/doencas");
            List contents;
            try {
                contents = Files.readAllLines(path);
                //Read from the stream
                contents.forEach((Object content) -> {
                    //for each line of content in contents
                    String linha[] = content.toString().split(";");
                    Doenca doenca = new Doenca(linha[0], linha[1]);
                    System.out.println(doenca.getCID() + " " + doenca.getNome());// print the line
                    this.doencaRepository.save(doenca);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            doencas = doencaRepository.findAll();
        }
/*
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            java.nio.file.Path path = Paths.get("src/main/resources/cid/doencas");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(";");

                    System.out.println(linha.toString());// print the line

                    this.usuarioRepository.save(new Usuario(linha[0], linha[1],
                            linha[2], linha[3], linha[4], linha[5]));
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuarios = usuarioRepository.findAll();
        }*/
        /*
        List<Pessoal> pessoais = this.pessoalRepository.findAll();
        if (usuarios.isEmpty()) {
            java.nio.file.Path path = Paths.get("src/main/resources/cid/perfil-pessoal");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(";");

                    System.out.println(linha.toString());// print the line
                    
                    this.pessoalRepository.save( new Pessoal(
                            linha[0], linha[1],
                            linha[2],linha[3],linha[4],linha[5]));
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuarios = usuarioRepository.findAll();
        }
         */
        usuarioRepository.deleteAll();
        pessoalRepository.deleteAll();
        institucionalRepository.deleteAll();

        List<Usuario> usuarios = this.usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            usuarios = new ArrayList<>();
            //String nome, String email, String password, String tefefone, String cpf
            usuarios.add(
                    this.usuarioRepository.save(
                            new Usuario(
                                    "Rafael Heitor Moreira",
                                    "rrafaelheitormoreira@accent.com.br",
                                    "F3DDrn104U",
                                    "(12) 99474-0150",
                                    "985.812.418-08",
                                    "10.408.727-4"
                            )));
            usuarios.add(
                    this.usuarioRepository.save(
                            new Usuario(
                                    "Samuel Danilo Baptista",
                                    "ssamueldanilobaptista@cvc.com.br",
                                    "frLzuohzKc",
                                    "(12) 99984-9322",
                                    "304.705.968-30",
                                    "10.408.727-4"
                            )));
            usuarios.add(
                    this.usuarioRepository.save(
                            new Usuario(
                                    "Enrico Iago Theo da Rosa",
                                    "enricoiagotheodarosa__enricoiagotheodarosa@brf-br.com",
                                    "BMFCBU250r",
                                    "(12) 99481-3256",
                                    "774.082.888-21",
                                    "10.408.727-4"
                            )));

            usuarios.add(
                    this.usuarioRepository.save(
                            new Usuario(
                                    "Tereza Bruna Márcia da Rosa",
                                    "enricoiagotheodarosa__enricoiagotheodarosa@brf-br.com",
                                    "BMFCBU250r",
                                    "(12) 99481-3256",
                                    "997.565.338-38",
                                    "10.408.727-4"
                            )));

            Localidade residencia = new Localidade("Avenida Major Hermenegildo Antônio Aquino",
                    "Parque das Rodovias", "Lorena", "SP", "732", "12605-610");
            Localidade trabalho = new Localidade("Geraldo e Raquel Pizzaria Delivery ME",
                    "Praça dos Artesãos Calabreses", "Bela Vista", "São Paulo", "SP", "867", "01316-090");

            this.pessoalRepository.save(new Pessoal(
                    usuarios.get(0), TipoPerfil.PESSOAL, residencia, trabalho,
                    LocalDate.parse("08/04/1997", formatter),
                    "F", true, false,
                    true, "O-", 1.73, 47.0));

            Usuario usuario = new Usuario(
                    "Tereza Bruna Márcia da Rosa",
                    "enricoiagotheodarosa__enricoiagotheodarosa@brf-br.com",
                    "BMFCBU250r",
                    "(12) 99481-3256",
                    "997.565.338-38",
                    "10.408.727-4");
            usuario = this.usuarioRepository.save(usuario);

            Pessoal perfilPessoal = new Pessoal(
                    usuario, TipoPerfil.PESSOAL,
                    new Localidade("Avenida Major Hermenegildo Antônio Aquino",
                            "Parque das Rodovias", "Lorena", "SP", "732", "12605-610"),
                    new Localidade("Geraldo e Raquel Pizzaria Delivery ME",
                            "Praça dos Artesãos Calabreses", "Bela Vista", "São Paulo", "SP", "867", "01316-090"),
                    LocalDate.parse("08/04/1997", formatter),
                    "F", true, false,
                    true, "O-", 1.73, 47.0
            );

            perfilPessoal = this.pessoalRepository.save(perfilPessoal);

            Pessoal perfilDependente = new Pessoal(
                    usuario, TipoPerfil.DEPENDENTE, "nome", "rg", "cpf",
                    new Localidade("Avenida Major Hermenegildo Antônio Aquino",
                            "Parque das Rodovias", "Lorena", "SP", "732", "12605-610"),
                    null,
                    LocalDate.parse("08/04/1997", formatter),
                    "F", true, false,
                    true, "O-", 1.73, 47.0
            );
            perfilDependente = this.pessoalRepository.save(perfilDependente);
            List<Dependente> dependentes = new ArrayList();

            Dependente dependente = new Dependente(Parentesco.FILHA, perfilDependente);
            //Dependente dependente = new Dependente();

            //dependentes.add(dependente);
            perfilPessoal.add(dependente);

            perfilPessoal = this.pessoalRepository.save(perfilPessoal);

            this.institucionalRepository.save(new Institucional("62.887.344/0001-11",
                    "742.812.551.727", LocalDate.parse("23/09/2009", formatter),
                    "www.jaquelineemarcosviniciuscasanoturnaltda.com.br",
                    "ouvidoria@jaquelineemarcosviniciuscasanoturnaltda.com.br",
                    new Localidade("Salão", "Avenida Presidente Wilson", "Centro",
                            "São Vicente", "SP", "888", "11320-903"),
                    "(13) 3641-3143", "(13) 99155-8383", Area.ACADEMICA,
                    "vai que você tenha uma overdose...", usuarios.get(1), "Jaque Casa Noturna"
            ));

        }
    }
}
