package mc.sn.waw;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.sn.waw.ChatRoomRepository;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ChatController {
	
	private final ChatRoomRepository chatRoomRepository = new ChatRoomRepository();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	@RequestMapping(value = "/echo", produces = "application/text; charset=utf8",method = RequestMethod.GET)
	public String chatting(Locale locale, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		return "chatting";
	}
	@RequestMapping(value = "/chat", produces = "application/text; charset=utf8", method = RequestMethod.GET)
	public String view_chat(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		return "view_chat";
	}

	@RequestMapping(value = "/", produces = "application/text; charset=utf8", method = RequestMethod.GET)
    public String rooms(Model model){
		
		System.out.println("rooms on");
        model.addAttribute("rooms",chatRoomRepository.findAllRoom());
        System.out.println("trasfer success");
        return "rooms";
    }

	@RequestMapping(value = "/rooms/{id}", produces = "application/text; charset=utf8", method = RequestMethod.GET)
    public String room(@PathVariable String id, Model model){
		
        ChatRoom room = chatRoomRepository.findRoomById(id);
        model.addAttribute("room",room);
        return "room";
    }

	@RequestMapping(value = "/new", produces = "application/text; charset=utf8", method = RequestMethod.GET)
    public String make(Model model){
		
        ChatRoomForm form = new ChatRoomForm();
        model.addAttribute("form",form);
        return "newRoom";
    }

	@RequestMapping(value = "/room/new", produces = "application/text; charset=utf8", method = RequestMethod.POST)
    public String makeRoom(ChatRoomForm form){
		
        chatRoomRepository.createChatRoom(form.getName());

        return "redirect:/";
    }
	
	
}
