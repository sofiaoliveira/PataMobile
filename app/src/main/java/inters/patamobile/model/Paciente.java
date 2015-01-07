package inters.patamobile.model;

import java.io.Serializable;
import java.util.Date;


public class Paciente implements Serializable {

    private int Id;
    private String Nome;
    private String DataNascimento;
    private String obs;
    private int terapeuta_id;

    public Paciente(){

    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return Nome;
    }



    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }
}
