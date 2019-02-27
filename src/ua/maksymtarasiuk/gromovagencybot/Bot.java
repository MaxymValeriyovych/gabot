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
    //String txtPrintPrice = "(����������) \n - �������; \n - ��������� 21�10��; \n - �������� �6 10�15��; \n - �������� �5 15�21��; \n - ����� �3 30�42��; \n - ��������; "
    //		+ "\n - ����������� �����. \n (��������������� ������) \n - ��������� �����; \n - ����������� ������; \n - ������; \n - ������� ���; \n - ��������; \n - �����;	"
    //		+ "\n - ������; \n - ��������� ������; \n - �������� �������. ";
    String txtPrintPrice = "�������� ����������� ��� ������";
    String txtLayoutPrice = "���� � ��� ���� �����, �� ����� ���������� ���������� ��� ��������� �� ������������ ����������� ����������� ����� ����������(������� ����.txt). \n"
    		+ "���� �� �� ����������� ��������� �������, � ��� �� ��������� �������� � ������ � ������. \n - ������� �� 70���; \n - ��������� �� 100���; \n - �������� �� 150���; "
    		+ "\n - ����� �� 150���; \n - �������� �� 60���; \n - ����������� ����� �� 80���; \n - ��������������� ������ �� 80���.";
    String txtPaymentDelivery = "1) ����� ������������ ������� ��� ������ ��� ���������� ����� �� ��� �������� ������ �������: \n - �������� �� ��������� ����� ����� \n - ���������; \n"
    		+ "- ���������� �������� � �������� �. ���� \n - ��������� �� 300���; \n - ��������� �� ������ ������ ������������. \n\n2) ��������� ������ ������� ��������� ������ �������� (���, �����, ����� ��� ��������� ��); "
    		+ "\n\n3) ����� ���������� �������� ������ ��������� ������ � ������������ � ������ ������� �� ����� ��� ���������� ����. \n ��� �� ���� ����������� �������� �������� ������ �������� ��������������� �������� ��� ������� �� 2000���. "
    		+ "\n\n4) �������� ������ �� ��������� ����� ����� ���������� � ���� ��� ���������� �� 18:00. ���������� �������� ����������� � 14 �� 18:30. \n"
    		+ "\n\n��������� �� ������ �������������� � 9:00 �� 18:00, � ������� �� 16:00.";
    String txtDiscountBonus = "�� � ������� � �������";
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
            		txt = ("������������, " + update.getMessage().getFrom().getFirstName() + ". ���� �������������� ��� � ��������-���� ���������� ��������� Gromov. \n \n" +
                        	"������ � ��� ���� ����������� ���������� �������� ����������� ���������� ������� ����������, ��������������� ������, �, ������� ��, ���������� �������. \n \n" +
                            "������� ���������! \n \n" + "��� �� ������ ������ ������?");
                            //long chat_id = message.getChatId();
                            SendMessage sendMessage = new SendMessage() // Create a message object object
                                    .setChatId(update.getMessage().getChatId().toString())
                                    .setText(txt);
                            
                            /*rowInline.add(new InlineKeyboardButton().setText("�������").setCallbackData("pop1"));
    	                    rowInline.add(new InlineKeyboardButton().setText("��������� 21�10��").setCallbackData("pop2"));
    	                    rowsInline.add(rowInline);
    	                    rowInline2.add(new InlineKeyboardButton().setText("�������� �6 10�15��").setCallbackData("pop3"));
    	                    rowInline2.add(new InlineKeyboardButton().setText("�������� �5 15�21��").setCallbackData("pop4"));
    	                    rowsInline.add(rowInline2);
    	                    rowInline3.add(new InlineKeyboardButton().setText("�������� �4 21�30��").setCallbackData("pop5"));
    	                    rowInline3.add(new InlineKeyboardButton().setText("����� �3 30�42��").setCallbackData("pop6"));
    	                    rowsInline.add(rowInline3);
    	                    rowInline4.add(new InlineKeyboardButton().setText("��������������� ������").setCallbackData("pop7"));
    	                    rowInline4.add(new InlineKeyboardButton().setText("��� ������ �����").setCallbackData("pop8"));
    	                    rowsInline.add(rowInline4);
    	                    rowInline5.add(new InlineKeyboardButton().setText("������ ���������� � ��� �� �����").setUrl("http://gromov.com.ua/"));
    	                    rowsInline5.add(rowInline5);
    	                    markupInline.setKeyboard(rowsInline);*/
                            rowInline.add(new InlineKeyboardButton().setText("�������").setCallbackData("pop1"));
                            rowInline.add(new InlineKeyboardButton().setText("��������� 21�10��").setCallbackData("pop2"));
                            rowsInline.add(rowInline);
                            rowInline2.add(new InlineKeyboardButton().setText("�������� �6 10�15��").setCallbackData("pop3"));
                            rowInline2.add(new InlineKeyboardButton().setText("�������� �5 15�21��").setCallbackData("pop4"));
                            rowsInline.add(rowInline2);
                            rowInline3.add(new InlineKeyboardButton().setText("�������� �4 21�30��").setCallbackData("pop5"));
                            rowInline3.add(new InlineKeyboardButton().setText("����� �3 30�42��").setCallbackData("pop6"));
                            rowsInline.add(rowInline3);
                            rowInline4.add(new InlineKeyboardButton().setText("�������� �� �������").setCallbackData("pop7"));
                            rowInline4.add(new InlineKeyboardButton().setText("������� �� �����").setCallbackData("pop8"));
                            rowsInline.add(rowInline4);
                            rowInline5.add(new InlineKeyboardButton().setText("�������� 9�5��").setCallbackData("pop9"));
                            rowInline5.add(new InlineKeyboardButton().setText("����������� �����").setCallbackData("pop10"));
                            rowsInline.add(rowInline5);                    
                            rowInline6.add(new InlineKeyboardButton().setText("��������������� ������").setCallbackData("pop11"));
                            rowsInline.add(rowInline6);
                            markupInline.setKeyboard(rowsInline);
    	                    
                            
                            
                            
                            ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
                            List<KeyboardRow> keyboard = new ArrayList<>();
                            KeyboardRow row = new KeyboardRow();
                            KeyboardRow row2 = new KeyboardRow();
                            for (int i = 0; i < 4; i++) {
                               switch (i){
                               case 0:
                            	   row.add("��������� ������");
                            	   break;
                               case 1:
                            	   row.add("��������� �������");
                            	   break;
                               case 2:
                            	   row2.add("������� ������ � ��������");
                            	   //keyboard.add(row);
                            	   break;
                               case 3:
                            	   row2.add("� ������� � �������");
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
                            
            	case "��������� ������":
            		rowInline.clear();
                    rowInline2.clear();
                    rowInline3.clear();
                    rowInline4.clear();
                    rowInline5.clear();
                    rowInline6.clear();
                    rowsInline.clear();
                    markupInline.setKeyboard(rowsInline);
                    rowInline.add(new InlineKeyboardButton().setText("�������").setCallbackData("pop1"));
                    rowInline.add(new InlineKeyboardButton().setText("��������� 21�10��").setCallbackData("pop2"));
                    rowsInline.add(rowInline);
                    rowInline2.add(new InlineKeyboardButton().setText("�������� �6 10�15��").setCallbackData("pop3"));
                    rowInline2.add(new InlineKeyboardButton().setText("�������� �5 15�21��").setCallbackData("pop4"));
                    rowsInline.add(rowInline2);
                    rowInline3.add(new InlineKeyboardButton().setText("�������� �4 21�30��").setCallbackData("pop5"));
                    rowInline3.add(new InlineKeyboardButton().setText("����� �3 30�42��").setCallbackData("pop6"));
                    rowsInline.add(rowInline3);
                    rowInline4.add(new InlineKeyboardButton().setText("�������� �� �������").setCallbackData("pop7"));
                    rowInline4.add(new InlineKeyboardButton().setText("������� �� �����").setCallbackData("pop8"));
                    rowsInline.add(rowInline4);
                    rowInline5.add(new InlineKeyboardButton().setText("�������� 9�5��").setCallbackData("pop9"));
                    rowInline5.add(new InlineKeyboardButton().setText("����������� �����").setCallbackData("pop10"));
                    rowsInline.add(rowInline5);                    
                    rowInline6.add(new InlineKeyboardButton().setText("��������������� ������").setCallbackData("pop11"));
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
		            
            	case "��������� �������":
            		SendMessage new_message3 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtLayoutPrice);
		            try {
		                execute(new_message3); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
            	case "������� ������ � ��������":
            		SendMessage new_message4 = new SendMessage()
            		.setChatId(update.getMessage().getChatId())
                    .setText(txtPaymentDelivery);
		            try {
		                execute(new_message4); 
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		            break;
		            
            	case "� ������� � �������":
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
		        			new_message6.setText((update.getMessage().getFrom().getFirstName()+" �� ���� ���� ������. ����� ���� �� ������������ ������!"));
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
                txt = ("������������, " + update.getMessage().getFrom().getFirstName() + ". ���� �������������� ��� � ��������-���� ���������� ��������� Gromov. \n \n" +
            	"������ � ��� ���� ����������� ���������� �������� ����������� ���������� ������� ����������, ��������������� ������, �, ������� ��, ���������� �������. \n \n" +
                "������� ���������! \n \n" + "��� �� ������ ������ ������?");
                //long chat_id = message.getChatId();
                SendMessage sendMessage = new SendMessage() // Create a message object object
                        .setChatId(update.getMessage().getChatId().toString())
                        .setText(txt);
                //rowInline.add(new InlineKeyboardButton().setText("��������� ������").setCallbackData("price_of_print"));
                //rowInline.add(new InlineKeyboardButton().setText("��������� ���������� �������").setCallbackData("price_of_layout"));
                //rowInline.add(new InlineKeyboardButton().setText("������� ������ � ��������").setCallbackData("payment_and_delivery"));
                //rowInline.add(new InlineKeyboardButton().setText("� ������� � �������").setCallbackData("discount_ and_bonuses"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                
                
                ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                for (int i = 0; i < 4; i++) {
                   switch (i){
                   case 0:
                	   row.add("��������� ������");
                	   //keyboard.add(row);
                	   break;
                   case 1:
                	   row.add("��������� ���������� �������");
                	   break;
                   case 2:
                	   row2.add("������� ������ � ��������");
                	   //keyboard.add(row);
                	   break;
                   case 3:
                	   row2.add("� ������� � �������");
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
            }else if(update.getMessage().getText().equals("��������� ������")){
            	SendMessage new_message2 = new SendMessage()
                		.setChatId(update.getMessage().getChatId())
                        .setText("(����������) \n - �������; \n - ��������� 21�10��; \n - �������� �6 10�15��; \n - �������� �5 15�21��;");
                try {
                    execute(new_message2); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            	System.out.println(txt);
                txt = (message.getFrom().getFirstName() + ". �� ���� ���� ������");
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
            	/*callBackAnswer = "�������� �������� ����� ��� ������� ��� � ����������� �� ������ ������� ���������(350�/�2). ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n "
                		+ "��������� �� �����: ��������� ��� �������. \n100�� = 95���, � ���������� 115���; \n500�� = 215���, � ������. ���������� - 240���; � �����. ���������� 265���; "
                		+ "\n1000�� = 260���, � ������. ���������� - 310���; � �����. ���������� 360���; \n5000�� = 985���, � ������. ���������� - 1280���; � �����. ���������� 1500���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop2":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "euro2110.jpg");
            	/*callBackAnswer = "�������� ���������� �� ����������� ������ ���������� (130�/�2). ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 170���; \n500�� = 340���; \n1000�� = 420���; \n5000�� = 1250���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop3":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a61510.jpg");
            	/*callBackAnswer = "�������� �������� ������� �6 �� ����������� ������ ���������� (130�/�2). ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 135���; \n500�� = 300���; \n1000�� = 365���; \n5000�� = 1070���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop4":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a52115.jpg");
            	/*callBackAnswer = "�������� �������� ������� �5 �� ����������� ������ ���������� (130�/�2). ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 240���; \n500�� = 560���; \n1000�� = 700���; \n5000�� = 2050���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop5":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a43021.jpg");
            	/*callBackAnswer = "�������� �������� ������� �4 �� ����������� ������ ���������� (130�/�2). ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 430���; \n500�� = 1010���; \n1000�� = 1270���; \n5000�� = 3750���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop6":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "a34230.jpg");
            	/*callBackAnswer = "������ ��������������� ������. ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 1620���; \n500�� = 2030���; \n1000�� = 2530���; \n5000�� = 6900���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop7":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "blokn.jpg");
            	/*callBackAnswer = "������ ��������������� ������. ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 1620���; \n500�� = 2030���; \n1000�� = 2530���; \n5000�� = 6900���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop8":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "brosh.jpg");
            	/*callBackAnswer = "������ ��������������� ������. ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 1620���; \n500�� = 2030���; \n1000�� = 2530���; \n5000�� = 6900���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop9":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "nakley.jpg");
            	/*callBackAnswer = "������ ��������������� ������. ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 1620���; \n500�� = 2030���; \n1000�� = 2530���; \n5000�� = 6900���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop10":
            	//rowInline5.clear();
            	mySendPhoto(callBackChatId, "placard.jpg");
            	/*callBackAnswer = "������ ��������������� ������. ��� ������ ���� - ��� �������. ���� ��������� �� 1 �����. "
                		+ "\n\n�� ������ �� ���������������� �� ������: \n- 1 �����(��������); \n- 2 �����(�� 5% �������); \n- 3 �����(�� 10% �������); \n\n"
                		+ "100�� = 1620���; \n500�� = 2030���; \n1000�� = 2530���; \n5000�� = 6900���.";
                sendCallBackAnswer(callBackChatId, callBackAnswer);*/
            	break;
            case "pop11":
            	callBackAnswer = "������� ���������� ��������� ��������������� ������. \n������� ������ (� �����������):";
            	/*callBackAnswer = "�������� �� ��������� ����� ���������� 400�/�2. \n��������� ����� = ����� � ����� / 10000 � 125��� \n��������� �������� = (����� + �����) � 2 / 0,3 / 100 � 3,2��� \n"
                		+ "������� � ������ = (����� + �����) � 2 / 100 � 2,4��� \n\n- ����������� ������ = ����� � ����� / 10000 � 125��� \n������� � ������ = (����� + �����) � 2 / 100 � 2,4��� \n\n"
                		+ "- ������ = ����� � ����� / 10000 � 95��� \n������� � ������ = (����� + �����) � 2 / 100 � 2,4��� \n\n- ������� ��� 3�� = ����� � ����� / 10000 � 525��� \n"
                		+ "������� � ������ = (����� + �����) � 2 / 100 � 3��� \n\n- �������� 3�� = ����� � ����� / 10000 � 750��� \n������� � ������ = (����� + �����) � 2 / 100 � 5��� \n\n"
                		+ "- ����� 3�� = ����� � ����� / 10000 � 1100��� \n������� � ������ = (����� + �����) � 2 / 100 � 5��� \n\n- ������ (�������������); \n\n- ��������� ������(�������������); \n\n"
                		+ "- �������� ������� (�������������).";*/
                sendCallBackAnswer(callBackChatId, callBackAnswer);
            	break;
            /*default:
            	width = Integer.parseInt(call_data);
            	if(width instanceof Integer) {
            		Integer integer = (Integer) width;
            		} else {
            			SendMessage loc_new_message = new SendMessage()
                        		.setChatId(update.getMessage().getChatId())
                                .setText("����� �����");
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
            	answer = "(����������) \n - �������; \n - ��������� 21�10��; \n - �������� �6 10�15��; \n - �������� �5 15�21��;";
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
            	answer = "�������� �������� ����� ��� ������� ��� � ����������� �� ������ ������� ���������(350�/�2).";
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
                String answer = "ϳ������� ������� �������� ���";
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
    	rowInline5.add(new InlineKeyboardButton().setText("������� �� ���� GA").setUrl("http://gromov.com.ua/"));
    	rowsInline5.add(rowInline5);
    	callbackMess = new SendMessage()
                .setChatId(callBackChatId)
                .setText("������ ���������� � ��� �� �����");
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
    	rowInline5.add(new InlineKeyboardButton().setText("������ ���������� � ��� �� �����").setUrl("http://gromov.com.ua/"));
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
