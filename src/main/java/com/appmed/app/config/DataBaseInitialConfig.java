package com.appmed.app.config;

import com.appmed.app.domain.Alergia;
import com.appmed.app.domain.CondicaoEspecial;
import com.appmed.app.domain.Medicamento;
import com.appmed.app.domain.Droga;
import com.appmed.app.domain.Doenca;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.appmed.app.domain.*;
import com.appmed.app.domain.Dependente;
import com.appmed.app.domain.Dependente.Parentesco;
import com.appmed.app.domain.AlergiaFicha;
import com.appmed.app.domain.CondicaoEspecialFicha;
import com.appmed.app.domain.DoencaFicha;
import com.appmed.app.domain.DrogaFicha;
import com.appmed.app.domain.MedicamentoFicha;
import com.appmed.app.repository.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    List<Usuario> usuarios = new ArrayList<Usuario>();
    List<CondicaoEspecial> condicoesEspeciais = new ArrayList<>();
    List<Doenca> doencas = new ArrayList<>();
    List<Droga> drogas = new ArrayList<>();
    List<Alergia> alergias = new ArrayList<>();
    List<Medicamento> medicamentos = new ArrayList<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent argument) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        condicoesEspeciais = condicaoEspecialRepository.findAll();
        doencas = doencaRepository.findAll();
        drogas = drogaRepository.findAll();
        medicamentos = medicamentoRepository.findAll();
        alergias = alergiaRepository.findAll();

        List<Pessoal> perfisPessoas = pessoalRepository.findAll();

        //insert cid
        //condicaoEspecialRepository.deleteAll();
        if (condicoesEspeciais.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/data/demo/condicoes-especiais");
            List<String> contents;
            try {
                contents = Files.readAllLines(path);
                for (int i = 0; i < 10; i++) {
                    String content = contents.get(i);
                    //String linha[] = content.toString().split(";");
                    CondicaoEspecial e = new CondicaoEspecial(content.toString());
                    System.out.println(e.getNome());// print the line
                    this.condicaoEspecialRepository.save(e);
                }
            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

            condicoesEspeciais = condicaoEspecialRepository.findAll();
        }

        if (drogas.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/data/demo/drogas");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    Droga e = new Droga(content.toString());
                    System.out.println(e.getNome());// print the line
                    this.drogaRepository.save(e);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            drogas = drogaRepository.findAll();
        }
        //drogaRepository.deleteAll();

        if (medicamentos.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/data/demo/medicamentos");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {

                    String linha[] = content.toString().split(";");
                    Medicamento medicamento = new Medicamento(linha[0], linha[1],
                            linha[2], linha[3]);
                    medicamento = this.medicamentoRepository.save(medicamento);
                    System.out.println(medicamento.getNome());

                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.medicamentos = medicamentoRepository.findAll();
        }

        //alergiaRepository.deleteAll();
        if (alergias.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/data/demo/alergias");
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
        //doencaRepository.deleteAll();

        if (doencas.isEmpty()) {

            java.nio.file.Path path = Paths.get("src/main/java/data/cid/doencas");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(";");
                    Doenca doenca = new Doenca(linha[0], linha[1]);
                    System.out.println(doenca.getCID() + " " + doenca.getNome());
                    this.doencaRepository.save(doenca);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            doencas = doencaRepository.findAll();
        }

        if (perfisPessoas.isEmpty()) {
            java.nio.file.Path path = Paths.get("src/main/java/data/demo/usuarios");
            List contents;
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(",");

                    Usuario usuario = this.usuarioRepository.save(new Usuario(linha[0], linha[1],
                            linha[2], linha[3], linha[4], linha[5]));
                    System.out.println(usuario.getNome());
                    usuarios.add(usuario);
                });

            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            // usuarios = usuarioRepository.findAll();

            List<Localidade> locaisResidencia = new ArrayList();
            path = Paths.get("src/main/java/data/demo/localidades-pessoal");
            try {
                contents = Files.readAllLines(path);
                contents.forEach((Object content) -> {
                    String linha[] = content.toString().split(",");
                    locaisResidencia.add(new Localidade(linha[0], linha[1],
                            linha[2], linha[3], linha[4], linha[5]));
                    System.out.println(content.toString());// print the line
                });
            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

            path = Paths.get("src/main/java/data/demo/perfil-pessoal");
            List<Pessoal> perfispessoais = new ArrayList();

            try {
                contents = Files.readAllLines(path);
                for (int i = 0; i < 10; i++) {
                    String linha[] = contents.get(i).toString().split(",");
                    Random rn = new Random();
                    //rn.nextInt(locaisResidencia.size()
                    Pessoal perfil = new Pessoal(
                            locaisResidencia.get(i),
                            LocalDate.parse(linha[0], formatter), linha[1],
                            rn.nextBoolean(), rn.nextBoolean(), rn.nextBoolean(),
                            linha[2], Double.parseDouble(linha[3]), Double.parseDouble(linha[4]),
                            usuarios.get(i)
                    );
                    perfil.add(
                            new CondicaoEspecialFicha(
                                    condicoesEspeciais.get(rn.nextInt(condicoesEspeciais.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new CondicaoEspecialFicha(
                                    condicoesEspeciais.get(rn.nextInt(condicoesEspeciais.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DoencaFicha(
                                    doencas.get(rn.nextInt(doencas.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DoencaFicha(
                                    doencas.get(rn.nextInt(doencas.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new DrogaFicha(
                                    drogas.get(rn.nextInt(drogas.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DrogaFicha(
                                    drogas.get(rn.nextInt(drogas.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new AlergiaFicha(
                                    alergias.get(rn.nextInt(alergias.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new MedicamentoFicha(
                                    medicamentos.get(rn.nextInt(medicamentos.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new MedicamentoFicha(
                                    medicamentos.get(rn.nextInt(medicamentos.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil = this.pessoalRepository.save(perfil);
                    Usuario usuario = usuarios.get(i);
                    usuario.setPerfilPessoal(perfil);
                    this.usuarioRepository.save(usuario);
                    System.out.println("PerfilPessoal" + usuario.getNome());
                    perfispessoais.add(perfil);

                };
            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

            path = Paths.get("src/main/java/data/demo/perfil-dependente");
            List<Pessoal> perfisDependentes = new ArrayList();

            try {
                contents = Files.readAllLines(path);
                for (int i = 0; i < 8; i++) {
                    String linha[] = contents.get(i).toString().split(",");

                    Random rn = new Random();
                    //rn.nextInt(locaisResidencia.size()

                    Usuario usuario = usuarios.get(i);
                    Pessoal perfilDependente = new Pessoal(
                            linha[0], linha[1], linha[2], linha[3],
                            LocalDate.parse(linha[4], formatter),
                            linha[5], linha[6], linha[7], linha[8], linha[9], linha[10],
                            linha[11],
                            Double.parseDouble(linha[12]), Double.parseDouble(linha[13]), linha[14],
                            rn.nextBoolean(), rn.nextBoolean(), rn.nextBoolean(),
                            usuario);

                    Pessoal perfil = this.pessoalRepository.save(perfilDependente);;

                    perfil.add(
                            new CondicaoEspecialFicha(
                                    condicoesEspeciais.get(rn.nextInt(condicoesEspeciais.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new CondicaoEspecialFicha(
                                    condicoesEspeciais.get(rn.nextInt(condicoesEspeciais.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DoencaFicha(
                                    doencas.get(rn.nextInt(doencas.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DoencaFicha(
                                    doencas.get(rn.nextInt(doencas.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new DrogaFicha(
                                    drogas.get(rn.nextInt(drogas.size())),
                                    new NivelPermissao(rn.nextInt(3))));
                    perfil.add(
                            new DrogaFicha(
                                    drogas.get(rn.nextInt(drogas.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new AlergiaFicha(
                                    alergias.get(rn.nextInt(alergias.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new MedicamentoFicha(
                                    medicamentos.get(rn.nextInt(medicamentos.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfil.add(
                            new MedicamentoFicha(
                                    medicamentos.get(rn.nextInt(medicamentos.size())),
                                    new NivelPermissao(rn.nextInt(3))));

                    perfilDependente = this.pessoalRepository.save(perfil);
                    perfisDependentes.add(perfilDependente);
                    Dependente dependente = new Dependente(perfilDependente);
                    usuario = this.usuarioRepository.findOne(usuario.getId());
                    Pessoal perfilPessoal = usuario.getPerfilPessoal();
                    perfilPessoal.add(dependente);
                    perfilPessoal = this.pessoalRepository.save(perfilPessoal);
                    System.out.println(perfilPessoal.getDependentes().size());
                };
            } catch (IOException ex) {
                Logger.getLogger(DataBaseInitialConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
