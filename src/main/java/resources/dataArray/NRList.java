/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.dataArray;

import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class NRList {

    private ArrayList<NR> nrList = new ArrayList<NR>();

    public NRList() {

        nrList.add(new NR("NR-4", "Serviços Especializados em Engenharia de Segurança e em Medicina do Trabalho (SESMT)"));
        nrList.add(new NR("NR-6", "Equipamentos de Proteção Individual (EPI)"));
        nrList.add(new NR("NR-7", "Programa de Controle Médico de Saúde Ocupacional (PCMSO)"));
        nrList.add(new NR("NR-8", "Edificações"));
        nrList.add(new NR("NR-9", "Programa de Prevenção de Riscos Ambientais (PPRA)"));
        nrList.add(new NR("NR-10", "Segurança em Instalações e Serviços em Eletricidade"));
        nrList.add(new NR("NR-12", "Máquinas e Equipamentos"));
        nrList.add(new NR("NR-15", "Atividades e Operações Insalubres"));
        nrList.add(new NR("NR-16", "Atividades e Operações Perigosas"));
        nrList.add(new NR("NR-17", "Ergonomia"));
        nrList.add(new NR("NR-18", "Condições e Meio Ambiente de Trabalho na Indústria da Construção"));
        nrList.add(new NR("NR-35", "Trabalho em Altura"));

    }

    public ArrayList<NR> getNrs() {
        return nrList;
    }

    public String[] NRListConcat() {
        int size = nrList.size();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            NR nr = nrList.get(i);
            result[i] = nr.nr + " % " + nr.title;
        }

        return result;
    }

    public class NR {

        String nr;
        String title;
        String concat;

        NR(String nr, String title) {
            this.nr = nr;
            this.title = title;
            this.concat = nr + "==" + title;
        }

        @Override
        public String toString() {
            return this.nr;
        }
    }

}
