package com.yank.nicks;

import java.util.List;
import java.util.Map;

public class NicksApplication {

	private static final String URL_GERACAO_NICKS = "https://www.4devs.com.br/gerador_de_nicks";
	private static final String URL_GERACAO_CPFS = "https://www.4devs.com.br/ferramentas_online.php";
	public static void main(String[] args) {
		List<String> nicks = new GerarNicks().getNicks(URL_GERACAO_NICKS);
		Map<String, String> nickCpf = new GerarCpfs().getCpfs(nicks, URL_GERACAO_CPFS);
		new GerarArquivoTexto().gravarNickCpf(nickCpf);
		System.exit(0);
	}
}
