/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valter * Tiago
 */
public class Aluno {

    String nome;
    int num;

    public Aluno(String nome, int num) {
        this.nome = nome;
        this.num = num;
    }

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public int getNum() {
        return num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
