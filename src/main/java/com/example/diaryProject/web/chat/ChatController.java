package com.example.diaryProject.web.chat;

import com.example.diaryProject.domain.chat.Chat;
import com.example.diaryProject.domain.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    //チャット一覧取得
    @GetMapping()
    public String showChat(Model model, Authentication authentication) {
         List<Chat> chatList = chatService.showChat(authentication.getName());
         if (chatList == null) {
             return "chat/show_chat";
         }
        model.addAttribute("chatList", chatList);
        return "/chat/show_caht";
    }

    //チャット作成画面表示
    @GetMapping("/create")
    public String showChatForm(@ModelAttribute ChatForm chatForm) {
        return "chat/chatform";
    }

    //チャット追加
    @PostMapping("/create_chat")
    public String createChat(String senderName,String receiverName,String message){
        chatService.createChat(senderName,receiverName,message);
        return "redirect:/chat";
    }

    //チャット削除
//    @PostMapping("/delete")
//    public String deleteChat(String id){
//        chatService.delete(id);
//        return "redirect:/chat";


}
