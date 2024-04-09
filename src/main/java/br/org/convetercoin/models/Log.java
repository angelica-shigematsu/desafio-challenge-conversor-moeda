package br.org.convetercoin.models;

import java.util.Date;

public class Log {
    private Date dataLog;

    private int escolha;

    public Log(Date dataLog, int escolha) {
        this.dataLog = dataLog;
        this.escolha = escolha;
    }

    public Date getDataLog() {
        return dataLog;
    }

    public int getEscolha() {
        return escolha;
    }

    public String listLogs(int coinCoverter) {
        return this.dataLog + " " + coinCoverter;
    }
}
