/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.dataArray;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author felip
 */
public class JobsAvailable {

    private ArrayList<Job> jobRole = new ArrayList<Job>();

    public JobsAvailable() {
        jobRole.add(new Job(2500f, "Secretário(a)"));
        jobRole.add(new Job(2800f, "Assistente Administrativo(a)"));
        jobRole.add(new Job(1800f, "Auxiliar de Escritório"));
        jobRole.add(new Job(5000f, "Supervisor(a) de Projetos"));
        jobRole.add(new Job(8000f, "Engenheiro(a) Civil"));
        jobRole.add(new Job(7000f, "Arquiteto(a)"));
        jobRole.add(new Job(4000f, "Encarregado(a) de Obras"));
        jobRole.add(new Job(3000f, "Pedreiro(a)"));
        jobRole.add(new Job(3500f, "Eletricista"));
        jobRole.add(new Job(3200f, "Encanador(a)"));
        jobRole.add(new Job(3300f, "Carpinteiro(a)"));
        jobRole.add(new Job(3100f, "Pintor(a)"));
        jobRole.add(new Job(4000f, "Montador(a) de Estruturas"));
        jobRole.add(new Job(3500f, "Soldador(a)"));
        jobRole.add(new Job(3300f, "Serralheiro(a)"));
        jobRole.add(new Job(4000f, "Operador(a) de Máquinas Pesadas"));
        jobRole.add(new Job(3500f, "Motorista de Caminhão"));
        jobRole.add(new Job(2500f, "Ajudante Geral"));
        jobRole.add(new Job(3000f, "Técnico(a) de Segurança do Trabalho"));
        jobRole.add(new Job(3500f, "Técnico(a) em Edificações"));
        jobRole.add(new Job(2800f, "Encarregado(a) de Limpeza"));
        jobRole.add(new Job(2500f, "Auxiliar de Serviços Gerais"));
        jobRole.add(new Job(5500f, "Mestre de Obras"));
        jobRole.add(new Job(4000f, "Encarregado(a) de Logística"));
        jobRole.add(new Job(2800f, "Almoxarife"));
        jobRole.add(new Job(4500f, "Orçamentista"));
        jobRole.add(new Job(2500f, "Auxiliar Técnico(a)"));
        jobRole.add(new Job(1500f, "Estagiário(a)"));
        jobRole.add(new Job(8000f, "Gerente de Projetos"));
        jobRole.add(new Job(6000f, "Coordenador(a) de Equipe"));
        jobRole.add(new Job(3500f, "Analista de Recursos Humanos"));
        jobRole.add(new Job(4000f, "Consultor(a) Financeiro"));
        jobRole.add(new Job(3000f, "Desenhista Técnico(a)"));
        jobRole.add(new Job(6000f, "Engenheiro(a) de Segurança do Trabalho"));
        jobRole.add(new Job(6500f, "Engenheiro(a) de Produção"));
        jobRole.add(new Job(3500f, "Inspetor(a) de Qualidade"));
        jobRole.add(new Job(4000f, "Supervisor(a) de Manutenção"));
        jobRole.add(new Job(3000f, "Técnico(a) em Informática"));
        jobRole.add(new Job(5000f, "Administrador(a) de Contratos"));
        jobRole.add(new Job(2800f, "Auxiliar de Compras"));
        jobRole.add(new Job(3500f, "Caldeireiro(a)"));
        jobRole.add(new Job(4000f, "Encarregado(a) de Elétrica"));
        jobRole.add(new Job(2000f, "Estagiário(a) de Engenharia"));
        jobRole.add(new Job(3500f, "Ferramenteiro(a)"));
        jobRole.add(new Job(3200f, "Mecânico(a) de Manutenção"));
        jobRole.add(new Job(3000f, "Operador(a) de Empilhadeira"));
        jobRole.add(new Job(4000f, "Supervisor(a) de Logística"));
        jobRole.add(new Job(3500f, "Técnico(a) em Automação Industrial"));
        jobRole.add(new Job(3200f, "Técnico(a) em Meio Ambiente"));
        jobRole.add(new Job(3800f, "Analista de Suprimentos"));
        jobRole.add(new Job(2800f, "Auxiliar de Almoxarifado"));
        jobRole.add(new Job(2800f, "Auxiliar de Contabilidade"));
        jobRole.add(new Job(2800f, "Chefe de Cozinha"));

        Collections.sort(jobRole, (job1, job2) -> job1.title.compareToIgnoreCase(job2.title));
    }

    public String[] listOfJobsTitle() {
        int size = jobRole.size();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            Job job = jobRole.get(i);
            result[i] = job.title;
        }

        return result;
    }

    public double salaryByTitle(String title) {
        int size = jobRole.size();
        for (int i = 0; i < size; i++) {
            if (jobRole.get(i).title == title) {
                return jobRole.get(i).salary;
            }
        }
        return 0;
    }

    public class Job {

        String title;
        double salary;

        Job(float salary, String title) {
            this.title = title;
            this.salary = salary;
        }
    }

}
