package com.yank.nicks;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerarCpfs {

    public Map<String, String> getCpfs(List<String> nicks, String url){
        Map<String, String> nickCpf = new HashMap<>();
        try{
            for (String nick : nicks){
                String cpf = requestWs(url);
                nickCpf.put(nick, cpf);
                System.out.println(cpf);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return nickCpf;

    }

    public String requestWs(String url) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "acao=gerar_cpf&pontuacao=S");
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
