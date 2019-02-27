	package ua.maksymtarasiuk.gromovagencybot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class Bot extends TelegramLongPollingBot{

    /*public static void main(String[] apps){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }*/
	
	String txt = "";
	//Message message;
	InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline5 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline = new ArrayList<>();
    List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline6 = new ArrayList<>();
    //String txtPrintPrice = "(полиграфия) \n - визитки; \n - еврофлаер 21х10см; \n - листовка А6 10х15см; \n - листовка А5 15х21см; \n - афиша А3 30х42см; \n - наклейки; "
    //		+ "\n - пластиковые карты. \n (широкоформатная печать) \n - баннерная ткань; \n - самоклейкая пленка; \n - бумага; \n - пластик ПВХ; \n - композит; \n - акрил;	"
    //		+ "\n - холсты; \n - мобильные стенды; \n - наружные вывески. ";
    String txtPrintPrice = "Выберите необходимый вид товара";
    String txtLayoutPrice = "Если у Вас есть макет, то нашим дизайнерам необходимо его проверить на соответствие техническим требованиям нашей типографии(скачать файл.txt). \n"
    		+ "Если же Вы заказываете разрабоку макетов, о они по умолчанию пригодны к подаче в печать. \n - визитка от 70грн; \n - еврофлаер от 100грн; \n - листовка от 150грн; "
    		+ "\n - афиша от 150грн; \n - наклейки от 60грн; \n - пластиковые карты от 80грн; \n - широкоформатная печать от 80грн.";
    String txtPaymentDelivery = "1) После согласования макетов под печать нам необходимо знать от Вас желаемый способ досавки: \n - доставка на отделение Новой почты \n - бесплатно; \n"
    		+ "- курьерская доставка в пределах г. Киев \n - бесплатно от 300грн; \n - самовывоз со склада нашего производства. \n\n2) Следующим этапом следует уточнение данных доставки (ФИО, номер, адрес или отделение НП); "
    		+ "\n\n3) Далее необходимо провести оплату стоимости печати и дизайнерских в полном размере на карту или рассчетный счет. \n Так же есть возможность оформить отсрочку оплаты согласно дополнительному договору для заказов от 2000грн. "
    		+ "\n\n4) Отправка заказа на отделение Новой почты происходит в день его готовности до 18:00. Курьерская доставка оформляется с 14 до 18:30. \n"
    		+ "\n\nСамовывоз со склада осуществляется с 9:00 до 18:00, в субботу до 16:00.";
    String txtDiscountBonus = "Всё о скидках и бонусах";
    String callBackAnswer = "";
    
    SendMessage callbackMessage;
    SendMessage callbackMess;
    SendMessage new_message5;
    String callBackChatId;
    Integer count = 0;
    SendPhoto sendPhotoRequest;
    String myID;
    Integer width;
    Integer height;

    /* (non-Javadoc)
     * @see org.telegram.telegrambots.meta.generics.LongPollingBot#onUpdateReceived(org.telegram.telegrambots.meta.api.objects.Update)
     */
    @Override
    public void onUpdateReceived(Update update) {
    	
        //message = update.getMessage();
        //String txt = message.getText();
    	new Thread(new Runnable() {
            public void run() {
        if (update.hasMessage() && update.getMessage().hasText()) {//message != null 
            switch (update.getMessage().getText()){
            	case "/start":
            		myID = update.getMessage().getChatId().toString();
            		//if (count == 0){
            		txt = ("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + ". Рады приветствовать Вас в телеграм-боте рекламного агентства Gromov. \n \n" +
                        	"Сейчас у Вас есть возможность оперативно получить необходимую информацию касаемо полиграфии, широкоформатной печати, и, конечно же, разработки макетов. \n \n" +
                            "Давайте приступим! \n \n" + "Что Вы хотите сейчас узнать?");
                            //long chat_id = message.getChatId();
                            SendMessage sendMessage = new SendMessage() // Create a message object object
                                    .setChatId(update.getMessage().getChatId().toString())
                                    .setText(txt);
                            
                            /*rowInline.add(new InlineKeyboardButton().setText("Визитки").setCallbackData("pop1"));
    	                    rowInline.add(new InlineKeyboardButton().setText("Еврофлаер 21х10см").setCallbackData("pop2"));
    	                    rowsInline.add(rowInline);
    	                    rowInline2.add(new InlineKeyboardButton().setText("Листовка А6 10х15см").setCallbackData("pop3"));
    	                    rowInline2.add(new InlineKeyboardButton().setText("Листовка А5 15х21см").setCallbackData("pop4"));
    	                    rowsInline.add(rowInline2);
    	                    rowInline3.add(new InlineKeyboardButton().setText("Листовка А4 21х30см").setCallbackData("pop5"));
    	                    rowInline3.add(new InlineKeyboardButton().setText("Афиша А3 30х42см").setCallbackData("pop6"));
    	                    rowsInline.add(rowInline3);
    	                    rowInline4.add(new InlineKeyboardButton().setText("Широкоформатная печать").setCallbackData("pop7"));
    	                    rowInline4.add(new InlineKeyboardButton().setText("Под каждый товар").setCallbackData("pop8"));
    	                    rowsInline.add(rowInline4);
    	                    rowInline5.add(new InlineKeyboardButton().setText("Больше информации у нас на сайте").setUrl("http://gromov.com.ua/"));
    	                    rowsInline5.add(rowInline5);
    	                    markupInline.setKeyboard(rowsInline);*/
                            rowInline.add(new InlineKeyboardButton().setText("Визитки").setCallbackData("pop1"));
                            rowInline.add(new InlineKeyboardButton().setText("Еврофлаер 21х10см").setCallbackData("pop2"));
                            rowsInline.add(rowInline);
                            rowInline2.add(new InlineKeyboardButton().setText("Листовка А6 10х15см").setCallbackData("pop3"));
                            rowInline2.add(new InlineKeyboardButton().setText("Листовка А5 15х21см").setCallbackData("pop4"));
                            rowsInline.add(rowInline2);
                            rowInline3.add(new InlineKeyboardButton().setText("Листовка А4 21х30см").setCallbackData("pop5"));
                            rowInline3.add(new InlineKeyboardButton().setText("Афиша А3 30х42см").setCallbackData("pop6"));
                            rowsInline.add(rowInline3);
                            rowInline4.add(new InlineKeyboardButton().setText("Блокноты на пружине").setCallbackData("pop7"));
                            rowInline4.add(new InlineKeyboardButton().setText("Брошюры на скобе").setCallbackData("pop8"));
                            rowsInline.add(rowInline4);
                            rowInline5.add(new InlineKeyboardButton().setText("Наклейки 9х5см").setCallbackData("pop9"));
                            rowInline5.add(new InlineKeyboardButton().setText("Пластиковые карты").setCallbackData("pop10"));
                            rowsInline.add(rowInline5);                    
                            rowInline6.add(new InlineKeyboardButton().setText("Широкоформатная печать").setCallbackData("pop11"));
                            rowsInline.add(rowInline6);
                            markupInline.setKeyboard(rowsInline);
    	                    
                            
                            
                            
                            ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
                            List<KeyboardRow> keyboard = new ArrayList<>();
                            KeyboardRow row = new KeyboardRow();
                            KeyboardRow row2 = new KeyboardRow();
                            for (int i = 0; i < 4; i++) {
                               switch (i){
                               case 0:
                            	   row.add("Стоимость печати");
                            	   break;
                               case 1:
                            	   row.add("Стоимость дизайна");
                            	   break;
                               case 2:
                            	   row2.add("Условия оплаты и доставки");
                            	   //keyboard.add(row);
                            	   break;
                               case 3:
                            	   row2.add("О скидках и бонусах");
                            	   break;
                               }                  
                            }
                            keyboard.add(row);
                            keyboard.add(row2);
                            keyBoardMarkup.setKeyboard(keyboard);
                            keyBoardMarkup.setResizeKeyboard(true);
                            //sendMessage.setReplyMarkup(markupInline);
                            sendMessage.setReplyMarkup(keyBoardMarkup);
                            try{
                                execute(sendMessage);
                            }catch(TelegramApiException e){
                                e.printStackTrace();
                            }
                            //count = 1;
                            break;
            		/*}else{
            			count = 
            			break;
            		}*/
                            
            	case "Стоимость печати":
            		rowInline.clear();
                    rowInline2.clear();
                    rowInline3.clear();
                    rowInline4.clear();
                    rowInline5.clear();
                    rowInline6.clear();
                    rowsInline.clear();
                    markupInline.setKeyboard(rowsInline);
                    rowInline.add(new InlineKeyboardButton().setText("Визитки").setCallbackData("pop1"));
                    rowInline.add(new InlineKeyboardButton().setText("Еврофлаер 21х10см").setCallbackData("pop2"));
                    rowsInline.add(rowInline);
                    rowInline2.add(new InlineKeyboardButton().setText("Листовка А6 10х15см").setCallbackData("pop3"));
                    rowInline2.add(new InlineKeyboardButton().setText("Листовка А5 15х21см").setCallbackData("pop4"));
                    rowsInline.add(rowInline2);
                    rowInline3.add(new InlineKeyboardButton().setText("Листовка А4 21х30см").setCallbackData("pop5"));
                    rowInline3.add(new InlineKeyboardButton().setText("Афиша А3 30х42см").setCallbackData("pop6"));
                    rowsInline.add(rowInline3);
                    rowInline4.add(new InlineKeyboardButton().setText("Блокноты на пружине").setCallbackData("pop7"));
                    rowInline4.add(new InlineKeyboardButton().setText("Брошюры на скобе").setCallbackData("pop8"));
                    rowsInline.add(rowInline4);
                    rowInline5.add(new InlineKeyboardButton().setText("Наклейки 9х5см").setCallbackData("pop9"));
                    rowInline5.add(new InlineKeyboardButton().setText("Пластиковые карты").setCallbackData("pop10"));
                    rowsInline.add(rowInline5);                    
                    rowInline6.add(new InlineKeyboardButton().setText("Широкоформатная печать").setCallbackData("pop11"));
                    rowsInline.add(rowInline6);   
                    markupInline.setKeyboard(rowsInline);
            		SendMessage new_message2 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtPrintPrice);
            		setInlineButtons(new_message2, markupInline);
		            try {
		                execute(new_message2); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
            	case "Стоимость дизайна":
            		SendMessage new_message3 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtLayoutPrice);
		            try {
		                execute(new_message3); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
            	case "Условия оплаты и доставки":
            		SendMessage new_message4 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtPaymentDelivery);
		            try {
		                execute(new_message4); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
            	case "О скидках и бонусах":
            		SendMessage new_message5 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtDiscountBonus);
		            try {
		                execute(new_message5); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
		        default:
		        	SendMessage new_message6 = new SendMessage();
		        	new_message6.setChatId(update.getMessage().getChatId());
		        	if(update.getMessage().getText().equals("/price_print")){
		        		    new_message6.setText(txtPrintPrice);
		        		    setInlineButtons(new_message6, markupInline);
		        	}else if(update.getMessage().getText().equals("/price_layout")){
	        		        new_message6.setText(txtLayoutPrice);
		        		}else if(update.getMessage().getText().equals("/payment_and_delivery")){
	        		        new_message6.setText(txtPaymentDelivery);
		        		}else if(update.getMessage().getText().equals("/discount_and_bonuses")){
	        		        new_message6.setText(txtDiscountBonus);
		        		}else{
		        			new_message6.setText((update.getMessage().getFrom().getFirstName()+" не могу тебя понять. Введи одну из существующих команд!"));
		        		}
		        	try {
			                execute(new_message6); 
			            } catch (TelegramApiException e) {
			                e.printStackTrace();
			            }
		        	break;
            }
        	
        	/*if (update.getMessage().getText().equals("/start")) {
            	//System.out.println(txt);
                txt = ("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + ". Рады приветствовать Вас в телеграм-боте рекламного агентства Gromov. \n \n" +
            	"Сейчас у Вас есть возможность оперативно получить необходимую информацию касаемо полиграфии, широкоформатной печати, и, конечно же, разработки макетов. \n \n" +
                "Давайте приступим! \n \n" + "Что Вы хотите сейчас узнать?");
                //long chat_id = message.getChatId();
                SendMessage sendMessage = new SendMessage() // Create a message object object
                        .setChatId(update.getMessage().getChatId().toString())
                        .setText(txt);
                //rowInline.add(new InlineKeyboardButton().setText("Стоимость печати").setCallbackData("price_of_print"));
                //rowInline.add(new InlineKeyboardButton().setText("Стоимость разработки макетов").setCallbackData("price_of_layout"));
                //rowInline.add(new InlineKeyboardButton().setText("Условия оплаты и доставки").setCallbackData("payment_and_delivery"));
                //rowInline.add(new InlineKeyboardButton().setText("О скидках и бонусах").setCallbackData("discount_ and_bonuses"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                
                
                ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                for (int i = 0; i < 4; i++) {
                   switch (i){
                   case 0:
                	   row.add("Стоимость печати");
                	   //keyboard.add(row);
                	   break;
                   case 1:
                	   row.add("Стоимость разработки макетов");
                	   break;
                   case 2:
                	   row2.add("Условия оплаты и доставки");
                	   //keyboard.add(row);
                	   break;
                   case 3:
                	   row2.add("О скидках и бонусах");
                	   break;
                   }                  
                }
                keyboard.add(row);
                keyboard.add(row2);
                keyBoardMarkup.setKeyboard(keyboard);
                keyBoardMarkup.setResizeKeyboard(true);
                
                //sendMessage.setReplyMarkup(markupInline);
                sendMessage.setReplyMarkup(keyBoardMarkup);
                try{
                    execute(sendMessage);
                }catch(TelegramApiException e){
                    e.printStackTrace();
                }
                //sendMsg(message, txt, markupInline);
            }else if(update.getMessage().getText().equals("Стоимость печати")){
            	SendMessage new_message2 = new SendMessage()
                		.setChatId(update.getMessage().getChatId())
                        .setText("(полиграфия) \n - визитки; \n - еврофлаер 21х10см; \n - листовка А6 10х15см; \n - листовка А5 15х21см;");
                try {
                    execute(new_message2); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            	System.out.println(txt);
                txt = (message.getFrom().getFirstName() + ". Не могу тебя понять");
                SendMessage sendMessage = new SendMessage();
                //sendMessage.enableMarkdown(true);
                sendMessage.setChatId(message.getChatId().toString());
                //sendMessage.setReplyToMessageId(message.getMessageId());
                sendMessage.setText(txt);
                try{
                    execute(sendMessage);
                }catch(TelegramApiException e){
                    e.printStackTrace();
                }
            }*/
        }else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            callBackChatId = update.getCallbackQuery().getMessage().getChatId().toString();
            
            switch (call_data) {
            case "pop1":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "vizit.jpg");
            	/*SendPhoto sendPhotoRequest = new SendPhoto();
                sendPhotoRequest.setChatId(callBackChatId);
                sendPhotoRequest.setPhoto("https://pbs.twimg.com/profile_images/773193845341380608/5wisBGwS.jpg");
                sendPhotoRequest.setCaption("VADIMUCH");
                try {
                	RequestsendPhoto(sendPhotoRequest);
                } catch (TelegramApiException e) {
                  e.printStackTrace();
                }*/
            	/*callBackAnswer = "Печатаем визитные карты как обычные так и евроформата на бумаге высокой плотности(350г/м2). Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n "
                		+ "Ламинация на выбор: глянцевая или матовая. \n100шт = 95грн, с ламинацией 115грн; \n500шт = 215грн, с одност. ламинацией - 240грн; с двуст. ламинацией 265грн; "
                		+ "\n1000шт = 260грн, с одност. ламинацией - 310грн; с двуст. ламинацией 360грн; \n5000шт = 985грн, с одност. ламинацией - 1280грн; с двуст. ламинацией 1500грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop2":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "euro2110.jpg");
            	/*callBackAnswer = "Печатаем еврофлаеры на меллованной бумаге плотностью (130г/м2). Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 170грн; \n500шт = 340грн; \n1000шт = 420грн; \n5000шт = 1250грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop3":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a61510.jpg");
            	/*callBackAnswer = "Печатаем листовки формата А6 на меллованной бумаге плотностью (130г/м2). Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 135грн; \n500шт = 300грн; \n1000шт = 365грн; \n5000шт = 1070грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop4":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a52115.jpg");
            	/*callBackAnswer = "Печатаем листовки формата А5 на меллованной бумаге плотностью (130г/м2). Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 240грн; \n500шт = 560грн; \n1000шт = 700грн; \n5000шт = 2050грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop5":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a43021.jpg");
            	/*callBackAnswer = "Печатаем листовки формата А4 на меллованной бумаге плотностью (130г/м2). Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 430грн; \n500шт = 1010грн; \n1000шт = 1270грн; \n5000шт = 3750грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop6":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a34230.jpg");
            	/*callBackAnswer = "Делаем широкоформатную печать. Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 1620грн; \n500шт = 2030грн; \n1000шт = 2530грн; \n5000шт = 6900грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop7":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "blokn.jpg");
            	/*callBackAnswer = "Делаем широкоформатную печать. Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 1620грн; \n500шт = 2030грн; \n1000шт = 2530грн; \n5000шт = 6900грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop8":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "brosh.jpg");
            	/*callBackAnswer = "Делаем широкоформатную печать. Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 1620грн; \n500шт = 2030грн; \n1000шт = 2530грн; \n5000шт = 6900грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop9":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "nakley.jpg");
            	/*callBackAnswer = "Делаем широкоформатную печать. Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 1620грн; \n500шт = 2030грн; \n1000шт = 2530грн; \n5000шт = 6900грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop10":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "placard.jpg");
            	/*callBackAnswer = "Делаем широкоформатную печать. Чем больше срок - тем дешевле. Цены приведены за 1 сутки. "
                		+ "\n\nПо срокам мы разграничиваемся на печать: \n- 1 сутки(стандарт); \n- 2 суток(на 5% дешевле); \n- 3 суток(на 10% дешевше); \n\n"
                		+ "100шт = 1620грн; \n500шт = 2030грн; \n1000шт = 2530грн; \n5000шт = 6900грн.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop11":
            	callBackAnswer = "Давайте просчитаем стоимость широкоформатной печати. \nВведите ширину (в сантиметрах):";
            	/*callBackAnswer = "Печатаем на баннерной ткани плотностью 400г/м2. \nбаннерная ткань = ХХХсм х УУУсм / 10000 х 125грн \nустановка люверсов = (ХХХсм + УУУсм) х 2 / 0,3 / 100 х 3,2грн \n"
                		+ "порезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 2,4грн \n\n- самоклейкая пленка = ХХХсм х УУУсм / 10000 х 125грн \nпорезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 2,4грн \n\n"
                		+ "- бумага = ХХХсм х УУУсм / 10000 х 95грн \nпорезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 2,4грн \n\n- пластик ПВХ 3мм = ХХХсм х УУУсм / 10000 х 525грн \n"
                		+ "порезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 3грн \n\n- композит 3мм = ХХХсм х УУУсм / 10000 х 750грн \nпорезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 5грн \n\n"
                		+ "- акрил 3мм = ХХХсм х УУУсм / 10000 х 1100грн \nпорезка в размер = (ХХХсм + УУУсм) х 2 / 100 х 5грн \n\n- холсты (индивидуально); \n\n- мобильные стенды(индивидуально); \n\n"
                		+ "- наружные вывески (индивидуально).";*/
                sendCallBackAnswer(callBackChatId, callBackAnswer);
            	break;
            /*default:
            	width = Integer.parseInt(call_data);
            	if(width instanceof Integer) {
            		Integer integer = (Integer) width;
            		} else {
            			SendMessage loc_new_message = new SendMessage()
                        		.setChatId(update.getMessage().getChatId())
                                .setText("якась хуйня");
            		            try {
            		                execute(loc_new_message); 
            		            } catch (TelegramApiException e) {
            		                e.printStackTrace();
            		            }
            		}
                sendCallBackAnswer(callBackChatId, callBackAnswer);
            	break;*/
            }
        }
        }
    	}).start();
        /* else if (update.hasCallbackQuery()) {
        	String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            String answer;
            SendMessage new_message;
            
            switch(call_data){
            case "price_of_print":
            	answer = "(полиграфия) \n - визитки; \n - еврофлаер 21х10см; \n - листовка А6 10х15см; \n - листовка А5 15х21см;";
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId((int)message_id)
                        .setText(answer);
                new_message = new SendMessage()
                		.setChatId(chat_id)
                        .setText(answer);
                try {
                    execute(new_message); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                break;
            case "price_of_layout":
            	answer = "Печатаем визитные карты как обычные так и евроформата на бумаге высокой плотности(350г/м2).";
                new_message = new SendMessage()
                		.setChatId(chat_id)
                        .setText(answer);
                try {
                    execute(new_message); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                break;
            }*/
            
            /*if (call_data.equals("price_of_print")) {
                String answer = "Піздюлєшно заєбешно пуканить все";
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId((int)message_id)
                        .setText(answer);
                SendMessage new_message = new SendMessage()
                		.setChatId(chat_id)
                        .setText(answer);
                try {
                    execute(new_message); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }    
    
    
    private void mySendPhoto(String id, String path) {
		// TODO Auto-generated method stub
		SendPhoto sendPhotoRequest = new SendPhoto();
        // Set destination chat id
        sendPhotoRequest.setChatId(id);
        // Set the photo url as a simple photo
        sendPhotoRequest.setPhoto(new File("D:/workspace/GromovAgencyBot/bin/ua/maksymtarasiuk/GromovAgencyBot/"+path));
        try {
            // Execute the method
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        rowInline5.clear();
    	rowsInline5.clear();
    	rowInline5.add(new InlineKeyboardButton().setText("перейти на сайт GA").setUrl("http://gromov.com.ua/"));
    	rowsInline5.add(rowInline5);
    	callbackMess = new SendMessage()
                .setChatId(callBackChatId)
                .setText("Больше информации у нас на сайте");
        markupInline.setKeyboard(rowsInline5);
		setInlineButtons(callbackMess, markupInline);
    	try {
            execute(callbackMess); 
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
    

    private void sendCallBackAnswer(String callBackChatId, String callBackAnswer) {
		// TODO Auto-generated method stub
    	rowInline5.clear();
    	rowsInline5.clear();
    	rowInline5.add(new InlineKeyboardButton().setText("Больше информации у нас на сайте").setUrl("http://gromov.com.ua/"));
    	rowsInline5.add(rowInline5);
    	callbackMessage = new SendMessage()
                .setChatId(callBackChatId)
                .setText(callBackAnswer);
        markupInline.setKeyboard(rowsInline5);
		setInlineButtons(callbackMessage, markupInline);
    	try {
            execute(callbackMessage); 
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

	private void setInlineButtons(SendMessage new_message, InlineKeyboardMarkup markupInline) {
		// TODO Auto-generated method stub
    	new_message.setReplyMarkup(markupInline);
	}

	/*private void sendMsg(Message message, String txt, InlineKeyboardMarkup markupInline) {
    	System.out.println(txt);
    	   	    	
        SendMessage sendMessage = new SendMessage();
        //sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(txt);
        sendMessage.setReplyMarkup(markupInline);
        try{
            execute(sendMessage);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }*/

    @Override
    public String getBotUsername() {
        return "Gromov_Agency_Bot";
    }

    @Override
    public String getBotToken() {
        return "689999819:AAHc9j2sgy_3Y011nWHZyhFiDIL5B-jDgJ0";
    }
}
