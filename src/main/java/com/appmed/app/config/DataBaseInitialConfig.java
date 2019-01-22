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
import com.appmed.app.domain.Perfil.TipoPerfil;
import com.appmed.app.domain.perfil.pessoal.Dependente;
import com.appmed.app.domain.perfil.pessoal.Dependente.Parentesco;
import com.appmed.app.repository.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataBaseInitialConfig implements ApplicationListener<ContextRefreshedEvent> {
 @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoalRepository pessoalRepository;
    
    @Autowired
    private InstitucionalRepository institucionalRepository;
    

    @Override
    public void onApplicationEvent(ContextRefreshedEvent argument) {
         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
/*
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
            usuario=this.usuarioRepository.save(usuario);
            
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
            
            perfilPessoal=this.pessoalRepository.save(perfilPessoal);
            

            Pessoal perfilDependente = new Pessoal(
                    usuario, TipoPerfil.DEPENDENTE,"nome","rg","cpf",
                    new Localidade("Avenida Major Hermenegildo Antônio Aquino",
                    "Parque das Rodovias", "Lorena", "SP", "732", "12605-610"),
                    null,
                    LocalDate.parse("08/04/1997", formatter),
                    "F", true, false,
                    true, "O-", 1.73, 47.0
            );
            perfilDependente=this.pessoalRepository.save(perfilDependente);
            List<Dependente> dependentes = new ArrayList();
            
            Dependente dependente = new Dependente(Parentesco.FILHA,perfilDependente);
            //Dependente dependente = new Dependente();
            
            //dependentes.add(dependente);
            
            perfilPessoal.add(dependente);
            
            perfilPessoal=this.pessoalRepository.save(perfilPessoal);
            
    
            this.institucionalRepository.save(new Institucional( "62.887.344/0001-11",
                    "742.812.551.727", LocalDate.parse("23/09/2009", formatter),
                    "www.jaquelineemarcosviniciuscasanoturnaltda.com.br",
                    "ouvidoria@jaquelineemarcosviniciuscasanoturnaltda.com.br",
                    new Localidade("Salão","Avenida Presidente Wilson", "Centro",
                            "São Vicente", "SP", "888", "11320-903"),
                    "(13) 3641-3143", "(13) 99155-8383",Area.CLUBE, 
                    "vai que você tenha uma overdose...",usuarios.get(1), "Jaque Casa Noturna"
            ));

        }*/

    }
}
