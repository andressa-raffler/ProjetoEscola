package org.example.servico;

import org.example.dominio.Aluno;
import org.example.dominio.Boletim;
import org.example.repositorio.RepositorioBoletins;


import java.util.Scanner;

public class VerificarSeNotaJaFoiLancada {
    Boletim boletim;
    Aluno aluno;

    public VerificarSeNotaJaFoiLancada(Aluno aluno, Boletim boletim) {
        this.boletim = boletim;
        this.aluno = aluno;

    }

    public boolean executar(Scanner sc, double nota, int bimestre) {

        for (Boletim boletimCadastrado : RepositorioBoletins.getInstance().getBoletimPorAluno(aluno)) {
            if (boletim.equals(boletimCadastrado) && boletimCadastrado.getNota(bimestre)!=0) {
                System.out.println("Nota ja cadastrada");
                System.out.println("Deseja substistuir? S / N");
                String Option = sc.next().toUpperCase();
                if(!(Option.equals("S")) && (!Option.equals("N"))) {
                    System.out.println("Opçao inválida");
                    return true;
                }
                if (Option.equals("S")) {
                    AtualizarNota.executar(boletimCadastrado, nota, boletim.getBimestre());
                    return true;
                }
            }
        }
        return false;
    }

}
