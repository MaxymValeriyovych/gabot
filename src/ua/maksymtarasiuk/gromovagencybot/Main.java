package ua.maksymtarasiuk.gromovagencybot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ApiContextInitializer.init();
	    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
	        telegramBotsApi.registerBot(new Bot());
	        System.out.println("Gromov Agency Bot ������ �������!");
	    } catch (TelegramApiException e){
	      	e.printStackTrace();
	      	System.out.println("�������� � �������� ����!");
	    }
	}

}
