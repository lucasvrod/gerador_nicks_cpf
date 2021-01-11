package com.yank.nicks;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

public class GerarArquivoTexto {
    public void gravarNickCpf(Map<String, String> nickCpf){
        try{
            FileWriter arqNickCpf = new FileWriter("./Nicks_cpf_list.txt");
            PrintWriter gravarDados = new PrintWriter(arqNickCpf);
            gravarDados.println("NICK;CPF");
            System.out.println("NICK;CPF");
            for(String nick : nickCpf.keySet()){
                gravarDados.println(nick.concat(";").concat(nickCpf.get(nick)));
                System.out.println(nick.concat(";").concat(nickCpf.get(nick)));
            }
            arqNickCpf.close();

        } catch(Exception e){
            e.getMessage();
        }
    }
}
