package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;





public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");

        Main main = new Main();
        main.submittingForm();
    }

    public void submittingForm() throws Exception {


        final WebClient webClient = new WebClient();
        final HtmlPage page1 = webClient.getPage("http://localhost:8087/admin");

        final HtmlForm form = page1.getForms().stream()
                .filter(f -> f.getActionAttribute().contains("/admin/delete"))
                .findFirst().orElse(null);

        if (form != null) {
            final HtmlButton button = form.getFirstByXPath("//button[text()='Delete']");
            final HtmlPage page2 = button.click();
            System.out.println("Button 'Delete' clicked!");
        } else {
            System.out.println("Form not found");
        }
    }
}
//            final WebClient webClient = new WebClient();
//            //Загружаем нужную страницу
//            final HtmlPage page1 = webClient.getPage("http://localhost:8087/admin");
//            // Выбираем нужную форму,
//            // находим кнопку отправки и поле, которое нужно заполнить.
////            final HtmlForm form = page1.getFormByName("txt");
//            final HtmlForm form = page1.getHtmlElementById("SAM_form");
//
//
//
//            final HtmlElement buttonElement = form.getFirstByXPath("//*[@id='SAM_button_send']");
//            HtmlButton button = (HtmlButton) buttonElement;
//                // Теперь вы можете использовать объект HtmlButton для выполнения действий с кнопкой
//
//
//
//
////            final HtmlSubmitInput button = form.getInputByName("KIDE_button_send");
////            final HtmlTextInput textField = form.getInputByName("userid");
////            final HtmlTextArea textField = form.getTextAreaByName("***");
//            final HtmlTextArea textField = form.getTextAreaByName("txt");
//
//
////            final HtmlTextArea textField = (HtmlTextArea) page1.getElementById("SAM_txt");
//
//
//            // Записывает в найденное поле нужное значение.
//            textField.setTextContent("ПриветВсем");
////            textField.setValueAttribute("Привет1111");
//            // Теперь «кликаем» на кнопку и переходим на новую страницу.
//            final HtmlPage page2 = button.click();
//            System.out.println("Hello world!2");
//        }



