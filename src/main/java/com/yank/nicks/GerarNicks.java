package com.yank.nicks;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerarNicks {
    public List<String> getNicks(String url) {
        WebClient web = new WebClient();
        web.getOptions().setThrowExceptionOnScriptError(false);
        web.getOptions().setThrowExceptionOnFailingStatusCode(false);
        web.getOptions().setPrintContentOnFailingStatusCode(false);
        web.setAjaxController(new NicelyResynchronizingAjaxController());

        List<String> nicks = new ArrayList<>();
        try {
            HtmlPage page = web.getPage(url);
            HtmlSelect selectMetodo = (HtmlSelect) page.getElementById("method");
            HtmlOption optionRandom = selectMetodo.getOptionByValue("random");
            selectMetodo.setSelectedAttribute(optionRandom, true);
            HtmlNumberInput numeroNicks = (HtmlNumberInput)page.getElementById("quantity");
            numeroNicks.setValueAttribute("50");
            HtmlSelect limiteLetras = (HtmlSelect)page.getElementById("limit");
            HtmlOption oitoLetras = (HtmlOption)limiteLetras.getOptionByValue("8");
            limiteLetras.setSelectedAttribute(oitoLetras, true);
            HtmlButtonInput submit = (HtmlButtonInput)page.getElementById("bt_gerar_nick");
            HtmlPage newPage = submit.click();
            HtmlDivision divNicks = (HtmlDivision)newPage.getElementById("nicks");
            HtmlUnorderedList listNicks = (HtmlUnorderedList)divNicks.getFirstChild();
            DomNodeList<DomNode> itensNicks = listNicks.getChildNodes();
            for (DomNode itemNick : itensNicks){
                HtmlListItem listItemNick = (HtmlListItem)itemNick;
                HtmlSpan spanNick = (HtmlSpan)listItemNick.getFirstChild();
                nicks.add(spanNick.getTextContent().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nicks;
    }

}
